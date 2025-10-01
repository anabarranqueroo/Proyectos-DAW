import java.util.Scanner;
public class Ejercicio19{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        int[]num=new int[12];
        int numin;
        int pos;

        System.out.println("Array original: ");
        System.out.print("Indice\t");

        for (int i = 0; i < 12; i++) {
            System.out.print(" \t"+i);
        }

        System.out.println();
        
        System.out.print("Valor\t");

        for (int i = 0; i < 12; i++) {
            num[i]=(int)(Math.random()*201);
            System.out.print(" \t"+num[i]);
        }

        System.out.println();

        System.out.println("Introduce el numero que quiere insertar: ");
        numin=s.nextInt();

        System.out.println("Introduce la posicion donde lo quieres insertar (0-11): ");
        pos=s.nextInt();

        System.out.println("Array resultado:");
        System.out.print("Indice\t");

        for (int i = 0; i < 12; i++) {
            System.out.print(" \t"+i);
        }

        System.out.println();
        
        System.out.print("Valor\t");

        for (int i = 11; i > pos; i--) {
            num[i]=num[i-1];  
        }
         num[pos]=numin;
         for (int i = 0; i < 12; i++) {
             System.out.print(" \t"+num[i]);
         }
         
            
    }
}