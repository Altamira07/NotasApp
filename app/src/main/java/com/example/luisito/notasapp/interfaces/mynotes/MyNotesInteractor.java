package com.example.luisito.notasapp.interfaces.mynotes;

/**
 * Created by luisito on 10/12/17.
 */

public interface MyNotesInteractor
{
    void loadNotes();
    void updateNote(int id,String title,String content);
    void deleteNote(int id);
    void saveNote(String title,String content);
    void sharedNote(int idNote,String email);
}
