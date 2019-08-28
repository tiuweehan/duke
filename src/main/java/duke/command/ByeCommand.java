package duke.command;

import duke.task.TaskList;
import duke.ui.Ui;
import duke.exception.DukeException;
import duke.storage.Storage;

public class ByeCommand extends BasicCommand {
    public ByeCommand(String line) throws DukeException {
        super(line);
        validate();
    }

    @Override
    public void validate() throws DukeException {
        String[] inputs = getInputs();

        // Throw a DukeException if there are wrong number of arguments for the command
        checkIfCorrectNumberOfArguments(inputs,0);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        // Print a message before closing Duke
        ui.print("Bye. Hope to see you again soon!");
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
