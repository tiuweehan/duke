import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        // Print the introduction
        String intro = wrapText("Hello! I'm Duke\nWhat can I do for you?\n");
        System.out.print(intro);

        // Declare a scanner to read input
        Scanner sc = new Scanner(System.in);

        // Read Eval Print Loop
        replLoop:
        while (sc.hasNextLine()) {
            // Read the next command
            String command = sc.nextLine();
            switch(command) {
                case "bye":
                    System.out.print(wrapText("Bye. Hope to see you again soon!"));
                    break replLoop;
                default:
                    System.out.print(wrapText(command));
                    break;
            }
        }

        sc.close();
    }

    /**
     * @param text The string message to be wrapped.
     * @return A string including both the wrapper and the message. The wrapper adds a
     * line to the top and bottom of the message and adds tab indentation.
     */
    public static String wrapText(String text) {
        String[] lines = text.split("\n");
        String result = "";
        result += "\t____________________________________________________________\n";
        for (String line: lines) {
            result += "\t " + line + "\n";
        }
        result += "\t____________________________________________________________\n";
        return result;
    }
}
