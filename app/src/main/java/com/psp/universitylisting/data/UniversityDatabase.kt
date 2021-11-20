package com.psp.universitylisting.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [University::class], version = 1)
@TypeConverters(Converters::class)
abstract class UniversityDatabase:RoomDatabase() {

    abstract fun universityDao():UniversityDao



}