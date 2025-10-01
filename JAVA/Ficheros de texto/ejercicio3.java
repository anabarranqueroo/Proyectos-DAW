package Ejercicios;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class ejercicio3 {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Uso del programa: ejercicio3 FICHERO1 FICHERO2 RESULTADO");
            System.exit(-1);
        }
        try {
            BufferedReader br1 = new BufferedReader(new FileReader("Ejercicios/fichero1.txt"));
            BufferedReader br2 = new BufferedReader(new FileReader("Ejercicios/fichero2.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("Ejercicios/resultado.txt"));
            String linea1 = "";
            String linea2 = "";
            while ( (linea1 != null) || (linea2 != null) ) {
                linea1 = br1.readLine();
                linea2 = br2.readLine();
                if (linea1 != null) {
                    bw.write(linea1 + " \n");
                }
                if (linea2 != null) {
                    bw.write(linea2 + "\n");
                }
            }
            br1.close();
            br2.close();
            bw.close();
            System.out.println("Archivo resultado.txt creado satisfactoriamente.");
        } catch (IOException ioe) {
            System.out.println("Se ha producido un error de lectura/escritura");
            System.err.println(ioe.getMessage());
        }
    }
}
