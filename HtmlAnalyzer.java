import java.io.IOException;
import java.net.URL;

public class HtmlAnalyzer {
    public static void main(String[] args) throws IOException {
        URL url = new URL(args[0]);
        try {
            String html = UrlConnection.extractHtml(url);

            if(HtmlValidator.isMalformed(html)) {
             //  throw new RuntimeException("malformed HTML");
               System.out.println("malformed HTML");
                return;
            }
            System.out.println(DeepTextSearch.findDeepestText(html));

       } catch (IOException e) {
            System.out.println("URL connection error");
        }
    }
}

