package com.stvayush.recipebook

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class RecipeListActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        findViewById<Button>(R.id.test_button).setOnClickListener {
            if (progressBar!!.visibility == View.VISIBLE) {
                Log.d(TAG, "onCreate: Showing the progress bar")
                showProgressBar(false)
            } else {
                Log.d(TAG, "onCreate: Turning off the progress bar")
                showProgressBar(visible = true)
            }
        }

    }

    companion object {
        private const val TAG = "RecipeListActivity"
    }
}