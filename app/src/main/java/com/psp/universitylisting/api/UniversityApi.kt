package com.psp.universitylisting.api

import com.psp.universitylisting.data.University
import retrofit2.http.GET

interface UniversityApi {

    companion object{
        val BASE_URL = "http://universities.hipolabs.com"
    }

    @GET(value = "/search?country=India")
    suspend fun getUniversities(): List<University>

}