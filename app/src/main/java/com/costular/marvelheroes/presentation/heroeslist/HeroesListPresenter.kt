package com.costular.marvelheroes.presentation.heroeslist

import com.costular.marvelheroes.domain.usecase.GetMarvelHeroesList
import javax.inject.Inject

/**
 * Created by costular on 17/03/2018.
 */
class HeroesListPresenter @Inject constructor(private val view: HeroesListContract.View,
                                              private val getMarvelHeroesList: GetMarvelHeroesList)
    : HeroesListContract.Presenter {

    override fun resume() {

    }

    override fun pause() {

    }

    override fun destroy() {
        getMarvelHeroesList.dispose()
    }

    override fun loadMarvelHeroes() {
        view.showLoading(true)
        getMarvelHeroesList.execute({ heroes ->
            view.showHeroesList(heroes)
            view.showLoading(false)
        }, {
            view.showError(it.toString())
            view.showLoading(false)
        })
    }

}