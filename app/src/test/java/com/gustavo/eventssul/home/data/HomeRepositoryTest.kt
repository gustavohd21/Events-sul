package com.gustavo.eventssul.home.data

import com.gustavo.eventssul.app.app.home.api.HomeApi
import com.gustavo.eventssul.app.app.home.data.HomeRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.verify
import io.kotlintest.shouldBe
import org.junit.Test

class HomeRepositoryTest {
    private val api = mock<HomeApi>()
    private var homeRepository = spy(HomeRepository(api))

    @Test
    fun `getEvents() should return empty list events`() {
        // when
       val events = homeRepository.getEvents()

        // then
        events shouldBe null
    }
}