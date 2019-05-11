package com.example.mvpnotemanager.features.showNoteList

import com.example.mvpnotemanager.pojoModels.Note

interface NoteListAdapterInterface {

    fun onDeleteButtonClick(note: Note)
    fun onNoteClick(note: Note)

}