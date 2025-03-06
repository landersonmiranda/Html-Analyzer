import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlConnection {

    /**
     * This method extracts an HTML structure from a URL on the internet and returns it as a String
     * @param url
     * @return A string with the HTML content of the passed URL
     * @throws IOException
     */
     public static String extractHtml(URL url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
         int status = conn.getResponseCode();
         if (status != HttpURLConnection.HTTP_OK) {
             throw new IOException("URL connection error");
         }
        InputStream is = conn.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder html = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            html.append(line).append("\n");
        }
        String result = html.toString();
        br.close();
        return result;

    }
}
