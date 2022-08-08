package com.akash.notesapp.di

import android.app.Application
import androidx.room.Room
import com.akash.notesapp.feaure_note.data.data_source.NoteDatabase
import com.akash.notesapp.feaure_note.data.repository.NoteRepositoryImpl
import com.akash.notesapp.feaure_note.domain.repository.NoteRepository
import com.akash.notesapp.feaure_note.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesNoteDatabase(app:Application) : NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providesRepository(noteDatabase: NoteDatabase):NoteRepository{
        return NoteRepositoryImpl(noteDatabase.noteDao)
    }

    @Provides
    @Singleton
    fun providesNotesUseCases(repository: NoteRepository):NotesUseCases{
        return NotesUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)
        )
    }
}