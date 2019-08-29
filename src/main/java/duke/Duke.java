package duke;

import duke.command.Command;
import duke.util.Parser;
import duke.task.TaskList;
import duke.ui.Ui;
import duke.ui.CliUi;
import duke.exception.DukeException;
import duke.storage.Storage;
import duke.storage.TextStorage;

public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Constructor for the Duke class, which instantiates the TaskList, Ui and Storage objects.
     *
     * @param filepath The filepath of the storage file.
     */
    public Duke(String filepath) {
        ui = new CliUi();
        storage = new TextStorage(filepath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            tasks = new TaskList();
        }
    }

    /**
     * Runs the duke program.
     */
    public void run() {
        ui.showWelcome();
        boolean isExit = false;

        // Read Eval Print Loop
        replLoop:
        while (!isExit) {
            try {
                // Read the next line
                String line = ui.readCommand();

                // Parse and get the next command
                Command command = Parser.parseCommand(line);

                // If there is no command, restart the loop
                if (command == null) {
                    continue;
                }

                // Execute the command
                command.execute(tasks, ui, storage);

                // Set isExit to true if the command is an exiting command
                isExit = command.isExit();
            } catch (DukeException e) {
                ui.print(e.getMessage());
            }
        }
    }

    /**
     * The entry point to the Duke program.
     *
     * @param args The input arguments to the program.
     */
    public static void main(String[] args) {
        (new Duke("./duke_data.txt")).run();
    }
}
