package matematicas;

public class funciones {
    /**
     * Le da la vuelta a un número.
     * @param x un número entero
     * @return el número a la inversa
     */
    public static int voltea(int x){
        int ultimo=0;
        int inverso = 0;
        while (x>0) { 
            ultimo = x % 10;
            inverso = (inverso * 10) + ultimo;
            x /= 10;
        }
        return inverso;
    }
    /**
     * Devuelve verdadero si el número que se pasa como parámetro
     * es capicúa y falso en caso contrario
     * @param x un número entero
     * @return si el número es capicua o no
     */
    public static boolean esCapicua(int x){
        return funciones.voltea(x) == x;
    }
    /**
     * Devuelve verdadero si el número que se pasa como parámetro
     * es primo y falso en caso contrario.
     * @param x un número entero
     * @return si el número es primo o no
     */
    public static boolean esPrimo(int x){
        return x/2!=0;
    }

    /**
     * Devuelve el menor primo que es mayor al número que
     * se pasa como parámetro.
     * @param x un numero entero
     * @return el siguiente primo del número introducido.
     */
    public static int siguientePrimo(int x){
        int siguiente = x +1;
        while (!esPrimo(siguiente)) { 
            siguiente ++;
        }
        return siguiente; 
    }

    /**
     * Dada una base y un exponente devuelve la potencia.
     * @param x un numero entero como base
     * @param e un nunmero entero como exponente
     * @return la potencia de un numero
     */
    public static int potencia(int x, int e){
        int potencia = 0;
        int exponente = 0;
        int base = 0;

        for (int i = 0; i < exponente; i++) {
            potencia = base * base;
        }
        return potencia;
    }

    /**
     * Cuenta el número de dígitos de un número entero.
     * @param x un numero entero
     * @return el numero de digitos del numero añadido
     */
    public static int digitos(int x){
        int contador = 0;
        while (x > 0) { 
            x /= 10;
            contador ++;
        }
        return contador; 
    }

    /**
     * Devuelve el dígito que está en la posición n de un número entero.
     * Se empieza contando por el 0 y de izquierda a derecha.
     * @param x un numero entero
     * @param n un nunmero entero como posicion
     * @return el digito de la posicion introducida.
     */
    public static int digitoN(int x, int n){
        int res = 0;
        
        x = voltea(x);
        for (int i = 0; i <= n; i++) {
            res = x%10;
            x /= 10;
        }
        return res;
    }

    /**
     * Da la posición de la primera ocurrencia de un dígito
     * dentro de un número entero. Si no se encuentra, devuelve -1
     * @param x numero entero
     * @param d numero que se busca
     * @return posicion de la primera ocurrencia del numero.
     */
    public static int posicionDeDigito(int x, int d){
        String xStr = Integer.toString(Math.abs(x));
        String dStr = Integer.toString (d);

        int posicion = xStr.indexOf(dStr);

        if (posicion == -1) {
            return -1;
        } else {
            return posicion;
        }
    }

    /**
     * Le quita a un número n dígitos por detrás (por la derecha).
     * @param n numero entero
     * @param d numero de digios que se van a quitar
     * @return numero sin los digitosw por detrás.
     */
    public static int quitaPorDetras(int n, int d){
        return n / (int) Math.pow(10, d);
    }

    /**
     *  Le quita a un número n dígitos por delante (por la izquierda).
     * @param n numero entero
     * @param d digitos que se quitan por delante
     * @return numero sin digitos anteriores por delante. 
     */
    public static int quitaPorDelante(int n, int d){
        n = voltea (n); 
        int potencia= n / (int) Math.pow(10, d);
        int res = voltea (potencia);
        return res;
    }

    /**
     * Añade un dígito a un número por detrás.
     * @param n numero entero
     * @param a digito que se quiere añadir.
     * @return numero entero con el digito añadido.
     */
    public static int pegaPorDetras (int n, int a){
        int res = n *10 + a;
        return res;
    }

    /**
     * Añade un dígito a un número por delante.
     * @param n numero entero
     * @param a digito que se añade por delante
     * @return numero entero con el digito añadido por delante.
     */
    public static int pegaPorDelante (int n, int a){
        n = voltea(n);
        int res = n*10 + a;
        int res2 = voltea(res);
        return res2;
    }

    /**
     * Toma como parámetros las posiciones inicial y final 
     * dentro de un número y devuelve el trozo correspondiente.
     * @param n numero entero
     * @param in nuhmero entero posicion inicial
     * @param f numero entero posicion final
     * @return trozo de numero incluida la posicion inicial y final indicadas.
     */
    public static int trozoDeNumero (int n, int in, int f){
        String strNum = Integer.toString(n);
        if (in < 0 || f < in || f >= strNum.length()) {
            return -1;
        }
        String res = strNum.substring(in, f +1);
        return Integer.parseInt(res);
    }

    /**
     *  Pega dos números para formar uno.
     * @param n1 numero entero
     * @param n2 otro numero entero
     * @return numero final con el numero primero juntado con el segundo.
     */
    public static int juntaNumeros (int n1, int n2){
        String PrimerNumero = Integer.toString(n1);
        String SegundoNumero = Integer.toString(n2);
        String res = PrimerNumero + SegundoNumero;
        return Integer.parseInt(res);
    
    
    }


}

