package com.example.mvpnotemanager.repository

import com.example.mvpnotemanager.pojoModels.Note
import com.example.mvpnotemanager.utilities.db.AppRoom

class NoteRepository(private var appRoom: AppRoom) {

    fun get():List<Note>{
        return appRoom.notes().get()
    }

    fun add(note:Note): Long {
        return appRoom.notes().insert(note)
    }

    fun update(note:Note){
        appRoom.notes().update(note)
    }

    fun delete(note: Note){
        appRoom.notes().delete(note)
    }
}