package com.psp.universitylisting.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UniversityDao {

    @Query("SELECT * from universities")
    fun getAllData(): Flow<List<University>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(universities:List<University>)

    @Query("DELETE from universities")
    suspend fun delete()

}