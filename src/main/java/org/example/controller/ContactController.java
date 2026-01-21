package org.example.controller;

import org.example.data.ContactDAO;
import org.example.exception.ExceptionHandler;
import org.example.model.Contact;
import org.example.view.ContactView;

public class ContactController {

    private final ContactDAO contactDAO;
    private final ContactView contactView;

    public ContactController(ContactDAO contactDAO, ContactView contactView) {
        this.contactDAO = contactDAO;
        this.contactView = contactView;
    }

    public void run() {
        boolean running = true;

        while (running) {
            contactView.displayMenu();
            String choice = contactView.getUserInput("Choose option");

            try {
                switch (choice) {
                    case "1" -> contactView.displayContacts(contactDAO.findAll());
                    case "2" -> addContact();
                    case "3" -> findContact();
                    case "0" -> running = false;
                    default -> contactView.displayError("Invalid choice");
                }
            } catch (Exception e) {
                ExceptionHandler.handle(e);
            }
        }
    }

    private void addContact() throws Exception {
        String name = contactView.getUserInput("Enter name");
        String phone = contactView.getUserInput("Enter phone (10 digits)");

        Contact contact = new Contact(name, phone);
        contactDAO.save(contact);

        contactView.displayMessage("Contact saved!");
    }

    private void findContact() throws Exception {
        String name = contactView.getUserInput("Enter name to search");
        Contact contact = contactDAO.findByName(name);

        if (contact == null) {
            contactView.displayError("Contact not found");
        } else {
            contactView.displayMessage("Found: " + contact);
        }
    }
}