package duke.tasks;

import duke.commands.TaskCommand;
import duke.exceptions.DukeException;
import duke.parser.Parser;

import java.util.Date;

public class EventWithEndDateTask extends EventTask {
    protected Date endDateTime;

    /**
     * Constructor for the EventWithEndDateTask class.
     *
     * @param description The description of the task.
     * @param startDateTime The start date & time of the task.
     * @param endDatetime The end date & time of the task.
     * @throws DukeException If the start date & time is after the end date & time.
     */
    public EventWithEndDateTask(String description, String startDateTime, String endDatetime) throws DukeException {
        super(description, startDateTime);
        this.endDateTime = Parser.parseDateTime(endDatetime);
        if (startDateTime.compareTo(endDatetime) > 0) {
            throw new DukeException("Start date & time cannot be after end date & time!");
        }
    }

    @Override
    public String toString() {
        return "[E]" + getDetails() + " (from: " + startDateTime + " to " + endDateTime + ")";
    }
}
