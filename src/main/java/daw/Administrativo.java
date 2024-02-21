/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.Objects;

/**
 *
 * @author danielnavasborjas
 */
final public class Administrativo extends Empleado {
    //atributo encapsulado
    private Grupo grupo;

    //constructor parametrizado
    public Administrativo(Grupo grupo, String numeroSeguridadSocial, double salario, String nombre, String apellido, Nif nif) {
        super(numeroSeguridadSocial, salario, nombre, apellido, nif);
        this.grupo = grupo;
    }
    
    //insertamos getter y setter
    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Administrativo{");
        sb.append(" Nombre: ").append(this.getNombre());
        sb.append(", Apellido: ").append(this.getApellido());
        sb.append(", Dni: ").append(this.getNif());
        sb.append(", grupo=").append(grupo);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.grupo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Administrativo other = (Administrativo) obj;
        return this.grupo == other.grupo;
    }
    
    

    //método para registrar documentos
    public void registrarDocumentos(String nombre) {
        System.out.println("Nombre: " + this.getNombre() + "\nApellido: " 
                + this.getApellido() + "\nNombre Documento: " + nombre + 
                "Hashcode: " + hashCode());
    }
    
    //sobreescribimos el método para calcular irpf
    @Override
    final public double calcularIrpf() {
        switch (this.grupo) {
            case C -> {
                return this.getSalario() * Grupo.C.getIrpf();
            }
            case D -> {
                return this.getSalario() * Grupo.D.getIrpf();
            }
            default -> {
                return this.getSalario() * Grupo.E.getIrpf();
            }
        }
    }
    
}
