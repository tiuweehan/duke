package duke.tasks;

public class EventTask extends Task {
    String rangeDateTime;

    public EventTask(String description, String rangeDateTime) {
        super(description);
        this.rangeDateTime = rangeDateTime;
    }

    @Override
    public String toStorageFormat() {
        return String.join(
            " | ",
            new String[] { "E", getIsDone() ? "1" : "0", super.description, rangeDateTime }
        );
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + rangeDateTime + ")";
    }
}
