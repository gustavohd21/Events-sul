package com.gustavo.eventssul.home

import com.gustavo.eventssul.app.app.home.HomeInteractor
import com.gustavo.eventssul.app.app.home.data.HomeRepository
import com.gustavo.eventssul.app.app.model.Events
import com.nhaarman.mockitokotlin2.*
import kotlinx.coroutines.runBlocking
import org.junit.Test

class HomeInteractorTest {
    private var homeRepository = mock<HomeRepository>().stub {
        doReturn(emptyList<Events>()).whenever(it).getEvents()
    }

    private val interactor = spy(HomeInteractor(homeRepository)) {
        doReturn(homeRepository).whenever(it).repository
    }

    @Test
    fun `getEvents() with empty list should call presenterOutput`() = runBlocking  {
        // when
       // interactor.getEvents()

        // then
        Unit
    }

}