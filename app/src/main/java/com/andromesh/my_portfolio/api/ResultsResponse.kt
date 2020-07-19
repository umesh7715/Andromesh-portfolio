package com.andromesh.my_portfolio.api

import com.google.gson.annotations.SerializedName

data class ResultsResponse<T>(
        @SerializedName("totalResults")
        val totalResults: Int,
        @SerializedName("Search")
        val search: List<T>,
        @SerializedName("Response")
        val response: Boolean
)