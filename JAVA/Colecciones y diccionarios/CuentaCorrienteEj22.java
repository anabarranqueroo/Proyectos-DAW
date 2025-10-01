package ejercicios;

import java.util.ArrayList;

public class CuentaCorrienteEj22{
    private long numCuenta;
    private double saldo;
    private ArrayList<String> movimientos = new ArrayList<>();

    public CuentaCorrienteEj22(double saldo){
        this.numCuenta = (long)(Math.random()*9000000000L)+1000000000L;
        this.saldo = saldo;
    }
    public CuentaCorrienteEj22(){
        this.numCuenta = (long)(Math.random()*9000000000L)+1000000000L;
    }
    @Override
    public String toString(){
        return "Numero de cta: " +this.numCuenta+ " Saldo: " +String.format("%.2f", this.saldo) +"€";
    }
    public void ingresos(double ingreso){
        this.saldo += ingreso;
        movimientos.add("Ingreso de " +ingreso + " € Saldo: " + String.format("%.2f", this.saldo) + " €");
    }
    public void cargo(double cargo){
        this.saldo -= cargo;
        movimientos.add("Cargo de " +cargo + " € Saldo: " + String.format("%.2f", this.saldo) + " €");
    }
    public void transferencia(CuentaCorrienteEj22 cuenta2, double saldoincluido){
        this.saldo -= saldoincluido;
        cuenta2.saldo += saldoincluido;
        movimientos.add("Transferencia de " +saldoincluido + "€ a la cuenta " + cuenta2.numCuenta + " Saldo " + String.format("%.2f", this.saldo) + " €");
        cuenta2.movimientos.add("Transferencia recibida de " +saldoincluido + "€ a la cuenta " + cuenta2.numCuenta + " Saldo " + String.format("%.2f", cuenta2.saldo) + " €");
    }
    public void movimientos(){
        System.out.println("Movimientos de la cuenta " +this.numCuenta);
        for (String movimiento : movimientos){
            System.out.println(movimiento);
        }
    }
}

