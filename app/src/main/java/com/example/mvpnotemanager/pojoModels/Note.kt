package com.example.mvpnotemanager.pojoModels

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true) var noteId: Int?, @ColumnInfo(name = "NoteText") var text: String?,
    @ColumnInfo(name = "DateTime") var dateTime: String?, @Embedded var category: NoteCategory?
) : Serializable