package ru.geekbrains.lesson6;


import ru.geekbrains.lesson6.database.NotesDatabase;
import ru.geekbrains.lesson6.database.NotesRecord;
import ru.geekbrains.lesson6.notes.core.application.ConcreteNoteEditor;
import ru.geekbrains.lesson6.notes.core.domain.Note;
import ru.geekbrains.lesson6.notes.infrastructure.persistance.NotesDbContext;
import ru.geekbrains.lesson6.notes.presentation.queries.controllers.NotesController;
import ru.geekbrains.lesson6.notes.presentation.queries.views.NotesConsolePresenter;

import java.util.Date;
import java.util.Optional;

public class Program {

    public static void main(String[] args) {
        NotesController controller = new NotesController(
                new ConcreteNoteEditor(new NotesDbContext(new NotesDatabase()), new NotesConsolePresenter()));

        controller.routeGetAll();
        System.out.println("-----------");

        // Возможно нужен другой конструктор Note(String title, String details) т.к. др. данные заполняются автоматически
        Note note = new Note(0,1,"Заметка 1", "супер 1", new Date());
        controller.routeAddNote(note);
        controller.routeAddNote("Заметка 2", "супер 2"); // Добавил такой вариант. Насколько правильно?

        controller.routeGetAll();
        System.out.println("-----------");

        controller.routeRemoveNote(note);
        controller.routeRemoveNote(controller.routeGetById(1001).get());
        controller.routeGetAll();

        //Внес изменения в методы class NotesDbContext, добавил в class NotesController метод routeGetById


    }

}
