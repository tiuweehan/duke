package duke.command;

import duke.task.TaskList;
import duke.ui.Ui;
import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.Task;
import duke.task.TodoTask;

public class TodoCommand extends BasicCommand {
    public TodoCommand(String line) {
        super(line);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
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
                "Now you have " + tasks.size() + " tasks in the list."
        );
    }
}
