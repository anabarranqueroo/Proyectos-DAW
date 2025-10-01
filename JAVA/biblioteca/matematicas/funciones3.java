package matematicas;

public class funciones3{
    
    /**
     * Genera un array de tamaño n x m con números
     * aleatorios cuyo intervalo (mínimo y máximo)
     * se indica como parámetro.
     * @param n filas
     * @param m columnas
     * @param min numero aleatorio minimo
     * @param max numero aletorio maximo
     * @return array con numeros aleatorios de intervalo minimo y maximo.
     */
    public static int generaArrayBilnt(int n, int m, int min, int max){
        int array[][] = new int [n][m];

        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                array[i][j]=(int)(Math.random()*(max-min)+min);
                return array[i][j];
            }
        }
        return 0;
    }

    /**
     * Devuelve la fila i-ésima del array que se pasa como
        parámetro.
        @param array array de enteros
        @param filai fila i-ésima como parámetro.
        @return Fila introducida.
     */
    public static int[] filaDeArrayBlint(int array[][], int filai){
        int f[] = new int [array[0].length];

        for (int i = 0; i < array[0].length; i++) {
            f[i] = array[filai][i];
        }
        return f;
        
    }

    /**
     *  Devuelve la columna j-ésima del array que se
        pasa como parámetro.
        @param array array de numeros enteros.
        @param columnaj columna j-ésima como parametro
        @return columna introducida.
     */
    public static int[] columnaDeArrayBilnt(int array[][], int columnaj){
        int c[] = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            c[i] = array[i][columnaj];
        }
        return c;
    }
    
    /**
     * Devuelve la fila y la columna (en un array
        con dos elementos) de la primera ocurrencia de un número dentro de un
        array bidimensional. Si el número no se encuentra en el array, la función
        devuelve el array {-1, -1}.
     * @param array array de numeros enteros.
     * @param num numero que se desea buscar en el array.
     * @return devuelve la fila y la columna donde está el numero. 
     */
    public static int[] coordenadasEnArrayBilnt(int array[][], int num){
        for (int i = 0; i < array.length; i++){
             for (int j = 0; j < array[0].length; j++) {
                 if (array[i][j] == num) {
                     int[] coordenadas = {i, j};
                     return coordenadas;
                 }
             }   
        }
        int[]coordenadas = {-1, -1};
        return coordenadas;
        }

    /**
    * Dice si un número es o no punto de silla, es decir,
        mínimo en su fila y máximo en su columna.
        @param array array de numeros enteros
        @param i fila 
        @param j columna
        @return devuelve true o false.
    */
        public static boolean esPuntoDeSilla(int array[][], int i, int j){
            int[] fila = filaDeArrayBlint(array, i);
            int[] columna = columnaDeArrayBilnt(array, j);
            return ((funciones2.minimoArrayInt(fila) == array[i][j])) && ((funciones2.maximoArrayInt(columna) == array[i][j]));
        }

    /**
    * Devuelve un array que contiene una de las diagonales del array
    bidimensional que se pasa como parámetro. Se pasan como parámetros
    fila, columna y dirección. La fila y la columna determinan el número que
    marcará las dos posibles diagonales dentro del array. La dirección es
    una cadena de caracteres que puede ser “nose” o “neso”. La cadena
    “nose” indica que se elige la diagonal que va del noroeste hacia el sureste,
    mientras que la cadena “neso” indica que se elige la diagonal que va del
    noreste hacia el suroeste.
    @param array array de numeros enteros.
    @param fila fila
    @param columna columna
    @param direccion direccion de la diagonal.
    @return devuelve los numeros de la diagonal.
    */
        public static int[] diagonal(int array[][], int fila, int columna, String direccion){
            int elementos = 0, i, j;
            int []diagonalAux = new int [1000];

            for (i = 0; i < array.length; i++) {
                for (j = 0; j < array[0].length; j++) {
                    if ((((columna - j) == (fila - i)) && (direccion.equals("nose"))) 
                    || (((columna - j ) == (i - fila)) && (direccion.equals("neso")))) {
                        diagonalAux[elementos++] = array[i][j];
                    }
                }
            }
            int[] diagonal = new int[elementos];
            for (j = 0; j < elementos; j++) {
                diagonal[j] = diagonalAux[j];
            }
            return diagonal;
        }
    }

   



