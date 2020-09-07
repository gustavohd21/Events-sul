package com.gustavo.eventssul.app.app.detail.di

import com.gustavo.eventssul.app.app.detail.*
import com.gustavo.eventssul.app.app.detail.api.DetailApi
import com.gustavo.eventssul.app.app.detail.data.DetailRepository
import com.gustavo.eventssul.app.app.di.ActivityScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class DetailModule {

    @Provides
    @ActivityScope
    fun api(retrofit: Retrofit): DetailApi = retrofit.create(DetailApi::class.java)

    @Provides
    @ActivityScope
    fun repository(api: DetailApi) = DetailRepository(api)

    @Provides
    @ActivityScope
    fun router(activity: DetailActivity): DetailContract.Router = DetailRouter(activity)

    @Provides
    @ActivityScope
    fun presenter(router: DetailContract.Router, interactor: DetailInteractor) = DetailPresenter(router, interactor)

    @Provides
    @ActivityScope
    fun interactor(repository: DetailRepository) = DetailInteractor(repository)
}