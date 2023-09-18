package ru.geekbrains.lesson6.notes.presentation.queries.controllers;

import ru.geekbrains.lesson6.notes.core.application.interfaces.NoteEditor;
import ru.geekbrains.lesson6.notes.core.domain.Note;

import java.util.Optional;

public class NotesController extends Controller{

    private final NoteEditor notesEditor;

    public NotesController(NoteEditor notesEditor){
        this.notesEditor = notesEditor;
    }

    public void routeAddNote(Note note){
        this.notesEditor.add(note);
    }
    public void routeAddNote(String title, String details){
        this.notesEditor.add(title, details);
    }

    public void routeRemoveNote(Note note){
        this.notesEditor.remove(note);
    }

    public Optional<Note> routeGetById(Integer id) {
        return this.notesEditor.getById(id);
    }

    public void routeGetAll(){
        this.notesEditor.printAll();
    }

}
