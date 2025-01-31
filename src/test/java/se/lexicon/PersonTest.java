package se.lexicon;

import org.junit.jupiter.api.Assertions;

class PersonTest {

    @org.junit.jupiter.api.Test
    void getSummary() {
        //Scenario
        Person mike = new Person("Mike","Smith", "m.s@example.com");
        Person eva = new Person("Eva","Nilsson", "e.n@example.com");

        //Expected
        String expected = "Person: [ID: 1, First name: Mike, Last name: Smith, email: m.s@example.com]";
        String expected2 = "Person: [ID: 2, First name: Eva, Last name: Nilsson, email: e.n@example.com]";

        //Actual
        String actual = mike.getSummary();
        String actual2 = eva.getSummary();

        //verifying
        Assertions.assertEquals(actual,expected);
        Assertions.assertEquals(actual2,expected2);
    }
}