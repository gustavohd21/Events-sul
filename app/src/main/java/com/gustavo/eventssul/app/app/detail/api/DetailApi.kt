package com.gustavo.eventssul.app.app.detail.api

import com.gustavo.eventssul.app.app.detail.model.CheckIn
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface DetailApi {

    @POST("api/checkin")
    @FormUrlEncoded
     fun sendPost(
        @Field("name") name: String?,
        @Field("email") email: String?,
        @Field("eventId") eventId: String?
    ): Observable<CheckIn>

}