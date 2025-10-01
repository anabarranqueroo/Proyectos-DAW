import java.util.Scanner;

public class ejercicio1 {
public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    int suma=0;
    
    System.out.println("Tirada de 3 dados\n");

    int d1=(int)(Math.random()*6)+1;
    int d2=(int)(Math.random()*6)+1;
    int d3=(int)(Math.random()*6)+1;

    suma= d1+d2+d3;

    System.out.println("Dado 1: "+d1);
    System.out.println("Dado 2: "+d3);
    System.out.println("Dado 3: "+d2);
    System.out.println("Suma: "+suma);
    }
    }

