package duke.task;

import duke.exception.DukeException;
import duke.util.Parser;

import java.util.Date;

public class EventTask extends Task {
    protected Date startDateTime;

    public EventTask(String description, String startDateTime) throws DukeException {
        super(description);
        this.startDateTime = Parser.parseDateTime(startDateTime);
    }

    @Override
    public String toStorageFormat() {
        return String.join(
            " | ",
            new String[] {
                "E",
                getIsDone() ? "1" : "0",
                super.description,
                Parser.convertDateTimeToString(startDateTime) }
        );
    }

    @Override
    public String toString() {
        return "[E]" + getDetails() + " (at: " + Parser.convertDateTimeToString(startDateTime) + ")";
    }
}