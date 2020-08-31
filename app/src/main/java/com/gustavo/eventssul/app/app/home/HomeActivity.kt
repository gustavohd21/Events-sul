package com.gustavo.eventssul.app.app.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.gustavo.eventssul.app.app.App
import com.gustavo.eventssul.app.app.home.di.DaggerHomeComponent
import com.gustavo.eventssul.app.app.home.di.HomeComponent
import com.gustavo.eventssul.app.app.home.di.HomeModule
import javax.inject.Inject


class HomeActivity : AppCompatActivity(), HomeContract.View {

    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, HomeActivity::class.java)
            context.startActivity(intent)
        }
    }

    @Inject
    lateinit var presenter: HomePresenter

    val component: HomeComponent by lazy {
        DaggerHomeComponent.builder()
            .appComponent((application as App).component)
            .activity(this)
            .plus(HomeModule())
            .build()
    }


}