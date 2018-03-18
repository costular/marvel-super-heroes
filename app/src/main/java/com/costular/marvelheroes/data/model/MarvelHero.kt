package com.costular.marvelheroes.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by costular on 16/03/2018.
 */
data class MarvelHero(
        val name: String = "",
        @SerializedName("photo")
        val photoUrl: String = "",
        val realName: String = "",
        val height: String = "",
        val power: String = "",
        val abilites: String = "",
        val groups: String = ""
) {

        fun getGroups(): Array<String> =
                groups.replace("\\s".toRegex(), "").split(",").toTypedArray()

}