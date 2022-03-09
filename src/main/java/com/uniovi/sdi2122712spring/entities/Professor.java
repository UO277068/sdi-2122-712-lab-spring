package com.uniovi.sdi2122712spring.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Professor {
    private String name;
    private String surname;
    private String category;
    @Id
    private String dni;

    public Professor() {

    }

    public Professor(String dni,String nombre,String apellidos,String categoria){
        this.name=nombre;
        this.category=categoria;
        this.surname=apellidos;
        this.dni=dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "nombre='" + name + '\'' +
                ", categoria='" + category + '\'' +
                ", dni='" + dni + '\'' +
                ", apellidos='" + surname + '\'' +
                '}';
    }
}
