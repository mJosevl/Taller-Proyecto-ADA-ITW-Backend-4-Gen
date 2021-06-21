package com.talleradiv2.TallerProyectoAda.Model;


import javax.persistence.*;

@Entity
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)/*Que se genere automaticamente, sera auto-incremental*/
    private int id_colaborador;

    private String nombre;

    private String apellido;

    private int telefono;

    private int celular;

    private int rut;

    private String correo;

    private String funcion;
    private String jornada;
    @OneToOne
    @JoinColumn(name = "id_direccion",referencedColumnName = "id_direccion")
    private  Direccion direccionColaborador ;

    public int getId_colaborador() {
        return id_colaborador;
    }

    public void setId_colaborador(int id_colaborador) {
        this.id_colaborador = id_colaborador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public Direccion getDireccionColaborador() {
        return direccionColaborador;
    }

    public void setDireccionColaborador(Direccion direccionColaborador) {
        this.direccionColaborador = direccionColaborador;
    }
}
