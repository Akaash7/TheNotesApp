package com.akash.notesapp.feaure_note.domain.use_case

import com.akash.notesapp.feaure_note.domain.model.InvalidNoteException
import com.akash.notesapp.feaure_note.domain.model.Note
import com.akash.notesapp.feaure_note.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNote(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note:Note){
        if(note.title.isBlank()){
            throw InvalidNoteException("Title is blank")
        }
        if(note.content.isBlank()){
            throw InvalidNoteException("Content is blank")
        }
        repository.insertNote(note)
    }
}