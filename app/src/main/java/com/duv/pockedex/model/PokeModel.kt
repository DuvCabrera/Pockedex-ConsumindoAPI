package com.duv.pockedex.model

data class PokeModel(
    val id: Int,
    val name: String,
    val base_experience: Int,
    val height: Int,
    val is_default: Boolean,
    val order: Int,
    val weight: Int,
    val abilities: List<PokemonAbility>,
    val forms: List<NamedAPIResource>,
    val game_indices: List<VersionGameIndex>,
    val held_items: List<PokemonHeldItem>,
    val location_area_encounter: String,
    val moves: List<PokemonMove>,
    val sprites: PokemonSprites,
    val species: NamedAPIResource,
    val stats: List<PokemonStat>,
    val types: List<PokemonType>
)

data class PokemonType (
    val slot: Int,
    val type: NamedAPIResource
    )

data class PokemonStat (
    val stat: NamedAPIResource,
    val effort: Int,
    val base_stat: Int
        )

data class PokemonSprites (
    val front_default: String?,
    val front_shiny: String?,
    val front_female: String?,
    val front_shiny_female: String?,
    val back_default: String?,
    val back_shiny: String?,
    val back_female: String?,
    val back_shiny_female: String?
        )

data class PokemonMove (
    val move: NamedAPIResource,
    val version_group_details: List<PokemonMoveVersion>
        )

data class PokemonMoveVersion (
    val move_learn_method: NamedAPIResource,
    val version_group: NamedAPIResource,
    val level_learned_at: Int
        )

data class PokemonHeldItem (
    val item: NamedAPIResource,
    val version_details: List<PokemonHeldItemVersion>
        )

data class PokemonHeldItemVersion (
    val version: NamedAPIResource,
    val rarity: Int
        )

data class VersionGameIndex (
    val game_index: Int,
    val version: NamedAPIResource
        )

data class NamedAPIResource (
    val name: String,
    val url: String
        )

data class PokemonAbility (
    val is_hidden: Boolean,
    val slot: Int,
    val ability: NamedAPIResource
    )
