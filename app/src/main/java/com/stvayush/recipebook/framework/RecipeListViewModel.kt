package com.stvayush.recipebook.framework

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.stvayush.recipebook.repo.Repository
import com.stvayush.recipebook.networking.serverresponses.RecipeResponse
import com.stvayush.recipebook.networking.serverresponses.RecipeSearchResponse
import com.stvayush.recipebook.utils.GenericApiResponse

/**
 * Authored by s-ayush2903 on 24/7/20
 */

class RecipeListViewModel @ViewModelInject constructor(private val repository: Repository) : ViewModel() {

    fun testSearch(query: String, pageNo: Int): LiveData<GenericApiResponse<RecipeSearchResponse>> {
        return repository.testSearchFun(query, pageNo)
    }

    fun testGet(recipeId:Int):LiveData<GenericApiResponse<RecipeResponse>>{
        return repository.testGetFun(recipeId)
    }

}
