package com.gustavo.eventssul.splash

import com.gustavo.eventssul.app.app.splash.SplashActivity
import com.gustavo.eventssul.app.app.splash.SplashContract
import com.gustavo.eventssul.app.app.splash.SplashPresenter
import com.nhaarman.mockitokotlin2.*
import io.kotlintest.shouldBe
import org.junit.Test

class SplashPresenterTest {
    private val router = mock<SplashContract.Router>()

    private val presenter = spy(SplashPresenter(router))

    @Test
    fun `bindView() should set view to presenter`() {
        //give
        val viewMock = SplashActivity()

        // when
        presenter.bindView(viewMock)

        // then
        presenter.view shouldBe viewMock
    }

    @Test
    fun `unbindView() should set null to view`() {

        // when
        presenter.unbindView()

        // then
        presenter.view shouldBe null
    }
}