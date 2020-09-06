package com.gustavo.eventssul.app.app.detail.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CheckIn(
    @SerializedName("eventId") var eventId: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("email") var email: String? = null
) : Parcelable