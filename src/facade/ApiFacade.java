package facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiFacade {

    /**
     * Sends an HTTP GET request to the given URL, retrieves JSON,
     * and extracts the value of the given attribute name.
     *
     * @param urlString      API endpoint as string
     * @param attributeName  JSON attribute key
     * @return value of attribute
     * @throws IOException if URL is invalid or request fails
     * @throws IllegalArgumentException if attribute is missing
     */
    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IllegalArgumentException, IOException {
        try {
            // 1. Send request
            String jsonResponse = getJsonFromApi(urlString);

            // 2. Extract attribute manually
            return extractAttribute(jsonResponse, attributeName);

        } catch (MalformedURLException e) {
            throw new IOException("Invalid URL: " + urlString, e);
        }
    }

    // Helper: fetch raw JSON string from API
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

    // Helper: very simple JSON attribute extractor
    private String extractAttribute(String json, String attributeName) {
        String search = "\"" + attributeName + "\":";
        int index = json.indexOf(search);
        if (index == -1) {
            throw new IllegalArgumentException("Attribute '" + attributeName + "' not found in JSON response.");
        }

        // move to first quote after the colon
        int start = json.indexOf("\"", index + search.length());
        if (start == -1) {
            throw new IllegalArgumentException("Attribute '" + attributeName + "' has no value in JSON response.");
        }
        start++; // skip the quote
        int end = json.indexOf("\"", start);
        if (end == -1) {
            throw new IllegalArgumentException("Malformed JSON while parsing attribute: " + attributeName);
        }

        return json.substring(start, end);
    }
}
