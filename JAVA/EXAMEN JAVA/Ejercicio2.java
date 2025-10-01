import java.util. Scanner;
public class Ejercicio2{
    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);

        int[]array=new int[30];
        int[]par=new int[30];
        int[]impar=new int[30];
        int pares=0;
        int impares=0;
        int i=0;
        
        System.out.println("Array original: ");
        for (i = 0; i < 30; i++) {
            array[i]=((int)(Math.random()*91)+10);
            System.out.print("   "+array[i]);
        }
        System.out.println();
        for (i = 0; i < 30; i++) {
            if (array[i]%2==0) {
                par[pares++]=array[i];
            }else{
                impar[impares++]=array[i];
            }
            
        }

        System.out.println();

        System.out.println("Array con pares al principio: ");

        for (i = 0; i < 30; i++) {
            System.out.print("    "+par[i]);
        }
        for (i = par[i+1]; i < 30; i++) {
            System.out.print("    "+par[i]+impar[i]);
        }
        }
    }
