package com.stvayush.recipebook.repo

import androidx.lifecycle.LiveData
import com.stvayush.recipebook.requests.RecipeApi
import com.stvayush.recipebook.requests.RecipeResponse
import com.stvayush.recipebook.requests.RecipeSearchResponse
import com.stvayush.recipebook.utils.GenericApiResponse
import javax.inject.Inject

/**
 * Authored by s-ayush2903 on 24/7/20
 */

class Repository @Inject constructor(private val recipeApi: RecipeApi) {
    fun testSearchFun(
        query: String,
        pageNo: Int
    ): LiveData<GenericApiResponse<RecipeSearchResponse>> {
        return recipeApi.searchRecipe(query, pageNo)
    }

    fun testGetFun(recipeId: Int): LiveData<GenericApiResponse<RecipeResponse>> {
        return recipeApi.getRecipes(recipeId)
    }
}
