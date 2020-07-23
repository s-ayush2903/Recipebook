package com.stvayush.recipebook.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.stvayush.recipebook.requests.RecipeApi
import com.stvayush.recipebook.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Authored by s-ayush2903 on 23/7/20
 */

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideRetrofitService(gson: Gson): Retrofit.Builder =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))

    @Singleton
    @Provides
    fun provideRecipeApi(retrofit: Retrofit.Builder): RecipeApi =
        retrofit
            .build()
            .create(RecipeApi::class.java)


}
