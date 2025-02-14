package se.lexicon.data;

import se.lexicon.TodoItem;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TodoItemDAOCollection implements TodoItemDAO {
    private HashSet<TodoItem> todoItems = new HashSet<>();

    @Override
    public TodoItem persist(TodoItem todoItem) {
        todoItems.add(todoItem);
        return todoItem;
    }

    @Override
    public TodoItem findById(int id) {
        for (TodoItem todoItem : todoItems) {
            if (todoItem.getId() == id) {
                return todoItem;
            }
        }
        return null;
    }

    @Override
    public Collection<TodoItem> findAll() {
        return new HashSet<>(todoItems);
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean done) {
        return todoItems.stream()
                .filter(todoItem -> todoItem.isDone() == done)
                .collect(Collectors.toSet());
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        return todoItems.stream()
                .filter(todoItem -> todoItem.getTitle().contains(title))
                .collect(Collectors.toSet());
    }

    @Override
    public Collection<TodoItem> findByPersonId(int personId) {
        return todoItems.stream()
                .filter(todoItem -> todoItem.getCreator().getId() == personId)
                .collect(Collectors.toSet());
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate date) {
        return todoItems.stream()
                .filter(todoItem -> todoItem.getDeadLine().isBefore(date))
                .collect(Collectors.toSet());
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate date) {
        return todoItems.stream()
                .filter(todoItem -> todoItem.getDeadLine().isAfter(date))
                .collect(Collectors.toSet());
    }

    @Override
    public void remove(int id) {
        for (TodoItem todoItem : todoItems) {
            if (todoItem.getId() == id) {
                todoItems.remove(todoItem);
            }
        }
    }
}