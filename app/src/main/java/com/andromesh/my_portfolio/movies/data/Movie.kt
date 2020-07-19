package com.andromesh.my_portfolio.movies.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie")
data class Movie(



        @field:SerializedName("Title")
        val title: String,

        @field:SerializedName("Year")
        val year: String,

        @PrimaryKey
        @field:SerializedName("imdbID")
        val imdbID: String,

        @field:SerializedName("Type")
        val type: String,

        @field:SerializedName("Poster")
        val poster: String
) {
    override fun toString(): String {
        return "Movie(title='$title', year='$year', imdbID='$imdbID', type='$type', poster='$poster')"
    }
}