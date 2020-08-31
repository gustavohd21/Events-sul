package com.gustavo.eventssul.app.app.home

import com.gustavo.eventssul.app.app.model.Events

class HomePresenterOutput(private val router: HomeContract.Router, private val view: HomeActivity) :
    HomeContract.PresenterOutput {
    override fun getEvenstResult(events: List<Events>) {
        TODO("Not yet implemented")
    }

    // private var view: MainContract.View? = null

}