package com.costular.marvelheroes.data.model.mapper

import com.costular.marvelheroes.data.model.MarvelHero
import com.costular.marvelheroes.domain.model.MarvelHeroEntity

/**
 * Created by costular on 17/03/2018.
 */
class MarvelHeroMapper : Mapper<MarvelHero, MarvelHeroEntity> {

    override fun transform(input: MarvelHero): MarvelHeroEntity =
            MarvelHeroEntity(
                    input.name,
                    input.photoUrl,
                    input.realName,
                    input.height,
                    input.power,
                    input.abilities,
                    getGroupsFromMarvelHero(input))

    override fun transformList(inputList: List<MarvelHero>): List<MarvelHeroEntity> =
            inputList.map { transform(it) }


    private fun getGroupsFromMarvelHero(marvelHero: MarvelHero): Array<String> =
            marvelHero.groups.replace("\\s".toRegex(), "").split(",").toTypedArray()

}