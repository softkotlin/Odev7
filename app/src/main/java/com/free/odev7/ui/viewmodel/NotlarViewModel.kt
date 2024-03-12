package com.free.odev7.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.free.odev7.data.entity.Notlar
import com.free.odev7.data.repo.NotlarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotlarViewModel @Inject constructor(var nrepo: NotlarRepository) : ViewModel() {
    var notlarListesi = MutableLiveData<List<Notlar>>()

    init {
        notlariYukle()
    }

    fun sil(not_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            nrepo.sil(not_id)
            notlariYukle()
        }
    }

    fun notlariYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            notlarListesi.value = nrepo.notlariYukle()
        }
    }

    fun ara(aramaKelimesi:String){
        CoroutineScope(Dispatchers.Main).launch {
            notlarListesi.value = nrepo.ara(aramaKelimesi)
        }
    }
}