package se.lexicon;

import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Objects;

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


    @Override
    public String toString() {
        String state = isAssigned() ? "assigned" : "not assigned";
        String assigneeState = (assignee == null) ? "No assignee" : assignee.getFirstName() + " " + assignee.getLastName();

        return "TodoItemTask: [ID: " + id + ", Title: " + todoItem.getTitle()  + ", State: " + state
                + ", assignee: " + assigneeState + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TodoItemTask that)) return false;
        return getId() == that.getId() && isAssigned() == that.isAssigned() && Objects.equals(getTodoItem(), that.getTodoItem());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), isAssigned(), getTodoItem());
    }
}
