package org.example;

import org.example.clients.Client;
import org.example.clients.ClientService;
import org.example.config.H2Database;

import java.sql.Connection;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws SQLException {

        Connection connection = H2Database.getInstance().getH2Connection();
        ClientService service = new ClientService(connection);




        for (Client client : service.listAll()) {
            System.out.println("client = " + client);
        }

    }
}

