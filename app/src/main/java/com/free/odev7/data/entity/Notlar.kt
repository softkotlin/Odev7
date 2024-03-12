package com.free.odev7.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "notlar")
data class Notlar(@PrimaryKey(autoGenerate = true)
                  @ColumnInfo(name = "not_id") var not_id:Int,
                  @ColumnInfo(name = "not") var not:String) : Serializable {

}