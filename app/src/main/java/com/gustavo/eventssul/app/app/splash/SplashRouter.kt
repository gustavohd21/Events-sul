package com.gustavo.eventssul.app.app.splash

import androidx.annotation.VisibleForTesting
import com.gustavo.eventssul.MainActivity


class SplashRouter(private val activity: SplashActivity) : SplashContract.Router {

    @VisibleForTesting
     val mainActivity = MainActivity()

    override fun openMain() {
        activity.finish()
    }
}