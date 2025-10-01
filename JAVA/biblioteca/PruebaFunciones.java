
 import java.util.Scanner;
public class PruebaFunciones {
public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    int n;

 // Prueba esPrimo()
    System.out.print("Introduzca un número entero positivo: ");
        n = Integer.parseInt(System.console().readLine());

    if (matematicas.varias.esPrimo(n)) {
        System.out.println("El " + n + " es primo.");
    } else {
        System.out.println("El " + n + " no es primo.");
    }

 // Prueba digitos()
    System.out.print("Introduzca un número entero positivo: ");
        n = Integer.parseInt(System.console().readLine());
    System.out.println(n + " tiene " + matematicas.varias.digitos(n) + " dígitos.");

 // Prueba volumenCilindro()
    double r, h;
    System.out.println("Cálculo del volumen de un cilindro");
    System.out.print("Introduzca el radio en metros: ");
        r = Double.parseDouble(System.console().readLine());
    System.out.print("Introduzca la altura en metros: ");
        h = Double.parseDouble(System.console().readLine());
    System.out.println("El volumen del cilindro es " + matematicas.Geometria.volumenCilindro(r, h) + " m3");
    
//Prueba esCapicua()
    System.out.println("Introduce un numero: ");
    n = Integer.parseInt(System.console().readLine());

    if (matematicas.varias.esCapicua(n)) {
        System.out.println("Es capicua");
    } else {
        System.out.println("No es capicua");
    }
//Prueba potencia()
    System.out.print("Introduzca el exponente: ");
        int e = Integer.parseInt(System.console().readLine());
    System.out.print("Introduzca la base: ");
        double b = Double.parseDouble(System.console().readLine());
    System.out.println("EL resultado es: "+matematicas.varias.potencia(b,e));

//Prueba siguientePrimo()
    System.out.println("Introduce un numero: ");
     n = Integer.parseInt(System.console().readLine());

    if (matematicas.varias.esPrimo(n)) {
        System.out.println("El " + n + " es primo.");
    } else {
        System.out.println("El " + n + " no es primo.");
    }
    System.out.println("EL siguiente primo es: "+matematicas.varias.siguientePrimo(n));
    
//Prueba voltea()
    System.out.println("Introduce un numero: ");
    n = Integer.parseInt(System.console().readLine());
    System.out.println("El numero es: "+matematicas.varias.voltea(n));

//Prueba digitoN()
    System.out.println("Introduce un numero: ");
    n = s.nextInt();
    System.out.println("Introduce la posicion: ");
    int p = s.nextInt();
    System.out.println("El numero es: "+matematicas.varias.digitoN(n, p));
    
//Prueba posicionDeDigito()
    System.out.println("Introduce un numero: ");
    n = s.nextInt();
    System.out.println("Introduce la posicion: ");
    p = s.nextInt();
    System.out.println("El numero es: "+matematicas.varias.posicionDeDigito(n, p));
    
//Prueba quitaPorDetras()
     System.out.println("Introduce un numero: ");
    n = s.nextInt();
    System.out.println("Introduce el numero de digitos que quieres quitar: ");
    p = s.nextInt();
    System.out.println("El numero es: "+matematicas.varias.quitaPorDetras(n, p));

    
//Prueba quitaPorDelante()
     System.out.println("Introduce un numero: ");
    n = s.nextInt();
    System.out.println("Introduce el numero de digitos que quieres quitar: ");
    p = s.nextInt();
    System.out.println("El numero es: "+matematicas.varias.quitaPorDelante(n, p));
    }
 }
  