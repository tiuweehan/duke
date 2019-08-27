package duke.command;

import duke.task.TaskList;
import duke.ui.Ui;
import duke.exception.DukeException;
import duke.storage.Storage;

public abstract class BasicCommand implements Command {
    protected String line;

    protected BasicCommand(String line) {
        this.line = line;
    }

    /**
     * Gets all inputs for the command in the form of a string array.
     *
     * @return all the inputs for the command in the form of a string array.
     */
    protected String[] getInputs() {
        return this.line.split("\\s+");
    }

    @Override
    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;

    /**
     * Checks if the input array has the correct number of arguments.
     *
     * @param inputs The inputs array.
     * @param correctNumberOfArguments The correct number of arguments for the command.
     * @throws DukeException The error that is thrown when command array has the wrong number of arguments.
     */
    protected static void checkIfCorrectNumberOfArguments(
            String[] inputs,
            int correctNumberOfArguments
    ) throws DukeException {
        int numberOfArguments = inputs.length - 1;
        if (numberOfArguments < correctNumberOfArguments) {
            throw new DukeException("☹ OOPS!!! Insufficient arguments for this command.");
        } else if (numberOfArguments > correctNumberOfArguments) {
            throw new DukeException("☹ OOPS!!! There are too many arguments for this command.");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
