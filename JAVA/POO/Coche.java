public class Coche extends Vehiculo{
    public Coche(){
        super();
    }

    public void recorrer(int km){
        super.recorre(km);
        System.out.println("El coche ha recorrido " + km + " kms");
    }

    public void derraparCoche(){
        System.out.println("Brrrrr!!");
    }
}