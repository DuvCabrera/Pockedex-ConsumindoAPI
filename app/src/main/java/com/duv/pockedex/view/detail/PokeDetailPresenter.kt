package com.duv.pockedex.view.detail

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import com.duv.pockedex.BASE_URL
import com.duv.pockedex.data.PokeRepository
import com.duv.pockedex.model.PokeModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.BufferedInputStream
import java.io.IOException
import java.net.URL
import kotlin.concurrent.thread


class PokeDetailPresenter( private val view: PokeDetailView, private val pokeRepository: PokeRepository) {

    private val callback = object : Callback<PokeModel> {
        override fun onResponse(
            call: Call<PokeModel>,
            response: Response<PokeModel>
        ) {
            if (response.code() == 200) {
                val pokeResponse = response.body()!!
                Log.e(pokeResponse.toString(),"")
                view.initPokemon(pokeResponse)
            } else {
                Log.e("Lista não Recebida", "Aconteceu algo errado")
            }
        }

        override fun onFailure(call: Call<PokeModel>, t: Throwable) {
            t.message?.let { Log.e("onFailure error", it) }
        }
    }

    fun getPokemon(name:String?){
        pokeRepository.getPokemonApi(BASE_URL, callback, name)
    }

    fun getPokeImage(url:String?):Bitmap?{

        thread {
            run() {
                var img: Bitmap? = null
                try{
                    val aUrl = URL(url)
                    val connection = aUrl.openConnection()
                    connection.connect()
                    val isInputStream = connection.getInputStream()
                    val bis = BufferedInputStream(isInputStream)
                    img = BitmapFactory.decodeStream(bis)
                    bis.close()
                    isInputStream.close()
                }catch (e: IOException){
                    Log.e("Erro na imagem", "Imagem não disponivel")
                }
            }
        }.start()
    }
}