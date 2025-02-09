package se.lexicon;

import java.util.InputMismatchException;
import java.util.Objects;

public class AppUser {

    private String username;
    private String password;
    private AppRole role;

    public AppUser(String username, String password, AppRole role) {
        setUsername(username);
        setPassword(password);
        setRole(role);
    }

    private void setUsername(String username) {
        if (username == null || username.strip().length() < 1) {
            throw new InputMismatchException("Username is not allowed to be null or empty.");
        }
        this.username = username.strip();
    }

    private void setPassword(String password) {
        if (password == null || password.strip().length() < 1) {
            throw new InputMismatchException("Password is not allowed to be null or empty.");
        }
        this.password = password.strip();
    }

    private void setRole(AppRole role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public AppRole getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "role: " + role +
                ", username: " + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof AppUser appUser)) return false;
        return Objects.equals(username, appUser.username) && role == appUser.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, role);
    }
}
