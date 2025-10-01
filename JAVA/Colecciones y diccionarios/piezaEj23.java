package ejercicios;

public class piezaEj23 {
    private String nombre;
    private int valor;
    private int cantidad;

    public piezaEj23(String nombre, int valor, int cantidad) {
        this.nombre = nombre;
        this.valor = valor;
        this.cantidad = cantidad;
    }
    public boolean seCaptura(){
        return this.cantidad > 0;
    }
    public void capturar(){
        this.cantidad--;
    }
    @Override
    public String toString() {
        return nombre + " (" + valor + (valor == 1 ? " peon)" : " peones)");
    }
    public int getValor(){
        return valor;
    }
}
