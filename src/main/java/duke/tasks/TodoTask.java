package duke.tasks;

public class TodoTask extends Task {
    public TodoTask(String description) {
        super(description);
    }

    @Override
    public String toStorageFormat() {
        return String.join(" | ", new String[] { "T", getIsDone() ? "1" : "0", super.description });
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
