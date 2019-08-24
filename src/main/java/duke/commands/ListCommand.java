package duke.commands;

import duke.consoles.Console;
import duke.exceptions.DukeException;
import duke.tasks.Task;

import java.util.List;

public class ListCommand extends TaskCommand {
    public ListCommand(String line, Console console, List<Task> tasks) {
        super(line, console, tasks);
    }

    @Override
    public void execute() throws DukeException {
        String[] inputs = getInputs();

        // Throw a DukeException if there are wrong number of arguments for the command
        checkIfCorrectNumberOfArguments(inputs, 0);

        // Print the list of tasks
        printTasks(tasks, console);
    }

    /**
     * Prints an list of tasks to a console.
     *
     * @param tasks The list of tasks to be printed.
     * @param console The console that the list of tasks should be printed to.
     */
    protected static void printTasks(List<Task> tasks, Console console) {
        // Create a new String array to store the lines
        String[] lines = new String[tasks.size()];
        for (int i = 0; i < tasks.size(); i++) {
            // Each line is prefixed with the item number
            lines[i] = (i + 1) + "." + tasks.get(i);
        }
        console.print(lines);
    }
}