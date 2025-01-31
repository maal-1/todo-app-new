package se.lexicon;

import java.util.InputMismatchException;

public class Person {

    private static int counter;
    private int id;
    private String firstName;
    private String lastName;
    private String email;


    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        id = ++counter;
    }

    public Person(String firstName, String lastName, String email) {
        this(firstName, lastName);
        setEmail(email);
    }

    private static void validateName(String name) {
        if (name == null || name.length() < 1)
            throw new InputMismatchException();
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        validateName(email);
        this.email = email;
    }

    public void setLastName(String lastName) {
        validateName(lastName);
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        validateName(firstName);
        this.firstName = firstName;
    }

    public String getSummary(){
        return "Person: [ID: " + id + ", First name: " + firstName  + ", Last name: " + lastName
            + ", email: " + email + "]";
    }
}
