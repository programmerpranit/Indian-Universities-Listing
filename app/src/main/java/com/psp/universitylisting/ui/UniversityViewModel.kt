package com.psp.universitylisting.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psp.universitylisting.api.UniversityApi
import com.psp.universitylisting.data.University
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UniversityViewModel @Inject constructor(
    api:UniversityApi
):ViewModel() {

    private val universityLiveData = MutableLiveData<List<University>>()
    val universities:LiveData<List<University>> = universityLiveData

    init {
        viewModelScope.launch {
            val universitiesList = api.getUniversities()
            universityLiveData.value = universitiesList
        }
    }
}