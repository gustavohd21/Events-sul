package com.gustavo.eventssul.splash

import com.gustavo.eventssul.app.app.splash.SplashActivity
import com.gustavo.eventssul.app.app.splash.SplashRouter
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test

class SplashRouterTest {
    private val fragment = mock<SplashActivity>()
    private var router = spy(SplashRouter(fragment))

    @Test
    fun `openMain() should go main screen and close splash screen`() {
        // when
        router.openMain()

        // then
        verify(fragment).finish()
    }
}