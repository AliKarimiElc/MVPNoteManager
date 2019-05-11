package com.example.mvpnotemanager.features.showNoteList

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvpnotemanager.R
import com.example.mvpnotemanager.pojoModels.Note
import com.example.mvpnotemanager.pojoModels.StickerColor
import kotlinx.android.synthetic.main.list_item.view.*

class NoteListAdapter(private var list: List<Note>,private var activity:NoteListAdapterInterface) :
    RecyclerView.Adapter<NoteListAdapter.NoteViewHolder>() {


    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return NoteViewHolder(view,activity)
    }

    class NoteViewHolder(var view: View,var activity: NoteListAdapterInterface) : RecyclerView.ViewHolder(view) {
        fun bindItem(note: Note) {
            view.textNote.text = note.text
            view.timeView.text = note.dateTime
            if (note.category != null && note.category?.color != null) {
                when (note.category?.color) {
                    StickerColor.Orange -> {
                        view.textNote.background = view.context.getDrawable(R.drawable.card_view_orange)
                        view.listCard.background = view.context.getDrawable(R.drawable.card_view_orange)
                        view.deleteButton.background = view.context.getDrawable(R.drawable.card_view_orange)
                    }
                    StickerColor.White -> {
                        view.textNote.background = view.context.getDrawable(R.drawable.card_view_background)
                        view.listCard.background = view.context.getDrawable(R.drawable.card_view_background)
                        view.deleteButton.background = view.context.getDrawable(R.drawable.card_view_background)
                    }
                    StickerColor.Blue -> {
                        view.textNote.background = view.context.getDrawable(R.drawable.card_view_blue)
                        view.listCard.background = view.context.getDrawable(R.drawable.card_view_blue)
                        view.deleteButton.background = view.context.getDrawable(R.drawable.card_view_blue)
                    }
                    StickerColor.Pink -> {
                        view.textNote.background = view.context.getDrawable(R.drawable.card_view_pink)
                        view.listCard.background = view.context.getDrawable(R.drawable.card_view_pink)
                        view.deleteButton.background = view.context.getDrawable(R.drawable.card_view_pink)
                    }
                    StickerColor.Yellow -> {
                        view.textNote.background = view.context.getDrawable(R.drawable.card_view_yellow)
                        view.listCard.background = view.context.getDrawable(R.drawable.card_view_yellow)
                        view.deleteButton.background = view.context.getDrawable(R.drawable.card_view_yellow)
                    }
                    StickerColor.Green -> {
                        view.textNote.background = view.context.getDrawable(R.drawable.card_view_green)
                        view.listCard.background = view.context.getDrawable(R.drawable.card_view_green)
                        view.deleteButton.background = view.context.getDrawable(R.drawable.card_view_green)
                    }

                }
            }
            view.textNote.setOnClickListener {
                activity.onNoteClick(note)
            }
            view.deleteButton.setOnClickListener {
                activity.onDeleteButtonClick(note)
            }
        }
    }
}


