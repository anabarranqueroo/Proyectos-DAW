public class bici extends Vehiculo{
    public bici(){
        super();
    }
    public void recorrer(int km){
        super.andar(km);
        System.out.println("Cuantos kilomtros has andado con el coche");
    }

    public void hacerCaballito(){
        System.out.println("Has hecho el caballito con la bici");
    }
}