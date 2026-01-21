package org.example;

public class Contact {

    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        setName(name);
        setPhoneNumber(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("^\\d{10}$")) {
            throw new IllegalArgumentException("Phone number must be 10 digits");
        }
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return name + " - " + phoneNumber;
    }
}

