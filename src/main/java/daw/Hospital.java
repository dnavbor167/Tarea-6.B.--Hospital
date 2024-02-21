/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package daw;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author danielnavasborjas
 */
public class Hospital {
    //insertamos atributos encapsulados
    private String nombre;
    private String direccion;
    private int numeroCamas;
    private List<Paciente> paciente;
    private List<Empleado> empleado;
    
    //insertamos constructor parametrizado
    public Hospital(String nombre, String direccion, int numeroCamas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroCamas = numeroCamas;
        this.paciente = new ArrayList<>();
        this.empleado = new ArrayList<>();
    }
    //insertamos constructor sin parametrizar
    public Hospital() {
    }
    
    //insertamos getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumeroCamas() {
        return numeroCamas;
    }

    public void setNumeroCamas(int numeroCamas) {
        this.numeroCamas = numeroCamas;
    }

    public List<Paciente> getPaciente() {
        return paciente;
    }

    public void setPaciente(List<Paciente> paciente) {
        this.paciente = paciente;
    }

    public List<Empleado> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(List<Empleado> empleado) {
        this.empleado = empleado;
    }
    
    //insertamos toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hospital{");
        sb.append("nombre=").append(nombre);
        sb.append(", direccion=").append(direccion);
        sb.append(", numeroCamas=").append(numeroCamas);
        sb.append(", paciente=").append(this.paciente);
        sb.append(", empleado=").append(this.empleado);
        sb.append('}');
        return sb.toString();
    }
    
    //insertamos equal y hashcode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.nombre);
        hash = 67 * hash + Objects.hashCode(this.direccion);
        hash = 67 * hash + this.numeroCamas;
        hash = 67 * hash + Objects.hashCode(this.paciente);
        hash = 67 * hash + Objects.hashCode(this.empleado);
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
        final Hospital other = (Hospital) obj;
        if (this.numeroCamas != other.numeroCamas) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.paciente, other.paciente)) {
            return false;
        }
        return Objects.equals(this.empleado, other.empleado);
    }
    
    //insertamos métodos para contratar empleados
    public void contratarEmpleados(Empleado emp) {
        this.empleado.add(emp);
        System.out.println("Añadiendo empleado...");
    }
    
    //insertamos método para ingresar pacientes
    public void ingresarPaciente(Paciente paciente) {
        this.paciente.add(paciente);
        System.out.println("Añadiendo paciente...");
    }
}
