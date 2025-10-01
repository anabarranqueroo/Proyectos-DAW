public class Arquero extends Personaje implements Ataque{
    private int daño;
    public Arquero() {
        super();
        this.daño = 0;
    }
    @Override
    public void atacar() {
        this.daño = this.getDestreza() * this.getNivel();
    }
}
