package my.rudione.sweetnotes.di

import android.app.Application
import androidx.room.Room
import my.rudione.sweetnotes.data.db.NoteDatabase
import my.rudione.sweetnotes.data.repository.NoteRepositoryImpl
import my.rudione.sweetnotes.domain.repository.NoteRepository
import my.rudione.sweetnotes.domain.usecase.*
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
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(database: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(database.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotesUseCase = GetNotesUseCase(repository),
            deleteNotesUseCase = DeleteNotesUseCase(repository),
            addNoteUseCase = AddNoteUseCase(repository),
            getNoteUseCases = GetNoteUseCase(repository)
        )
    }
}