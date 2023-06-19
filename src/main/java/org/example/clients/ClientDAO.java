package org.example.clients;

import java.util.List;

public interface ClientDAO {

    long create(String name);
    String getById(long id);
    void setName(long id, String name);

    void deleteById(long id);

    List<Client> listAll();

    }




