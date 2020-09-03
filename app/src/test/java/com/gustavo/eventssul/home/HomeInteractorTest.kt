package com.gustavo.eventssul.home

import com.gustavo.eventssul.app.app.home.HomeInteractor
import com.gustavo.eventssul.app.app.home.data.HomeRepository
import com.gustavo.eventssul.app.app.model.Events
import com.nhaarman.mockitokotlin2.*
import io.reactivex.Single
import org.junit.Test

class HomeInteractorTest {

    private val listEvents = mock<Single<Events>>()

    private var homeRepository = mock<HomeRepository>().stub {
        doReturn(listEvents).whenever(it).getEvents()
    }

    private val interactor = spy(HomeInteractor(homeRepository)) {
        doReturn(homeRepository).whenever(it).repository
    }

    @Test
    fun `getEvents() with empty list should call presenterOutput`()   {
        //give
       val onSuccess: (List<Events>) -> Unit = { list -> Unit }
       val onError: (Throwable) -> Unit = {thr -> Unit}
        // when
        interactor.getEvents(onSuccess, onError)

        verify(homeRepository).getEvents()
    }

}