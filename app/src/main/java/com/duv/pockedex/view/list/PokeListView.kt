package com.duv.pockedex.view.list

import com.duv.pockedex.model.PokeList


interface PokeListView {
    fun initPokeList(list: List<PokeList>) {}
}