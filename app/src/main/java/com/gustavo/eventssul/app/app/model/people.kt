package com.gustavo.eventssul.app.app.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class People(
    @SerializedName("id") var id: String? = null,
    @SerializedName("eventId") var eventId: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("picture") var picture: String? = null
) : Parcelable