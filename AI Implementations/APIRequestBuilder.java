// === Utility for building JSON API requests ===
public class APIRequestBuilder {
    public static String buildJSONRequest(String prompt) {
        // Builds a JSON request with user prompt and default parameters
        return String.format("{\"prompt\": \"%s\", \"max_tokens\": 150}", prompt);
    }
}
