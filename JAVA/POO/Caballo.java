public class Caballo{
    String color;
    int edad;
    Caballo (String c, int n){
        this.color = c;
        this.edad = n;
    }
    String getColor(){
        return this.color;
    }
    int getEdad(){
        return this.edad;
    }
    void trotar(){
        System.out.println("popopopo");
    }
    void come(String comida){
        if (comida.equals("pasto")) {
            System.out.println("¡Que rico!");
        } else {
            System.out.println("mmm no me gusta");
        }
    }

}


