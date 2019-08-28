package duke.storage;

import duke.exception.DukeException;
import duke.task.DeadlineTask;
import duke.task.EventTask;
import duke.task.EventWithEndDateTask;
import duke.task.Task;
import duke.task.TaskList;
import duke.task.TodoTask;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TextStorage implements Storage {
    protected String fileLocation;

    public TextStorage(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    @Override
    public void store(TaskList tasks) throws DukeException {
        try {
            FileWriter fw = new FileWriter(fileLocation);
            for (Task task : tasks) {
                fw.write(task.toStorageFormat() + '\n');
            }
            fw.close();
        } catch (IOException e) {
            throw new DukeException("Cannot store tasks");
        }
    }

    @Override
    public TaskList load() throws DukeException {
        try {
            String content = Files.readString(Paths.get(fileLocation), StandardCharsets.US_ASCII);
            List<Task> tasks = new ArrayList<Task>();
            for (String taskStorageFormat : content.split("\n")) {
                String[] taskDetails = taskStorageFormat.split(" \\| ");
                Task task = null;
                switch (taskDetails[0]) {
                case "T":
                    task = new TodoTask(taskDetails[2]);
                    break;
                case "D":
                    task = new DeadlineTask(taskDetails[2], taskDetails[3]);
                    break;
                case "E":
                    if (taskDetails.length == 4) {
                        task = new EventTask(taskDetails[2], taskDetails[3]);
                    } else {
                        task = new EventWithEndDateTask(taskDetails[2], taskDetails[3], taskDetails[4]);
                    }
                    break;
                default:
                    throw new IOException();
                }
                if (taskDetails[1].equals("1")) {
                    task.markAsDone();
                }
                tasks.add(task);
            }
            return new TaskList(tasks);
        } catch (IOException e) {
            throw new DukeException("Unable to load file");
        }
    }
}
