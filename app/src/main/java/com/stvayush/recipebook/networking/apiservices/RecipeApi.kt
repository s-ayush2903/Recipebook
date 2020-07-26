package com.stvayush.recipebook.networking.apiservices

import androidx.lifecycle.LiveData
import com.stvayush.recipebook.networking.serverresponses.RecipeResponse
import com.stvayush.recipebook.networking.serverresponses.RecipeSearchResponse
import com.stvayush.recipebook.utils.GenericApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Authored by s-ayush2903 on 17/7/20
 */

interface RecipeApi {

    @GET("api/search")
    fun searchRecipe(
        @Query("q") query: String,
        @Query("page") page: Int
    ): LiveData<GenericApiResponse<RecipeSearchResponse>>


    @GET("api/get")
    fun getRecipes(
        @Query("rId") recipeId: Int
    ): LiveData<GenericApiResponse<RecipeResponse>>

}
