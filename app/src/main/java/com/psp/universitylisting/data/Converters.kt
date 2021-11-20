package com.psp.universitylisting.data

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromList(list: List<String>):String{
        return list[0]
    }

    @TypeConverter
    fun toList(website:String):List<String>{
        return listOf(website)
    }
}