package com.gustavo.eventssul.app.app.home.data

import com.gustavo.eventssul.app.app.home.HomeContract
import com.gustavo.eventssul.app.app.home.api.HomeApi
import com.gustavo.eventssul.app.app.model.Events
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRepository(private val api: HomeApi) : HomeContract.Repository {

    override fun getEvents(): List<Events>  {
        val call = api.getEvents()

        val request = call.execute()

        if (request.isSuccessful) {
            val events = request.body()
            if (events != null) {
                return events
            }
        }

        return emptyList()
    }
}