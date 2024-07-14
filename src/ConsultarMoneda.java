import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarMoneda {
    public String buscarMoneda(String codigoDeMoneda) {
        String address = String.format("https://v6.exchangerate-api.com/v6/39da6447f4c4394ec6ebfa81/latest/%s", codigoDeMoneda);

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(address))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception e) {
            throw new RuntimeException(String.format("No se encontró la moneda de código: %s", codigoDeMoneda));
        }
    }

}
