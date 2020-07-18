package com.stvayush.recipebook.requests

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.stvayush.recipebook.datamodelling.Recipe


/**
 * Authored by s-ayush2903 on 17/7/20
 */

class RecipeSearchResponse {

    @SerializedName("count")
    @Expose
    private val count: Int? = null

    @SerializedName(value = "recipe")
    @Expose
    private var recipesList: List<Recipe>? = null

    fun getCount(): Int? {
        return count
    }
    fun getRecipes(): List<Recipe>? {
        return recipesList
    }
    override fun toString(): String {
        return "RecipeSearchResponse(count=$count, recipesList=$recipesList)"
    }

}
