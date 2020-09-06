package com.gustavo.eventssul.home

import com.gustavo.eventssul.app.app.home.HomeActivity
import com.gustavo.eventssul.app.app.home.HomeInteractor
import com.gustavo.eventssul.app.app.home.HomePresenter
import com.gustavo.eventssul.app.app.home.HomeRouter
import com.gustavo.eventssul.app.app.model.Events
import com.nhaarman.mockitokotlin2.*
import io.kotlintest.shouldBe
import org.junit.Test

class HomePresenterTest {

    private var interactor = mock<HomeInteractor>()

    private var router = mock<HomeRouter>()

    private val presenter = HomePresenter(router, interactor)
    @Test
    fun `bindView() should get view`()   {
        //give
        val view = HomeActivity()

        // when
        presenter.bindView(view)

        // then
        presenter.view shouldBe view
    }

    @Test
    fun `unbindView() should set null view`() {
        // when
        presenter.unbindView()

        // then
        presenter.view shouldBe null
        verify(interactor).dispose()
    }

    @Test
    fun `onViewCreated() should load screen and call interactor`() {
        // when
        presenter.onViewCreated()

        // then
        verify(interactor).getEvents(any(), any())
    }

    @Test
    fun `onItemClicked() should call router open details`() {
        //give
        val events = Events()

        // when
        presenter.onItemClicked(events)

        // then
        verify(router).openEventDetails(events)
    }

    @Test
    fun `onBackClicked() should call router back`() {
        // when
        presenter.onBackClicked()

        // then
        verify(router).finish()
    }
}