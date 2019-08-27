package duke.storage;

import duke.exceptions.DukeException;
import duke.tasks.Task;
import duke.tasks.TaskList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Storage {
    public void store(TaskList tasks) throws DukeException;

    public List<Task> load() throws DukeException;
}