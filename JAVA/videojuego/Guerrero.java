public class Guerrero extends Personaje implements Ataque{
    private int daño;
    public Guerrero() {
        super();
        this.daño = 0;
    }
    @Override
    public void atacar(){
        this.daño = this.getFuerza() * this.getNivel() ;
    }
}
