package duke.command;

import duke.task.TaskList;
import duke.ui.Ui;
import duke.util.PrintFormatter;
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
        PrintFormatter.printTasks(tasks, ui);
    }
}
