package com.gustavo.eventssul.app.app.splash.di

import com.gustavo.eventssul.app.app.di.ActivityScope
import com.gustavo.eventssul.app.app.di.AppComponent
import com.gustavo.eventssul.app.app.splash.SplashActivity
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(modules = [SplashModule::class], dependencies = [AppComponent::class])
interface SplashComponent {

    fun inject(target: SplashActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: SplashActivity): Builder

        fun appComponent(component: AppComponent): Builder

        fun plus(module: SplashModule): Builder

        fun build(): SplashComponent
    }
}