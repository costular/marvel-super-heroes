package com.costular.marvelheroes.mapper

import com.costular.marvelheroes.data.model.MarvelHero
import com.costular.marvelheroes.data.model.mapper.MarvelHeroMapper
import com.costular.marvelheroes.domain.model.MarvelHeroEntity
import org.assertj.core.api.Assertions
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by costular on 18/03/2018.
 */
class MarvelHeroMapperTest {

    private lateinit var marvelHeroMapper: MarvelHeroMapper

    @Before
    fun setUp() {
        marvelHeroMapper = MarvelHeroMapper()
    }

    @Test
    fun `Transform MarvelHero into MarvelHeroEntity`() {
        // Given
        val marvelHero = MarvelHero("Iron Man", "http://ironman.com")

        // When
        val marvelHeroEntity = marvelHeroMapper.transform(marvelHero)

        // Then
        Assertions.assertThat(marvelHeroEntity.name).isEqualTo(marvelHero.name)
        Assertions.assertThat(marvelHeroEntity.photoUrl).isEqualTo(marvelHero.photoUrl)
    }

    @Test
    fun `Transform MarvelHero collection into MarvelHeroEntity collection`() {
        // Given
        val marvelHeroes = listOf(
                MarvelHero("Iron Man", "http://ironman.com", groups = "1, 2"),
                MarvelHero("Spider-Man", "http://spider-man.com", groups = "1, 2")
        )

        // When
        val marvelHeroesEntities = marvelHeroMapper.transformList(marvelHeroes)

        // Then
        Assertions.assertThat(marvelHeroes.size).isEqualTo(marvelHeroesEntities.size)
        Assertions.assertThat(marvelHeroesEntities).allMatch { it is MarvelHeroEntity }
        Assertions.assertThat(marvelHeroesEntities.first().groups).isEqualTo(arrayOf("1", "2"))
        Assertions.assertThat(marvelHeroesEntities.first().name).isEqualTo(marvelHeroes.first().name)
        Assertions.assertThat(marvelHeroesEntities.last().name).isEqualTo(marvelHeroes.last().name)
    }

}