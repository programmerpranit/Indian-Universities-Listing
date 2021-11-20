package com.psp.universitylisting.ui

import androidx.lifecycle.*
import com.psp.universitylisting.api.UniversityApi
import com.psp.universitylisting.data.University
import com.psp.universitylisting.data.UniversityRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UniversityViewModel @Inject constructor(
    repo:UniversityRepo
):ViewModel() {

    val universities = repo.getUniversities().asLiveData()

}