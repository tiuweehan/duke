package duke.commands;

import duke.tasks.TaskList;
import duke.ui.Ui;
import duke.exceptions.DukeException;
import duke.storage.Storage;
import duke.tasks.EventTask;
import duke.tasks.EventWithEndDateTask;
import duke.tasks.Task;

import java.util.List;

public class EventCommand extends BasicCommand {
    public EventCommand(String line) {
        super(line);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
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

        String[] dateTimes = details[1].split("\\s+/to\\s+", 2);

        // Create a new task using the information stored in details
        Task task = dateTimes.length == 1
            ? new EventTask(details[0], dateTimes[0])
            : new EventWithEndDateTask(details[0], dateTimes[0], dateTimes[1]);

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
