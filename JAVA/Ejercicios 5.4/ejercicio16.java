import java.util.Scanner;

public class ejercicio16 {
public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Introduce un numero");
    int num=s.nextInt();

    if (num<=1) {
        System.out.println("No es primo");
    }else{
        int div=0;
        for (int i=2; i<=Math.sqrt(num);i++) {
            if(num%i==0){
                div=i;
            }
        }
    if (div==0) {
        System.out.println("Es primo.");
    } else {
        System.out.println("No es primo.");
    }
    }
}
}
