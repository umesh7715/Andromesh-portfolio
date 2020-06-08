package com.andromesh.movies_catalog.api

import com.google.gson.annotations.SerializedName

data class ResultsResponse<T>(
        @SerializedName("totalResults")
        val totalResults: Int,
        @SerializedName("Search")
        val search: List<T>,
        @SerializedName("Response")
        val response: List<T>
)