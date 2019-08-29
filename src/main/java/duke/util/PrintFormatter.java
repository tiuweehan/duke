package duke.util;

import duke.exception.DukeException;
import duke.task.TaskList;
import duke.ui.Ui;

public class PrintFormatter {

    /**
     * Prints an list of tasks to a ui.
     *
     * @param tasks The list of tasks to be printed.
     * @param ui The ui that the list of tasks should be printed to.
     */
    public static void printTasks(TaskList tasks, Ui ui) throws DukeException {
        // Create a new String array to store the lines
        String[] lines = new String[tasks.size()];
        for (int i = 0; i < tasks.size(); i++) {
            // Each line is prefixed with the item number
            lines[i] = (i + 1) + "." + tasks.get(i);
        }
        ui.print(lines);
    }
}
