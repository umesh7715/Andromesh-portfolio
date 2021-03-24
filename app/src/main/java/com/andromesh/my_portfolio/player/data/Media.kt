package com.andromesh.my_portfolio.player.data

data class Media(private val name: String,
                 private val url: String,
                 private val mediaType: MediaType) {

    enum class MediaType {
        VIDEO, AUDIO
    }

}