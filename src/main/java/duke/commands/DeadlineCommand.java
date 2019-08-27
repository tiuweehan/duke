package duke.commands;

import duke.tasks.TaskList;
import duke.ui.Ui;
import duke.exceptions.DukeException;
import duke.storage.Storage;
import duke.tasks.DeadlineTask;
import duke.tasks.Task;

import java.util.List;

public class DeadlineCommand extends BasicCommand {
    public DeadlineCommand(String line) {
        super(line);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        // Throw a DukeException if there is no input
        if (line.equals("deadline")) {
            throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
        }

        // Split the line by a regex and store the information in the details
        String[] details = line.split("deadline\\s*", 2)[1].split("\\s+/by\\s+", 2);

        // Throw a DukeException if input is invalid
        if (details.length < 2 || details[0].isEmpty() || details[1].isEmpty()) {
            throw new DukeException("☹ OOPS!!! The description or the deadline for this task is empty.");
        }

        // Create a new task using the information stored in details
        Task task = new DeadlineTask(details[0], details[1]);

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
