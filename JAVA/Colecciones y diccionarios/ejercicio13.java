package ejercicios;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ejercicio13 {
    static ArrayList<ArticuloEj13> articulos = new ArrayList<ArticuloEj13>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> lineas = new HashMap<String, Integer>();
        int opcion;
        int opcion2;
        int stockIntro;
        int unidades = 0;
        int unidadesEnFactura = 0;
        double precioDeCompraIntro;
        double precioDeVentaIntro;
        double subtotal;
        double baseImponible;
        double totalFactura;
        String codigo;
        String codigoIntro = "";
        String descripcionIntro;
        String precioDeCompraIntroString;
        String precioDeVentaIntroString;
        String stockIntroString;

        do {
            System.out.println("1.Listado");
            System.out.println("2.Alta");
            System.out.println("3.Baja");
            System.out.println("4.Modificacion");
            System.out.println("5.Entrada de mercancia");
            System.out.println("6. Venta");
            System.out.println("7. Salir");
            System.out.print("Introduzca una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    for (ArticuloEj13 articulo : articulos) {
                        System.out.println(articulo);
                    }
                    break;
                case 2:
                    System.out.print("Introduzca los datos del articulo: ");
                    System.out.print("Codigo: ");

                    do {
                        codigoIntro = sc.nextLine();
                        if (posicion(codigoIntro) != -1) {
                            System.out.print("El codigo ya existe. Introduzca otro: ");
                        }
                    } while (posicion(codigoIntro) != -1);

                    System.out.print("Descripcion: ");
                    descripcionIntro = sc.nextLine();

                    System.out.print("Precio de compra: ");
                    precioDeCompraIntro = sc.nextDouble();

                    System.out.print("Precio de venta: ");
                    precioDeVentaIntro = sc.nextDouble();

                    System.out.print("Stock: ");
                    stockIntro = sc.nextInt();

                    articulos.add(new ArticuloEj13(codigoIntro, descripcionIntro, precioDeCompraIntro, precioDeVentaIntro, stockIntro));
                    sc.nextLine();
                    break;
                case 3:
                    System.out.print("Introduzca el codigo del articulo que vas a dar de baja: ");
                    codigoIntro = sc.nextLine();

                    if (posicion(codigoIntro) == -1) {
                        System.out.print("Lo siento, el codigo introducido no existe");
                    } else {
                        articulos.remove(posicion(codigoIntro));
                        System.out.println("El articulo se ha borrado");
                    }
                    break;
                case 4:
                    System.out.print("Introduzca el codigo del articulo que quieres cambiar: ");
                    do {
                        codigoIntro = sc.nextLine();
                        if (posicion(codigoIntro) == -1) {
                            System.out.println("No existe ese codigo. Introduce otro:");
                        }
                    } while (posicion(codigoIntro) == -1);

                    int i = posicion(codigoIntro);
                    System.out.print("Introduzca los nuevos datos del articulo: ");
                    System.out.print("Codigo: " + articulos.get(i).getCodigo());
                    System.out.print("Nuevo codigo: ");
                    codigoIntro = sc.nextLine();
                    if (!codigoIntro.equals("")) {
                        articulos.get(i).setCodigo(codigoIntro);
                    }
                    System.out.print("Descripcion: " + articulos.get(i).getDescripcion());
                    System.out.print("Nueva descripcion: ");
                    descripcionIntro = sc.nextLine();
                    if (!descripcionIntro.equals("")) {
                        articulos.get(i).setDescripcion(descripcionIntro);
                    }
                    System.out.println("Precio de compra: " + articulos.get(i).getPrecioCompra());
                    System.out.print("Nuevo precio de compra: ");
                    precioDeCompraIntroString = sc.nextLine();
                    if (!precioDeCompraIntroString.equals("")) {
                        articulos.get(i).setPrecioCompra(Double.parseDouble(precioDeCompraIntroString));
                    }

                    System.out.println("Precio de venta: " + articulos.get(i).getPrecioVenta());
                    System.out.print("Nuevo precio de venta: ");
                    precioDeVentaIntroString = sc.nextLine();
                    if (!precioDeVentaIntroString.equals("")) {
                        articulos.get(i).setPrecioVenta(Double.parseDouble(precioDeVentaIntroString));
                    }

                    System.out.println("Stock: " + articulos.get(i).getStock());
                    System.out.print("Nuevo stock: ");
                    stockIntroString = sc.nextLine();
                    if (!stockIntroString.equals("")) {
                        articulos.get(i).setStock(Integer.parseInt(stockIntroString));
                    }
                    break;
                case 5:
                    System.out.print("Introduzca el codigo del articulo: ");
                    codigoIntro = sc.nextLine();

                    do {
                        if (posicion(codigoIntro) == -1) {
                            System.out.println("No existe ese codigo. Introduce otro:");
                            codigoIntro = sc.nextLine();
                        }
                    } while (posicion(codigoIntro) == -1);

                    i = posicion(codigoIntro);

                    System.out.println("Entrada de mercancía del siguiente artículo: ");
                    System.out.print(articulos.get(i));
                    System.out.print("Introduzca el número de unidades que entran al almacén: ");
                    stockIntro = sc.nextInt();
                    articulos.get(i).setStock(stockIntro + articulos.get(i).getStock());
                    System.out.println("La mercancia ha entrado al almacen");
                    sc.nextLine();
                    break;
                case 6:
                    do {
                        System.out.println("1. Añadir artículo");
                        System.out.println("2. Generar factura");
                        System.out.println("3. Cancelar");
                        System.out.print("Introduzca una opción: ");
                        opcion2 = sc.nextInt();
                        sc.nextLine();

                        switch (opcion2) {
                            case 1:
                                System.out.print("Introduzca el codigo del articulo: ");
                                codigoIntro = sc.nextLine();
                                i = posicion(codigoIntro);

                                if (i == -1) {
                                    System.out.print("No hay ningun articulo con ese codigo");
                                } else {
                                    System.out.print(articulos.get(i));

                                    if (lineas.containsKey(codigoIntro)) {
                                        unidadesEnFactura = lineas.get(codigoIntro);
                                    } else {
                                        unidadesEnFactura = 0;
                                    }
                                    System.out.println("Unidades de Factura: " + unidadesEnFactura);

                                    System.out.println("Unidades que quiere incorporar a la factura: ");
                                    unidades = sc.nextInt();

                                    if ((articulos.get(i).getStock()) - unidadesEnFactura < unidades) {
                                        System.out.println("No hay suficiente stock.");
                                    } else if (lineas.containsKey(codigoIntro)) {
                                        lineas.put(codigoIntro, lineas.get(codigoIntro) + unidades);
                                    } else {
                                        lineas.put(codigoIntro, unidades);
                                    }
                                }
                                System.out.print("\n\n CÓDIGO | DESCRIPCIÓN | UNIDADES | PRECIO UNID. | SUBTOTAL");
                                for (Map.Entry pareja : lineas.entrySet()) {
                                    codigo = pareja.getKey().toString();
                                    i = posicion(codigo);
                                    unidades = Integer.parseInt(pareja.getValue().toString());
                                    subtotal = unidades * articulos.get(i).getPrecioVenta();
                                    System.out.printf(" %6s | %17s | %8d | %12.2f | %8.2f\n", codigo, articulos.get(i).getDescripcion(), unidades, articulos.get(i).getPrecioVenta(), subtotal);
                                }
                                break;
                            case 2:
                                baseImponible = 0;
                                System.out.println("\n\n CÓDIGO | DESCRIPCIÓN | UNIDADES | PRECIO UNID. | SUBTOTAL");
                                for (Map.Entry pareja : lineas.entrySet()) {
                                    codigo = pareja.getKey().toString();
                                    i = posicion(codigo);
                                    unidades = Integer.parseInt(pareja.getValue().toString());
                                    subtotal = unidades * articulos.get(i).getPrecioVenta();
                                    System.out.printf(" %6s | %15s | %8d | %12.2f | %8.2f\n", codigo, articulos.get(i).getDescripcion(), unidades, articulos.get(i).getPrecioVenta(), subtotal);
                                    baseImponible += subtotal;
                                    articulos.get(i).setStock(articulos.get(i).getStock() - unidades);
                                }
                                System.out.printf(" BASE IMPONIBLE: %8.2f \n", baseImponible);
                                System.out.printf(" IVA (21%): %8.2f \n", baseImponible * 0.21);
                                System.out.printf(" TOTAL: %8.2f \n", baseImponible * 1.21);
                                System.out.println("\n\nFactura generada.\nPulse INTRO para volver al menú principal.");
                                System.out.println();
                                sc.nextLine();
                                break;
                        }
                    } while (opcion2 == 1);
                    break;
            }
        } while (opcion != 7);

    }
    static public int posicion(String codigo) {
        int i = -1;
        for (ArticuloEj13 aux : articulos) {
            i++;
            if (aux.getCodigo().equals(codigo)) {
                return i;
            }
        }
        return -1;
    }
}
