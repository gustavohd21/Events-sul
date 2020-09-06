package com.gustavo.eventssul.app.app.detail.di

import com.gustavo.eventssul.app.app.detail.DetailActivity
import com.gustavo.eventssul.app.app.di.ActivityScope
import com.gustavo.eventssul.app.app.di.AppComponent
import dagger.BindsInstance
import dagger.Component

@ActivityScope
@Component(modules = [DetailModule::class], dependencies = [AppComponent::class])
interface DetailComponent {

    fun inject(target: DetailActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun activity(activity: DetailActivity): Builder

        fun appComponent(component: AppComponent): Builder

        fun plus(module: DetailModule): Builder

        fun build(): DetailComponent
    }
}