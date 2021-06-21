package com.talleradiv2.TallerProyectoAda.Model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class OrdenDeTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_orden_de_trabajo;


    private Date fecha_de_inicio;
    private Date fecha_de_termino;
    private Date fecha_de_entrega;
    private String detalle;
    private double valor_final;

    @OneToOne
    @JoinColumn(name = "id_cotizacion",referencedColumnName = "id_cotizacion")
    private Cotizacion cotizacion;

    @OneToOne
    @JoinColumn(name = "id_colaborador",referencedColumnName = "id_colaborador")
    private Colaborador colaborador;

    public int getId_orden_de_trabajo() {
        return id_orden_de_trabajo;
    }

    public void setId_orden_de_trabajo(int id_orden_de_trabajo) {
        this.id_orden_de_trabajo = id_orden_de_trabajo;
    }

    public Date getFecha_de_inicio() {
        return fecha_de_inicio;
    }

    public void setFecha_de_inicio(Date fecha_de_inicio) {
        this.fecha_de_inicio = fecha_de_inicio;
    }

    public Date getFecha_de_termino() {
        return fecha_de_termino;
    }

    public void setFecha_de_termino(Date fecha_de_termino) {
        this.fecha_de_termino = fecha_de_termino;
    }

    public Date getFecha_de_entrega() {
        return fecha_de_entrega;
    }

    public void setFecha_de_entrega(Date fecha_de_entrega) {
        this.fecha_de_entrega = fecha_de_entrega;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public double getValor_final() {
        return valor_final;
    }

    public void setValor_final(double valor_final) {
        this.valor_final = valor_final;
    }

    public Cotizacion getCotizacion() {
        return cotizacion;
    }

    public void setCotizacion(Cotizacion cotizacion) {
        this.cotizacion = cotizacion;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }
}
