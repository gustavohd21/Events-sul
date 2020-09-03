package com.gustavo.eventssul.app.app.home.api

import com.gustavo.eventssul.app.app.model.Events
import io.reactivex.Single
import retrofit2.http.GET

interface HomeApi {

    @GET("api/events")
    fun getData(): Single<List<Events>>

}