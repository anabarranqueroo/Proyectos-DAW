import java.util.Scanner;

public class ejercicio18 {
public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Introduce un numero");
    int num1=s.nextInt();
    System.out.println("Introduce otro numero");
    int num2=s.nextInt();

    int menor;
    int mayor;

    if (num1==num2) {
        System.out.println("Error, debes introducir dos numeros distintos.");
    } 

    if (num1<num2){
        menor=num1;
        mayor=num2;
    }else{
        menor=num2;
        mayor=num1;
    }
    for (int i = menor; i <= mayor; i+=7) {
        System.out.println(i);
    }
    }
}
