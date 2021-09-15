package com.duv.pockedex.data

import com.duv.pockedex.model.PokeListModel
import retrofit2.Call
import retrofit2.http.GET

interface PokePlaceHolderApi {

    @GET("pokemon?limit=151&offset=0")
    fun getPokemonList(): Call<PokeListModel>


}