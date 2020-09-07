package com.gustavo.eventssul.detail

import android.content.Context
import com.gustavo.eventssul.app.app.detail.DetailActivity
import com.gustavo.eventssul.app.app.detail.DetailInteractor
import com.gustavo.eventssul.app.app.detail.DetailPresenter
import com.gustavo.eventssul.app.app.detail.DetailRouter
import com.gustavo.eventssul.app.app.model.Events
import com.nhaarman.mockitokotlin2.*
import io.kotlintest.shouldBe
import org.junit.Test

class DetailPresenterTest {

    private var router = mock<DetailRouter>()

    private var interactor = mock<DetailInteractor>()

    private val presenter = DetailPresenter(router, interactor)
    @Test
    fun `bindView() should get view`()   {
        //give
        val view = DetailActivity()

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
    }

    @Test
    fun `shareButtonClicked() should call router`() {
        //give
        val context = mock<Context>()
        val event = Events()
        // when
        presenter.shareButtonClicked(context, event)

        // then
        verify(router).openShared(any(), any())
    }
    @Test
    fun `onBackClicked() should call router back`() {
        // when
        presenter.onBackClicked()

        // then
        verify(router).finish()
    }
}