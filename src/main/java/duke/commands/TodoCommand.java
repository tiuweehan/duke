package duke.commands;

import duke.consoles.Console;
import duke.exceptions.DukeException;
import duke.tasks.Task;
import duke.tasks.TodoTask;

import java.util.List;

public class TodoCommand extends TaskCommand {
    public TodoCommand(String line, Console console, List<Task> tasks) {
        super(line, console, tasks);
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

        // Print a message confirming the addition of the task
        console.print(
                "Got it. I've added this task:",
                task.toString(),
                "Now you have " + getNumberOfTasks() + " tasks in the list."
        );
    }
}