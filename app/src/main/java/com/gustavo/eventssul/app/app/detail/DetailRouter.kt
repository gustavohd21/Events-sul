package com.gustavo.eventssul.app.app.detail

import android.content.Context
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity

class DetailRouter(private val activity: DetailActivity) : DetailContract.Router {

    override fun finish() {
        activity.finish()
    }

    override fun openShared(context: Context,description: String) {
        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, description)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)
        startActivity(context,shareIntent, null)
    }
}