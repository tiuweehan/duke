package duke.command;

import duke.task.TaskList;
import duke.ui.Ui;
import duke.exception.DukeException;
import duke.storage.Storage;

public class ListCommand extends BasicCommand {
    public ListCommand(String line) throws DukeException {
        super(line);
        validate();
    }

    @Override
    public void validate() throws DukeException {
        String[] inputs = getInputs();

        // Throw a DukeException if there are wrong number of arguments for the command
        checkIfCorrectNumberOfArguments(inputs, 0);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        // Print the list of tasks
        printTasks(tasks, ui);
    }

    /**
     * Prints an list of tasks to a ui.
     *
     * @param tasks The list of tasks to be printed.
     * @param ui The ui that the list of tasks should be printed to.
     */
    protected static void printTasks(TaskList tasks, Ui ui) throws DukeException {
        // Create a new String array to store the lines
        String[] lines = new String[tasks.size()];
        for (int i = 0; i < tasks.size(); i++) {
            // Each line is prefixed with the item number
            lines[i] = (i + 1) + "." + tasks.get(i);
        }
        ui.print(lines);
    }
}
