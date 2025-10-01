public class Mago extends Personaje implements Ataque{
    private int daño;
    public Mago() {
        super();
        this.daño = 0;
    }
    @Override
    public void atacar() {
        this.daño = this.getInteligencia() * this.getNivel();
    }
}
