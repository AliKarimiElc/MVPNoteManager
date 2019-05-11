package com.example.mvpnotemanager.features.showNoteList.presenter

import android.content.Context
import com.example.mvpnotemanager.features.showNoteList.Contract
import com.example.mvpnotemanager.features.showNoteList.model.NoteListModel
import com.example.mvpnotemanager.pojoModels.Note

class NoteListPresenter(var view: Contract.View, context: Context) : Contract.Presenter {

    private var sort: Contract.NoteSort = Contract.NoteSort.DateDec
    var notes: List<Note>? = null

    override fun onDeleteDialogPositiveClicked(note: Note) {
        model.deleteNote(note)
        getNotes()
        sortNotes()
        view.showNoteList(notes!!)
    }

    override fun onDeleteDialogNegativeClicked(note: Note) {
        view.showNoteList(notes!!)
    }

    override fun onDeleteButtonClicked(note: Note) {
        view.showDeleteDialog(note, "حذف یادداشت",
            "آیا واقعا میخواهید این یادداشت را حذف کنید؟",
            "بله", "خیر")
    }


    override fun onSortClicked(noteSort: Contract.NoteSort) {
        sort = noteSort
        getNotes()
        sortNotes()
        view.showNoteList(notes!!)
    }

    private var model: NoteListModel = NoteListModel(this, context)

    override fun onViewShow() {
        notes = model.getNotes().sortedBy { d -> d.dateTime }
        view.showNoteList(notes!!)
    }

    override fun onOneNoteClicked(note: Note) {
        view.showEditNoteActivity()
    }

    override fun onAddNoteClicked() {
        view.showAddNoteActivity()
    }

    override fun onExitClicked() {
        view.finishActivity()
    }

    private fun sortNotes() {
        when (sort) {
            Contract.NoteSort.Color -> notes?.sortedBy { n -> n.category?.color }
            Contract.NoteSort.DateAsc -> notes?.sortedBy { n -> n.dateTime }
            Contract.NoteSort.DateDec -> notes?.sortedByDescending { n -> n.dateTime }
        }
    }

    private fun getNotes() {
        notes = model.getNotes()
    }
}