public class Catalogo  {
    private String nombre;
    private int vida;
    private int fuerza;
    private int destreza;
    private int inteligencia;
    private int experiencia;
    private int nivel;
    private Objeto[] equipo;

    public Catalogo(Personaje personaje){
        this.nombre = personaje.getNombre();
        this.vida = personaje.getVida();
        this.fuerza = personaje.getFuerza();
        this.destreza = personaje.getDestreza();
        this.inteligencia = personaje.getInteligencia();
        this.experiencia = personaje.getExperiencia();
        this.nivel = personaje.getNivel();
        this.equipo = personaje.getEquipo();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public int getFuerza() {
        return fuerza;
    }
    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }
    public int getDestreza() {
        return destreza;
    }
    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }
    public int getInteligencia() {
        return inteligencia;
    }
    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }
    public int getExperiencia() {
        return experiencia;
    }
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public Objeto[] getEquipo() {
        return equipo;
    }
    public void setEquipo(Objeto[] equipo) {
        this.equipo = equipo;
    }
    @Override
    public String toString() {
        return "Personaje: " +
                "nombre='" + this.nombre + ", vida=" + this.vida + ", fuerza=" + this.fuerza + ", destreza=" + this.destreza + ", inteligencia=" + this.inteligencia + ", experiencia=" + this.experiencia + ", nivel=" + this.nivel;
    }
}
