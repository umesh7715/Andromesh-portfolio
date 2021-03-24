package com.andromesh.my_portfolio.util

class APIKeyLibrary {

    init {
        System.loadLibrary("native-lib")
    }

    external fun getIMDBKey(): String


}
