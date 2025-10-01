import java.util.Scanner;
public class ejercicio2{
 public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.println("Introduce una hora (24h)");
    int hora = Integer.parseInt(s.nextLine());
   
    if (hora>=6 && hora<=12) {
            System.out.println("Buenos dias");
        
        } else if (hora>=13 && hora<=20){
            System.out.println("Buenas tardes");

        } else if (hora>=21 && hora<=23){
            System.out.println("Buenas noches");

        } else if (hora>=0 && hora<=5){
            System.out.println("Buenas noches");
            
        }else {
             System.out.println("No existe esa hora");
        }
    
     }
 }