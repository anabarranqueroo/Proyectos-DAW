import java.util.Scanner;

public class ejercicio20 {
public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    System.out.println("Introduce la altura");
    int alt=s.nextInt();
    System.out.println("Introduce el caracter para hacer la piramide");
    char carac=s.next().charAt(0);

    for (int i=1; i<=alt; i++) {
        for (int j=alt; j>i; j--) {
            System.out.print(" ");
        }
        for(int k=1; k<=(2*i-1);k++){
            if(k==1 || k==(2*i-1) || i==alt){
             System.out.print(carac);
            }else{
                System.out.print(" ");
            }
           
        }
       System.out.println();
    }

    
    }
}