package Ejercicios;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class ejercicio1 {
    public static void main(String[] args) {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("primos.dat"));
            for (int i=2;i<500;i++){
                boolean primo=true;
                for (int j=2;j<=Math.sqrt(i);j++){
                    if (i%j==0){
                        primo=false;
                    }
                }
                if(primo){
                    bw.write(i+" \n");
                }
            }
            bw.close();

        }catch(IOException ioe){
            System.out.println("No se ha podido escribir en el fichero");
        }
    }
}