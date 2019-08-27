package duke.commands;

import duke.ui.Ui;
import duke.exceptions.DukeException;
import duke.storage.Storage;

public class ByeCommand extends BasicCommand {
    public ByeCommand(String line, Ui ui, Storage storage) {
        super(line, ui, storage);
    }

    @Override
    public void execute() throws DukeException {
        String[] inputs = getInputs();

        // Throw a DukeException if there are wrong number of arguments for the command
        checkIfCorrectNumberOfArguments(inputs,0);

        // Print a message before closing Duke
        ui.print("Bye. Hope to see you again soon!");
    }
}
