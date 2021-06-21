package com.talleradiv2.TallerProyectoAda.Model;

import javax.persistence.*;

@Entity
public class Repuestos {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_repuestos;

    private String tipo;
    private double valor;
    @OneToOne
    @JoinColumn(name = "id_proveedor",referencedColumnName = "id_proveedor")
    private Proveedor proveedor;

    public int getId_repuestos() {
        return id_repuestos;
    }

    public void setId_repuestos(int id_repuestos) {
        this.id_repuestos = id_repuestos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
