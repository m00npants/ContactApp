package org.example.data;

import org.example.exception.ContactStorageException;
import org.example.exception.DuplicateContactException;
import org.example.model.Contact;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileContactDAOImpl implements ContactDAO {

    private final Path filePath;

    public FileContactDAOImpl(String fileName) {
        this.filePath = Paths.get(fileName);
        try {
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage file");
        }
    }

    @Override
    public List<Contact> findAll() throws ContactStorageException {
        List<Contact> contacts = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                contacts.add(new Contact(parts[0], parts[1]));
            }

        } catch (IOException e) {
            throw new ContactStorageException("Failed to read contacts", e);
        }

        return contacts;
    }

    @Override
    public void save(Contact contact) throws Exception {
        if (findByName(contact.getName()) != null) {
            throw new DuplicateContactException("Contact already exists: " + contact.getName());
        }

        try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardOpenOption.APPEND)) {
            writer.write(contact.getName() + "," + contact.getPhoneNumber());
            writer.newLine();
        } catch (IOException e) {
            throw new ContactStorageException("Failed to save contact", e);
        }
    }

    @Override
    public Contact findByName(String name) throws ContactStorageException {
        try {
            return findAll()
                    .stream()
                    .filter(c -> c.getName().equalsIgnoreCase(name))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            throw new ContactStorageException("Failed to search contact", e);
        }
    }
}