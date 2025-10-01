import java.util.Scanner;
public class ejercicio8 {
    public static void main(String[] args) {
        Scanner s=new Scanner (System.in);

        System.out.println("¿Cuantas horas has trabajado el lunes?");
        int hl=s.nextInt();
       
        System.out.println("¿Cuantas horas has trabajado el martes? ");
        int hm=s.nextInt();
       
        System.out.println("¿Cuantas horas has trabajado el miercoles? ");
        int hmm=s.nextInt();

        System.out.println("¿Cuantas horas has trabajado el jueves? ");
        int hj=s.nextInt();

        System.out.println("¿Cuantas horas has trabajado el viernes? ");
        int hv=s.nextInt();

        int total=(hl+hm+hmm+hj+hv)*12;
        System.out.println("El salario semanal es: "+total);
    }}