package duke.commands;

import duke.consoles.Console;
import duke.exceptions.DukeException;

public class ByeCommand extends BasicCommand {
    public ByeCommand(String line, Console console) {
        super(line, console);
    }

    @Override
    public void execute() throws DukeException {
        String[] inputs = getInputs();

        // Throw a DukeException if there are wrong number of arguments for the command
        checkIfCorrectNumberOfArguments(inputs,0);

        // Print a message before closing Duke
        console.print("Bye. Hope to see you again soon!");
    }
}