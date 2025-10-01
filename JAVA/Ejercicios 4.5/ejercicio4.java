import java.util.Scanner;
public class ejercicio4{
 public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.print("Introduce el número de horas trabajadas durante la semana: ");
    int horas = s.nextInt();
    int dinero, hora, resul;

     if (horas<=40) {
            dinero=horas*12; 
            System.out.println("Su sueldo semanal es: "+dinero +" euros");
    } else {
            hora=horas-40;
            resul=40*12;
            dinero=hora*16;
            dinero=dinero+resul;
            System.out.println("Su sueldo semanal es: "+dinero +" euros");   
        }
     }
 }