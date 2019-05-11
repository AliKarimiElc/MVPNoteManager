package com.example.mvpnotemanager.utilities.db.dao

import android.arch.persistence.room.*
import com.example.mvpnotemanager.pojoModels.Note

@Dao
interface NoteDao {

    @Insert
    fun insert(note: Note): Long

    @Insert
    fun insert(vararg note: Note): List<Long>

    @Delete
    fun delete(note: Note)

    @Delete
    fun delete(vararg note: Note)

    @Update
    fun update(note: Note)

    @Query("select * from Note")
    fun get(): List<Note>

    @Query("select * from Note order by CategoryColor")
    fun getOrderByColor(): List<Note>

    @Query("select * from Note order by DateTime desc")
    fun getOrderByDateDesc(): List<Note>

    @Query("select * from Note order by DateTime asc")
    fun getOrderByDateAsc(): List<Note>

    @Query("select * from Note where noteId == :id")
    fun find(id: Int): Note
}