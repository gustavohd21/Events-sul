package com.gustavo.eventssul.app.app.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gustavo.eventssul.R
import com.gustavo.eventssul.app.app.App
import com.gustavo.eventssul.app.app.home.adapter.HomeAdapter
import com.gustavo.eventssul.app.app.home.di.DaggerHomeComponent
import com.gustavo.eventssul.app.app.home.di.HomeComponent
import com.gustavo.eventssul.app.app.home.di.HomeModule
import com.gustavo.eventssul.app.app.model.Events
import kotlinx.android.synthetic.main.activity_home.*
import javax.inject.Inject


class HomeActivity : AppCompatActivity(), HomeContract.View {

    companion object {
        fun launch(context: Context) {
            val intent = Intent(context, HomeActivity::class.java)
            context.startActivity(intent)
        }
    }

    @Inject
    lateinit var presenter: HomePresenter

    val component: HomeComponent by lazy {
        DaggerHomeComponent.builder()
            .appComponent((application as App).component)
            .activity(this)
            .plus(HomeModule())
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initView()
        component.inject(this)
        presenter.bindView(this)
        presenter.onViewCreated()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
    }

    override fun showLoading() {
        recyclerView.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        recyclerView.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }

    override fun publishData(data: List<Events>) {
       val adapter = HomeAdapter(data, object : HomeAdapter.EventsListener {
          override fun onItemClick(event: Events) {
                presenter.onItemClicked(event)
            }
        })
        recyclerView.adapter = adapter
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun initView() {
        val manager = LinearLayoutManager(this).apply { orientation = LinearLayoutManager.VERTICAL }
        recyclerView.layoutManager = manager
    }

}