package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

public interface Command {
    void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;

    void validate() throws DukeException;

    boolean isExit();
}