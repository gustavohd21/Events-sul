package com.gustavo.eventssul.app.app.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gustavo.eventssul.R
import com.gustavo.eventssul.app.app.App
import com.gustavo.eventssul.app.app.splash.di.DaggerSplashComponent
import com.gustavo.eventssul.app.app.splash.di.SplashComponent
import com.gustavo.eventssul.app.app.splash.di.SplashModule
import javax.inject.Inject

class SplashActivity : AppCompatActivity(), SplashContract.View {

    @Inject
    lateinit var presenter: SplashPresenter

    val component: SplashComponent by lazy {
        DaggerSplashComponent.builder()
            .appComponent((application as App).component)
            .activity(this)
            .plus(SplashModule())
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        component.inject(this)
        presenter.bindView(this)
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
    }
}