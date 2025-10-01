package ejercicios;
import java.util.ArrayList;
public class CarritoEj17 {
    ArrayList<ElementoEj17> elementos = new ArrayList <ElementoEj17>();

    public void agrega(ElementoEj17 e){
        boolean existe = false;
        for (ElementoEj17 elemento : elementos) {
            if (elemento.getNombreproducto().equals(e.getNombreproducto())) {
                elemento.setCantidad(elemento.getCantidad() + e.getCantidad());
                existe = true;
            }
        }
            if (!existe){
                elementos.add(e);
            }
        }
    public int numeroDeElementos(){
        return elementos.size();
    }
    public double importeTotal(){
        double total = 0;
        for(ElementoEj17 e : elementos){
            total += e.getPrecio() * e.getCantidad();
        }
        return total;
    }
    @Override
    public String toString() {
        String res = "Contenido del carrito\n";
        for(ElementoEj17 e : elementos){
            res += e.toString() + "\n";
        }
        return res;
    }
}


