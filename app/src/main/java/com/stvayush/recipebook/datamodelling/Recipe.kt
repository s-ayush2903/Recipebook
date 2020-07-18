package com.stvayush.recipebook.datamodelling

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parceler
import kotlinx.android.parcel.Parcelize

/**
 * Authored by s-ayush2903 on 17/7/20
 */
@Parcelize
data class Recipe(
    private val title: String?,
    private val publisher: String?,
    private val ingredients: Array<String>?,
    private val recipeId: String?,
    private val socialRank: Float
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArray(),
        parcel.readString(),
        parcel.readFloat()
    ) {
    }



    companion object : Parceler<Recipe> {

        override fun Recipe.write(parcel: Parcel, flags: Int) {
            parcel.writeString(title)
            parcel.writeString(publisher)
            parcel.writeStringArray(ingredients)
            parcel.writeString(recipeId)
            parcel.writeFloat(socialRank)
        }

        override fun create(parcel: Parcel): Recipe {
            return Recipe(parcel)
        }
    }

    override fun toString(): String {
        return "Recipe(title=$title, publisher=$publisher, ingredients=${ingredients?.contentToString()}, recipeId=$recipeId, socialRank=$socialRank)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Recipe

        if (title != other.title) return false
        if (publisher != other.publisher) return false
        if (ingredients != null) {
            if (other.ingredients == null) return false
            if (!ingredients.contentEquals(other.ingredients)) return false
        } else if (other.ingredients != null) return false
        if (recipeId != other.recipeId) return false
        if (socialRank != other.socialRank) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title?.hashCode() ?: 0
        result = 31 * result + (publisher?.hashCode() ?: 0)
        result = 31 * result + (ingredients?.contentHashCode() ?: 0)
        result = 31 * result + (recipeId?.hashCode() ?: 0)
        result = 31 * result + socialRank.hashCode()
        return result
    }
}
