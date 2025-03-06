import java.util.Stack;

public class DeepTextSearch {

    /**
     * this method finds the deepest text in a html structure.
     * A deepest text is the text that is nested inside the most HTML tags.
     * @param html
     * @return the deepest text in a html structure
     */
    public static String findDeepestText(String html) {

        int deepestLevel = -1;
        String deepText = "";
        String[] lines = html.split("\n");
        Stack<String> stack = new Stack<>();

        for (String line : lines) {
            line = line.trim();
            
            if (line.startsWith("</")) {
                stack.pop();
            } else if (!line.startsWith("<") && !line.isEmpty()) {

                if (stack.size() > deepestLevel) {
                    deepestLevel = stack.size();
                    deepText = line;
                }
            }

            if (!line.startsWith("</") && line.startsWith("<")) {
                stack.push(line);
            }
        }

        return deepText;
    }
}
