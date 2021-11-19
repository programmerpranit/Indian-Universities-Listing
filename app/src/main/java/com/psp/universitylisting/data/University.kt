package com.psp.universitylisting.data

import androidx.room.Entity

@Entity(tableName = "Universities")
data class University(
    val alpha_two_code: String,
    val country: String,
    val domains: List<String>,
    val name: String,
    val state_province: String,
    val web_pages: List<String>
)