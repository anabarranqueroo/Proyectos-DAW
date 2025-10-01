import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class ejemplo2 {
    public static void main(String[] args) {
        System.out.print("Introduzca el nombre del archivo donde se encuentran los números: ");
        String nombreFichero = System.console().readLine();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(nombreFichero));
            String linea = "0";
            int i = 0;
            double suma = 0;
            while (linea != null) {
                i++;
                suma += Double.parseDouble(linea);
                linea = br.readLine();
            }
            i--;
            br.close();
            System.out.println("La media es " + suma / (double)i);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}


