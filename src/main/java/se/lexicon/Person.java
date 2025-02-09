package se.lexicon;

import java.util.InputMismatchException;
import java.util.Objects;

public class Person {

    private static int counter;
    private int id;
    private String firstName;
    private String lastName;
    private String email;


    private AppUser credentials;


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

    private AppUser getCredentials() {
        return credentials;
    }

    private void setCredentials(AppUser credentials) {
        this.credentials = credentials;
    }

    @Override
    public String toString() {
        return "Person: [ID: " + id + ", First name: " + firstName  + ", Last name: " + lastName
                + ", email: " + email + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return getId() == person.getId() && Objects.equals(getFirstName(), person.getFirstName())
                && Objects.equals(getLastName(), person.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName());
    }
}
