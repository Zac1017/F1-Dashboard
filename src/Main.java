
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws Exception {

        String url = "https://api.openf1.org/v1/car_data"
                   + "?driver_number=55"
                   + "&session_key=9159"
                   + "&speed%3E=315";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        

        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        List<CarData> telemetry = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\{[^{}]*\\}");
        Matcher matcher = pattern.matcher(response.body());

        while (matcher.find()) {
            telemetry.add(new CarData(matcher.group()));
        }
        
        for (CarData car : telemetry) {
            System.out.println(
                car.getDriverNumber() + " | " +
                car.getSpeed() + " km/h | " +
                car.getRpm() + " rpm | " + 
                car.getGear() + " gear | " +
                car.getThrottle() + " % throttle | " +
                car.getBrake() + " % brake"
                );
        }
    }
}
