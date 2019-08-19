import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        // Print the introduction
        String intro = TextFormatter.wrapText("Hello! I'm Duke", "What can I do for you?");
        System.out.print(intro);

        // Declare a scanner to read input
        Scanner sc = new Scanner(System.in);

        // Declare an array to store the list of messages
        ArrayList<Task> tasks = new ArrayList<>();

        // Read Eval Print Loop
        replLoop:
        while (sc.hasNextLine()) {
            // Read the next command
            String line = sc.nextLine();
            String[] commands = line.split(" ");
            String command = commands[0];
            switch(command) {
                case "bye":
                    System.out.print(TextFormatter.wrapText("Bye. Hope to see you again soon!"));
                    break replLoop;
                case "done":
                    int index = Integer.parseInt(commands[1]) - 1;
                    tasks.get(index).markAsDone();
                    System.out.print(
                        TextFormatter.wrapText(
                            "Nice! I've marked this task as done: ",
                            tasks.get(index).toString()
                        )
                    );
                    break;
                case "list":
                    System.out.print(Task.listTasks(tasks));
                    break;
                default:
                    // Add line to stored texts
                    tasks.add(new Task(line));
                    System.out.print(TextFormatter.wrapText("added: " + line));
                    break;
            }
        }
    }
}
