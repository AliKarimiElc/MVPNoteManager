package com.example.mvpnotemanager.features.addNewNote.presenter

import android.content.Context
import com.example.mvpnotemanager.features.addNewNote.AddNoteContract
import com.example.mvpnotemanager.features.addNewNote.model.AddEditNoteModel
import com.example.mvpnotemanager.pojoModels.Note
import com.example.mvpnotemanager.pojoModels.NoteCategory
import com.example.mvpnotemanager.pojoModels.StickerColor
import com.example.mvpnotemanager.utilities.dateTimeHelper.DateTimeHelper

class AddEditNotePresenter(private var view: AddNoteContract.View, context: Context) : AddNoteContract.Presenter {
    override fun onClearButtonClicked() {
        view.clearNoteText()
    }

    var workingNote: Note? = null
    private var model = AddEditNoteModel(context, this)
    var viewMode: AddNoteContract.ViewMode? = null
    var workingNoteText: String? = null
    var workingNoteColor: StickerColor? = null

    override fun onColorSelect(stickerColor: StickerColor) {
        workingNoteColor = stickerColor
        workingNote =
            Note(null, workingNoteText, DateTimeHelper.getCurrentDateTimeStringJalali(),
                NoteCategory().apply {
                color = workingNoteColor
            })
        model.saveNote(workingNote!!)
        view.showSaveSuccessToast()
        view.finishActivity()
    }

    override fun onNoteTextReceive(noteText: String) {
        if(viewMode == AddNoteContract.ViewMode.NewNote) {
            workingNoteText = noteText
            view.showSelectColorDialog()
        }else{
            workingNote?.text = noteText
            workingNote?.let { model.updateNote(it) }
            view.showUpdateSuccessToast()
        }
    }


    override fun onCreateView(note: Note?) {
        workingNote = note
        viewMode = if (note != null) {
            view.showNote(note)
            AddNoteContract.ViewMode.EditNode
        } else {
            view.showEmptyNote()
            AddNoteContract.ViewMode.NewNote
        }
    }


    override fun onSaveButtonClicked() {
        view.getNoteText()
    }


    override fun onExitButtonClicked() {
        view.finishActivity()
    }
}