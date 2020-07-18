package com.stvayush.recipebook

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.stvayush.recipebook.datamodelling.Recipe
import com.stvayush.recipebook.requests.RecipeApi
import com.stvayush.recipebook.requests.RecipeSearchResponse
import com.stvayush.recipebook.requests.ServiceGenerator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeListActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        findViewById<Button>(R.id.test_button).setOnClickListener {
                testCalls()
//            if (progressBar!!.visibility == View.VISIBLE) {
//                Log.d(TAG, "onCreate: Showing the progress bar")
//                showProgressBar(false)
//            } else {
//                Log.d(TAG, "onCreate: Turning off the progress bar")
//                showProgressBar(visible = true)
//            }
        }

    }

    private fun testCalls() {

        val recipeApi: RecipeApi = ServiceGenerator.getRecipeApi
        val recipeSearchResponseCall: Call<RecipeSearchResponse> =
            recipeApi.searchRecipe("chicken breast", 1)
        recipeSearchResponseCall.enqueue(object : Callback<RecipeSearchResponse> {
            override fun onFailure(call: Call<RecipeSearchResponse>, t: Throwable) {
                Log.d(TAG, "onFailure: Failed")
                Log.d(TAG, "onFailure: " + t.message)

            }

            override fun onResponse(
                call: Call<RecipeSearchResponse>,
                response: Response<RecipeSearchResponse>
            ) {
                Log.d(TAG, "onResponse: Server Response:-> $response")
//                if (response.code() == 200) {
//                    val recipes: List<Recipe> = ArrayList(response.body().getRecipes())
//                    for (recipe2: Recipe in recipes) {
//                        Log.d(TAG, "onResponse: " + recipe2.copy())
//                    }
//                }
            }
        })


    }

    companion object {
        private const val TAG = "RecipeListActivity"
    }
}
