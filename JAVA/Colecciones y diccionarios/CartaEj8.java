package ejercicios;

public class CartaEj8 implements Comparable<CartaEj8> {
    private static String palos[] = {"espadas", "bastos", "oros", "copas"};
    private static String numeros[] = {"as", "dos", "tres", "cuatro", "cinco", "seis", "siete", "sota", "caballo", "rey"};
    private String palo;
    private String numero;

    public CartaEj8() {
        this.palo = palos[(int) (Math.random() * 4)];
        this.numero = numeros[(int) (Math.random() * 10)];
    }
    public String getPalo() {
        return palo;
    }

    public String getNumero() {
        return numero;
    }

    public int compareTo(CartaEj8 carta2) {
        int result = (this.palo).compareTo(carta2.getPalo());
        if (result == 0) {
            return (this.numero).compareTo(carta2.getNumero());
        }
        return result;
    }
    public String toString() {
        return numero + " de " + palo;
    }
}
