package com.uniovi.sdi2122712spring.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Professor {
    private String nombre;
    private String categoria;
    @Id
    private String dni;
    private String apellidos;

    public Professor() {

    }

    public Professor(String dni,String nombre,String apellidos,String categoria){
        this.nombre=nombre;
        this.categoria=categoria;
        this.apellidos=apellidos;
        this.dni=dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", dni='" + dni + '\'' +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}
