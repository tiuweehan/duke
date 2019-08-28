package duke.command;

import duke.task.TaskList;
import duke.ui.Ui;
import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.EventTask;
import duke.task.EventWithEndDateTask;
import duke.task.Task;

public class EventCommand extends BasicCommand {
    public EventCommand(String line) throws DukeException {
        super(line);
        validate();
    }

    public String[] getDetails() {
        return line.split("event\\s*", 2)[1].split("\\s+/at\\s+", 2);
    }

    @Override
    public void validate() throws DukeException {
        // Throw a DukeException if there is no input
        if (line.equals("event")) {
            throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.");
        }

        // Split the line by a regex and store the information in the details
        String[] details = getDetails();

        // Throw a DukeException if input is invalid
        if (details.length < 2 || details[0].isEmpty() || details[1].isEmpty()) {
            throw new DukeException("☹ OOPS!!! The description or the date & time for this task is empty.");
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        String[] details = getDetails();

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
