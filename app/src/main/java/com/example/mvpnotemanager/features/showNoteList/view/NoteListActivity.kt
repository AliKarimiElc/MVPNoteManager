package com.example.mvpnotemanager.features.showNoteList.view

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.example.mvpnotemanager.R
import com.example.mvpnotemanager.features.showNoteList.Contract
import com.example.mvpnotemanager.features.showNoteList.NoteListAdapter
import com.example.mvpnotemanager.features.showNoteList.NoteListAdapterInterface
import com.example.mvpnotemanager.features.showNoteList.presenter.NoteListPresenter
import com.example.mvpnotemanager.pojoModels.Note
import kotlinx.android.synthetic.main.activity_note_list.*

class NoteListActivity : AppCompatActivity(), Contract.View, NoteListAdapterInterface {

    override fun showDeleteDialog(
        note: Note,
        dialogTitle: String,
        dialogMessage: String,
        positiveTitle: String,
        negativeTitle: String
    ) {
        val alertDialogBuilder = AlertDialog.Builder(this.applicationContext)
        alertDialogBuilder.setTitle("حذف یادداشت")
            .setMessage("آیا می خواهید این یادداشت را حذف کنید؟").setCancelable(false)
            .setPositiveButton("بله") { _, _ ->
                presenter?.onDeleteDialogPositiveClicked(note)
            }.setNegativeButton("خیر") { _, _ ->
                presenter?.onDeleteDialogNegativeClicked(note)
            }
        val dialog = alertDialogBuilder.create()
        dialog.show()
    }


    override fun onDeleteButtonClick(note: Note) {
        presenter?.onDeleteButtonClicked(note)
    }

    override fun onNoteClick(note: Note) {
        presenter?.onOneNoteClicked(note)
    }

    override fun showNoteList(noteList: List<Note>) {
        val noteListAdapter=NoteListAdapter(noteList,this)
        noteRecycler.layoutManager=GridLayoutManager(this.applicationContext,2)
        noteRecycler.adapter = noteListAdapter
        noteListAdapter.notifyDataSetChanged()
    }

    override fun showAddNoteActivity() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private var presenter: NoteListPresenter? = null

    override fun showEditNoteActivity() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun finishActivity() {
        finish()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)
        presenter = NoteListPresenter(this, this.applicationContext)
        presenter?.onViewShow()
    }


}
