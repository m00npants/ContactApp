package org.example.data;

import org.example.model.Contact;
import java.util.List;

public interface ContactDAO {
    List<Contact> findAll() throws Exception;
    void save(Contact contact) throws Exception;
    Contact findByName(String name) throws Exception;
}
