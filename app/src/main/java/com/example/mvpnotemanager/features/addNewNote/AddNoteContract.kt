package com.example.mvpnotemanager.features.addNewNote

import com.example.mvpnotemanager.pojoModels.Note
import com.example.mvpnotemanager.pojoModels.StickerColor

interface AddNoteContract {

    interface View {
        fun showEmptyNote()
        fun showNote(note: Note)
        fun showSelectColorDialog()
        fun finishActivity()
        fun getNoteText()
        fun showSaveSuccessToast()
        fun clearNoteText()
        fun showUpdateSuccessToast()
    }

    interface Presenter {

        fun onClearButtonClicked()
        fun onColorSelect(stickerColor: StickerColor)
        fun onNoteTextReceive(noteText: String)
        fun onCreateView(note: Note?)
        fun onSaveButtonClicked()
        fun onExitButtonClicked()
    }

    enum class ViewMode {
        NewNote,
        EditNode
    }
}