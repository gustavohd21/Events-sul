package com.gustavo.eventssul.app.app.home

import com.gustavo.eventssul.app.app.model.Events
import io.reactivex.Single

interface HomeContract {
    interface View {
        fun showLoading()
        fun hideLoading()
        fun publishData(data: List<Events>)
        fun showMessage(msg: String)
    }

    interface Presenter {
        fun bindView(view: View)

        fun unbindView()

        fun onViewCreated()

        fun onItemClicked(event: Events)

        fun onBackClicked()
    }


    interface Interactor {
        fun getEvents(onSuccess: (List<Events>) -> Unit, onError: (Throwable) -> Unit)
    }

    interface Router {
        fun finish()
        fun openEventDetails(event: Events)
    }

    interface Repository {
        fun getEvents(): Single<List<Events>>
    }
}