package org.example;

public class ContactStorageException extends Exception {
    public ContactStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
public class DuplicateContactException extends Exception {
    public DuplicateContactException(String message) {
        super(message);
    }
}
public class ExceptionHandler {

    public static void handle(Exception e) {
        System.err.println("[ERROR] " + e.getMessage());
    }
}
