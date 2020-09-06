package com.gustavo.eventssul.home

import com.gustavo.eventssul.app.app.home.HomeActivity
import com.gustavo.eventssul.app.app.home.HomeRouter
import com.gustavo.eventssul.app.app.model.Events
import com.nhaarman.mockitokotlin2.*
import org.junit.Test

class HomeRouterTest {

    private var view = mock<HomeActivity>()

    private val router = HomeRouter(view)

    @Test
    fun `finish() should finish screen`() {
        // when
        router.finish()

        // then
        verify(view).finish()
    }

    @Test
    fun `openEventDetails() should open detail screen`() {
        //give
        val events = Events()
        // when
        router.openEventDetails(events)

        // then
        verify(view).finish()
    }
}