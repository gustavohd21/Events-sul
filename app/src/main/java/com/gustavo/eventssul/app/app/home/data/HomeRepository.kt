package com.gustavo.eventssul.app.app.home.data

import com.gustavo.eventssul.app.app.home.HomeContract
import com.gustavo.eventssul.app.app.home.api.HomeApi
import com.gustavo.eventssul.app.app.model.Events
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRepository(private val api: HomeApi) : HomeContract.Repository {

    override fun getEvents(): Single<List<Events>> = api.getData()
}