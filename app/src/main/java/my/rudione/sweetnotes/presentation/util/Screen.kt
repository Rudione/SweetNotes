package my.rudione.sweetnotes.presentation.util

sealed class Screen(val route: String) {
    object NotesScreen: Screen("notes_screen")
    object AddEditNoteScreen: Screen("add_edit_screen")
}