package com.example.mvpnotemanager.features.showNoteList

import com.example.mvpnotemanager.pojoModels.Note

interface Contract {

    enum class NoteSort {
        DateAsc,
        DateDec,
        Color
    }

    interface View{
        fun showNoteList(noteList:List<Note>)
        fun showEditNoteActivity()
        fun showAddNoteActivity()
        fun finishActivity()
        fun showDeleteDialog(note:Note,dialogTitle: String, dialogMessage: String, positiveTitle: String, negativeTitle: String)

    }

    interface Presenter{
        fun onViewShow()
        fun onOneNoteClicked(note: Note)
        fun onAddNoteClicked()
        fun onSortClicked(noteSort:NoteSort)
        fun onExitClicked()
        fun onDeleteButtonClicked(note: Note)
        fun onDeleteDialogPositiveClicked(note: Note)
        fun onDeleteDialogNegativeClicked(note: Note)
    }

}