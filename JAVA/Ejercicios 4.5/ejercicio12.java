import java.util.Scanner;
public class ejercicio12{
    public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int puntos=0;

    System.out.println("¿Se hacen examenes en sostenibilidad?");
    String r = System.console().readLine();
    if (r.equals("No")) {
        puntos++;
        System.out.println("Respuesta correcta");
    }else{
        System.out.println("Respuesta incorrecta");
    }

    System.out.println("¿Que tema estamos viendo en base de datos?");
    String r1 = System.console().readLine();
    if (r1.equals("Consultas SQL")) {
        puntos++;
        System.out.println("Respuesta correcta");
    }else{
        System.out.println("Respuesta incorrecta");
    }

    System.out.println("¿Que lenguaje estamos dando en programacion?");
    String r2 = System.console().readLine();
    if (r2.equals("Java")) {
        puntos++;
        System.out.println("Respuesta correcta");
    }else{
        System.out.println("Respuesta incorrecta");
    }

    System.out.println("¿Donde se encuentra el microprocesador de un ordenador?");
    String r3 = System.console().readLine();
    if (r3.equals("En la placa base")) {
        puntos++;
        System.out.println("Respuesta correcta");
    }else{
        System.out.println("Respuesta incorrecta");
    }

    System.out.println("¿Que hace la etiqueta <br> en html?");
    String r4 = System.console().readLine();
    if (r4.equals("Inserta un salto de línea")) {
        puntos++;
        System.out.println("Respuesta correcta");
    }else{
        System.out.println("Respuesta incorrecta");
    }

    System.out.println("¿Cuantos examenes hacemos en programacion al trimestre?");
    String r5 = System.console().readLine();
    if (r5.equals("Uno")) {
        puntos++;
        System.out.println("Respuesta correcta");
    }else{
        System.out.println("Respuesta incorrecta");
    }

    System.out.println("¿Con que lenguaje hacemos consultas en base de datos?");
    String r6 = System.console().readLine();
    if (r6.equals("SQL")) {
        puntos++;
        System.out.println("Respuesta correcta");
    }else{
        System.out.println("Respuesta incorrecta");
    }

    System.out.println("¿Como se llama la aplicación en la que escribimos html?");
    String r7 = System.console().readLine();
    if (r7.equals("Notepad++")) {
        puntos++;
        System.out.println("Respuesta correcta");
    }else{
        System.out.println("Respuesta incorrecta");
    }

    System.out.println("¿Que significa UC en sistemas informaticos?");
    String r8 = System.console().readLine();
    if (r8.equals("Unidad de Control")) {
        puntos++;
        System.out.println("Respuesta correcta");
    }else{
        System.out.println("Respuesta incorrecta");
    }

    System.out.println("¿Como nos evaluan en digitalizacion?");
    String r9 = System.console().readLine();
    if (r9.equals("Presentaciones y actividades")) {
        puntos++;
        System.out.println("Respuesta correcta");
    }else{
        System.out.println("Respuesta incorrecta");
    }

    System.out.println("Puntos obtenidos "+puntos+" / 10");
}

}
