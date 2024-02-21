/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author danielnavasborjas
 */
public abstract class Persona {
    //declaramos atributos encapsulados
    private String nombre;
    private String apellido;
    private Nif nif;
    
    //insertamos constructor parametrizado
    public Persona(String nombre, String apellido, Nif nif) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nif = nif;
    }

    //insertamos constructos vacío
    public Persona() {
    }
    
    //insertamos getter y setter
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

    public Nif getNif() {
        return nif;
    }

    public void setNif(Nif nif) {
        this.nif = nif;
    }
    
    //insertamos toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("nombre=").append(nombre);
        sb.append(", apellido=").append(apellido);
        sb.append(", nif=").append(nif);
        sb.append('}');
        return sb.toString();
    }

    //método para renovarNif
    final public void renovarNif(LocalDate fechaSolicitud) {
        this.nif.renovar(fechaSolicitud);
    }
}
