package duke.command;

import duke.task.TaskList;
import duke.ui.Ui;
import duke.exception.DukeException;
import duke.storage.Storage;

public class DoneCommand extends BasicCommand {
    public DoneCommand(String line) {
        super(line);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        String[] inputs = getInputs();

        // Throw a DukeException if there are wrong number of arguments for the command
        checkIfCorrectNumberOfArguments(inputs, 1);

        // Get the index of the task in the list of tasks and retrieve the task
        // Throw a DukeException if the argument is not a number or if there is no task at given index.
        int index = -1;
        try {
            index = Integer.parseInt(inputs[1]) - 1;
            tasks.markAsDone(index);
        } catch (NumberFormatException e) {
            throw new DukeException("☹ OOPS!!! The argument should be a number.");
        }

        storage.store(tasks);

        // Print a message confirming that the task is marked as done
        ui.print(
                "Nice! I've marked this task as done: ",
                tasks.get(index).toString()
        );
    }
}
