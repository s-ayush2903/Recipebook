package com.stvayush.recipebook.requests

import retrofit2.Call
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
    ): Call<RecipeSearchResponse>


    @GET("api/get")
    fun getRecipes(
        @Query("rId") recipeId:Int
    ): Call<RecipeResponse>

}
