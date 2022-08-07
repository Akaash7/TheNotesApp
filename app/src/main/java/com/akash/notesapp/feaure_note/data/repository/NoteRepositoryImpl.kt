package com.akash.notesapp.feaure_note.data.repository

import com.akash.notesapp.feaure_note.data.data_source.NoteDao
import com.akash.notesapp.feaure_note.domain.model.Note
import com.akash.notesapp.feaure_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: NoteDao
) : NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {

        return dao.getNodeById(id)
    }

    override suspend fun insertNote(note: Note) {
        return dao.insertNode(note)
    }

    override suspend fun deleteNote(note: Note) {
        return dao.deleteNote(note)
    }
}