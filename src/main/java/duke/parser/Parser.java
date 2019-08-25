package duke.parser;

import duke.exceptions.DukeException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Parser {
    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    /**
     * Converts a string of format "dd/MM/yyyy HH:mm" into a java Date object.
     *
     * @param dateTimeString An input string in the format dd/MM/yyyy HH:mm
     * @return A datetime corresponding to the input string
     * @throws DukeException if the input dateTimeString is invalid
     */
    public static Date parseDateTime(String dateTimeString) throws DukeException {
        try {
            return DATE_FORMATTER.parse(dateTimeString);
        } catch (ParseException e) {
            throw new DukeException("Invalid Date Time format! Format should be: dd/MM/yyyy HH:mm");
        }
    }

    public static String convertDateTimeToString(Date date) {
        return DATE_FORMATTER.format(date);
    }
}