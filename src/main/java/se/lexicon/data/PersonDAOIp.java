package se.lexicon.data;
import se.lexicon.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class PersonDAOIp {

    private final Connection connection ;

    public PersonDAOIp(Connection connection) {
        this.connection = connection;
    }


    public Person create(Person person) {

        String sql = "INSERT INTO person (first_name, last_name) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());

            int rows = preparedStatement.executeUpdate();

            if (rows > 0) {
                System.out.println("Insert successful");
            } else {
                System.out.println("Insert failed");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }

    public void update(Person person){

        String sql = "UPDATE person SET first_name = ?, last_name = ? WHERE person_id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);) {

            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.setInt(3, person.getId());

            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                System.out.println("Updated successfully");
            } else {
                System.out.println("Update failed");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Collection<Person> findAll() {

        List<Person> personsList = new ArrayList<>();

        try (Statement statement = connection.createStatement();) {

            String sql = "SELECT * FROM person";
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                personsList.add(
                        new Person(
                                result.getInt("person_id"),
                                result.getString("first_name"),
                                result.getString("last_name")
                        )
                );
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return personsList;
    }


    public Person findById(int id) {

        return null;
    }

    public boolean deleteById(int id) {
        try (Connection connection = DatabaseConnection.getConnection();) {

            String sql = "DELETE FROM person WHERE person_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rows = preparedStatement.executeUpdate();

            if (rows > 0) {
                System.out.println("Deleted successfully");
                return true;
            } else {
                System.out.println("Delete failed");
                return false;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
