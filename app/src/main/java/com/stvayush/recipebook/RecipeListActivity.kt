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
    private val recipeListViewModel: RecipeListViewModel by viewModels() // this is being injected not just normally instantiated

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)
        findViewById<Button>(R.id.test_button).setOnClickListener {
            testCalls()
        }
    }

    private fun testCalls() {
        recipeListViewModel.testSearch("chicken breast", 1).observe(this, Observer {
            when (it) {
                is ApiEmptyResponse -> {
                    Log.d(TAG, "onCreate: EMPTY RESPONSE!!!")
                }
                is ApiErrorResponse -> {
                    Log.d(TAG, "onCreate-API_ERROR_RESPONSE: ${it.errorMessage}")
                }
                is ApiSuccessResponse -> {
                    Log.d(TAG, "onCreate:API_SUCCESS_RESPONSE: ${it.body.recipesList}")
                    val resp = it.body.recipesList
                    if (resp != null) {
                        for (reicp in resp)
                            Log.d(TAG, "testCalls:PRINTING RECIPES TITLE -> ${reicp.title}")
                    }
                }
            }
        })
    }

    companion object {
        private const val TAG = "RecipeListActivity"
    }
}
