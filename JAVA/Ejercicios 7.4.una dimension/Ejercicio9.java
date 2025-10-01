import java.util.Scanner;
public class Ejercicio9{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        int[]num=new int [8];

        for (int i = 0; i < 8; i++) {
            System.out.println("Introduce un numero");
            num[i]=s.nextInt();  
        }
        for (int i = 0; i < 8; i++) {
            if (num[i]%2==0) {
                System.out.println(num[i]+" Par");
            } else {
                System.out.println(num[i]+" Impar");
            }
        }
    }
}