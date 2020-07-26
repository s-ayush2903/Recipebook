package com.stvayush.recipebook.networking.serverresponses

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.stvayush.recipebook.datamodelling.Recipe


/**
 * Authored by s-ayush2903 on 17/7/20
 */

class RecipeSearchResponse {

    @SerializedName("count")
    @Expose
    val count: Int? = null

    @SerializedName(value = "recipes")
    @Expose
    val recipesList: List<Recipe>? = null

    override fun toString(): String {
        return "RecipeSearchResponse(count=$count, recipesList=$recipesList)"
    }

}
