package com.emineakduman.donanmhaber.model.news

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "news")
data class NewsResults(

    @SerializedName("DateWellFormed")
    @ColumnInfo(name = "DateWellFormed")
    val DateWellFormed: String?,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "newsId")
    @SerializedName("Id")
    val newsId: Int,
    @SerializedName("Image")
    @ColumnInfo(name = "Image")
    val Image: Image?,
    @SerializedName("ShortContent")
    @ColumnInfo(name = "ShortContent")
    val ShortContent: String?,
    @SerializedName("Title")
    @ColumnInfo(name = "Title")
    val Title: String?,
    @SerializedName("TotalRead")
    @ColumnInfo(name = "TotalRead")
    val TotalRead: String?
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readParcelable(com.emineakduman.donanmhaber.model.news.Image::class.java.classLoader),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(DateWellFormed)
        parcel.writeInt(newsId)
        parcel.writeParcelable(Image, flags)
        parcel.writeString(ShortContent)
        parcel.writeString(Title)
        parcel.writeString(TotalRead)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NewsResults> {
        override fun createFromParcel(parcel: Parcel): NewsResults {
            return NewsResults(parcel)
        }

        override fun newArray(size: Int): Array<NewsResults?> {
            return arrayOfNulls(size)
        }
    }
}
