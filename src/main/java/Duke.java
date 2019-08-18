import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        // Print the introduction
        String intro = wrapText("Hello! I'm Duke", "What can I do for you?");
        System.out.print(intro);

        // Declare a scanner to read input
        Scanner sc = new Scanner(System.in);

        // Declare an array to store the list of messages
        ArrayList<String> storedTexts = new ArrayList<>();

        // Read Eval Print Loop
        replLoop:
        while (sc.hasNextLine()) {
            // Read the next command
            String command = sc.nextLine();
            switch(command) {
                case "bye":
                    System.out.print(wrapText("Bye. Hope to see you again soon!"));
                    break replLoop;
                case "list":
                    // Create a new String array to store the lines
                    String[] lines = new String[storedTexts.size()];
                    for (int i = 0; i < storedTexts.size(); i++) {
                        // Each line is prefixed with the item number
                        lines[i] = (i + 1) + ". " + storedTexts.get(i);
                    }
                    System.out.print(wrapText(lines));
                    break;
                default:
                    // Add line to stored texts
                    storedTexts.add(command);
                    System.out.print(wrapText("added: " + command));
                    break;
            }
        }

        sc.close();
    }

    /**
     * @param lines An array of messages to be wrapped.
     * @return A string including both the wrapper and the messages separated by a newline.
     * The wrapper adds a line to the top and bottom of the message and adds tab indentation.
     */
    public static String wrapText(String ...lines) {
        String result = "";
        result += "\t____________________________________________________________\n";
        for (String line: lines) {
            result += "\t " + line + "\n";
        }
        result += "\t____________________________________________________________\n";
        return result;
    }
}
