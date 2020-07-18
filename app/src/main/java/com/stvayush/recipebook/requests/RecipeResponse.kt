package com.stvayush.recipebook.requests

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.stvayush.recipebook.datamodelling.Recipe


/**
 * Authored by s-ayush2903 on 17/7/20
 */
class RecipeResponse {

    @SerializedName("recipe")
    @Expose
    private var recipe: Recipe? = null

    fun getRecipe():Recipe? = recipe

    override fun toString(): String {
        return "RecipeResponse(recipe=$recipe)"
    }

}
