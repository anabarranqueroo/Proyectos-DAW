package ejercicios;

public class ElementoEj17 {
    private String nombreproducto;
    private double precio;
    private int cantidad;

    public ElementoEj17(String producto, double precio, int cantidad) {
        this.nombreproducto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    public String getNombreproducto() {
        return nombreproducto;
    }
    public void setNombreproducto(String producto) {
        this.nombreproducto = producto;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    @Override
    public String toString() {
        return this.nombreproducto + " PVP:" + String.format("%.2f", this.precio)
                + " Unidades:" +  this.cantidad
                + " Subtotal:" + String.format("%.2f", this.cantidad * this.precio);
    }
}

