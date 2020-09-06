package com.gustavo.eventssul.app.app.detail

import android.content.Context
import androidx.annotation.VisibleForTesting
import com.gustavo.eventssul.app.app.model.Events

class DetailPresenter(private val router: DetailContract.Router) : DetailContract.Presenter {

    @VisibleForTesting
    var view: DetailContract.View? = null

    override fun bindView(view: DetailContract.View) {
        this.view = view
    }

    override fun unbindView() {
        view = null
    }

    override fun onViewCreated(events: Events) {

        view?.publishData(events)
    }

    override fun shareButtonClicked(context: Context,event: Events) {
        val description = "Titulo: ${event.title} descrição: ${event.description}"
       router.openShared(context, description)
    }

    override fun onBackClicked() {
        router.finish()
    }

    override fun checkInClicked(event: Events) {
        view?.openDialog(event)
    }

    override fun checkInSendClicked(name:String, email: String, event: Events) {
        TODO("Not yet implemented")
    }

    override fun checkInResult(result: Boolean) {
        if (result) {
            view?.openDialogSuccess()
        } else {
            view?.openDialogError()
        }
    }
}