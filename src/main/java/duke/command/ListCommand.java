package duke.command;

import duke.task.TaskList;
import duke.util.Formatter;
import duke.exception.DukeException;
import duke.storage.Storage;

/**
 * The command used to list all the tasks in the Duke Program.
 */
public class ListCommand extends BasicCommand {
    public ListCommand(String line) throws DukeException {
        super(line);
        validate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void validate() throws DukeException {
        String[] inputs = getInputs();

        // Throw a DukeException if there are wrong number of arguments for the command
        checkIfCorrectNumberOfArguments(inputs, 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] execute(TaskList tasks, Storage storage) throws DukeException {
        // Return the formatted list of tasks
        return Formatter.formatTasks(tasks);
    }
}
