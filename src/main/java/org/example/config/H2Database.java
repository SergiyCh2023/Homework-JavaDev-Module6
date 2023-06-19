package org.example.config;

import org.flywaydb.core.Flyway;

import java.sql.*;

public class H2Database {

    private static final H2Database INSTANCE;  // єдиний екземпляр бази данних

    static {
        try {
            INSTANCE = new H2Database();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection H2Connection; // приватна змінна для підключення


    H2Database() throws SQLException {

        try {
            String h2ConnectionUrl = "jdbc:h2:./test";
            this.H2Connection = DriverManager.getConnection(h2ConnectionUrl);
       //     flywayMigration(h2ConnectionUrl);
        } catch (SQLException ex) {
            System.out.println(" H2Database problems connection. Reason:  " + ex.getMessage());
        }

    }

    private void flywayMigration(String h2ConnectionUrl) {
        Flyway flyway = Flyway
                .configure()
                .dataSource(h2ConnectionUrl, null, null)
                .load();
        flyway.migrate();
    }

    public static H2Database getInstance() {
        return INSTANCE;  // екземпляр чогось, мабудь підключення до БД
    }

    public Connection getH2Connection() {
        return  H2Connection;
    }

    public void closeConnection() {
        try {
            H2Connection.close();
        }   catch (SQLException ex) {
            throw new RuntimeException();
        }
    }

}



