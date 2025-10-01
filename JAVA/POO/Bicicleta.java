public class Bicicleta extends Vehiculo{
    public Bicicleta(){
        super();
    }
    public void recorrer(int km){
        super.recorre(km);
        System.out.println("La bicicleta ha recorrido " + km + " kms");
    }

    public void hacerCaballito(){
        System.out.println("Toma caballito con la bici!!");
    }
}