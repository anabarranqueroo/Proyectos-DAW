import java.util.Scanner;

public class ejercicio5 {
public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    int max=0;
    int min=200;
    int suma=0;
    for (int i = 0; i < 50; i++) {
        int num=((int)(Math.random()*100)+100);
        System.out.print(num +" ");
        if (num>max) {
            max = num;
        }
        if(num<min){
            min = num;
        }
        suma = suma + num;
    }
    System.out.println(" ");
    System.out.println("La media es: "+suma/50);
    System.out.println("El maximo es: "+max);
    System.out.println("El minimo es: "+min);
   
}
}