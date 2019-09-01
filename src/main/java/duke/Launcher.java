package duke;

import duke.program.DukeCli;
import duke.program.DukeGui;
import javafx.application.Application;

public class Launcher {
    /**
     * The entry point to the Duke CLI program.
     *
     * @param filepath The location of the storage file.
     */
    public static void launchCli(String filepath) {
        new DukeCli(filepath).run();
    }

    /**
     * The entry point to the Duke GUI program.
     *
     * @param filepath The location of the storage file.
     */
    public static void launchGui(String filepath) {
        Application.launch(DukeGui.class, filepath);
    }

    public static void main(String[] args) {
        launchGui("./duke_data.txt");
    }
}
