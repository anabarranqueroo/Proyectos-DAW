import java.util.Scanner;

public class Ejercicio8{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

        int[]temp=new int [12];
        String[]mes= new String[12];
        
        mes[0]="Enero"; mes[1]="Febrero"; mes[2]="Marzo";mes[3]="Abril"; mes[4]="Mayo";
        mes[5]="Junio"; mes[6]="Julio"; mes[7]="Agosto"; mes[8]="Septiembre"; mes[9]="Octubre";
        mes[10]="Noviembre"; mes[11]="Diciembre";

        for (int i = 0; i < 12; i++) {
            System.out.println("Dime la temperatura media de "+mes[i]);
            temp[i]=s.nextInt();
        }
        
        for (int i = 0; i < 12; i++) {
            System.out.println();
            for (int j = 0; j < temp[i]; j++) {
                System.out.print("*");
            }
            
        }

    }
}