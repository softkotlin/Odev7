package com.free.odev7.data.repo

import com.free.odev7.data.datasource.NotlarDataSource
import com.free.odev7.data.entity.Notlar

class NotlarRepository(var nds: NotlarDataSource) {

    suspend fun kaydet(not:String) = nds.kaydet(not)

    suspend fun guncelle(not_id:Int,not:String) = nds.guncelle(not_id, not)

    suspend fun sil(not_id:Int) = nds.sil(not_id)

    suspend fun notlariYukle() : List<Notlar> = nds.notlariYukle()

    suspend fun ara(aramaKelimesi:String) : List<Notlar> = nds.ara(aramaKelimesi)
}