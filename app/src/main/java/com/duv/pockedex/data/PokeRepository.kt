package com.duv.pockedex.data

import android.util.Log
import com.duv.pockedex.model.PokeListModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PokeRepository {

    fun getApiList(baseUrl: String): List<PokeListModel> {

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(PokePlaceHolderApi::class.java)
        val call = service.getPokemonList()
        var pokeResponse: List<PokeListModel> = listOf()
        call.enqueue(object : Callback<List<PokeListModel>> {
            override fun onResponse(
                call: Call<List<PokeListModel>>,
                response: Response<List<PokeListModel>>
            ) {
                if (response.code() == 200){
                    pokeResponse = response.body()!!
                }
            }

            override fun onFailure(call: Call<List<PokeListModel>>, t: Throwable) {
                t.message?.let { Log.e("onFailure error", it) }
            }
        })
        return pokeResponse
    }
}