package se.lexicon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TodoItemTaskTest {

    @Test
    void setAssignee() {
        //Scenario
        Person eva = new Person("Eva","Nilsson", "e.n@example.com");
        TodoItem todoItem = new TodoItem(eva, LocalDate.of(2025,2,15), "Return the books");
        TodoItemTask todoItemTask = new TodoItemTask(todoItem);
        todoItemTask.setAssignee(eva);

        //Expected
        String expected = "TodoItemTask: [ID: 1, Title: Return the books, State: assigned, assignee: Eva Nilsson]";

        //Actual
        String actual = todoItemTask.toString();

        //verifying
        Assertions.assertEquals(actual,expected);
    }

    @Test
    void getSummary() {
        //Scenario

        Person mike = new Person("Mike","Smith", "m.s@example.com");
        TodoItem todoItem = new TodoItem(mike, LocalDate.of(2025,2,15), "Return the books");
        TodoItemTask todoItemTask = new TodoItemTask(todoItem);

        //Expected
        String expected = "TodoItemTask: [ID: 1, Title: Return the books, State: not assigned, assignee: No assignee]";

        //Actual
        String actual = todoItemTask.toString();

        //verifying
        Assertions.assertEquals(actual,expected);
    }
}