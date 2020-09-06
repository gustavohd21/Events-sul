package com.gustavo.eventssul.detail

import com.gustavo.eventssul.app.app.detail.DetailActivity
import com.gustavo.eventssul.app.app.detail.DetailRouter
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

class DetailRouterTest {

    private var view = mock<DetailActivity>()

    private val router = DetailRouter(view)

    @Test
    fun `finish() should finish screen`() {
        // when
        router.finish()

        // then
        verify(view).finish()
    }
}