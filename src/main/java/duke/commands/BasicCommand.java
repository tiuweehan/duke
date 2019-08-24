package duke.commands;

import duke.consoles.Console;
import duke.exceptions.DukeException;

public abstract class BasicCommand implements Command {
    protected String line;
    protected Console console;

    public BasicCommand(String line, Console console) {
        this.line = line;
        this.console = console;
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
    public abstract void execute() throws DukeException;

    /**
     * Checks if the input array has the correct number of arguments.
     *
     * @param inputs The inputs array.
     * @param correctNumberOfArguments The correct number of arguments for the command.
     * @throws DukeException The error that is thrown when command array has the wrong number of arguments.
     */
    public static void checkIfCorrectNumberOfArguments(
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
}