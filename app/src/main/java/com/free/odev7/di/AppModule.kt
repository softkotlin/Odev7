package com.free.odev7.di

import android.content.Context
import androidx.room.Room
import com.free.odev7.data.datasource.NotlarDataSource
import com.free.odev7.data.repo.NotlarRepository
import com.free.odev7.room.NotlarDao
import com.free.odev7.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideNotlarRepository(nds: NotlarDataSource) : NotlarRepository {
        return NotlarRepository(nds)
    }

    @Provides
    @Singleton
    fun provideNotlarDataSource(ndao: NotlarDao) : NotlarDataSource {
        return NotlarDataSource(ndao)
    }

    @Provides
    @Singleton
    fun provideNotlarDao(@ApplicationContext context:Context) : NotlarDao {
        val vt = Room.databaseBuilder(context, Veritabani::class.java,"notlar.sqlite")
            .createFromAsset("notlar.sqlite").build()
        return vt.getNotlarDao()
    }
}