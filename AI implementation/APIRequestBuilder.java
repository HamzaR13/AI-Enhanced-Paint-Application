// === Utility for building API requests ===
public class APIRequestBuilder {
    public static String buildJSONRequest(String prompt) {
        // Example of how to build a JSON request for an AI API
        return "{\"prompt\": \"" + prompt + "\"}";
    }
}
