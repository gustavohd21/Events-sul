package com.gustavo.eventssul.app.app.detail.di

import com.gustavo.eventssul.app.app.detail.DetailActivity
import com.gustavo.eventssul.app.app.detail.DetailContract
import com.gustavo.eventssul.app.app.detail.DetailPresenter
import com.gustavo.eventssul.app.app.detail.DetailRouter
import com.gustavo.eventssul.app.app.di.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class DetailModule {

    @Provides
    @ActivityScope
    fun router(activity: DetailActivity): DetailContract.Router = DetailRouter(activity)

    @Provides
    @ActivityScope
    fun presenter(router: DetailContract.Router) = DetailPresenter(router)
}