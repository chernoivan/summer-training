package com.chernoivan;

import com.chernoivan.controller.Controller;
import com.chernoivan.model.Model;
import com.chernoivan.view.View;

public class Main {

    public static void main(String[] args) {
	    Controller controller = new Controller(new Model(), new View());
	    controller.processUser();
    }
}
