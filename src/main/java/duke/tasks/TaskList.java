package duke.tasks;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    protected List<Task> tasks;

    public TaskList(List<Task> tasks) {
        this.tasks = new ArrayList<Task>(tasks);
    }
}
