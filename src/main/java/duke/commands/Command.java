package duke.commands;

import duke.exceptions.DukeException;

public interface Command {
    public void execute() throws DukeException;
}