import java.util.Scanner;
public class ejercicio16{
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int puntos=0;

    System.out.println("Este es un programa para ver la probabilidad de que nuestra pareja nos sea infiel.");
    System.out.println("Contesta estas preguntas con V (Verdadero) o F (Falso)");

    System.out.println("1.Tu pareja parece estar más inquieta de lo normal sin ningún motivo aparente.");
    String r = System.console().readLine();

    System.out.println("2. Ha aumentado sus gastos de vestuario");
    String r2 = System.console().readLine();

    System.out.println("3. Ha perdido el interés que mostraba anteriormente por ti");
    String r3 = System.console().readLine();

    System.out.println("4. Ahora se afeita y se asea con más frecuencia (si es hombre) o ahora se arregla el pelo y se asea con más frecuencia (si es mujer)");
    String r4 = System.console().readLine();

    System.out.println("5. No te deja que mires la agenda de su teléfono móvil");
    String r5 = System.console().readLine();

    System.out.println("6. A veces tiene llamadas que dice no querer contestar cuando estás tú delante");
    String r6 = System.console().readLine();

    System.out.println("7. Últimamente se preocupa más en cuidar la línea y/o estar bronceado/a");
    String r7 = System.console().readLine();

    System.out.println("8. Muchos días viene tarde después de trabajar porque dice tener mucho más trabajo");
    String r8 = System.console().readLine();

    System.out.println("9. Has notado que últimamente se perfuma más");
    String r9 = System.console().readLine();

    System.out.println("10. Se confunde y te dice que ha estado en sitios donde no ha ido contigo");
    String r10 = System.console().readLine();

    if (r.equals("V")) {
        puntos = puntos+3;
    } else {
        puntos = puntos;
    }

    if (r2.equals("V")) {
        puntos = puntos+3;
    } else {
        puntos = puntos;
    }

    if (r3.equals("V")) {
        puntos = puntos+3;
    } else {
        puntos = puntos;
    }

    if (r4.equals("V")) {
        puntos = puntos+3;
    } else {
        puntos = puntos;
    }

    if (r5.equals("V")) {
        puntos = puntos+3;
    } else {
        puntos = puntos;
    }

    if (r6.equals("V")) {
        puntos = puntos+3;
    } else {
        puntos = puntos;
    }

    if (r7.equals("V")) {
        puntos = puntos+3;
    } else {
        puntos = puntos;
    }

    if (r8.equals("V")) {
        puntos = puntos+3;
    } else {
        puntos = puntos;
    }

    if (r9.equals("V")) {
        puntos = puntos+3;
    } else {
        puntos = puntos;
    }

    if (r10.equals("V")) {
        puntos = puntos+3;
    } else {
        puntos = puntos;
    }

    if (puntos>=0 && puntos<=10) {
        System.out.println(" ¡Enhorabuena! tu pareja parece ser totalmente fiel.");
    } else if (puntos>=11 && puntos<=22) {
        System.out.println("Quizás exista el peligro de otra persona en su vida o en su mente, aunque seguramente será algo sin importancia. No bajes la guardia. ");  
    } else if (puntos>=23 && puntos <=30) {
        System.out.println("Tu pareja tiene todos los ingredientes para estar viviendo un romance con otra persona. Te aconsejamos que indagues un poco más y averigües que es lo que está pasando por su cabeza.");
    }

    System.out.println("Tienes "+puntos+" puntos de 30.");

    }
} 