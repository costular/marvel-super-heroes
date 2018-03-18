package com.costular.marvelheroes.usecase

import android.support.test.runner.AndroidJUnit4
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.CountDownLatch

/**
 * Created by costular on 17/03/2018.
 */
@RunWith(AndroidJUnit4::class)
class UseCaseTest {

    lateinit var stubUseCase: StubUseCase

    @Before
    fun setUp() {
        stubUseCase = StubUseCase()
    }

    @Test
    fun testSuccessObservableBuilding() {
        val countDownLatch = CountDownLatch(1)

        stubUseCase.execute({
            Assert.assertEquals(it, StubUseCase.intArray)
            countDownLatch.countDown()
        })

        countDownLatch.await()
    }

    @Test
    fun testDispose() {
        stubUseCase.execute({})

        stubUseCase.dispose()

        Assert.assertTrue(stubUseCase.disposables.isDisposed)
    }

}