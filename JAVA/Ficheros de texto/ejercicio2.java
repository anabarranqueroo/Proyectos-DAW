package Ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ejercicio2 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("Ejercicios/primos.dat"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException ioe) {
            System.out.println("No se ha podido leer el fichero.");
        }
    }
}

