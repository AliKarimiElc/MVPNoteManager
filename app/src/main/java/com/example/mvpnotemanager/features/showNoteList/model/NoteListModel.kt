package com.example.mvpnotemanager.features.showNoteList.model

import android.content.Context
import com.example.mvpnotemanager.features.showNoteList.Contract
import com.example.mvpnotemanager.pojoModels.Note
import com.example.mvpnotemanager.repository.NoteRepository
import com.example.mvpnotemanager.utilities.db.AppRoom

class NoteListModel(presenter: Contract.Presenter,context: Context){

    var appRoom=AppRoom.getInstance(context)
    var repository = NoteRepository(appRoom)

    fun getNotes(): List<Note> {
        return repository.get()
    }

    fun deleteNote(note: Note) {
        repository.delete(note)
    }


}