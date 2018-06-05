package com.costular.marvelheroes.di.modules

import com.costular.marvelheroes.BuildConfig
import com.costular.marvelheroes.data.net.MarvelHeroesService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by costular on 17/03/2018.
 */
@Module
class NetModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val client =
                OkHttpClient.Builder()
                        .addInterceptor(HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        })
                        .build()

        return Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

    }

    @Provides
    @Singleton
    fun provideMarvelHeroesService(retrofit: Retrofit): MarvelHeroesService =
            retrofit.create(MarvelHeroesService::class.java)

}