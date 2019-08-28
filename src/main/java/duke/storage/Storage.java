package duke.storage;

import duke.exception.DukeException;
import duke.task.TaskList;

public interface Storage {
    void store(TaskList tasks) throws DukeException;

    TaskList load() throws DukeException;
}