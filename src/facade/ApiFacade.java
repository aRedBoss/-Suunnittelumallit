package facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiFacade {

    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IllegalArgumentException, IOException {
        try {

            String jsonResponse = getJsonFromApi(urlString);

            return extractAttribute(jsonResponse, attributeName);

        } catch (MalformedURLException e) {
            throw new IOException("Invalid URL: " + urlString, e);
        }
    }

    private String getJsonFromApi(String apiUrl) throws IOException {
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            return content.toString();
        } finally {
            con.disconnect();
        }
    }

    private String extractAttribute(String json, String attributeName) {
        String search = "\"" + attributeName + "\":";
        int index = json.indexOf(search);
        if (index == -1) {
            throw new IllegalArgumentException("Attribute '" + attributeName + "' not found in JSON response.");
        }

        int start = json.indexOf("\"", index + search.length());
        if (start == -1) {
            throw new IllegalArgumentException("Attribute '" + attributeName + "' has no value in JSON response.");
        }
        start++;
        int end = json.indexOf("\"", start);
        if (end == -1) {
            throw new IllegalArgumentException("Malformed JSON while parsing attribute: " + attributeName);
        }

        return json.substring(start, end);
    }
}
