package com.duv.pockedex.data


import com.duv.pockedex.model.PokeListModel
import com.duv.pockedex.model.PokeModel
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PokeRepository {

    fun createRetrofit(baseUrl: String): Retrofit{
        return  Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
    }

    fun getApiList(baseUrl: String, callback: Callback<PokeListModel>){

        val retrofit = createRetrofit(baseUrl)

        val service = retrofit.create(PokePlaceHolderApi::class.java)
        val call = service.getPokemonList()
        call.enqueue(callback)
    }

    fun getPokemonApi(baseUrl: String, callback: Callback<PokeModel>, name: String?){

        val retrofit = createRetrofit(baseUrl)

        val service = retrofit.create(PokePlaceHolderApi::class.java)
        val call = service.getPokemon(name)
        call.enqueue(callback)
    }
}