package duke.storage;

import duke.exception.DukeException;
import duke.task.Task;
import duke.task.TaskList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Storage {
    public void store(TaskList tasks) throws DukeException;

    public List<Task> load() throws DukeException;
}