package com.duv.pockedex.view.list

import com.duv.pockedex.model.PokeListModel

interface PokeListView {
    fun initPokeList(list: List<PokeListModel>) {}
}