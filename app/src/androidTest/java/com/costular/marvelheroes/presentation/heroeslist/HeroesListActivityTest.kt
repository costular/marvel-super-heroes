package com.costular.marvelheroes.presentation.heroeslist

import android.content.Intent
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.costular.marvelheroes.R
import com.costular.marvelheroes.presentation.heroedetail.MarvelHeroeDetailActivity
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by costular on 18/03/2018.
 */
@RunWith(AndroidJUnit4::class)
class HeroesListActivityTest {

    val activityTestRule = ActivityTestRule<HeroesListActivity>(HeroesListActivity::class.java)

    @Test
    fun testBasicInitialization() {
        activityTestRule.launchActivity(Intent())

        onView(withText(R.string.app_name)).check(matches(isDisplayed()))
    }

    @Test
    fun testClickOnItemAndOpenDetailActivity() {
        Intents.init()
        activityTestRule.launchActivity(Intent())

        // This is very bad I would like to implement Idling Resources
        // with https://github.com/JakeWharton/okhttp-idling-resource
        Thread.sleep(1000)

        onView(withId(R.id.heroesListRecycler))
                .perform(RecyclerViewActions.actionOnItemAtPosition<HeroesListAdapter.HeroesViewHolder>(0, click()))

        intended(hasComponent(MarvelHeroeDetailActivity::class.java.name))

        Intents.release()
    }

}