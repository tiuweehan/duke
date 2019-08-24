package duke.commands;

import duke.consoles.Console;
import duke.exceptions.DukeException;
import duke.tasks.Task;

import java.util.List;

public class DeleteCommand extends TaskCommand {
    public DeleteCommand(String line, Console console, List<Task> tasks) {
        super(line, console, tasks);
    }

    @Override
    public void execute() throws DukeException {
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
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("☹ OOPS!!! There is no task at that index.");
        }

        // Print a message confirming that the task is removed
        console.print(
                "Noted. I've removed this task: ",
                newTask.toString(),
                "Now you have " + tasks.size() + " tasks in the list."
        );
    }
}