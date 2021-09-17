package com.duv.pockedex.data

import com.duv.pockedex.POKE_NAME
import com.duv.pockedex.model.PokeListModel
import com.duv.pockedex.model.PokeModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokePlaceHolderApi {

    @GET("pokemon?limit=151&offset=0")
    fun getPokemonList(): Call<PokeListModel>

    @GET("pokemon/{name}")
    fun getPokemon(@Path("name") name: String?): Call<PokeModel>

}