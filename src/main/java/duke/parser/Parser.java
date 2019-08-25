package duke.parser;

import duke.exceptions.DukeException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parser {
    /**
     * Converts a string of format "dd/MM/yyyy HH:mm" into a java Date object.
     *
     * @param dateTimeString An input string in the format dd/MM/yyyy HH:mm
     * @return A datetime corresponding to the input string
     * @throws DukeException if the input dateTimeString is invalid
     */
    public static Date parseDateTime(String dateTimeString) throws DukeException {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            return formatter.parse(dateTimeString);
        } catch (ParseException e) {
            throw new DukeException("Invalid Date Time format! Format should be: dd/MM/yyyy HH:mm");
        }
    }
}