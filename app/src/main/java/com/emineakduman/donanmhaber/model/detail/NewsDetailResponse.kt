package com.emineakduman.donanmhaber.model.detail

import android.os.Parcel
import android.os.Parcelable
import com.emineakduman.donanmhaber.model.news.Image
import com.google.gson.annotations.SerializedName

data class NewsDetailResponse (
    @SerializedName("DateWellFormed")
    val DateWellFormed: String?,
    @SerializedName("Id")
    val Id: Int,
    @SerializedName("Image")
    val Image: Image?,
    @SerializedName("ShortContent")
    val ShortContent: String?,
    @SerializedName("Title")
    val Title: String?,
    @SerializedName("TotalRead")
    val TotalRead: Int
        ):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readParcelable(com.emineakduman.donanmhaber.model.news.Image::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(DateWellFormed)
        parcel.writeInt(Id)
        parcel.writeParcelable(Image, flags)
        parcel.writeString(ShortContent)
        parcel.writeString(Title)
        parcel.writeInt(TotalRead)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NewsDetailResponse> {
        override fun createFromParcel(parcel: Parcel): NewsDetailResponse {
            return NewsDetailResponse(parcel)
        }

        override fun newArray(size: Int): Array<NewsDetailResponse?> {
            return arrayOfNulls(size)
        }
    }
}