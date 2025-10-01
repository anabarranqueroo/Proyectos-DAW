package ejercicios;

import java.util.Scanner;
import java.util.ArrayList;

public class PruebaDiscos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 3;
        ArrayList<Discos> discos = new ArrayList<Discos>();

        for (int i = 0; i <n; i++) {
            discos.add(new Discos());
        }

        int opcion;
        String codigoIntroducido;
        String autorIntroducido;
        String tituloIntroducido;
        String genero;
        int duracionIntroducida;
        int primeraLibre;
        int lleno = -1;
        String codigonuevo;
        boolean existeCodigo = true;
        int opcion2;
        String autor;
        String genero2;
        int duracionmin;
        int duracionmax;

        do {
            System.out.println("\n\nCOLECCIÓN DE DISCOS");
            System.out.println("===================");
            System.out.println("1. Listado");
            System.out.println("2. Nuevo disco");
            System.out.println("3. Modificar codigo disco");
            System.out.println("4. Borrar");
            System.out.println("5. Salir");
            System.out.print("Introduzca una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    do {
                        System.out.println("1. Autor");
                        System.out.println("2. Genero");
                        System.out.println("3. Duracion");
                        System.out.println("4. Salir");
                        opcion2 = sc.nextInt();

                        switch (opcion2) {
                            case 1:
                                System.out.print("Introduzca el autor: ");
                                autor = sc.next();
                                for (int i = 0; i < n; i++) {
                                    if (autor.equals(discos.get(i).getAutor())){
                                        System.out.println(discos.get(i).toString());
                                    }
                                }
                                break;
                            case 2:
                                System.out.print("Introduzca el genero: ");
                                genero2 = sc.next();
                                for (int i = 0; i < n; i++) {
                                    if (genero2.equals(discos.get(i).getGenero())){
                                        System.out.println(discos.get(i).toString());
                                    }
                                }
                                break;
                            case 3:
                                System.out.print("Introduzca el rango de duracion ");
                                System.out.println();
                                System.out.println("Duracion min:");
                                duracionmin = sc.nextInt();
                                System.out.print("Duracion max: ");
                                duracionmax = sc.nextInt();

                                for (int i = 0; i < n; i++) {
                                    if (duracionmin <= discos.get(i).getDuracion() && duracionmax >= discos.get(i).getDuracion()){
                                        System.out.println(discos.get(i).toString());
                                    }
                                }
                        }

                    }while(opcion2 != 4);
                    break;
                case 2:
                    boolean espacio=false;
                    for (int i = 0; i <n; i++) {
                        if (discos.get(i).getCodigo().equals("LIBRE")) {
                            espacio=true;
                            break;
                        }
                    }
                        if (!espacio) {
                            System.out.println("No hay mas espacios para añadir discos.");
                            System.out.println();
                        } else {
                            primeraLibre = -1;
                            do {
                                primeraLibre++;
                            } while (!discos.get(primeraLibre).getCodigo().equals("LIBRE"));

                            System.out.print("Introduzca el codigo: ");

                            existeCodigo = true;
                            while (existeCodigo) {
                                existeCodigo = false;
                                codigoIntroducido = sc.next();

                                for (int i = 0; i<n; i++) {
                                    if (codigoIntroducido.equals(discos.get(i).getCodigo())) {
                                        existeCodigo = true;
                                        break;
                                    }
                                }
                                    if (existeCodigo) {
                                        System.out.println("Error. Codigo ya existente.");
                                        System.out.println("Introduce otro codigo: ");
                                    }else{
                                        discos.get(primeraLibre).setCodigo(codigoIntroducido);
                                }

                            }

                            System.out.print("Introduzca el autor: ");
                            autorIntroducido = sc.next();
                            discos.get(primeraLibre).setAutor(autorIntroducido);

                            System.out.print("Introduzca el titulo: ");
                            tituloIntroducido = sc.next();
                            discos.get(primeraLibre).setTitulo(tituloIntroducido);

                            System.out.print("Introduzca el genero: ");
                            genero = sc.next();
                            discos.get(primeraLibre).setGenero(genero);

                            System.out.print("Introduzca la duracion en minutos: ");
                            duracionIntroducida = sc.nextInt();
                            discos.get(primeraLibre).setDuracion(duracionIntroducida);
                        }
                    break;
                case 3:
                    System.out.print("Introduzca el codigo que quieres cambiar ");
                    codigoIntroducido = sc.next();

                    int i = -1;
                    do {
                        i++;
                    }while(!discos.get(i).getCodigo().equals(codigoIntroducido));

                    System.out.print("Introduzca el codigo nuevo: ");
                    codigonuevo = sc.next();

                    for (int j=0; j<n; j++) {
                        if (codigonuevo.equals(discos.get(j).getCodigo())) {
                            System.out.print("Error. Codigo ya existente.");
                            break;
                        }
                        if (!codigonuevo.equals(discos.get(j).getCodigo())) {
                            discos.get(j).setCodigo(codigoIntroducido);
                            System.out.print("Codigo modificado.");
                        }
                        break;
                    }
                    break;
                case 4:
                    System.out.println("Introduzca el codigo del disco que quieres borrar: ");
                    codigoIntroducido = sc.next();

                    for (i =0; i<n; i++ ) {
                        if (discos.get(i).getCodigo().equals(codigoIntroducido)) {
                            System.out.print("Codigo correcto.");
                            discos.get(i).setCodigo("LIBRE");
                            discos.get(i).setAutor("");
                            discos.get(i).setTitulo("");
                            discos.get(i).setGenero("");
                            discos.get(i).setDuracion(0);
                            System.out.print("Borrando...");
                            lleno--;
                            break;
                        }
                        if(!discos.get(i).getCodigo().equals(codigoIntroducido)) {
                            System.out.print("Codigo incorrecto.");
                            break;
                        }
                    }
                default:
            }
        } while (opcion != 5);
    }
}