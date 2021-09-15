package com.duv.pockedex.model

data class PokeListModel (
        val count: Int?,
        val next: String?,
        val previous: String?,
        val results: List<PokeList>?
        )

data class PokeList(
    val name: String,
    val url: String
    )