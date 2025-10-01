import java.util.Scanner;

public class ejercicio28 {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    
    int jugada2; 
    System.out.print("Turno del jugador 1 (introduzca 1.piedra, 2.papel o 3.tijera): ");
    int jugada1 = s.nextInt();
    
    System.out.print("Turno del jugador 2 (ordenador): ");
    jugada2= (int)(Math.random()*3);
    System.out.println(jugada2);
    switch (jugada2) {
        case 0:
            System.out.println("Piedra");
            break;
        case 1:
          System.out.println("Papel");
          break;
        case 2:
          System.out.println("Tijera");
          break;  
        default:
        throw new AssertionError();
    }
    
    if (jugada1==jugada2) {
      System.out.println("Empate");
    } else {
      int ganador = 2;
      switch(jugada1) {
        case 1 -> {
            if (jugada2==2) {
                ganador = 1;
            } }
        case 2 -> {
            if (jugada2==2) {
                ganador = 1;
            } }
        case 3-> {
            if (jugada2==1) {
                ganador = 1;
            } }
        default -> {
            }
      }
      System.out.println("Gana el jugador " + ganador);
    }
  }
}
  