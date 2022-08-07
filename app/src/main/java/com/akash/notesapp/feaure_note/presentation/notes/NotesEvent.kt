package com.akash.notesapp.feaure_note.presentation.notes

import com.akash.notesapp.feaure_note.domain.model.Note
import com.akash.notesapp.feaure_note.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder:NoteOrder) : NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote : NotesEvent()
    object ToggleOrderSection : NotesEvent()
}