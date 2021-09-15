package com.duv.pockedex.data

import android.util.Log
import com.duv.pockedex.model.PokeList
import com.duv.pockedex.model.PokeListModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PokeRepository {

    fun getApiList(baseUrl: String): List<PokeList>? {

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(PokePlaceHolderApi::class.java)
        val call = service.getPokemonList()
        var pokeResponse = PokeListModel(null,null,null,null)
        call.enqueue(object : Callback<PokeListModel> {
            override fun onResponse(
                call: Call<PokeListModel>,
                response: Response<PokeListModel>
            ) {
                if (response.code() == 200){
                    pokeResponse = response.body()!!
                }
            }

            override fun onFailure(call: Call<PokeListModel>, t: Throwable) {
                t.message?.let { Log.e("onFailure error", it) }
            }
        })
        return pokeResponse.results
    }
}