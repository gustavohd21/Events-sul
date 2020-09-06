package com.gustavo.eventssul.app.app.detail.api

import com.gustavo.eventssul.app.app.detail.model.CheckIn
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface DetailApi {

    @POST("api/checkin")
    @FormUrlEncoded
     fun sendPost(
        @Field("eventId") eventId: String?,
        @Field("name") name: String?,
        @Field("email") email: String?
    ): Call<CheckIn?>?

}