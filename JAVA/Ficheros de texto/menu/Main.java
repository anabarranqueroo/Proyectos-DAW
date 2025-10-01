import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion=0;
        while(opcion!=7) {
            System.out.println("1. Crear un fichero de texto.");
            System.out.println("2. Mostrar por pantalla el fichero creado.");
            System.out.println("3. Buscar por ciudad de nacimiento.");
            System.out.println("4. Eliminar ficheros.");
            System.out.println("5. Ordenar contenido del fichero.");
            System.out.println("6. Añadir datos a un fichero existente.");
            System.out.println("7. Salir.");
            System.out.println("Seleccione una opcion (1-7): ");
            opcion=sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:

                    System.out.println("Introduce el nombre del fichero que quieres crear con .txt: ");
                    String nombref=sc.nextLine();

                    try(BufferedWriter bw = new BufferedWriter(new FileWriter(nombref))){
                        String nombre;
                        System.out.println("Escribe tu nombre: ");
                        nombre = sc.nextLine();
                        bw.write("Nombre: " + nombre + " \n");
                        String apellido;
                        System.out.println("Escribe tu apellido: ");
                        apellido = sc.nextLine();
                        bw.write("Apellido: " + apellido + " \n");
                        String ciudad;
                        System.out.println("Escribe tu ciudad de nacimiento: ");
                        ciudad = sc.nextLine();
                        bw.write("Ciudad: " + ciudad + " \n");
                        bw.close();
                    } catch (IOException ioe) {
                        System.out.println("Problema al escribir el fichero.");
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Ingrese el nombre del fichero que quiere mostrar: ");
                        String nombrefichero = sc.nextLine();
                        BufferedReader br = new BufferedReader(new FileReader(nombrefichero));
                        String linea;
                        while ((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        }
                        br.close();
                    } catch (IOException ioe) {
                        System.out.println("No se encuentra el fichero.");
                    }
                    break;
                case 3:
                        System.out.println("Nombre del fichero a buscar: ");
                        String fichero = sc.nextLine();
                        System.out.println("Nombre de la ciudad a buscar: ");
                        String ciudad = sc.nextLine();

                        try(BufferedReader br = new BufferedReader(new FileReader(fichero))){
                            String linea;
                            boolean esta = false;
                            while((linea = br.readLine()) != null) {
                                if (linea.contains(ciudad)) {
                                    esta = true;
                                    System.out.println(linea);
                                }else{
                                    System.out.println(linea);
                                }
                            }
                            }catch (IOException ioe) {
                            System.out.println("No se encuentra el fichero.");
                        }
                        break;
                case 4:
                    System.out.println("Nombre del fichero que desea borrar: ");
                    String nombreAr = sc.nextLine();
                    File fichero2 = new File(nombreAr);
                    if (fichero2.exists()) {
                        fichero2.delete();
                        System.out.println("Fichero eliminado correctamente.");
                    } else {
                        System.out.println("No se encontro el fichero.");
                    }
                    break;
                case 5:
                    System.out.println("Nombre del fichero que desea ordenar: ");
                    String nombreOrden = sc.nextLine();
                    ArrayList<String> a = new ArrayList<String>();
                    try {
                        BufferedReader br = new BufferedReader(new FileReader(nombreOrden));
                        String linea;
                        while ((linea = br.readLine()) != null) {
                            a.add(linea);
                        }
                        Collections.sort(a);
                        for (String nombre : a) {
                            System.out.println(nombre);
                        }
                    }catch (IOException ioe){
                        System.out.println("No se encuentra el fichero.");
                    }
                    break;
                case 6:
                    System.out.println("Nombre del fichero que desea añadir datos: ");
                    String nombreA = sc.nextLine();

                    try{
                        FileWriter fr = new FileWriter(nombreA, true);
                        String nombre;
                        System.out.println("Escribe tu nombre: ");
                        nombre = sc.nextLine();
                        fr.write("Nombre: " + nombre + " \n");
                        String apellido;
                        System.out.println("Escribe tu apellido: ");
                        apellido = sc.nextLine();
                        fr.write("Apellido: " + apellido + " \n");
                        String ciudadd;
                        System.out.println("Escribe tu ciudad de nacimiento: ");
                        ciudadd = sc.nextLine();
                        fr.write("Ciudad: " + ciudadd + " \n");
                        fr.close();
                    }catch (IOException ioe){
                        System.out.println("No se encuentra el fichero.");
                    }
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
            }
        }
    }
}