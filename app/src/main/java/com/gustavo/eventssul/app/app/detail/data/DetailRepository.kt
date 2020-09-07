package com.gustavo.eventssul.app.app.detail.data

import com.gustavo.eventssul.app.app.detail.DetailContract
import com.gustavo.eventssul.app.app.detail.api.DetailApi
import com.gustavo.eventssul.app.app.detail.model.CheckIn
import io.reactivex.Observable

class DetailRepository(private val api: DetailApi) : DetailContract.Repository {

    override fun sendPost(name: String, email: String, eventId: String): Observable<CheckIn> =
        api.sendPost(name, email, eventId)
}