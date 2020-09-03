package com.gustavo.eventssul.home.data

import com.gustavo.eventssul.app.app.home.api.HomeApi
import com.gustavo.eventssul.app.app.home.data.HomeRepository
import com.gustavo.eventssul.app.app.model.Events
import com.nhaarman.mockitokotlin2.*
import io.kotlintest.shouldBe
import io.reactivex.Single
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

    @Test
    fun `getEvents() should return  list events`() {
        //give
        val listEvents = mock<Single<Events>>()

        api.stub {
            doReturn(listEvents).whenever(it).getData()
        }
        // when
        val events = homeRepository.getEvents()

        // then
        events shouldBe listEvents
    }
}