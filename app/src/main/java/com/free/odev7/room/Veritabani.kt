package com.free.odev7.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.free.odev7.data.entity.Notlar

@Database(entities = [Notlar::class], version = 1)
abstract class Veritabani : RoomDatabase()  {
    abstract fun getNotlarDao() : NotlarDao

}