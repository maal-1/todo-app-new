package se.lexicon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
class TodoItemTest {

    @Test
    void getSummary() {
        //Scenario
        Person mike = new Person("Mike","Smith", "m.s@example.com");
        TodoItem todoItem = new TodoItem(mike, LocalDate.of(2025,2,15), "Return the books");


        //Expected
        String expected = "TodoItem: [ID: 1, Title: Return the books, Task Description: null, " +
                "Creator: Mike Smith, State: pending, in time, Deadline: 2025-02-15]";

        //Actual
        String actual = todoItem.toString();

        //verifying
        Assertions.assertEquals(actual,expected);
    }

    @Test
    void setTaskDescription() {
        //Scenario
        Person mike = new Person("Mike","Smith", "m.s@example.com");
        TodoItem todoItem = new TodoItem(mike, LocalDate.of(2025,2,15), "Return the books");
        todoItem.setTaskDescription("Return old borrowed books to the central library");


        //Expected
        String expected = "TodoItem: [ID: 1, Title: Return the books, Task Description: Return old borrowed books to the central library, " +
                "Creator: Mike Smith, State: pending, in time, Deadline: 2025-02-15]";

        //Actual
        String actual = todoItem.toString();

        //verifying
        Assertions.assertEquals(actual,expected);
    }

    @Test
    void setDone() {
        //Scenario
        Person mike = new Person("Mike","Smith", "m.s@example.com");
        TodoItem todoItem = new TodoItem(mike, LocalDate.of(2025,2,15), "Return the books");
        todoItem.setDone(true);

        //Expected
        String expected = "TodoItem: [ID: 1, Title: Return the books, Task Description: null, " +
                "Creator: Mike Smith, State: done, in time, Deadline: 2025-02-15]";

        //Actual
        String actual = todoItem.toString();

        //verifying
        Assertions.assertEquals(actual,expected);
    }
}