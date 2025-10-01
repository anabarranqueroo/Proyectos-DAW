public class Objeto {
    private String nombre;
    private String tipo;
    private int daño;

    public Objeto(String nombre, String tipo, int daño) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.daño = daño;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getDaño(){
        return daño;
    }
    public void setDaño(int daño){
        this.daño = daño;
    }

    public String toString(String objeto) {
        for (int i = 0; i < 3; i++) {
            objeto= "Nombre del objeto: " + this.nombre + "Tipo: " + this.tipo + "Daño: " +  this.daño;
        }
        return objeto;
    }

}
