package com.psp.universitylisting.data

import androidx.room.withTransaction
import com.psp.universitylisting.api.UniversityApi
import com.psp.universitylisting.util.networkBoundResource
import javax.inject.Inject

class UniversityRepo @Inject constructor(
    private val api:UniversityApi,
    private val db:UniversityDatabase
) {
    private val universityDao = db.universityDao()

    fun getUniversities() = networkBoundResource(
        query = {
            universityDao.getAllData()
        },
        fetch = {
            api.getUniversities()
        },
        saveFetchResult = { universities ->
            db.withTransaction {
                universityDao.getAllData()
                universityDao.insert(universities)
            }
        },

    )
}