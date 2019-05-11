package com.example.mvpnotemanager.features.addNewNote.model

import android.content.Context
import com.example.mvpnotemanager.features.addNewNote.AddNoteContract
import com.example.mvpnotemanager.pojoModels.Note
import com.example.mvpnotemanager.repository.NoteRepository
import com.example.mvpnotemanager.utilities.db.AppRoom

class AddEditNoteModel(context: Context, presenter: AddNoteContract.Presenter) {

    private var appRoom = AppRoom.getInstance(context)
    private var repository = NoteRepository(appRoom)

    fun saveNote(note: Note) {
        repository.add(note)
    }

    fun updateNote(note: Note) {
        repository.update(note)
    }
}