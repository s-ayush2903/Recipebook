package com.stvayush.recipebook.framework

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.stvayush.recipebook.networking.serverresponses.RecipeResponse
import com.stvayush.recipebook.networking.serverresponses.RecipeSearchResponse
import com.stvayush.recipebook.repo.Repository
import com.stvayush.recipebook.utils.GenericApiResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.coroutines.coroutineContext

/**
 * Authored by s-ayush2903 on 24/7/20
 */

class RecipeListViewModel @ViewModelInject constructor(private val repository: Repository) :
    ViewModel() {
    fun testSearch(
        query: String,
        pageNo: Int
    ): Flow<LiveData<GenericApiResponse<RecipeSearchResponse>>> = flow {
        repository.testSearchFun(query, pageNo).asLiveData(coroutineContext, 1).observeForever {
            Observer<GenericApiResponse<RecipeSearchResponse>>{
                when (it) {
                    is GenericApiResponse.ApiErrorResponse<*> -> {
                        Log.d(TAG, "onCreate-API_ERROR_RESPONSE: ${it.errorMessage}")
                    }
                    is GenericApiResponse.ApiEmptyResponse<*> -> {
                        Log.d(TAG, "onCreate: EMPTY RESPONSE!!!")
                    }
                    is GenericApiResponse.ApiSuccessResponse<*> -> {
                        Log.d(TAG, "onCreate:API_SUCCESS_RESPONSE: ${it.body}")
                    }
                }
            }

        }
    }

    fun testGet(recipeId: Int): LiveData<GenericApiResponse<RecipeResponse>> {
        return repository.testGetFun(recipeId)
    }

    companion object{
        private const val TAG = "RecipeListViewModel"
    }

//    override fun onCleared() {
//        repository.testSearchFun().asLiveData().removeObserver(Observer<GenericApiResponse<RecipeSearchResponse>>)
//        super.onCleared()
//    }

}
