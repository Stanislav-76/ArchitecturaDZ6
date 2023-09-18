package ru.geekbrains.lesson6.notes.core.application.interfaces;

import ru.geekbrains.lesson6.notes.core.domain.Note;

import java.util.Collection;

public interface NotesDatabaseContext {

    Collection<Note> getAll();

    void add(Note item);


    void add(String title, String details);

    void remove(Note item);

    boolean saveChanges();

}
