package com.costular.marvelheroes.domain.model

/**
 * Created by costular on 17/03/2018.
 */
data class MarvelHeroEntity(
        val name: String,
        val photoUrl: String,
        val realName: String,
        val height: String,
        val power: String,
        val abilites: String,
        val groups: Array<String>
)