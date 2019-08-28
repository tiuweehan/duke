package duke.storage;

import duke.exception.DukeException;
import duke.task.TaskList;

public interface Storage {
    public void store(TaskList tasks) throws DukeException;

    public TaskList load() throws DukeException;
}