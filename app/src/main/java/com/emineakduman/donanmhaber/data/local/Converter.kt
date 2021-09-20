package com.emineakduman.donanmhaber.data.local

import androidx.room.TypeConverter
import com.emineakduman.donanmhaber.model.news.Image

class Converter {
    @TypeConverter
    fun fromImage(image: Image): String{
        return image.toString()
    }

    @TypeConverter
    fun toImage(value:String):Image{
        return Image(value)
    }
}