package com.stvayush.recipebook.datamodelling

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Authored by s-ayush2903 on 17/7/20
 */
@Parcelize
data class Recipe(
    val title: String?,
    val publisher: String?,
    val recipe_id: String?,
    val social_rank: Float?,
    val ingredients: ArrayList<String>?
) : Parcelable {
}
