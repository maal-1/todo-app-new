package se.lexicon;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;

public class TodoItem {

    private static int counter;
    private int id;
    private String title;
    private String taskDescription;
    private LocalDate deadLine;
    private boolean done;
    private Person creator;

    public TodoItem(Person creator, LocalDate deadLine, String title) {
        this.creator = creator;
        setDeadLine(deadLine);
        setTitle(title);
        id = ++counter;
    }

    public String getSummary(){
        String state = isDone() ? "done" : "pending";
        String overdue = isOverdue() ? "overdue" : "in time";
        return "TodoItem: [ID: " + id + ", Title: " + title  + ", Task Description: " + taskDescription
                + ", Creator: " + creator.getFirstName() + " " + creator.getLastName() + ", State: " + state + ", " + overdue
                + ", Deadline: " + deadLine.format(DateTimeFormatter.ISO_DATE) + "]";
    }

    public boolean isOverdue(){
        return deadLine.isBefore(LocalDate.now());
    }

    private static void validateName(String name) {
        if (name == null || name.length() < 1)
            throw new InputMismatchException();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public boolean isDone() {
        return done;
    }

    public Person getCreator() {
        return creator;
    }

    public void setTitle(String title) {
        validateName(title);
        this.title = title;
    }

    public void setTaskDescription(String taskDescription) {
        validateName(taskDescription);
        this.taskDescription = taskDescription;
    }

    public void setDeadLine(LocalDate deadLine) {
        if (deadLine == null)
            throw new InputMismatchException();
        this.deadLine = deadLine;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }
}
