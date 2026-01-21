package org.example;

import org.example.controller.ContactController;
import org.example.data.FileContactDAOImpl;
import org.example.view.ContactView;

public class App {
    public static void main(String[] args) {
        ContactController controller = new ContactController(
                new FileContactDAOImpl("contacts.txt"),
                new ContactView()
        );
        controller.run();
    }
}
