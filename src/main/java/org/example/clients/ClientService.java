package org.example.clients;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;




public class ClientService implements ClientDAO{

    List<Client> clientList = new ArrayList<>();

    private Connection connection;

    public ClientService (Connection connection) throws SQLException {
        this.connection = connection;
    }


        public long create (String name) {
            try (PreparedStatement createClientByName = this.connection.prepareStatement(
                    "INSERT INTO clients (name) VALUES( ? )")) {
                createClientByName.setString(1, name);
                int result = createClientByName.executeUpdate();  // падає
                if (result==1) return findByName(name);
                else  throw new RuntimeException();
        } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        private long findByName (String name) {
            try (PreparedStatement findByName = this.connection.prepareStatement(
                    "SELECT id FROM clients WHERE name = ?")) {
                    long returnedResult = -1l;
                //    this.insertStatement.setLong(1, id);
                findByName.setString(1, name);
                ResultSet result = findByName.executeQuery();
                if (result.next()) {
                      returnedResult = result.getLong("id");
                }
                else  throw new RuntimeException();
            } catch (SQLException e) {
               throw new RuntimeException(e);
            }
            return -1l;
        }



    public String getById(long id) {
        try(PreparedStatement getNameById = connection.prepareStatement(
                "SELECT name FROM clients WHERE id = ?"  )) {
            String returnedName = "";
            getNameById.setLong(1, id);
            ResultSet result = getNameById.executeQuery();
            if (result.next()) returnedName = result.getString( "name");
            System.out.println("returnedName = " + returnedName);
            return returnedName;
           } catch (Exception e){
            throw new RuntimeException(e);
        }
    }



   public List<Client> listAll() {
       try(PreparedStatement getByAll = connection.prepareStatement("SELECT * FROM clients")) {
           ResultSet result = getByAll.executeQuery();
           while (result.next()) {
           Client client = new Client(result.getLong( "id"), result.getString("name"));
               clientList.add(client);
           }
           result.close();
           return clientList;
       } catch (SQLException ex) {
           System.out.println(" SQL exception in method listAll(). Reason: " + ex.getMessage());
           return null;
       }
   }



    public void deleteById(long id){
        try(PreparedStatement deleteById = connection.prepareStatement("DELETE FROM clients where id= ?")) {
            deleteById.setLong(1, id);
            deleteById.executeUpdate();
            System.out.println("deleteById = " + deleteById.toString());
            } catch (SQLException ex) {
            System.out.println(" SQL exception in method deleteById(long id). Reason: " + ex.getMessage());
        }
    }


    public void setName(long id, String name) {
        try(PreparedStatement updateNameById = connection.prepareStatement("UPDATE clients SET name = ? WHERE id = ?;")) {
            updateNameById.setString(1, name);
            updateNameById.setLong(2, id);
            updateNameById.executeUpdate();
            System.out.println("updateNameById = " + updateNameById.toString());
        } catch (SQLException ex) {
            System.out.println(" SQL exception in method setName(). Reason: " + ex.getMessage());
        }
    }



}
