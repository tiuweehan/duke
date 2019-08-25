package duke.tasks;

public class DeadlineTask extends Task {
    String dueDateTime;

    public DeadlineTask(String description, String dueDateTime) {
        super(description);
        this.dueDateTime = dueDateTime;
    }

    @Override
    public String toStorageFormat() {
        return String.join(
                " | ",
                new String[] { "D", getIsDone() ? "1" : "0", super.description, dueDateTime }
        );
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + dueDateTime + ")";
    }
}
