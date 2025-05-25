// === Enhanced AI API integration class ===
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class OllamaAPIIntegrator {
    private final String apiEndpoint;
    private final String apiKey;

    public OllamaAPIIntegrator(String apiEndpoint, String apiKey) {
        this.apiEndpoint = apiEndpoint;
        this.apiKey = apiKey;
    }

    public String sendPrompt(String prompt) {
        try {
            URL url = new URL(apiEndpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Authorization", "Bearer " + apiKey);
            conn.setDoOutput(true);

            String jsonRequest = APIRequestBuilder.buildJSONRequest(prompt);
            try (OutputStream os = conn.getOutputStream()) {
                os.write(jsonRequest.getBytes());
                os.flush();
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        response.append(line);
                    }
                    return response.toString();
                }
            } else {
                System.err.println("API call failed. Response code: " + responseCode);
                return "";
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public void handleResponse(String response) {
        if (response.isEmpty()) {
            System.err.println("Empty response from API.");
        } else {
            String summary = APIResponseParser.parseSummary(response);
            System.out.println("AI Summary: " + summary);
        }
    }
}
