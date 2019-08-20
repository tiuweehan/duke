import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) throws DukeException {
        // Declare an Console interface
        Console console = new CLIConsole();

        // Print the introduction
        console.print("Hello! I'm Duke", "What can I do for you?");

        // Declare a scanner to read input
        Scanner sc = new Scanner(System.in);

        // Declare an array to store the list of messages
        ArrayList<Task> tasks = new ArrayList<>();

        // Read Eval Print Loop
        replLoop:
        while (sc.hasNextLine()) {
            try {
                // Read the next line
                String line = sc.nextLine().trim();

                // Get all commands by splitting on a whitespaces delimiter
                String[] commands = line.split("\\s+");

                // If there is no input, wait for another input
                if (commands.length == 0) {
                    continue;
                }

                // Declaring variables for use in switch statement
                String[] details;
                Task newTask;

                // First command
                String command = commands[0];
                switch(command) {
                    case "bye":
                        // Throw a DukeException if there are arguments to the command
                        if (commands.length != 1) {
                            throw new DukeException("☹ OOPS!!! There are unknown arguments for this command.");
                        }

                        // Print a message before closing Duke
                        console.print("Bye. Hope to see you again soon!");
                        break replLoop;
                    case "done":
                        // Throw a DukeException if there is none or more than 1 argument
                        if (commands.length < 2) {
                            throw new DukeException("☹ OOPS!!! Insufficient arguments for this command.");
                        } else if (commands.length > 2) {
                            throw new DukeException("☹ OOPS!!! There are unknown arguments for this command.");
                        }

                        // Get the index of the Task in the list of tasks
                        int index = Integer.parseInt(commands[1]) - 1;

                        // Retrieve the task and mark it as done
                        tasks.get(index).markAsDone();

                        // Print a message confirming that the task is marked as done
                        console.print(
                            "Nice! I've marked this task as done: ",
                            tasks.get(index).toString()
                        );
                        break;
                    case "list":
                        // Throw a DukeException if there are arguments to the command
                        if (commands.length != 1) {
                            throw new DukeException("☹ OOPS!!! There are unknown arguments for this command.");
                        }

                        // Print the list of tasks
                        printTasks(tasks, console);
                        break;
                    case "todo":
                        // Throw a DukeException if there is no input
                        if (line.equals("todo")) {
                            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                        }

                        // Split the line by a regex and store the information in the details
                        details = line.split("todo\\s*", 2);

                        // Create a new task using the information stored in details
                        newTask = new TodoTask(details[1]);

                        // Add the new task to the list of tasks
                        tasks.add(newTask);

                        // Print a message confirming the addition of the task
                        console.print(
                            "Got it. I've added this task:",
                            newTask.toString(),
                            "Now you have " + tasks.size() + " tasks in the list."
                        );
                        break;
                    case "deadline":
                        // Throw a DukeException if there is no input
                        if (line.equals("deadline")) {
                            throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
                        }

                        // Split the line by a regex and store the information in the details
                        details = line.split("deadline\\s*", 2)[1].split("\\s+/by\\s+", 2);

                        // Throw a DukeException if input is invalid
                        if (details.length < 2 || details[0].isEmpty() || details[1].isEmpty()) {
                            throw new DukeException("☹ OOPS!!! The description or the deadline for this task is empty.");
                        }

                        // Create a new task using the information stored in details
                        newTask = new DeadlineTask(details[0], details[1]);

                        // Add the new task to the list of tasks
                        tasks.add(newTask);

                        // Print a message confirming the addition of the task
                        console.print(
                            "Got it. I've added this task:",
                            newTask.toString(),
                            "Now you have " + tasks.size() + " tasks in the list."
                        );
                        break;
                    case "event":
                        // Throw a DukeException if there is no input
                        if (line.equals("event")) {
                            throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.");
                        }

                        // Split the line by a regex and store the information in the details
                        details = line.split("event\\s*", 2)[1].split("\\s+/at\\s+", 2);

                        // Throw a DukeException if input is invalid
                        if (details.length < 2 || details[0].isEmpty() || details[1].isEmpty()) {
                            throw new DukeException("☹ OOPS!!! The description or the date & time for this task is empty.");
                        }

                        // Create a new task using the information stored in details
                        newTask = new EventTask(details[0], details[1]);

                        // Add the new task to the list of tasks
                        tasks.add(newTask);

                        // Print a message confirming the addition of the task
                        console.print(
                            "Got it. I've added this task:",
                            newTask.toString(),
                            "Now you have " + tasks.size() + " tasks in the list."
                        );
                        break;
                    default:
                        throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                }
            } catch (DukeException e) {
                console.print(e.getMessage());
            }
        }
    }

    public static void printTasks(ArrayList<Task> tasks, Console console) {
        // Create a new String array to store the lines
        String[] lines = new String[tasks.size()];
        for (int i = 0; i < tasks.size(); i++) {
            // Each line is prefixed with the item number
            lines[i] = (i + 1) + "." + tasks.get(i);
        }
        console.print(lines);
    }
}
