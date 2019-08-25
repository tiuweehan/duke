package duke.commands;

import duke.consoles.Console;
import duke.exceptions.DukeException;
import duke.storage.Storage;
import duke.tasks.EventTask;
import duke.tasks.Task;

import java.util.List;

public class EventCommand extends TaskCommand {
    public EventCommand(String line, Console console, Storage storage, List<Task> tasks) {
        super(line, console, storage, tasks);
    }

    @Override
    public void execute() throws DukeException {
        // Throw a DukeException if there is no input
        if (line.equals("event")) {
            throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.");
        }

        // Split the line by a regex and store the information in the details
        String[] details = line.split("event\\s*", 2)[1].split("\\s+/at\\s+", 2);

        // Throw a DukeException if input is invalid
        if (details.length < 2 || details[0].isEmpty() || details[1].isEmpty()) {
            throw new DukeException("☹ OOPS!!! The description or the date & time for this task is empty.");
        }

        // Create a new task using the information stored in details
        Task task = new EventTask(details[0], details[1]);

        // Add the new task to the list of tasks
        tasks.add(task);

        storage.store(tasks);

        // Print a message confirming the addition of the task
        console.print(
                "Got it. I've added this task:",
                task.toString(),
                "Now you have " + getNumberOfTasks() + " tasks in the list."
        );
    }
}