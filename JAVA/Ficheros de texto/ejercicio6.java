package Ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ejercicio6 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso : ejercicio6 fichero.txt palabra");
            System.exit(-1);
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));

            String linea="";
            int ocurrencia=0;
            int contador=0;
            String palabra= args[1];

            while ((linea= br.readLine()) !=null) {
                if((ocurrencia = linea.indexOf(palabra))!= -1){
                    linea=linea.substring(ocurrencia + palabra.length(), linea.length());
                    contador++;
                }
            }
            br.close();
            System.out.println("Ocurrencias de esa palabra: "+contador);

        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
}
