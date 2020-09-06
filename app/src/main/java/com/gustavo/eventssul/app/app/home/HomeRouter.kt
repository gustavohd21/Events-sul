package com.gustavo.eventssul.app.app.home

import com.gustavo.eventssul.app.app.detail.DetailActivity
import com.gustavo.eventssul.app.app.model.Events

class HomeRouter(private val activity: HomeActivity) : HomeContract.Router {
    override fun finish() {
        activity.finish()
    }

    override fun openEventDetails(event: Events) {
        DetailActivity.launch(activity, event)
    }
}