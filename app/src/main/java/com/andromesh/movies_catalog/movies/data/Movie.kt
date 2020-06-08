package com.andromesh.movies_catalog.movies.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie")
data class Movie(
        @PrimaryKey
        val id: Long,

        @field:SerializedName("Title")
        val title: String,

        @field:SerializedName("Year")
        val year: String,

        @field:SerializedName("imdbID")
        val imdbID: String,

        @field:SerializedName("Type")
        val type: String,

        @field:SerializedName("Poster")
        val poster: String
) {
    override fun toString(): String {
        return "Movie(id=$id, title='$title', year='$year', imdbID='$imdbID', type='$type', poster='$poster')"
    }
}