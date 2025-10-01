public abstract class Vehiculo{
    private static int vehiculosCreados = 0;
    private static int kilometrosTotales = 0;

    static int kilometrosRecorridos = 0;

    public Vehiculo(){
        this.kilometrosRecorridos=0;
    }

    public static int getkilometrosTotales(){
        return Vehiculo.kilometrosTotales;
    }

    public void recorre(int km){
        this.kilometrosRecorridos += km;
        Vehiculo.kilometrosTotales += km;
    }

    public int getkilometrosRecorridos(){
        return this.kilometrosRecorridos;
    }
}