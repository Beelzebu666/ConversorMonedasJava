package principal;

import java.io.IOException;

import conversorMonedas.MenuConversor;

public class Principal {
 public static void main(String[] args)  {
	 try {
		MenuConversor.main(args);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
}
