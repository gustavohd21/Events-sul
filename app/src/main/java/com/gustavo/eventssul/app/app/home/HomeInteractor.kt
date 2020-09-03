package com.gustavo.eventssul.app.app.home

import com.gustavo.eventssul.app.app.home.data.HomeRepository
import com.gustavo.eventssul.app.app.model.Events
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeInteractor( val repository: HomeRepository
) : HomeContract.Interactor {
    private val compositeDisposable = CompositeDisposable()

    override fun getEvents(onSuccess: (List<Events>) -> Unit, onError: (Throwable) -> Unit) {

        val disposable = repository.getEvents()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess(onSuccess)
            .doOnError(onError)
            .subscribe({ println("ok") }, {throwable -> println("error $throwable") })

        compositeDisposable.add(disposable)
    }

    fun dispose() = compositeDisposable.dispose()
}