package se.lexicon;

import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;

public class TodoItemTask {

    private static int counter;
    private int id;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    public TodoItemTask(TodoItem todoItem) {
        setTodoItem(todoItem);
        id = ++counter;
    }

    public TodoItemTask(TodoItem todoItem, Person assignee) {
        this(todoItem);
        setAssignee(assignee);
    }

    private void setAssigned() {

        this.assigned = assignee != null;

    }

    public void setTodoItem(TodoItem todoItem) {
        if (todoItem == null)
            throw new InputMismatchException();

        this.todoItem = todoItem;
    }

    public void setAssignee(Person assignee) {
        this.assignee = assignee;
        setAssigned();
    }

    public int getId() {
        return id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    public String getSummary(){
        String state = isAssigned() ? "assigned" : "not assigned";
        String assigneeState = (assignee == null) ? "No assignee" : assignee.getFirstName() + " " + assignee.getLastName();

        return "TodoItemTask: [ID: " + id + ", Title: " + todoItem.getTitle()  + ", State: " + state
                + ", assignee: " + assigneeState + "]";
    }
}
