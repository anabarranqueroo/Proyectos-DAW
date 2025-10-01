import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);

       
        int n = 10;  
        int min = 1;  
        int max = 100; 

        
        int[] array = matematicas.funciones2.generaArrayInt(n, min, max);

        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println(" ");
        int minimo = matematicas.funciones2.minimoArrayInt(array);

        System.out.println("El valor minimo del array es: " + minimo);

        System.out.println(" ");
        int maximo = matematicas.funciones2.maximoArrayInt(array);

        System.out.println("El valor maximo del array es: " + maximo);

        System.out.println(" ");
        double media = matematicas.funciones2.mediaArrayInt(array);

        System.out.println("La media del array es: " + media);

        int num = 28;
        boolean encontrado = matematicas.funciones2.estaEnArrayInt(array, num);
        if (encontrado) {
            System.out.println("El número " + num + " está en el array.");
        } else {
            System.out.println("El número " + num + " no está en el array.");
        }

        int numero = 23;

        System.out.println("El numero "+numero+ " esta en la posicion: "+matematicas.funciones2.posicionEnArray(array, num));

        System.out.println("El array volteado es: "+matematicas.funciones2.volteaArrayInt(array));

        
    }


        

    }
