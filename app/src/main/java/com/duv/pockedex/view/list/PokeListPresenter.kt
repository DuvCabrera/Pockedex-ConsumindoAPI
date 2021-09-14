package com.duv.pockedex.view.list

import com.duv.pockedex.BASE_URL
import com.duv.pockedex.data.PokeRepository

class PokeListPresenter(private val view: PokeListView, private val pokeRepository: PokeRepository) {

    fun getPokeList(){
        view.initPokeList(pokeRepository.getApiList(BASE_URL))
    }
}