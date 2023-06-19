package org.example.config;

import org.example.properties.PropertyReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgresDatabase {

    private static final PostgresDatabase INSTANCE = new PostgresDatabase();

    private Connection PostgresConnection;
    private PostgresDatabase () {

        try {
            String postgresConnectionUrl = PropertyReader.getConnectionUrlForPostgres();
            this.PostgresConnection = DriverManager.getConnection(postgresConnectionUrl,
                    PropertyReader.getUserForPostgres(), PropertyReader.getPasswordForPostgres());
        } catch (SQLException e) {
            throw new RuntimeException("Create connection exception");
        }
    }

    public static PostgresDatabase getInstance() {
        return INSTANCE;
    }

    public Connection getPostgresConnection() {
        return PostgresConnection;
    }

    public int executeUpdate(String query) {
        try(Statement statement = INSTANCE.getPostgresConnection().createStatement()) {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection() {
        try {
            PostgresConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
