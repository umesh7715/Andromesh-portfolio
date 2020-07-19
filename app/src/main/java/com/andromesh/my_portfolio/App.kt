package com.andromesh.my_portfolio

import android.app.Activity
import android.app.Application
import com.andromesh.my_portfolio.di.AppInjector
import com.andromesh.my_portfolio.util.CrashReportingTree
import com.facebook.stetho.Stetho
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

class App : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) Stetho.initializeWithDefaults(this)

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        else Timber.plant(CrashReportingTree())

        AppInjector.init(this)
    }

    override fun activityInjector() = dispatchingAndroidInjector
}