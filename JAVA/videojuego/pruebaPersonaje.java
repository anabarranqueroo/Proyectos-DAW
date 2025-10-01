import java.util.Scanner;

public class pruebaPersonaje {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 3;
        Catalogo [] catalogo = new Catalogo[3];

        for(int i = 0; i < 3; i++){
            catalogo[i] = new Catalogo();
        }

        int nummenu;
        String nombre;
        int primeraLibre;
        boolean existeNombre = true;
        int vida;
        int fuerza;
        int destreza;
        int inteligencia;
        int experiencia;
        int nivel;

        do {
            System.out.println("1.Añadir un personaje al catalogo.");
            System.out.println("2.Consultar los datos de un personaje por su nombre.");
            System.out.println("3.Eliminar un personaje por su nombre.");
            System.out.println("4.Modificar los datos de un personaje por su nombre.");
            System.out.println("5.Mostrar un listado con todos los personajes del catalogo.");
            System.out.println("6.Salir.");
            nummenu = sc.nextInt();
            switch (nummenu) {
                case 1:
                    boolean espacio=false;
                    for (int i = 0; i <n; i++) {
                        if (catalogo[i].getNombre().equals(" ")) {
                            espacio=true;
                            break;
                        }
                    }
                    if (!espacio) {
                        System.out.println("No hay mas espacios para añadir personajes.");
                        System.out.println();
                    } else {
                        primeraLibre = -1;
                        do {
                            primeraLibre++;
                        } while (!catalogo[primeraLibre].getNombre().equals(" "));

                        System.out.print("Introduzca el nombre: ");

                        existeNombre = true;
                        while (existeNombre) {
                            existeNombre = false;
                            nombre = sc.next();

                            for (int i = 0; i < n; i++) {
                                if (nombre.equals(catalogo[i].getNombre())) {
                                    existeNombre = true;
                                    break;
                                }
                            }
                            if (existeNombre) {
                                System.out.println("Error. Nombre ya existente.");
                                System.out.println("Introduce otro nombre del personaje: ");
                            } else {
                                catalogo[primeraLibre].setNombre(nombre);
                            }

                        }

                        System.out.print("Introduzca la vida del personaje: ");
                        vida = sc.nextInt();
                        catalogo[primeraLibre].setVida(vida);

                        System.out.print("Introduzca la fuerza del personaje: ");
                        fuerza = sc.nextInt();
                        catalogo[primeraLibre].setFuerza(fuerza);

                        System.out.print("Introduzca la destreza del personaje: ");
                        destreza = sc.nextInt();
                        catalogo[primeraLibre].setDestreza(destreza);

                        System.out.print("Introduzca la inteligencia del personaje: ");
                        inteligencia = sc.nextInt();
                        catalogo[primeraLibre].setInteligencia(inteligencia);

                        System.out.print("Introduzca la experiencia del personaje: ");
                        experiencia = sc.nextInt();
                        catalogo[primeraLibre].setExperiencia(experiencia);

                        System.out.print("Introduzca el nivel del personaje: ");
                        nivel = sc.nextInt();
                        catalogo[primeraLibre].setNivel(nivel);
                        break;
                    }
                case 2:
                    System.out.println("Ingrese el nombre del personaje: ");
                    nombre = sc.nextLine();
                    for (int i = 0; i <n; i++) {
                    if (catalogo[i].getNombre().equals(nombre)) {
                    System.out.println(catalogo[i].toString());
                    }
                    }
                    break;
                case  3:
                    System.out.println("Ingrese el nombre del personaje: ");
                    nombre = sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        if (nombre.equals(catalogo[i].getNombre())){
                            System.out.println("Borrando...");
                            catalogo[i].setNombre("");
                            catalogo[i].setVida(0);
                            catalogo[i].setDestreza(0);
                            catalogo[i].setExperiencia(0);
                            catalogo[i].setFuerza(0);
                            catalogo[i].setInteligencia(0);
                            catalogo[i].setNivel(0);
                        }
                    }
                    break;
                case 5:
                    for (int i = 0; i < n; i++) {
                        System.out.println(catalogo[i].toString());
                    }
                    break;
            }
        }while (nummenu != 6);

    }
}
