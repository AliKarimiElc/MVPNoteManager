package com.example.mvpnotemanager.features.addNewNote.view

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.mvpnotemanager.R
import com.example.mvpnotemanager.features.addNewNote.AddNoteContract
import com.example.mvpnotemanager.features.addNewNote.presenter.AddEditNotePresenter
import com.example.mvpnotemanager.pojoModels.Note
import com.example.mvpnotemanager.pojoModels.NoteCategory
import com.example.mvpnotemanager.pojoModels.StickerColor
import kotlinx.android.synthetic.main.activity_note.*

class NoteActivity : AppCompatActivity(), AddNoteContract.View {

    private var presenter = AddEditNotePresenter(this, this.applicationContext)
    var note: Note? = null

    override fun showUpdateSuccessToast() {
        Toast.makeText(this.applicationContext,"یادداشت با موفقیت بروزرسانی شد",Toast.LENGTH_SHORT).show()
    }


    override fun clearNoteText() {
        noteText.setText("")
    }

    override fun showSaveSuccessToast() {
        Toast.makeText(this.applicationContext,"ذخیره با موفقیت انجام شد",Toast.LENGTH_SHORT).show()
    }

    override fun getNoteText() {
        presenter.onNoteTextReceive(noteText.text.toString())
    }

    override fun showEmptyNote() {
        noteText.background = getDrawable(R.color.stickerWhite)
    }

    override fun showNote(note: Note) {
        if (note.category?.color == StickerColor.White)
            noteText.background = getDrawable(R.color.stickerWhite)
        if (note.category?.color == StickerColor.Blue)
            noteText.background = getDrawable(R.color.stickerBlue)
        if (note.category?.color == StickerColor.Green)
            noteText.background = getDrawable(R.color.stickerGreen)
        if (note.category?.color == StickerColor.Orange)
            noteText.background = getDrawable(R.color.stickerOrange)
        if (note.category?.color == StickerColor.Pink)
            noteText.background = getDrawable(R.color.stickerPink)
        if (note.category?.color == StickerColor.Yellow)
            noteText.background = getDrawable(R.color.stickerYellow)
        noteText.setText(note.text)
    }

    override fun showSelectColorDialog() {

        val colors = arrayOf("سفید", "صورتی", "زرد", "سبز", "آبی", "نارنجی")
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("انتخاب رنگ")
            .setCancelable(true)
        alertDialogBuilder.setItems(colors) { _, which ->
            note?.category = NoteCategory()
            when (which) {
                0 -> presenter.onColorSelect(StickerColor.White)
                1 -> presenter.onColorSelect(StickerColor.Pink)
                2 -> presenter.onColorSelect(StickerColor.Yellow)
                3 -> presenter.onColorSelect(StickerColor.Green)
                4 -> presenter.onColorSelect(StickerColor.Blue)
                5 -> presenter.onColorSelect(StickerColor.Orange)
            }
            val dialog = alertDialogBuilder.create()
            dialog.show()
        }
    }

    override fun finishActivity() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.note_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.action_save) {
            presenter.onSaveButtonClicked()
        }
        if (item?.itemId == R.id.action_erase) {
            noteText.text.clear()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val extras = intent.extras
        extras?.let { note = it.get("note") as Note }
        presenter.onCreateView(note)
        super.onCreate(savedInstanceState)
    }
}
