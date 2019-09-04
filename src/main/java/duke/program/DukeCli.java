package duke.program;

import duke.command.Command;
import duke.exception.DukeException;
import duke.storage.Storage;
import duke.storage.TextStorage;
import duke.task.TaskList;
import duke.ui.cli.CliUi;
import duke.ui.Ui;
import duke.util.Parser;

public class DukeCli {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Constructor for the Duke class, which instantiates the TaskList, Ui and Storage objects.
     *
     * @param filepath The filepath of the storage file.
     */
    public DukeCli(String filepath) {
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


    public static void main(String[] args) {

    }
}
