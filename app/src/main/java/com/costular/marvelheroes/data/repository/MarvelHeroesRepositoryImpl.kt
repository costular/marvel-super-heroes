package com.costular.marvelheroes.data.repository

import com.costular.marvelheroes.data.model.mapper.MarvelHeroMapper
import com.costular.marvelheroes.data.repository.datasource.FakeMarvelHeroesDataSource
import com.costular.marvelheroes.data.repository.datasource.RemoteMarvelHeroesDataSource
import com.costular.marvelheroes.domain.model.MarvelHeroEntity
import io.reactivex.Observable

/**
 * Created by costular on 17/03/2018.
 */
class MarvelHeroesRepositoryImpl(private val remoteMarvelHeroesDataSource: RemoteMarvelHeroesDataSource,
                                 private val marvelHeroesMapper: MarvelHeroMapper)
    : MarvelHeroesRepository {

    override fun getMarvelHeroesList(): Observable<List<MarvelHeroEntity>> =
        remoteMarvelHeroesDataSource
                .getMarvelHeroesList()
                .map { marvelHeroesMapper.transformList(it) }

}