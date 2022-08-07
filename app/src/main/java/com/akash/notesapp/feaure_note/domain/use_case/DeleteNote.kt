package com.akash.notesapp.feaure_note.domain.use_case

import com.akash.notesapp.feaure_note.domain.model.Note
import com.akash.notesapp.feaure_note.domain.repository.NoteRepository

class DeleteNote(
   private val repository: NoteRepository
) {
    suspend operator fun invoke(note:Note) {
        repository.deleteNote(note)
    }
}