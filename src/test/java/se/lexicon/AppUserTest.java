package se.lexicon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppUserTest {

    @Test
    void testToString() {
        //Scenario
        AppUser user1 = new AppUser("Mallin", "mallin123", AppRole.ROLE_APP_ADMIN);
        AppUser user2 = new AppUser(" Mallin", "12333", AppRole.ROLE_APP_USER);

        //Expected
        String expected1 = "AppUser{role: ROLE_APP_ADMIN, username: Mallin'}";
        String expected2 = "AppUser{role: ROLE_APP_USER, username: Mallin'}";

        //Actual
        String actual1 = user1.toString();
        String actual2 = user2.toString();

        //verifying

        assertAll("testToString", () -> {
            assertEquals(expected1,actual1);
            assertEquals(expected2,actual2);
        });
    }

    @Test
    void testEquals() {
        //Scenario
        AppUser user1 = new AppUser("Mallin", "mallin123", AppRole.ROLE_APP_USER);
        AppUser user2 = new AppUser(" Mallin", "12333", AppRole.ROLE_APP_USER);

        //verifying
        assertAll("testToString", () -> {
            assertTrue(user1.equals(user2));
        });
    }
}