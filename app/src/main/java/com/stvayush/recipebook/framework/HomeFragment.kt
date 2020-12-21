package com.stvayush.recipebook.framework

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.stvayush.recipebook.R
import com.stvayush.recipebook.framework.HomeFragment.Companion.TAG
import com.stvayush.recipebook.utils.GenericApiResponse
import com.stvayush.recipebook.utils.GenericApiResponse.*
import kotlinx.android.synthetic.main.fragment_home.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private val recipeListViewModel: RecipeListViewModel by viewModels() // this is being injected not just normally instantiated

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val test_button = view?.findViewById<Button>(R.id.test_button)

        test_button?.setOnClickListener(View.OnClickListener {
            testSearch()
            testGetter()
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun testGetter() {
        recipeListViewModel.testGet(41470).observe(this, Observer {
            when (it) {
                is GenericApiResponse.ApiEmptyResponse -> {
                    Log.d(HomeFragment.TAG, "onCreate: EMPTY RESPONSE!!!")
                }
                is GenericApiResponse.ApiErrorResponse -> {
                    Log.d(HomeFragment.TAG, "onCreate-API_ERROR_RESPONSE: ${it.errorMessage}")
                }
                is GenericApiResponse.ApiSuccessResponse -> {
                    Log.d(HomeFragment.TAG, "testGetter: API_SUCCESS_RESPONSE-> ${it.body.recipe}")
                    Log.d(HomeFragment.TAG, "testGetter: PRINTING INGREDIENTS-> ${it.body.recipe?.ingredients}")
                }
            }
        })
    }

    private fun testSearch() {
        recipeListViewModel.testSearch("chicken breast", 1).observe(this, Observer {
            when (it) {
                is GenericApiResponse.ApiEmptyResponse -> {
                    Log.d(HomeFragment.TAG, "onCreate: EMPTY RESPONSE!!!")
                }
                is GenericApiResponse.ApiErrorResponse -> {
                    Log.d(HomeFragment.TAG, "onCreate-API_ERROR_RESPONSE: ${it.errorMessage}")
                }
                is GenericApiResponse.ApiSuccessResponse -> {
                    Log.d(HomeFragment.TAG, "onCreate:API_SUCCESS_RESPONSE: ${it.body.recipesList}")
                    val resp = it.body.recipesList
                    if (resp != null) {
                        for (reicp in resp)
                            Log.d(HomeFragment.TAG, "testCalls:PRINTING RECIPES TITLE -> ${reicp.title}")
                    }
                }
            }
        })
    }


    companion object {
        private const val TAG = "RecipeListActivity"
    }

}