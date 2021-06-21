package com.talleradiv2.TallerProyectoAda.Model;

import javax.persistence.*;

@Entity
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_proveedor;

    private String nombre_empresa;

    private int telefono;
    private int celular;
    private int rut;
    private String correo;



    @OneToOne
    @JoinColumn(name = "id_direccion",referencedColumnName = "id_direccion")
    private Direccion direccionProveedor;

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Direccion getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(Direccion direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }
}
