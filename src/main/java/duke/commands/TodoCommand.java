package duke.commands;

import duke.ui.Ui;
import duke.exceptions.DukeException;
import duke.storage.Storage;
import duke.tasks.Task;
import duke.tasks.TodoTask;

import java.util.List;

public class TodoCommand extends TaskCommand {
    public TodoCommand(String line, Ui ui, Storage storage, List<Task> tasks) {
        super(line, ui, storage, tasks);
    }

    @Override
    public void execute() throws DukeException {
        // Throw a DukeException if there is no input
        if (line.equals("todo")) {
            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
        }

        // Split the line by a regex and store the information in the details
        String[] details = line.split("todo\\s*", 2);

        // Create a new task using the information stored in details
        Task task = new TodoTask(details[1]);

        // Add the new task to the list of tasks
        tasks.add(task);

        storage.store(tasks);

        // Print a message confirming the addition of the task
        ui.print(
                "Got it. I've added this task:",
                task.toString(),
                "Now you have " + getNumberOfTasks() + " tasks in the list."
        );
    }
}
