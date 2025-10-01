import java.util.Scanner;

public class ejercicio4 {
public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    for (int i = 1; i < 21; i++) {
        System.out.print(((int)(Math.random()*10)+1)+" ");
    }

}
}