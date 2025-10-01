import java.util.Scanner;

public class ejercicio3 {
public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    String carta = "";
    String palo = "";
    int ncarta=(int)(Math.random()*13) + 1;

    carta = switch (ncarta) {
        case 1 -> "as";
        case 11 -> "sota";
        case 12 -> "caballo";
        case 13 -> "rey";
        default -> String.valueOf(ncarta);
    };

    int npalo = (int)(Math.random()*4) + 1;
    switch (npalo) {
        case 1:
            palo = "oro";
            break;
            case 2:
            palo = "copa";
            break;
            case 3:
            palo = "espada";
            break;
            case 4:
            palo = "basto";
            break;
        default:
    }
    System.out.println(carta + " " + palo);
    }
}