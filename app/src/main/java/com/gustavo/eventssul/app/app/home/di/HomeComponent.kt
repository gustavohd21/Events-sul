package com.gustavo.eventssul.app.app.home.di

import com.gustavo.eventssul.app.app.di.ActivityScope
import com.gustavo.eventssul.app.app.di.AppComponent
import com.gustavo.eventssul.app.app.home.HomeActivity
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(modules = [HomeModule::class], dependencies = [AppComponent::class])
interface HomeComponent {

    fun inject(target: HomeActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: HomeActivity): Builder

        fun appComponent(component: AppComponent): Builder

        fun plus(module: HomeModule): Builder

        fun build(): HomeComponent
    }
}