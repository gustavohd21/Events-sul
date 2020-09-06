package com.gustavo.eventssul.app.app.detail

import android.content.Context
import android.content.Intent
import android.location.Geocoder
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.gustavo.eventssul.BuildConfig
import com.gustavo.eventssul.R
import com.gustavo.eventssul.app.app.App
import com.gustavo.eventssul.app.app.detail.di.DaggerDetailComponent
import com.gustavo.eventssul.app.app.detail.di.DetailComponent
import com.gustavo.eventssul.app.app.detail.di.DetailModule
import com.gustavo.eventssul.app.app.model.Events
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.check_in_layout.view.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class DetailActivity : AppCompatActivity(), DetailContract.View {

    companion object {
        private const val EVENTS = "${BuildConfig.APPLICATION_ID}_EVENTS"

        fun launch(context: Context, data: Events) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EVENTS, data)
            context.startActivity(intent)
        }
    }

    @Inject
    lateinit var presenter: DetailPresenter

    val component: DetailComponent by lazy {
        DaggerDetailComponent.builder()
            .appComponent((application as App).component)
            .activity(this)
            .plus(DetailModule())
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        toolbar.setTitle(R.string.detail_title)
        toolbar.setNavigationOnClickListener { presenter.onBackClicked() }

        shareButton.setOnClickListener {
            presenter.shareButtonClicked(it.context,intent.getParcelableExtra(EVENTS))
        }

        checkInButton.setOnClickListener {
            presenter.checkInClicked(intent.getParcelableExtra(EVENTS))
        }

        component.inject(this)
        presenter.bindView(this)
        intent.getParcelableExtra<Events>(EVENTS)
        presenter.onViewCreated(intent.getParcelableExtra(EVENTS))

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
    }

    override fun publishData(events: Events) {
        val geocoder = Geocoder(applicationContext)
        val addressList =
            geocoder.getFromLocation(events.latitude, events.longitude,3)
        var addressResult = ""

        if (addressList != null && addressList.size > 0) {
            val address = addressList[0]
            val sb = StringBuilder()
            for (i in 0 until address.maxAddressLineIndex) {
                sb.append(address.getAddressLine(i))
                sb.append(address.locality).append("\n")
                sb.append(address.postalCode).append("\n")
                sb.append(address.countryName)
                addressResult = sb.toString()
            }
        }

        val formatter = SimpleDateFormat("dd/MM/yyyy")
        val  date = formatter.format(events.date?.let { Date(it) })

        Picasso.get()
            .load(events.image)
            .placeholder(R.drawable.image_empty)
            .error(R.drawable.image_empty)
            .into(imageDetail)

        titleEvents.text = events.title
        adress.text = addressResult
        price.text = "R$ ${events.price}"
        dateString.text = date
        description.text = events.description
    }

    override fun showLoading() {
        progressBarDetail.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBarDetail.visibility = View.GONE
    }

    override fun openDialog(events: Events) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.title_dialog)

        val viewInflated: View = LayoutInflater.from(this)
            .inflate(R.layout.check_in_layout,null, false)

        val inputEmail = viewInflated.inputEmail

        val inputName = viewInflated.inputName

        builder.setView(viewInflated)

        builder.setPositiveButton(R.string.send) { dialog, _ ->
            presenter.checkInSendClicked(inputName.toString(),inputEmail.toString(), events)
            dialog.dismiss()
        }

        builder.setNegativeButton(R.string.cancel) { dialog, _ ->
           dialog.dismiss()
        }

        builder.show()
    }

    override fun openDialogError() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.error_dialog_title)
        builder.setMessage(R.string.error_dialog_description)

        val alert = builder.create()

        alert.show()

        val countdownTimer = object : CountDownTimer(300, 100) {
            override fun onFinish() {
                alert.cancel()
            }

            override fun onTick(p0: Long) {

            }
        }
        countdownTimer.start()
    }

    override fun openDialogSuccess() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.success_dialog_title)
        builder.setMessage(R.string.success_dialog_description)

        val alert = builder.create()

        alert.show()

        val countdownTimer = object : CountDownTimer(300, 100) {
            override fun onFinish() {
                alert.cancel()
            }

            override fun onTick(p0: Long) {

            }
        }
        countdownTimer.start()
    }
}