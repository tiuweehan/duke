package duke.tasks;

import duke.exceptions.DukeException;
import duke.parser.Parser;

import java.text.ParseException;
import java.util.Date;

public class DeadlineTask extends Task {
    Date dueDateTime;

    public DeadlineTask(String description, String dueDateTime) throws DukeException {
        super(description);
        this.dueDateTime = Parser.parseDateTime(dueDateTime);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + dueDateTime + ")";
    }
}
