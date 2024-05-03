package conversorMonedas;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
public class ValorConversion {

    
    public static void main(String[] args) throws IOException, InterruptedException {
        

        String direccion = "https://v6.exchangerate-api.com/v6/dc4b2e8cdfa462de9498f977/latest/" +
                           "USD";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        
        Gson gson = new Gson();

        // Convertir el JSON a un objeto DatosMonedas
       DatosMoneda datosMonedas = gson.fromJson(json, DatosMoneda.class);
        // Ahora puedes acceder a los datos del objeto DatosMonedas
       System.out.println("Result: " + datosMonedas.getDolar());
       System.out.println("Result: " + datosMonedas.getPesoArgentino());
       System.out.println("Result: " + datosMonedas.getPesoColombiano());
       System.out.println("Result: " + datosMonedas.getRealBrasilero());
       
    }
    }