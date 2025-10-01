package matematicas;

import java.lang.reflect.Array;

public class funciones2{
    
    /**
     *  Genera un array de tamaño n con números aleatorios
        cuyo intervalo (mínimo y máximo) se indica como parámetro.
        @param n entero que da el tamaño del array.
        @param min entero minimo aleatorio del array.
        @param max entero maximo aleatorio del array.
        @return deuelve el array aleatoriamente. 
     */
    public static int generaArrayInt(int n, int min, int max){
        
         int array[] = new int[n];

         for (int i = 0; i < n; i++) {
            array[i]=(int)(Math.random()*(max-min)+min);
            return array[i];
        }
        return 0;
    }

    /** 
     * Devuelve el mínimo del array que se pasa como pará
        metro.
        @param array array anterior
        @return devuelve el valor minimo del array.
    */
    public static int minimoArrayInt(int array[]){
        
         int min = Integer.MAX_VALUE;

         for (int i = 0; i < Array.getLength(array); i++) {
             if (array[i] < min) {
                 min = array[i];
             }
            
         }
     return min;    
    }

    /** 
     * Devuelve el maximo del array que se pasa como parámetro.
        @param array array anterior
        @return devuelve el valor maximo del array.
    */
    public static int maximoArrayInt(int array[]){
        
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < Array.getLength(array); i++){
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    /** 
     * Devuelve la media del array que se pasa como parámetro.
        @param array array anterior
        @return devuelve la media del array.
    */
    public static double mediaArrayInt(int array[]){

        int suma = 0;

        for (int i = 0; i < Array.getLength(array); i++) {
            suma += array[i];
        }
        double media = suma / array.length;
        return media;
    }

    /**
     *  Dice si un número está o no dentro de un array.
     * @param array array anterior.
     * @param num numero entero para ver si esta en el array.
     * @return te dice si  esta o no el numero en el array.
     */
    public static boolean estaEnArrayInt(int array[], int num){
        for (int i = 0; i < Array.getLength(array); i++) {
            if (array[i] == num) {
                return true;
            }  
            }
            return false;
        }

    /**
     *Busca un número en un array y devuelve la posición
    (el índice) en la que se encuentra.
    @param array array anterior.
    @param num numero entero que se introduce para buscar.
    @return posición en la que está el numero introducido.
     */
    public static int posicionEnArray(int array[], int num){
        for (int i = 0; i < Array.getLength(array); i++) {
            if (array[i] == num) {
                return i;
            }
        }
        return -1;
        }

    /**
    * Le da la vuelta a un array
    * @param array array anterior.
    * @return devuelve el array anterior al reves.
    */
    public static void volteaArrayInt(int array[]){
        int n[] = new int[Array.getLength(array)];
        int contador = Array.getLength(array)-1;

        for (int i=0; i<=Array.getLength(array)-1; i++) {
            n[i] = array[contador];
            System.out.println(n[i]);
            contador --;
        }   
    }

    /**
     * Rota n posiciones a la derecha los números de un
        array.
        @param array array anterior.
        @param n numero entero de posiciones a la derecha.
     */
    public static void rotaDerechaArrayInt(int array[], int n){
        int [] res = new int [array.length];
        for (int i = 0; i < n; i++) {
            res[i] = array[array.length - n + i];
        }
        for (int i = n; i < array.length; i++) {
            res[i] = array[i - n];
            System.out.println(res[i]);
        }
    }

    /**
     *  Rota n posiciones a la izquierda los números de
        un array.
     */
    public static void rotaIzquierdaArrayInt(int array[], int n){
        int [] res = new int [array.length];
        for (int i = 0; i < array.length - n; i++) {
            res[i] = array[i + n];
        }
        for (int i = 0; i < n; i++) {
            res[array.length - n + i] = array[i];
            System.out.println(res[i]);
        }
    }
}

    
    

