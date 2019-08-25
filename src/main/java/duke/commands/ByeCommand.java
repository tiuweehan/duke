package duke.commands;

import duke.consoles.Console;
import duke.exceptions.DukeException;
import duke.storage.Storage;

public class ByeCommand extends BasicCommand {
    public ByeCommand(String line, Console console, Storage storage) {
        super(line, console, storage);
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