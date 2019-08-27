package duke.commands;

import duke.tasks.TaskList;
import duke.ui.Ui;
import duke.exceptions.DukeException;
import duke.storage.Storage;
import duke.tasks.Task;

public class DeleteCommand extends BasicCommand {
    public DeleteCommand(String line) {
        super(line);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        String[] inputs = getInputs();

        // Throw a DukeException if there are wrong number of arguments for the command
        checkIfCorrectNumberOfArguments(inputs, 1);

        // Get the index of the task in the list of tasks and remove the task
        // Throw a DukeException if the argument is not a number or if there is no task at given index.
        Task newTask = null;
        int index = -1;
        try {
            index = Integer.parseInt(inputs[1]) - 1;
            newTask = tasks.remove(index);
        } catch (NumberFormatException e) {
            throw new DukeException("☹ OOPS!!! The argument should be a number.");
        }

        storage.store(tasks);

        // Print a message confirming that the task is removed
        ui.print(
                "Noted. I've removed this task: ",
                newTask.toString(),
                "Now you have " + tasks.size() + " tasks in the list."
        );
    }
}
