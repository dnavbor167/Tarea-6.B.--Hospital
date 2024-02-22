/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

/**
 *
 * @author danielnavasborjas
 */
final public class Medico extends Empleado implements Nadador{
    public static double IRPF_CIRUJANO = 0.25;
    public static double IRPF_MEDICO = 0.235;

    //insertamos atributos encapsulados
    private String especialidad;
    
    //insertamos constructor parametrizado
    public Medico(String especialidad, String numeroSeguridadSocial, double salario, String nombre, String apellido, Nif nif) {
        super(numeroSeguridadSocial, salario, nombre, apellido, nif);
        this.especialidad = especialidad;
    }
    //insertamos constructor sin parámetros
    public Medico() {
    }
    
    //insertamos getter y setter
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    //insertamos toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Medico{");
        sb.append(" Nombre: ").append(this.getNombre());
        sb.append(", Apellido: ").append(this.getApellido());
        sb.append(", Dni: ").append(this.getNif());
        sb.append("especialidad=").append(especialidad);
        sb.append('}');
        return sb.toString();
    }
    
    //método para tratar al paciente
    final public void tratar(Paciente paciente, String medicina) {
        System.out.println("El médico " + this.getNombre() + " trata a " 
                + paciente.getNombre() + " Con la medicina " + medicina);
        //no sé si implementar el método de paciente aquí, tiene sentido
        //así se conectan las medicinas
        paciente.tomarMedicina(medicina);
    }
    
    //sobreescribimos el método de calcular irpf del padre
    @Override
    final public double calcularIrpf() {
        if (this.especialidad.equalsIgnoreCase("cirugía")) {
            return this.getSalario() * IRPF_CIRUJANO;
        }
        return this.getSalario() * IRPF_MEDICO;
    }

    //insertamos método abstracto de la interfaz Nadador
    @Override
    public void nada(Empleado e) {
        System.out.println("Un médico nada");
    }

    
    
}
