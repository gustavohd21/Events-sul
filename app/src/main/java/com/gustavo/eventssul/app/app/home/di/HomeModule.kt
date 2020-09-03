package com.gustavo.eventssul.app.app.home.di

import com.gustavo.eventssul.app.app.di.ActivityScope
import com.gustavo.eventssul.app.app.home.*
import com.gustavo.eventssul.app.app.home.api.HomeApi
import com.gustavo.eventssul.app.app.home.data.HomeRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import kotlin.coroutines.CoroutineContext

@Module
class HomeModule {

    @Provides
    @ActivityScope
    fun api(retrofit: Retrofit): HomeApi = retrofit.create(HomeApi::class.java)

    @Provides
    @ActivityScope
    fun repository(api: HomeApi) = HomeRepository(api)


    @Provides
    @ActivityScope
    fun router(activity: HomeActivity): HomeContract.Router = HomeRouter(activity)

    @Provides
    @ActivityScope
    fun presenter(router: HomeContract.Router, interactor: HomeInteractor) = HomePresenter(router, interactor)

    @Provides
    @ActivityScope
    fun interactor(repository: HomeRepository) = HomeInteractor(repository)
}