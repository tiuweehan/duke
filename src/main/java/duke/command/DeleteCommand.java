package duke.command;

import duke.task.TaskList;
import duke.ui.Ui;
import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.Task;

public class DeleteCommand extends BasicCommand {
    public DeleteCommand(String line) throws DukeException {
        super(line);
        validate();
    }

    @Override
    public void validate() throws DukeException {
        String[] inputs = getInputs();

        // Throw a DukeException if there are wrong number of arguments for the command
        checkIfCorrectNumberOfArguments(inputs, 1);

        try {
            Integer.parseInt(inputs[1]);
        } catch (NumberFormatException e) {
            throw new DukeException("☹ OOPS!!! The argument should be a number.");
        }
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        String[] inputs = getInputs();

        // Get the index of the task in the list of tasks and remove the task
        int index = Integer.parseInt(inputs[1]) - 1;
        Task task = tasks.remove(index);

        storage.store(tasks);

        // Print a message confirming that the task is removed
        ui.print(
                "Noted. I've removed this task: ",
                task.toString(),
                "Now you have " + tasks.size() + " tasks in the list."
        );
    }
}
