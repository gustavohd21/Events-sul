package com.gustavo.eventssul.app.app.detail

import androidx.annotation.VisibleForTesting
import com.gustavo.eventssul.app.app.detail.data.DetailRepository
import com.gustavo.eventssul.app.app.detail.model.CheckIn
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailInteractor( val repository: DetailRepository
) : DetailContract.Interactor {

    @VisibleForTesting
    val compositeDisposable = CompositeDisposable()

    override fun sendcheckIn(checkIn: CheckIn, onSuccess: () -> Unit, onError: (Throwable) -> Unit) {
        val disposable =repository.sendPost(checkIn.name, checkIn.email, checkIn.eventId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError(onError)
            .doOnComplete(onSuccess)
            .subscribe({ println("ok") }, {throwable -> println("error $throwable") })

        compositeDisposable.add(disposable)
    }

    fun dispose() {
        compositeDisposable.dispose()
    }
}