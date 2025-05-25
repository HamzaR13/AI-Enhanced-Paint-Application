// === Utility for parsing AI API JSON responses ===
import org.json.JSONObject;

public class APIResponseParser {
    public static String parseSummary(String jsonResponse) {
        try {
            JSONObject obj = new JSONObject(jsonResponse);
            // Assuming a 'summary' field in the response
            return obj.getString("summary");
        } catch (Exception e) {
            e.printStackTrace();
            return "Error parsing response.";
        }
    }
}
