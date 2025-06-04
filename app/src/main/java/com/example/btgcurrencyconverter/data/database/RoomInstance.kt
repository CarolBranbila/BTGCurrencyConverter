package com.example.btgcurrencyconverter.data.database

import android.content.Context
import androidx.room.Room

fun createRoomDatabaseInstance(
    applicationContext: Context
) =
    Room.databaseBuilder(
        applicationContext,
        AppDataBase::class.java,
        "btg.db",
    ).build()