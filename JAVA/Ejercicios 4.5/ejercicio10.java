import java.util.Scanner;
public class ejercicio10{
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    System.out.println("¿En que dia has nacido?");
    int dia = s.nextInt();

    System.out.println("¿En que mes has nacido?");
    String mes = System.console().readLine();
    

    if (dia>=21 && mes.equals("Marzo")) {
        System.out.println("Eres Aries");

    }else if (dia<=19 && mes.equals("Abril")) {
        System.out.println("Eres Aries");

    }else if (dia>=20 && mes.equals("Abril")) {
        System.out.println("Eres Tauro");

    }else if (dia<=20 && mes.equals("Mayo")) {
        System.out.println("Eres Tauro");

    }else if (dia>=21 && mes.equals("Mayo")) {
        System.out.println("Eres Geminis");

    }else if (dia<=20 && mes.equals("Junio")) {
        System.out.println("Eres Geminis");

    }else if (dia>=21 && mes.equals("Junio")) {
        System.out.println("Eres Cancer");

    }else if (dia<=22 && mes.equals("Julio")) {
        System.out.println("Eres Cancer");

    }else if (dia>=23 && mes.equals("Julio")) {
        System.out.println("Eres Leo");

    }else if (dia<=22 && mes.equals("Agosto")) {
        System.out.println("Eres Leo");

    }else if (dia>=23 && mes.equals("Agosto")) {
        System.out.println("Eres Virgo");

    }else if (dia<=22 && mes.equals("Septiembre")) {
        System.out.println("Eres Virgo");

    }else if (dia>=23 && mes.equals("Septiembre")) {
        System.out.println("Eres Libra");

    }else if (dia<=22 && mes.equals("Octubre")) {
        System.out.println("Eres Libra");
 
    }else if (dia>=23 && mes.equals("Octubre")) {
        System.out.println("Eres Escorpio");

    }else if (dia<=21 && mes.equals("Noviembre")) {
        System.out.println("Eres Escorpio");

    }else if (dia>=22 && mes.equals("Noviembre")) {
        System.out.println("Eres Sagitario");

    }else if (dia<=21 && mes.equals("Diciembre")) {
        System.out.println("Eres Sagitario");

    }else if (dia>=22 && mes.equals("Diciembre")) {
        System.out.println("Eres Capricornio");

    }else if (dia<=19 && mes.equals("Enero")) {
        System.out.println("Eres Capricornio");

    }else if (dia>=20 && mes.equals("Enero")) {
        System.out.println("Eres Acuario");

    }else if (dia<=18 && mes.equals("Febrero")) {
        System.out.println("Eres Acuario");

    }else if (dia>=19 && mes.equals("Febrero")) {
        System.out.println("Eres Piscis");

    }else if (dia<=20 && mes.equals("Marzo")) {
        System.out.println("Eres Piscis");

    } else {
        System.out.println("Error");
    }

    }
}