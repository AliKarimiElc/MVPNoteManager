package com.example.mvpnotemanager.utilities.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.mvpnotemanager.pojoModels.Note
import com.example.mvpnotemanager.utilities.db.dao.NoteDao

@Database(entities = [Note::class], version = 1)
abstract class AppRoom : RoomDatabase() {
    abstract fun notes(): NoteDao

    companion object {
        private var roomInstance: AppRoom? = null
        @Synchronized
        fun getInstance(context: Context): AppRoom {
            if (roomInstance == null) {
                roomInstance =
                    Room.databaseBuilder(context.applicationContext, AppRoom::class.java, "NoteDatabase")
                        .allowMainThreadQueries().fallbackToDestructiveMigration()
                        .build()
            }
            return roomInstance as AppRoom
        }
    }
}