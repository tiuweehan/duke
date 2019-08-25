package duke.commands;

import duke.consoles.Console;
import duke.exceptions.DukeException;
import duke.storage.Storage;
import duke.tasks.Task;

import java.util.List;

public class DoneCommand extends TaskCommand {
    public DoneCommand(String line, Console console, Storage storage, List<Task> tasks) {
        super(line, console, storage, tasks);
    }

    @Override
    public void execute() throws DukeException {
        String[] inputs = getInputs();

        // Throw a DukeException if there are wrong number of arguments for the command
        checkIfCorrectNumberOfArguments(inputs, 1);

        // Get the index of the task in the list of tasks and retrieve the task
        // Throw a DukeException if the argument is not a number or if there is no task at given index.
        int index = -1;
        try {
            index = Integer.parseInt(inputs[1]) - 1;
            tasks.get(index).markAsDone();
        } catch (NumberFormatException e) {
            throw new DukeException("☹ OOPS!!! The argument should be a number.");
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("☹ OOPS!!! There is no task at that index.");
        }

        storage.store(tasks);

        // Print a message confirming that the task is marked as done
        console.print(
                "Nice! I've marked this task as done: ",
                tasks.get(index).toString()
        );
    }
}