package com.gustavo.eventssul.app.app.splash

import android.os.Handler
import androidx.annotation.VisibleForTesting

class SplashPresenter(private val router: SplashContract.Router) : SplashContract.Presenter {

    companion object {
        private const val SPLASH_DISPLAY_TIME = 1000L
    }

    @VisibleForTesting
     val handler = Handler()

    @VisibleForTesting
     var view: SplashContract.View? = null

    override fun bindView(view: SplashContract.View) {
        this.view = view
    }

    override fun unbindView() {
        view = null
    }

    override fun onViewCreated() {
        handler.postDelayed({
            router.openMain()
        }, SPLASH_DISPLAY_TIME)
    }
}