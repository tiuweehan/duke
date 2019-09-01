package duke.command;

import duke.task.TaskList;
import duke.exception.DukeException;
import duke.storage.Storage;

/**
 * The command used to exit the Duke Program.
 */
public class ByeCommand extends BasicCommand {
    public ByeCommand(String line) throws DukeException {
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
        checkIfCorrectNumberOfArguments(inputs,0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] execute(TaskList tasks, Storage storage) {
        // Return a message before closing Duke
        return new String[] { "Bye. Hope to see you again soon!" };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
