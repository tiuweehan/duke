import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
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
            // Read the next line
            String line = sc.nextLine();

            // Get all commands by splitting on a space delimiter
            String[] commands = line.split(" ");

            // Declaring variables for use in switch statement
            String[] details;
            Task newTask;

            // First command
            String command = commands[0];
            switch(command) {
                case "bye":
                    // Print a message before closing Duke
                    console.print("Bye. Hope to see you again soon!");
                    break replLoop;
                case "done":
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
                    // Print the list of tasks
                    printTasks(tasks, console);
                    break;
                case "todo":
                    // Split the line by a regex and store the information in the details
                    details = line.split("todo ");

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
                    // Split the line by a regex and store the information in the details
                    details = line.split("deadline | /by ");

                    // Create a new task using the information stored in details
                    newTask = new DeadlineTask(details[1], details[2]);

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
                    // Split the line by a regex and store the information in the details
                    details = line.split("event | /at ");

                    // Create a new task using the information stored in details
                    newTask = new EventTask(details[1], details[2]);

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
                    // Add line to stored texts
                    tasks.add(new Task(line));
                    console.print("added: " + line);
                    break;
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
