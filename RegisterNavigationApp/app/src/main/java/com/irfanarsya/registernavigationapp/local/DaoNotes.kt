package com.irfanarsya.registernavigationapp.local

import androidx.room.*

@Dao
interface DaoNotes {

    @Query("SELECT * FROM notes")
    fun getAllNotes(): List<Notes>

    @Insert
    fun insertNotes(notes: Notes)

    @Update
    fun updateNotes(notes: Notes)

    @Delete
    fun deleteNews(notes: Notes)

}