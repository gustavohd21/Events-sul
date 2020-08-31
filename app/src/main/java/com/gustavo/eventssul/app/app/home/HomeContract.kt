package com.gustavo.eventssul.app.app.home

import com.gustavo.eventssul.app.app.model.Events
import io.reactivex.Single

interface HomeContract {
    interface View {

    }

    interface Presenter {
      //  fun getEvenstResult(events:List<Events>)
    }

    interface PresenterOutput {
        fun getEvenstResult(events:List<Events>)
    }

    interface Interactor {
        suspend fun getEvents()
    }

    interface Router {
   //     fun finish()
      //  fun openFullJoke(joke: Joke)
    }

    interface Repository {
        fun getEvents(): List<Events>
    }
}