package org.example.exception;

public class ExceptionHandler {

    public static void handle(Exception e) {
        System.err.println("[ERROR] " + e.getMessage());
    }
}
