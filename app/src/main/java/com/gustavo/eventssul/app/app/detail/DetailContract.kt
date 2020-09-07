package com.gustavo.eventssul.app.app.detail

import android.content.Context
import com.gustavo.eventssul.app.app.detail.model.CheckIn
import com.gustavo.eventssul.app.app.model.Events
import io.reactivex.Observable
import io.reactivex.Single

interface DetailContract {
    interface View {
        fun publishData(event: Events)

        fun showLoading()

        fun hideLoading()

        fun openDialog(event: Events)

        fun openDialogSuccess()

        fun openDialogError()
    }

    interface Presenter {
        fun bindView(view: View)

        fun unbindView()

        fun onViewCreated(event: Events)

        fun shareButtonClicked(context: Context,event: Events)

        fun onBackClicked()

        fun checkInClicked(event: Events)

        fun checkInSendClicked(name:String, email: String, event: Events)

        fun checkInResult(result: Boolean)
    }

    interface Router {
        fun finish()

        fun openShared(context: Context, description: String)
    }

    interface Repository {
        fun sendPost(name: String, email: String, eventId: String): Observable<CheckIn>
    }
}