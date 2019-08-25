package duke.commands;

import duke.consoles.Console;
import duke.exceptions.DukeException;
import duke.storage.Storage;
import duke.tasks.Task;

import java.util.List;

public abstract class TaskCommand extends BasicCommand {
    protected List<Task> tasks;

    public TaskCommand(String line, Console console, Storage storage, List<Task> tasks) {
        super(line, console, storage);
        this.tasks = tasks;
    }

    /**
     * Gets the number of tasks in the list of tasks.
     *
     * @return The number of tasks in the list of tasks.
     */
    protected int getNumberOfTasks() {
        return tasks.size();
    }

    @Override
    public abstract void execute() throws DukeException;
}