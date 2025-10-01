import java.util.Scanner;
public class ejercicio13{
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.println("Introduce un numero entero");
    int num1 = s.nextInt();

    System.out.println("Introduce otro numero entero");
    int num2 = s.nextInt();

    System.out.println("Introduce el ultimo numero entero");
    int num3 = s.nextInt();

    int mayor, medio, menor;

    if (num1>= num2 && num1>= num3) {
        mayor=num1;
        if (num2>=num3) {
            medio=num2;
            menor=num3;
        }
    } else if (num2>=num1 && num2>=num3){
        mayor=num2;
        if(num1>=num3){
            medio=num1;
            menor=num3;
        }else{
            mayor=num3;
            if (num1>=num2) {
                medio=num1;
                menor=num2;
            }else{
                medio=num2;
                menor=num1;
            }
        }

    System.out.println("El orden de los numeros son: " + menor +","+ medio +","+ mayor);

        }
    }
} 
