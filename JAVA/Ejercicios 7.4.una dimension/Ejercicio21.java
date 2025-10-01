import java.util.Scanner;
public class Ejercicio21{
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);

        int []array=new int[15];
      
        System.out.println("Array original: ");
        for (int i=0; i<15; i++) {
            array[i]=(int)(Math.random()*501);
            System.out.print(" "+array[i]);
        }
        System.out.println();
        System.out.println("Array circuerizado:");
        for (int i = 0; i < 15; i++) {
            while (array[i]%5!=0) { 
                array[i]++;
            }
        }
        for (int i = 0; i < 15; i++) {
            System.out.print(" "+array[i]);
        }
    }
}