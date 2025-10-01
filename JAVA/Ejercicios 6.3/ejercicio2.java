import java.util.Scanner;

public class ejercicio2 {
public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    String carta = "";
    String palo = "";
    int ncarta=(int)(Math.random()*13) + 1;

    carta = switch (ncarta) {
        case 1 -> "a";
        case 11 -> "J";
        case 12 -> "Q";
        case 13 -> "K";
        default -> String.valueOf(ncarta);
    };

    int npalo = (int)(Math.random()*4) + 1;
    switch (npalo) {
        case 1:
            palo = "diamantes";
            break;
            case 2:
            palo = "picas";
            break;
            case 3:
            palo = "treboles";
            break;
            case 4:
            palo = "rombo";
            break;
        default:
    }
    System.out.println(carta + " " + palo);
    }
}