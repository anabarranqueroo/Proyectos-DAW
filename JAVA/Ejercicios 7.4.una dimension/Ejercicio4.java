import java.util.Scanner;

public class Ejercicio4 {
public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

     int[]num = new int[20];
     int[]cuadrado= new int[20];
     int[]cubo= new int[20];

    System.out.printf("%-7s%6s%5s\n", "NUMERO", "CUADRADO", "CUBO");

    for (int i = 0; i < 20; i++) {
        num[i]=(int)(Math.random()*101);
        cuadrado[i]=(num[i]*num[i]);
        cubo[i]=(num[i]*num[i]*num[i]);
        //System.out.println("NUMERO = " + num[i]+ "\nCuadrado = " +cuadrado[i]+ "\nCubo = " +cubo[i]);
        System.out.printf("%5d%6d%8d\n", num[i], cuadrado[i], cubo[i]);
        }
    }
}