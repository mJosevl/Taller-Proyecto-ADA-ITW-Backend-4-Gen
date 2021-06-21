package com.talleradiv2.TallerProyectoAda.Model;

import javax.persistence.*;

@Entity
public class Presupuesto {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_presupuesto;

    private String tipo_daño;
    private String mo_pintura;
    private String mo_chapa;
    private  String mo_detailing;
    private String mo_mecanica;
    private  String mo_otros_servicios;
    private double valor;

    @OneToOne
    @JoinColumn(name = "id_repuestos",referencedColumnName = "id_repuestos")
    private Repuestos repuestos;

    public int getId_presupuesto() {
        return id_presupuesto;
    }

    public void setId_presupuesto(int id_presupuesto) {
        this.id_presupuesto = id_presupuesto;
    }

    public String getTipo_daño() {
        return tipo_daño;
    }

    public void setTipo_daño(String tipo_daño) {
        this.tipo_daño = tipo_daño;
    }

    public String getMo_pintura() {
        return mo_pintura;
    }

    public void setMo_pintura(String mo_pintura) {
        this.mo_pintura = mo_pintura;
    }

    public String getMo_chapa() {
        return mo_chapa;
    }

    public void setMo_chapa(String mo_chapa) {
        this.mo_chapa = mo_chapa;
    }

    public String getMo_detailing() {
        return mo_detailing;
    }

    public void setMo_detailing(String mo_detailing) {
        this.mo_detailing = mo_detailing;
    }

    public String getMo_mecanica() {
        return mo_mecanica;
    }

    public void setMo_mecanica(String mo_mecanica) {
        this.mo_mecanica = mo_mecanica;
    }

    public String getMo_otros_servicios() {
        return mo_otros_servicios;
    }

    public void setMo_otros_servicios(String mo_otros_servicios) {
        this.mo_otros_servicios = mo_otros_servicios;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Repuestos getRepuestos() {
        return repuestos;
    }

    public void setRepuestos(Repuestos repuestos) {
        this.repuestos = repuestos;
    }
}
