package com.free.odev7.data.datasource

import com.free.odev7.data.entity.Notlar
import com.free.odev7.room.NotlarDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class NotlarDataSource(var ndao: NotlarDao) {
    suspend fun kaydet(not:String){
        val yeniNot = Notlar(0,not)
        ndao.kaydet(yeniNot)
    }

    suspend fun guncelle(not_id:Int,not:String){
        val guncellenenNot = Notlar(not_id,not)
        ndao.guncelle(guncellenenNot)
    }

    suspend fun sil(not_id:Int){
        val silinenNot = Notlar(not_id,"")
        ndao.sil(silinenNot)
    }

    suspend fun notlariYukle() : List<Notlar> =
        withContext(Dispatchers.IO){
            return@withContext ndao.notlariYukle()
        }

    suspend fun ara(aramaKelimesi:String) : List<Notlar> =
        withContext(Dispatchers.IO){
            return@withContext ndao.ara(aramaKelimesi)
        }
}