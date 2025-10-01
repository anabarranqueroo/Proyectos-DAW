import java.util.Scanner;
public class Ejercicio16{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        int[]array=new int[20];

        for (int i = 0; i < 20; i++) {
            array[i]=(int)(Math.random()*401);
            System.out.print(" "+array[i]);
        }
        System.out.println();
        System.out.println("¿Que numeros quieres resaltar? (1-multiplos de 5, 2-multiplos de 7): ");
        int opcion=s.nextInt();
        for (int i = 0; i < 20; i++) {
        if (opcion==1) {
            if (array[i]%5==0) {
                System.out.print("[" +array[i]+"] ");
            }else if (array[i]==0) {
                System.out.print(array[i]+" ");
            }else {
                System.out.print(array[i]+" ");
            }
        } else {
            if (array[i]%7==0) {
                System.out.print("[" +array[i]+"] ");
                
            }else if (array[i]==0) {
                System.out.print(array[i]+" ");
            }else {
                System.out.print(array[i]+" ");
            }
        }
        }
        
    }
}