package duke.ui;

public interface Ui {
    String readCommand();

    void showWelcome();

    /**
     * Prints an output to the console.
     *
     * @param lines An array of messages to be wrapped.
     */
    void print(String...lines);
}
