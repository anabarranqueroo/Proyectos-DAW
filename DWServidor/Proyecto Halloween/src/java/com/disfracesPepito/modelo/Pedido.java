
package com.disfracesPepito.modelo;

import java.time.LocalDate;


public class Pedido {
    private String referencia;
    private double cantTotal;
    private LocalDate entregaPos1;
    private LocalDate entregaPos2;
    private LocalDate realizaPed;

    public Pedido(String referencia, double cantTotal, LocalDate entregaPos1, LocalDate entregaPos2, LocalDate realizaPed) {
        this.referencia = referencia;
        this.cantTotal = cantTotal;
        this.entregaPos1 = entregaPos1;
        this.entregaPos2 = entregaPos2;
        this.realizaPed = realizaPed;
    }

    public String getReferencia() {
        return referencia;
    }

    public double getCantTotal() {
        return cantTotal;
    }

    public LocalDate getEntregaPos1() {
        return entregaPos1;
    }

    public LocalDate getEntregaPos2() {
        return entregaPos2;
    }

    public LocalDate getRealizaPed() {
        return realizaPed;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setCantTotal(double cantTotal) {
        this.cantTotal = cantTotal;
    }

    public void setEntregaPos1(LocalDate entregaPos1) {
        this.entregaPos1 = entregaPos1;
    }

    public void setEntregaPos2(LocalDate entregaPos2) {
        this.entregaPos2 = entregaPos2;
    }

    public void setRealizaPed(LocalDate realizaPed) {
        this.realizaPed = realizaPed;
    }
    
    
}
