package com.gustavo.eventssul.app.app.splash

import androidx.annotation.VisibleForTesting
import com.gustavo.eventssul.app.app.home.HomeActivity


class SplashRouter(private val activity: SplashActivity) : SplashContract.Router {

    @VisibleForTesting
     val homeActivity = HomeActivity

    override fun openMain() {
        homeActivity.launch(activity)
        activity.finish()
    }
}