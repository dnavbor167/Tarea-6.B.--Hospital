/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

/**
 *
 * @author danielnavasborjas
 */
public class Paciente extends Persona{
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
        sb.append(" Apellido: ").append(super.getApellido());
        sb.append("numeroHistoria=").append(numeroHistoria);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
