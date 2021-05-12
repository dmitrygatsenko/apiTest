import com.github.opendevl.JFlat;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest;
//import java.net.ProxySelector;
import java.net.URI;

public class App {
    public static void main(String[] args) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
        .uri(new URI("http://api.weatherstack.com/current" +
                    "?access_key=683131ae8beff57c6ab2475979d087c0" +
                    "&query=New%20York"))
        .GET()
        .build();
        HttpResponse<String> response = HttpClient
        .newBuilder()
        .build()
        .send(request, HttpResponse.BodyHandlers.ofString());
        JFlat flatMe = new JFlat(response.body());
        //directly write the JSON document to CSV
        flatMe.json2Sheet().write2csv("file.csv");
    }
}