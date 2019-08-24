package duke.tasks;

public class DeadlineTask extends Task {
    String dueDateTime;

    public DeadlineTask(String description, String dueDateTime) {
        super(description);
        this.dueDateTime = dueDateTime;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + dueDateTime + ")";
    }
}
