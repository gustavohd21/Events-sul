package com.gustavo.eventssul.app.app.home

import com.gustavo.eventssul.app.app.home.data.HomeRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class HomeInteractor( val repository: HomeRepository,
                     private val presenter: HomePresenterOutput
) : HomeContract.Interactor {
    override suspend fun getEvents() {
        coroutineScope {
            launch {
                val events = repository.getEvents()
                presenter.getEvenstResult(events)
            }
        }
    }
}