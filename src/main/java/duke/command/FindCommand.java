package duke.command;

import duke.task.Task;
import duke.task.TaskList;
import duke.ui.Ui;
import duke.util.PrintFormatter;
import duke.exception.DukeException;
import duke.storage.Storage;

public class FindCommand extends BasicCommand {
    public FindCommand(String line) throws DukeException {
        super(line);
        validate();
    }

    @Override
    public void validate() throws DukeException {
        String[] inputs = getInputs();

        // Throw a DukeException if there are wrong number of arguments for the command
        checkIfCorrectNumberOfArguments(inputs, 1);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        // Retrieve the keyword
        String keyword = getInputs()[1];

        // Filter the tasks that contain the keyword
        TaskList filteredTasks = new TaskList();
        for (Task task : tasks) {
            if (task.toString().contains(keyword)) {
                filteredTasks.add(task);
            }
        }

        // Print the list of tasks
        PrintFormatter.printTasks(filteredTasks, ui);
    }
}
