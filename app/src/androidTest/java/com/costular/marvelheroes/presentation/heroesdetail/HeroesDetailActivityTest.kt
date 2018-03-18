package com.costular.marvelheroes.presentation.heroesdetail

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.costular.marvelheroes.R
import com.costular.marvelheroes.domain.model.MarvelHeroEntity
import com.costular.marvelheroes.presentation.FakeData
import com.costular.marvelheroes.presentation.heroedetail.MarvelHeroeDetailActivity
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by costular on 18/03/2018.
 */
@RunWith(AndroidJUnit4::class)
class HeroesDetailActivityTest {

    val activityTestRule = ActivityTestRule<MarvelHeroeDetailActivity>(MarvelHeroeDetailActivity::class.java, false, false)

    @Test
    fun testBasicInitialization() {
        activityTestRule.launchActivity(Intent())
        Espresso.onView(ViewMatchers.withText(R.string.app_name)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testDataIsLoadedSuccessfully() {
        val intent = Intent(
                InstrumentationRegistry.getTargetContext(),
                MarvelHeroeDetailActivity::class.java
        ).apply {
            putExtra(MarvelHeroeDetailActivity.PARAM_HEROE, FakeData.IRON_MAN)
        }
        activityTestRule.launchActivity(intent)

        onView(withId(R.id.heroDetailName)).check(matches(withText(FakeData.NAME)))
        onView(withId(R.id.heroDetailRealName)).check(matches(withText(FakeData.REAL_NAME)))
        onView(withId(R.id.heroDetailHeight)).check(matches(withText(FakeData.HEIGHT)))
        onView(withId(R.id.heroDetailPower)).check(matches(withText(FakeData.POWER)))
        onView(withId(R.id.heroDetailAbilities)).check(matches(withText(FakeData.ABILITIES)))
    }

}