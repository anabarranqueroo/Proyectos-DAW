import java.util.Scanner;

public class ejercicio9 {
public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Introduce un numero");
    int num = s.nextInt();

    int c=1;
    while (num>10) { 
        num=num/10;
        c++; 
    }
    System.out.println("EL numero introducido tiene "+c +" digitos.");
   
    }
} 