import java.util.Scanner;
public class ejercicio8{
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.println("Dime tu primera nota ");
    double n1 = s.nextDouble(); 

    System.out.println("Dime tu segunda nota ");
    double n2 = s.nextDouble(); 

    System.out.println("Dime tu tercera nota ");
    double n3 = s.nextDouble(); 

    double media=(n1+n2+n3)/3;

    System.out.printf("La media de las tres notas es: %.2f", media);

        if (media<5) {
            System.out.println(" TIENE UN INSUFICIENTE");
        
            } else if (media==5){
            System.out.println(" TIENE UN SUFICIENTE");

            } else if (media==6){
            System.out.println(" TIENE UN BIEN");

            } else if (media>=7 && media<=8){
            System.out.println(" TIENE UN NOTABLE");
            
            }else {
             System.out.println(" TIENE UN SOBRESALIENTE");
         }
    }
}