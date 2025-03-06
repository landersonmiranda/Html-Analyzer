import java.util.Stack;

public class HtmlValidator {

    /**
     * This method 'isMalFormed' checks if a html structure is malformed
     *
     * @param html
     * @return true if is MalFormed or false if it is not
     */
    public static boolean isMalformed(String html) {
        String[] lines = html.split("\n");
        Stack<String> openTagsStack = new Stack<>();

        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) continue;

            if (line.startsWith("<") && line.endsWith(">")) {
                if (line.startsWith("</")) {
                    String closeTag = line.substring(2, line.length() - 1);
                    if (openTagsStack.isEmpty() || !openTagsStack.peek().equals(closeTag)) {
                        return true;
                    }
                    openTagsStack.pop();
                } else {
                    String openTag = line.substring(1, line.length() - 1);
                    openTagsStack.push(openTag);
                }
            }
        }


        return !openTagsStack.isEmpty();
    }
}
