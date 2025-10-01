import java.util.Scanner;
public class ejercicio11{
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.print("Introduce las horas (0-23)");
    int h = s.nextInt();
    System.out.print("Introduce los minutos (0-59)");
    int m = s.nextInt();

    if (h<0 || h>23 || m<0 || m>59){
        System.out.println("Formato no válido");
    }

    int seg= (23-h)*3600+(59-m)*60;
    
    System.out.println("Para medianoche faltan "+seg+" segundos.");

     }
}