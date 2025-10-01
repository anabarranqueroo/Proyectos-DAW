import java.util.Scanner;

public class Ejercicio7{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        int[]alea=new int [100];

        for (int i = 0; i < 100; i++) {
            alea[i]=(int)(Math.random()*20);
            System.out.print(" "+alea[i]);
        }
        System.out.println("Escribe un numero de los que han salido anteriormente: ");
        int num=s.nextInt();
        System.out.println("Escribe el numero por el que lo quieres cambiar: ");
        int num2=s.nextInt();

        System.out.println("Numeros después de la sustitución: ");

        for (int i = 0; i < 100; i++) {
            if (alea[i]==num) {
                System.out.print("'"+num2+"'");
            }else{
            System.out.print(alea[i]+ " ");
            } 
            
        }

    }
}