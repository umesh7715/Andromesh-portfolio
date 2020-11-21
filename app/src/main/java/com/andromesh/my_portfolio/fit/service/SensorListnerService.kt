package com.andromesh.my_portfolio.fit.service

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.IBinder
import android.util.Log
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.andromesh.my_portfolio.auth.ui.AuthViewModel
import com.andromesh.my_portfolio.fit.data.SensorData
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class SensorListnerService : LifecycleService(), SensorEventListener {


    private lateinit var mSensorManager: SensorManager
    val dateFormat: DateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.US)


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var authViewModel: AuthViewModel

    override fun onCreate() {

        super.onCreate()

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {


        super.onStartCommand(intent, flags, startId)
        return START_STICKY
    }

    override fun onBind(intent: Intent): IBinder {
        return super.onBind(intent)!!
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    override fun onSensorChanged(sensorEvent: SensorEvent?) {

        val cal: Calendar = Calendar.getInstance()

        cal.time = Date(sensorEvent?.timestamp!!)
        
        var sensorData = SensorData(sensorEvent.timestamp,
                dateFormat.format(cal.time),
                cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.HOUR_OF_DAY),
                sensorEvent.values?.get(0)!!.toInt(),
                0)


    }

}
