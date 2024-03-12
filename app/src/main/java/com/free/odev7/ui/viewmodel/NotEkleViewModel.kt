package com.free.odev7.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.free.odev7.data.repo.NotlarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotEkleViewModel @Inject constructor(var nrepo: NotlarRepository): ViewModel() {

    fun kaydet(not:String){
        CoroutineScope(Dispatchers.Main).launch {
            nrepo.kaydet(not)
        }
    }
}