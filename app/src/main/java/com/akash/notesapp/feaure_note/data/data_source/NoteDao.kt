package com.akash.notesapp.feaure_note.data.data_source

import androidx.room.*
import com.akash.notesapp.feaure_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getNotes(): Flow<List<Note>>

    @Query("SELECT * FROM note WHERE id = :id ")
    suspend fun getNodeById( id : Int) : Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE )
    suspend fun insertNode(note:Note)

    @Delete
    suspend fun deleteNote(note : Note)



}