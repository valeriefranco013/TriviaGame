
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args)
            throws IOException, InterruptedException {

        String url = "https://opentdb.com/api.php?amount=5&category=17&difficulty=medium&type=multiple";

        getTriviaResponse(url);
    }

    public static void getTriviaResponse(String url)
            throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(
                request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            System.out.println(response.body());
        } else {
            System.out.println("Request failed. Status code: "
                    + response.statusCode());
        }
    }
}
