package se.lexicon.data;

import se.lexicon.TodoItemTask;

import java.util.Collection;

public interface TodoItemTaskDAO {

    TodoItemTask persist(TodoItemTask task);

    TodoItemTask findById(int id);

    Collection<TodoItemTask> findAll();

    Collection<TodoItemTask> findByAssignedStatus(boolean status);

    Collection<TodoItemTask> findByPersonId(int personId);

    void remove(int id);
}