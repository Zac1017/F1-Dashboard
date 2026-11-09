
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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
        
        CarData carData = new CarData(response.body());

        System.out.println("Driver Number: " + carData.getDriverNumber());
        System.out.println("Session Key: " + carData.getSessionKey());
        System.out.println("Speed: " + carData.getSpeed());
        System.out.println("Throttle: " + carData.getThrottle());
        System.out.println("RPM: " + carData.getRpm());
        System.out.println("Gear: " + carData.getGear());
        System.out.println("DRS: " + carData.getDrs());
        System.out.println("Date: " + carData.getDate());
        System.out.println("Brake: " + carData.isBrake());
    }
}
