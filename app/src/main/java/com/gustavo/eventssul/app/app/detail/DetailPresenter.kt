package com.gustavo.eventssul.app.app.detail

import android.content.Context
import androidx.annotation.VisibleForTesting
import com.gustavo.eventssul.app.app.detail.model.CheckIn
import com.gustavo.eventssul.app.app.model.Events

class DetailPresenter(private val router: DetailContract.Router,  private val interactor: DetailInteractor) : DetailContract.Presenter {

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
        val checkIn = CheckIn(name, email,event.id)
        interactor.sendcheckIn(checkIn,{
            view?.hideLoading()
            view?.openDialogSuccess()
        }, this::onError)
    }


    private fun onError(error: Throwable) {
        view?.hideLoading()
        view?.openDialogError()
    }
}