package duke.task;

import duke.exception.DukeException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskList implements Iterable<Task> {
    protected List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public TaskList(List<Task> tasks) {
        this.tasks = new ArrayList<Task>(tasks);
    }

    public TaskList(TaskList tasks) {
        this.tasks = new ArrayList<Task>(tasks.tasks);
    }

    public void add(Task task) {
        this.tasks.add(task);
    }

    /**
     * Removes a task from the task list at a given index.
     *
     * @param index The index of the task to be removed in the task list.
     * @return The task that was removed.
     * @throws DukeException if there is no task at the given index.
     */
    public Task remove(int index) throws DukeException {
        try {
            return tasks.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("☹ OOPS!!! There is no task at that index.");
        }
    }

    /**
     * Returns a task from the task list at a given index.
     *
     * @param index The index of the task in the task list which should be retrieved.
     * @return The task at the given index in the task list.
     * @throws DukeException If there is no task at the given index.
     */
    public Task get(int index) throws DukeException {
        try {
            return tasks.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("☹ OOPS!!! There is no task at that index.");
        }
    }

    public void markAsDone(int index) throws DukeException {
        get(index).markAsDone();
    }

    public int size() {
        return tasks.size();
    }

    @Override
    public Iterator<Task> iterator() {
        return tasks.iterator();
    }

}
