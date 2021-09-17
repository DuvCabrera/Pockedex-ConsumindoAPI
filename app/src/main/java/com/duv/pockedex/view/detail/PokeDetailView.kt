package com.duv.pockedex.view.detail

import com.duv.pockedex.model.PokeModel

interface PokeDetailView {
    fun initPokemon(pokemon: PokeModel) {}
}