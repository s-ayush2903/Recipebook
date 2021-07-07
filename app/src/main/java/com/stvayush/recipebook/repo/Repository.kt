package com.stvayush.recipebook.repo

import androidx.lifecycle.LiveData
import com.stvayush.recipebook.networking.apiservices.RecipeApi
import com.stvayush.recipebook.networking.serverresponses.RecipeResponse
import com.stvayush.recipebook.networking.serverresponses.RecipeSearchResponse
import com.stvayush.recipebook.utils.GenericApiResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Authored by s-ayush2903 on 24/7/20
 */

class Repository @Inject constructor(private val recipeApi: RecipeApi) {
    suspend fun testSearchFun(
        query: String,
        pageNo: Int
    ): Flow<LiveData<GenericApiResponse<RecipeSearchResponse>>> = flow {
//        emit(DataState.LOADING)
        try {
            recipeApi.searchRecipe(query, pageNo)
        } catch (exc: Exception) {
//            emit(DataState.ERROR)
        }
    }

    fun testGetFun(recipeId: Int): LiveData<GenericApiResponse<RecipeResponse>> {
        return recipeApi.getRecipes(recipeId)
    }
}
