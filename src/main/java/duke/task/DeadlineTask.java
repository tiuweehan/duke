package duke.task;

import duke.exception.DukeException;
import duke.parser.Parser;

import java.util.Date;

public class DeadlineTask extends Task {
    Date dueDateTime;

    public DeadlineTask(String description, String dueDateTime) throws DukeException {
        super(description);
        this.dueDateTime = Parser.parseDateTime(dueDateTime);
    }

    @Override
    public String toStorageFormat() {
        return String.join(
            " | ",
            new String[] {
                "D",
                getIsDone() ? "1" : "0",
                super.description,
                Parser.convertDateTimeToString(dueDateTime)
            }
        );
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + Parser.convertDateTimeToString(dueDateTime) + ")";
    }
}
