package duke;

import java.util.Scanner;
import java.util.List;

import duke.commands.ByeCommand;
import duke.commands.Command;
import duke.commands.DeadlineCommand;
import duke.commands.DeleteCommand;
import duke.commands.DoneCommand;
import duke.commands.EventCommand;
import duke.commands.ListCommand;
import duke.commands.TodoCommand;
import duke.consoles.Console;
import duke.consoles.CliConsole;
import duke.enums.CommandEnum;
import duke.exceptions.DukeException;
import duke.storage.Storage;
import duke.storage.TextStorage;
import duke.tasks.Task;

public class Main {
    /**
     * The entry point to the Duke program.
     *
     * @param args The input arguments to the program.
     */
    public static void main(String[] args) {
        // Declare an Console interface
        Console console = new CliConsole();

        // Print the introduction
        console.print("Hello! I'm Duke", "What can I do for you?");

        // Declare a scanner to read the input
        Scanner sc = new Scanner(System.in);

        Storage storage = new TextStorage("./duke_data.txt");

        // Declare an array to store the list of messages
        List<Task> tasks = storage.load();

        // Read Eval Print Loop
        replLoop:
        while (sc.hasNextLine()) {
            try {
                // Read the next line and trim the whitespaces around it
                String line = sc.nextLine().trim();

                // Get all inputs by splitting on a whitespaces delimiter
                String[] inputs = line.split("\\s+");

                // If there are no inputs, skip the current loop iteration and wait for another input
                if (inputs.length == 0) {
                    continue;
                }

                // Declaring and initializing variables for use in switch statement
                String[] details = new String[] {};
                Task newTask = null;
                int index = -1;

                // The first value in the inputs array is the command.
                // Retrieve the command and get its enum value.
                // Throw a DukeException if there is no corresponding enum value.
                CommandEnum commandEnum = null;
                try {
                    commandEnum = CommandEnum.valueOf(inputs[0].toUpperCase());
                } catch (IllegalArgumentException e) {
                    throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }

                Command command = null;
                switch (commandEnum) {
                case BYE:
                    command = new ByeCommand(line, console, storage);
                    break replLoop;
                case LIST:
                    command = new ListCommand(line, console, storage, tasks);
                    break;
                case DONE:
                    command = new DoneCommand(line, console, storage, tasks);
                    break;
                case DELETE:
                    command = new DeleteCommand(line, console, storage, tasks);
                    break;
                case TODO:
                    command = new TodoCommand(line, console, storage, tasks);
                    break;
                case DEADLINE:
                    command = new DeadlineCommand(line, console, storage, tasks);
                    break;
                case EVENT:
                    command = new EventCommand(line, console, storage, tasks);
                    break;
                default:
                    break;
                }

                // Execute the command
                command.execute();
            } catch (DukeException e) {
                console.print(e.getMessage());
            }
        }
    }
}
