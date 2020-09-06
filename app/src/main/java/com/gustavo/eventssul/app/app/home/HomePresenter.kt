package com.gustavo.eventssul.app.app.home

import androidx.annotation.VisibleForTesting
import com.gustavo.eventssul.app.app.model.Events

class HomePresenter(private val router: HomeContract.Router, private val interactor: HomeInteractor) :
    HomeContract.Presenter {

    @VisibleForTesting
     var view: HomeContract.View? = null

    override fun bindView(view: HomeContract.View) {
        this.view = view
    }

    override fun unbindView() {
        view = null
        interactor.dispose()
    }

    override fun onViewCreated() {
        view?.showLoading()
        interactor.getEvents({
            view?.hideLoading()
            view?.publishData(it)
        }, this::onError)
    }

    override fun onItemClicked(event: Events) {
        router.openEventDetails(event)
    }

    override fun onBackClicked() {
        router.finish()
    }

    private fun onError(error: Throwable) {
        view?.hideLoading()
        error.message?.let { view?.showMessageError() }
    }

}