/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author danielnavasborjas
 */
public class GestionHospital {
    //métod main
    public static void main(String[] args) {
        //Instanciamos la variable aleatoria de tipo Random
        Random r = new Random();
        //empleado aleatorio
        int empleado;
        
        //Lo primero de todo es crear un hospital
        Hospital hospital = new Hospital("Hospitén", 
                "111000 Puerto Real, Cádiz", 3500);
        
        //creamos 5 empleados
        //2 médicos
        Medico med1 = crearMedico("Cirugía", 
                "426-53-4669", 2599.54, "Juan", 
                "Gerto", new Nif(23431265, 
                        LocalDate.of(2029, Month.JUNE, 23)));
        Medico med2 = crearMedico("Huesólogo", 
                "532-76-1234", 1552.23, "Pino", 
                "Pato", new Nif(23431265, 
                        LocalDate.of(2034, Month.AUGUST, 12)));
        //3 adiministrativos
        Administrativo administrativo1 = crearPersonalPAS(Grupo.C, 
                "123-45-6789", 1345.45, "Mateo", "Gómez", 
                new Nif(11128756, LocalDate.of(2024, Month.MARCH, 2)));
        Administrativo administrativo2 = crearPersonalPAS(Grupo.D, 
                "123-45-6789", 1345.45, "Trent", "Nino", 
                new Nif(43127689, LocalDate.of(2026, Month.DECEMBER, 17)));
        Administrativo administrativo3 = crearPersonalPAS(Grupo.E, 
                "123-45-6789", 1345.45, "Pepi", "Pilar", 
                new Nif(02174625, LocalDate.of(2026, Month.NOVEMBER, 6)));
        
        //ingresamos 5 pacientes
        Paciente pac1 = crearPaciente("Historia1", "Andrés", "Mirador",
                new Nif(00000000, LocalDate.of(2025, Month.SEPTEMBER, 28)));
        Paciente pac2 = crearPaciente("Historia2", "Carlos", "Alto",
                new Nif(12345678, LocalDate.of(2025, Month.SEPTEMBER, 16)));
        Paciente pac3 = crearPaciente("Historia3", "Pedro", "Cuar",
                new Nif(98765432, LocalDate.of(2026, Month.MAY, 1)));
        Paciente pac4 = crearPaciente("Historia4", "Antitino", "teno",
                new Nif(19283746, LocalDate.of(2031, Month.FEBRUARY, 7)));
        Paciente pac5 = crearPaciente("Historia5", "Sergio", "Ramos",
                new Nif(01223344, LocalDate.of(2025, Month.SEPTEMBER, 23)));
        
        //añadimos al hospital creado anteriormente todos los pacientes y empleados
        hospital.contratarEmpleados(med1);
        hospital.contratarEmpleados(med2);
        hospital.contratarEmpleados(administrativo1);
        hospital.contratarEmpleados(administrativo2);
        hospital.contratarEmpleados(administrativo3);
        hospital.ingresarPaciente(pac1);
        hospital.ingresarPaciente(pac2);
        hospital.ingresarPaciente(pac3);
        hospital.ingresarPaciente(pac4);
        hospital.ingresarPaciente(pac5);
        
        //elegimos paciente aleatorio
        Paciente paciAleato = hospital.getPaciente().get(r.nextInt(hospital.getPaciente().size()));
        //Creamos médico vacío
        Medico medAleato = new Medico();
        
        empleado = 0;
        //bucle para que se repita hasta que sea un empleado Medico
        do {
            //asignamos a la variable empleado un número aleatorio del tamaño de
            //la lista de empleados del hospital
            empleado = r.nextInt(hospital.getEmpleado().size());
            //si el empleado es de tipo Medico guardamos en la variable med
            //(de tipo médico) el médico aleatorio
            if (hospital.getEmpleado().get(empleado) instanceof Medico medico) {
                medAleato = medico;
            }
        } while (hospital.getEmpleado().get(empleado) instanceof Administrativo);
        
        System.out.println();
        
        //una vez obtenidos los médicos y los pacientes aleatorios
        //tratamos al paciente aleatorio con el médico aleatorio
        medAleato.tratar(paciAleato, "Pancetamol");
        
        System.out.println();
        
        //Ejecutmaos el método abstracto de todos los empleados
        for (Empleado empleado1 : hospital.getEmpleado()) {
                if (empleado1 instanceof Medico) {
                    System.out.println("El médico " + empleado1.getNombre() 
                            + " paga de IRPF: " + String.format(
                                    "%.2f", empleado1.calcularIrpf()));
                }
                if (empleado1 instanceof Administrativo) {
                    System.out.println("El Administrativo " + empleado1.getNombre() 
                            + " paga de IRPF: " + String.format(
                                    "%.2f", empleado1.calcularIrpf()));
                }
        }
        
        System.out.println();
        
        //renovamos un nif a un paciente cualquiera
        hospital.getPaciente().get(r.nextInt(
                hospital.getPaciente().size()))
                .renovarNif(LocalDate.now());
    }

    //método para crear un paciente
    public static Paciente crearPaciente(String numeroHistoria, String nombre, String apellido, Nif nif) {
        return new Paciente(numeroHistoria, nombre, apellido, nif);
    }
    
    //método para crear a un médico
    public static Medico crearMedico(String especialidad, String numeroSeguridadSocial,
            double salario, String nombre, String apellido, Nif nif) {
        return new Medico(especialidad, numeroSeguridadSocial, salario, nombre, apellido, nif);
    }
    
    //método para crear administrativos
    public static Administrativo crearPersonalPAS(Grupo grupo, String numeroSeguridadSocial,
            double salario, String nombre, String apellido, Nif nif) {
        return new Administrativo(grupo, numeroSeguridadSocial, salario, nombre, apellido, nif);
    }
}
