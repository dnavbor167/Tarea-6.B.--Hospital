/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author danielnavasborjas
 */
final public class Paciente extends Persona implements Nadador{
    private String numeroHistoria;

    //insertamos constructor parametrizado
    public Paciente(String numeroHistoria, String nombre, String apellido, Nif nif) {
        super(nombre, apellido, nif);
        this.numeroHistoria = numeroHistoria;
    }
    
    //insertamos getter y setter
    public String getNumeroHistoria() {
        return numeroHistoria;
    }

    public void setNumeroHistoria(String numeroHistoria) {
        this.numeroHistoria = numeroHistoria;
    }
    
    //insertamos toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Paciente{");
        sb.append("Nombre: ").append(super.getNombre());
        sb.append(", Apellido: ").append(super.getApellido());
        sb.append(", Dni: ").append(super.getNif());
        sb.append(", numeroHistoria=").append(numeroHistoria);
        sb.append('}');
        return sb.toString();
    }
    
    //insertamos equal y hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.numeroHistoria);
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
        final Paciente other = (Paciente) obj;
        return Objects.equals(this.numeroHistoria, other.numeroHistoria);
    }
    
    //insertamos método para tomar medicina
    public void tomarMedicina(String medicina) {
        Random r = new Random();
        String mensaje = (r.nextInt(2) == 1) ? "El paciente " +
                this.getNombre() + ", se ha curado" : "El paciente " +
                this.getNombre() + ", no se ha curado";
        System.out.println(mensaje);
    }
    
    //insertamos método abstracto de la interfaz Nadador
    @Override
    public void nada(Empleado e) {
        System.out.println("Un paciente nada");
    }
}
