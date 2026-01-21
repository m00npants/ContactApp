package org.example.view;

import org.example.model.Contact;
import java.util.List;
import java.util.Scanner;

public class ContactView {

    private final Scanner scanner = new Scanner(System.in);

    public String getUserInput(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    public void displayMenu() {
        System.out.println("\n=== CONTACT MENU ===");
        System.out.println("1. View all contacts");
        System.out.println("2. Add new contact");
        System.out.println("3. Find contact by name");
        System.out.println("0. Exit");
    }

    public void displayContacts(List<Contact> contacts) {
        System.out.println("\n--- CONTACT LIST ---");
        contacts.forEach(System.out::println);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayError(String message) {
        System.err.println("[ERROR] " + message);
    }
}