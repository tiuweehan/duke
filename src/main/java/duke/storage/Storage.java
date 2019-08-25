package duke.storage;

import duke.exceptions.DukeException;
import duke.tasks.Task;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Storage {
    public void store(List<Task> tasks) throws DukeException;

    public List<Task> load();
}