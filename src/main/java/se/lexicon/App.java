package se.lexicon;

import se.lexicon.data.DatabaseConnection;
import se.lexicon.data.PersonDAOIp;

import java.sql.Connection;
import java.sql.SQLException;

public class App {

    public static void main(String[] args) {
        Person mike = new Person("Mike", "Smith");

        try (Connection connection = DatabaseConnection.getConnection();) {


            PersonDAOIp personDAOIp = new PersonDAOIp(connection);
//            personDAOIp.create(mike);

//            personDAOIp.deleteById(5);

            mike.setLastName("Baker");
            mike.setId(4);
            personDAOIp.update(mike);

            personDAOIp.findAll().forEach(System.out::println);

            System.out.println(personDAOIp.findById(4));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
