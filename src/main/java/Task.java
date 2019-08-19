import java.util.ArrayList;

public class Task {
  protected String description;
  protected boolean isDone;

  public Task(String description) {
    this.description = description;
    this.isDone = false;
  }

  public String getStatusIcon() {
    return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
  }

  public void markAsDone() {
    this.isDone = true;
  }

  @Override
  public String toString() {
    return "[" + getStatusIcon() + "] " + description;
  }

  public static String listTasks(ArrayList<Task> tasks) {
    // Create a new String array to store the lines
    String[] lines = new String[tasks.size()];
    for (int i = 0; i < tasks.size(); i++) {
        // Each line is prefixed with the item number
        lines[i] = (i + 1) + "." + tasks.get(i);
    }
    return TextFormatter.wrapText(lines);
  }
}