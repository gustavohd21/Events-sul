package com.gustavo.eventssul.home

import com.gustavo.eventssul.app.app.home.HomeInteractor
import com.gustavo.eventssul.app.app.home.data.HomeRepository
import com.gustavo.eventssul.app.app.model.Events
import com.nhaarman.mockitokotlin2.*
import io.kotlintest.shouldBe
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.Test

class HomeInteractorTest {

    private val listEvents = mock<Single<Events>>()

    private val compositeDisposable = mock<CompositeDisposable>()

    private var homeRepository = mock<HomeRepository>().stub {
        doReturn(listEvents).whenever(it).getEvents()
    }

    private val interactor = spy(HomeInteractor(homeRepository)) {
        doReturn(homeRepository).whenever(it).repository
        doReturn(compositeDisposable).whenever(it).compositeDisposable
    }

    @Test
    fun `dispose() should call compositeDisposable`() {
        // when
        interactor.dispose()

        // then
        interactor.compositeDisposable shouldBe compositeDisposable
        interactor.compositeDisposable.isDisposed shouldBe false
    }
}