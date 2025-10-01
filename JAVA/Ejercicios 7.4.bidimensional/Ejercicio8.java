import java.util.Scanner;
public class Ejercicio8 {
public static void main(String[] args) {
    Scanner s=new Scanner(System.in);

    String[][]tablero=new String[8][8];

    String ilet="";
    String jlet="";

    System.out.print("Introduce la posición del alfil (Eje X, nº0-7): ");
        int posX = s.nextInt()-1;
    System.out.print("Introduce la posición del alfil (Eje Y, nº0-7): ");
        int posY = s.nextInt()-1;
    System.out.println();

    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if((String.valueOf(i).equals(String.valueOf(posX)) && String.valueOf(j).equals(String.valueOf(posY)))){
                    tablero[i][j] = "O";    
                } else{
                    tablero[i][j] = "_";
                    
                }
                System.out.printf("%s ", tablero[i][j]);
            }
            System.out.println();
        }
    System.out.println("\nPosibles movimientos del alfil: ");

    for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(Math.abs(posX-i) == Math.abs(posY-j)){
                    switch(i){
                        case 0:
                        ilet = "a";
                        break;
                        case 1:
                        ilet = "b";
                        break;
                        case 2:
                        ilet = "c";
                        break;
                        case 3:
                        ilet = "d";
                        break;
                        case 4:
                        ilet = "e";
                        break;
                        case 5:
                        ilet = "f";
                        break;
                        case 6:
                        ilet = "g";
                        break;
                        case 7:
                        ilet = "h";
                        break;
                    }
                    switch(j){
                        case 0:
                        jlet = "8";
                        break;
                        case 1:
                        jlet = "7";
                        break;
                        case 2:
                        jlet = "6";
                        break;
                        case 3:
                        jlet = "5";
                        break;
                        case 4:
                        jlet = "4";
                        break;
                        case 5:
                        jlet = "3";
                        break;
                        case 6:
                        jlet = "2";
                        break;
                        case 7:
                        jlet = "1";
                        break;
                    }
                    System.out.printf("Posición: (%s, %s)\n", ilet, jlet);
                }
            }
        }




        }
        
    }


