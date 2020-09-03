package com.gustavo.eventssul.app.app.splash.di

import com.gustavo.eventssul.app.app.di.ActivityScope
import com.gustavo.eventssul.app.app.splash.SplashActivity
import com.gustavo.eventssul.app.app.splash.SplashContract
import com.gustavo.eventssul.app.app.splash.SplashPresenter
import com.gustavo.eventssul.app.app.splash.SplashRouter
import dagger.Module
import dagger.Provides

@Module
class SplashModule {

    @Provides
    @ActivityScope
    fun router(activity: SplashActivity): SplashContract.Router = SplashRouter(activity)

    @Provides
    @ActivityScope
    fun presenter(router: SplashContract.Router) = SplashPresenter(router)
}