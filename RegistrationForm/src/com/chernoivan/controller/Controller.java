package com.chernoivan.controller;

import com.chernoivan.model.Model;
import com.chernoivan.view.View;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);
        InputNoteNoteBook inputNoteNoteBook = new InputNoteNoteBook(view, sc);
        inputNoteNoteBook.inputNote();
    }
}
