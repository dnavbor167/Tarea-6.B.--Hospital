/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

/**
 *
 * @author danielnavasborjas
 */
public abstract class Empleado extends Persona{
    //insertamos atributos encapsulados
    private String numeroSeguridadSocial;
    private double salario;
    
    //insertamos constructor parametrizado
    public Empleado(String numeroSeguridadSocial, double salario, String nombre, String apellido, Nif nif) {
        super(nombre, apellido, nif);
        this.numeroSeguridadSocial = numeroSeguridadSocial;
        this.salario = salario;
    }
    
    //insertamos constructor vacío
    public Empleado() {
    }
    
    //insertamos getter y setter

    public String getNumeroSeguridadSocial() {
        return numeroSeguridadSocial;
    }

    public void setNumeroSeguridadSocial(String numeroSeguridadSocial) {
        this.numeroSeguridadSocial = numeroSeguridadSocial;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
    //insertamos método abstracto para calcular el irpf
    public abstract double calcularIrpf();
    
}
