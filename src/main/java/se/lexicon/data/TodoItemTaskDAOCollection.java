package se.lexicon.data;

import se.lexicon.TodoItemTask;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO {

    private HashSet<TodoItemTask> tasks = new HashSet<>();

    @Override
    public TodoItemTask persist(TodoItemTask task) {
        tasks.add(task);
        return task;
    }

    @Override
    public TodoItemTask findById(int id) {
        for (TodoItemTask task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return new HashSet<>(tasks);
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean status) {
        return tasks.stream()
                    .filter(task -> task.isAssigned() == status)
                    .collect(Collectors.toList());
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int personId) {
        return tasks.stream()
                    .filter(task -> task.getAssignee().getId() == personId)
                    .collect(Collectors.toSet());
    }

    @Override
    public void remove(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }
}