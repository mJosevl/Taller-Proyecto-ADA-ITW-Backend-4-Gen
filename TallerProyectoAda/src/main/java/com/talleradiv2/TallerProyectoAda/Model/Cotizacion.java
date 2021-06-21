package com.talleradiv2.TallerProyectoAda.Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Cotizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cotizacion;


    private Date fecha;
    private double valor_neto;
    private double iva;
    private double valor_total;
    private String tipo_pago;
    private String observaciones;


    @OneToOne
    @JoinColumn(name = "id_cliente",referencedColumnName = "id_cliente")
    private Cliente cliente;
    @OneToOne
    @JoinColumn(name = "id_presupuesto",referencedColumnName = "id_presupuesto")
    private Presupuesto presupuesto;

    public int getId_cotizacion() {
        return id_cotizacion;
    }

    public void setId_cotizacion(int id_cotizacion) {
        this.id_cotizacion = id_cotizacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getValor_neto() {
        return valor_neto;
    }

    public void setValor_neto(double valor_neto) {
        this.valor_neto = valor_neto;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
    }
}
