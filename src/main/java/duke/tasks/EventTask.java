package duke.tasks;

import duke.exceptions.DukeException;
import duke.parser.Parser;

import java.util.Date;

public class EventTask extends Task {
    protected Date startDateTime;

    public EventTask(String description, String startDateTime) throws DukeException {
        super(description);
        this.startDateTime = Parser.parseDateTime(startDateTime);
    }

    @Override
    public String toString() {
        return "[E]" + getDetails() + " (at: " + startDateTime + ")";
    }
}
