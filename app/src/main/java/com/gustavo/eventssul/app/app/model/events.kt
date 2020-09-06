package com.gustavo.eventssul.app.app.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Events(
    @SerializedName("id") var id: String? = null,
    @SerializedName("people") var people: List<People>? = null,
    @SerializedName("date") var date: Long? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("longitude") var longitude: Double = 0.0,
    @SerializedName("latitude") var latitude: Double = 0.0,
    @SerializedName("price") var price: Double? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("cupons") var cupons: List<Cupons>? = null

) : Parcelable