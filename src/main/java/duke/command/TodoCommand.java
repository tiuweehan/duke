package duke.command;

import duke.task.TaskList;
import duke.ui.Ui;
import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.Task;
import duke.task.TodoTask;

/**
 * The command used to create a todo task in the Duke Program.
 */
public class TodoCommand extends BasicCommand {
    public TodoCommand(String line) throws DukeException {
        super(line);
        validate();
    }

    /**
     * Gets the details of the command as an array of strings.
     *
     * @return an array of strings, the first element being the description of the todo task.
     */
    public String[] getDetails() {
        return line.split("todo\\s*", 2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void validate() throws DukeException {
        // Throw a DukeException if there are no arguments
        if (line.equals("todo")) {
            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        // Split the line by a regex and store the information in the details
        String[] details = getDetails();

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
