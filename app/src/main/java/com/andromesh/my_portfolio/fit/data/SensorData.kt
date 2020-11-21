package com.andromesh.my_portfolio.fit.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "sensor_data")
data class SensorData(

        @PrimaryKey
        @field:SerializedName("timestamp")
        var timestamp: Long,

        @field:SerializedName("date")
        var date: String,

        @field:SerializedName("dayOfTheMonth")
        var dayOfTheMonth: Int,

        @field:SerializedName("hourOfTheDay")
        var hourOfTheDay: Int,

        @field:SerializedName("stepCount")
        var stepCount: Int,

        @field:SerializedName("runningStepCount")
        var runningStepCount: Int) {

    override fun toString(): String {
        return "SensorData(timestamp=$timestamp, date='$date', dayOfTheMonth=$dayOfTheMonth, hourOfTheDay='$hourOfTheDay', stepCount=$stepCount, runningStepCount=$runningStepCount)"
    }
}
