class TextFormatter {
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