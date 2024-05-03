package conversorMonedas;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.DecimalFormat;
import java.util.Scanner;

import com.google.gson.Gson;

public class MenuConversor {
	
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException, InterruptedException {
        mostrarMenu();
		
		
	}
    
    

    public static void mostrarMenu() throws IOException, InterruptedException {
    	
    	
    	String direccion = "https://v6.exchangerate-api.com/v6/dc4b2e8cdfa462de9498f977/latest/" +
                "USD";

HttpClient client = HttpClient.newHttpClient();
HttpRequest request = HttpRequest.newBuilder()
     .uri(URI.create(direccion))
     .build();
HttpResponse<String> response = client
     .send(request, HttpResponse.BodyHandlers.ofString());

String json = response.body();

		//Convertir el JSON a un objeto DatosMonedas
		Gson gson = new Gson();
		DatosMoneda datosMonedas = gson.fromJson(json, DatosMoneda.class);
    	double pesoAr = datosMonedas.getPesoArgentino();
    	double realBr = datosMonedas.getRealBrasilero();
    	double pesoCol = datosMonedas.getPesoColombiano();
    	
    	 // Creamos un formato para mostrar solo tres decimales
        DecimalFormat df = new DecimalFormat("#.###");
    	
    	 String pregunta;

         int monto;
        do {
            System.out.println("Seleccione la moneda a la que desea convertir:");
            System.out.println("1. Dolar USA a Peso Argentino");
            System.out.println("2. Peso Argentino a Dolar USA");
            System.out.println("3. Dolar a Real Brasileno");
            System.out.println("4. Real Brasileno a Dolar USA");
            System.out.println("5. Dolar USA a Peso Colombiano");
            System.out.println("6. Peso Colombiano a Dolar USA");
            System.out.println(" ");
            System.out.println("***********************************");
            
            

            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                
                case 1:
                    System.out.println("Ingresa Candidad a Cambiar");
                    monto = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Cantindad en Peso Argentino" +(monto*pesoAr));
                    System.out.println(" ");
                    System.out.println("******************************");
                    break;
                case 2:
                	 System.out.println("Ingresa Candidad a Cambiar");
                	 monto = scanner.nextInt();
                	 scanner.nextLine(); 
                     System.out.println("Total en Dolares:"+df.format(monto/pesoAr));
                     System.out.println(" ");
                     System.out.println("******************************");
                    break;
                case 3:
                	 System.out.println("Ingresa Candidad a Cambiar");
                	 monto = scanner.nextInt();
                	 scanner.nextLine(); 
                     System.out.println("Total en Real Brasilero:"+(monto*realBr));
                     System.out.println(" ");
                     System.out.println("******************************");
                    break;
                case 4:
                	 System.out.println("Ingresa Candidad a Cambiar");
                	 monto = scanner.nextInt();
                	 scanner.nextLine(); 
                     System.out.println("Total en Dolares:"+df.format(monto/realBr));
                     System.out.println(" ");
                     System.out.println("******************************");
                    break;
                case 5:
                	 System.out.println("Ingresa Candidad a Cambiar");
                	 monto = scanner.nextInt();
                	 scanner.nextLine(); 
                     System.out.println("Total en Peso Colombiano:"+(monto*pesoCol));
                     System.out.println(" ");
                     System.out.println("******************************");
                    break;
                case 6:
                	 System.out.println("Ingresa Candidad a Cambiar");
                	 monto = scanner.nextInt();
                	 scanner.nextLine(); 
                     System.out.println("Total en Dolares:"+df.format(monto/pesoCol));
                     System.out.println(" ");
                     System.out.println("******************************");
                    break;
                
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
            
            System.out.println("Desea hacer otro Cambio Y/N?");
            pregunta = scanner.nextLine();
            
        }while(pregunta.equalsIgnoreCase("Y"));
        
        System.out.println("*****Gracis por usar mi APP***");
    }

   
    
}
