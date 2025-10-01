package ejercicios;

public class ejercicio22{
    public static void main(String[] args) {
        CuentaCorrienteEj22 cuenta1 = new CuentaCorrienteEj22(0);
        CuentaCorrienteEj22 cuenta2 = new CuentaCorrienteEj22(1500);
        CuentaCorrienteEj22 cuenta3 = new CuentaCorrienteEj22(6000);
        cuenta1.ingresos(2000);
        cuenta2.cargo(600);
        cuenta3.ingresos(75);
        cuenta1.cargo(55);
        cuenta2.transferencia(cuenta1, 100);
        cuenta1.transferencia(cuenta3, 250);
        cuenta3.transferencia(cuenta1, 22);
        cuenta1.movimientos();

    }
}
