package com.gustavo.eventssul.app.app.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cupons(
    @SerializedName("id") var id: String? = null,
    @SerializedName("eventId") var eventId: String? = null,
    @SerializedName("discount") var discount: Int? = null
) : Parcelable