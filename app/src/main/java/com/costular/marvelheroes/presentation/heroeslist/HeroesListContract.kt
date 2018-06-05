package com.costular.marvelheroes.presentation.heroeslist

import com.costular.marvelheroes.data.model.MarvelHero
import com.costular.marvelheroes.domain.model.MarvelHeroEntity
import com.costular.marvelheroes.presentation.base.BasePresenter

/**
 * Created by costular on 17/03/2018.
 */
interface HeroesListContract {

    interface View {

        fun showLoading(isLoading: Boolean)

        fun showHeroesList(heroes: List<MarvelHeroEntity>)

        fun showError(message: String)

        fun showError(messageRes: Int)

    }

    interface Presenter : BasePresenter {

        fun loadMarvelHeroes()

    }

}