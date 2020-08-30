package com.gustavo.eventssul.app.app

import android.app.Application
import com.gustavo.eventssul.app.app.di.AppComponent
import com.gustavo.eventssul.app.app.di.AppModule
import com.gustavo.eventssul.app.app.di.DaggerAppComponent

class App : Application() {

    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
            .context(this)
            .plus(AppModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        component.inject(this)
    }
}