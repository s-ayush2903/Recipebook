package com.stvayush.recipebook

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.stvayush.recipebook.utils.GenericApiResponse.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListActivity : BaseActivity() {
    private val recipeListViewModel: RecipeListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)
        findViewById<Button>(R.id.test_button).setOnClickListener {
            testCalls()
        }
    }

    private fun testCalls() {
        recipeListViewModel.testSearch("breast chicken", 2).observe(this, Observer {
            when (it) {
                is ApiEmptyResponse -> {
                    Log.d(TAG, "onCreate: EMPTY RESPONSE!!!")
                }
                is ApiErrorResponse -> {
                    Log.d(TAG, "onCreate-API_ERROR_RESPONSE: ${it.errorMessage}")
                }
                is ApiSuccessResponse -> {
                    Log.d(TAG, "onCreate:API_SUCCESS_RESPONSE: ${it.body}")
                }
            }
        })
    }

    companion object {
        private const val TAG = "RecipeListActivity"
    }
}
