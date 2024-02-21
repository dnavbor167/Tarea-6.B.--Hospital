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
public class Nif {
    //insertamos atributos encapsulados
    private long numero;
    private char letra;
    private LocalDate fechaCaducidad;
    
    //Insertamos constructor parametrizado
    public Nif(long numero, LocalDate fechaCaducidad) {
        //Con esto nos aseguramos de que el número esté en ese rango
        if (numero > 10000000L && numero < 99999999L) {
            this.numero = numero;
        } else {
            //en caso de que no esté en ese rango el número por defecto será un 0
            this.numero = 0;
        }
        this.letra = calcularLetra();
        this.fechaCaducidad = fechaCaducidad;
    }
    //insertamos constructor sin parámetros
    public Nif() {
    }
    
    
    //insertamos getter y setter
    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    
    //insertamos toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nif{");
        sb.append("numero=").append(numero);
        sb.append(", letra=").append(letra);
        sb.append(", fechaCaducidad=").append(fechaCaducidad);
        sb.append('}');
        return sb.toString();
    }
    
    //insertamos equal y hashcode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + (int) (this.numero ^ (this.numero >>> 32));
        hash = 37 * hash + this.letra;
        hash = 37 * hash + Objects.hashCode(this.fechaCaducidad);
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
        final Nif other = (Nif) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (this.letra != other.letra) {
            return false;
        }
        return Objects.equals(this.fechaCaducidad, other.fechaCaducidad);
    }
    
 
    //méto privado para calcular la letra del char
    private char calcularLetra() {
        //creo un array de char con las posiciones exactas
        char[] letra = {'T', 'R', 'W', 'A', 'G', 'M','Y', 'F', 'P', 'D', 'X', 'B','N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        
        //guardo en una variable el divisor de numero entre 23
        int pos = (int)this.numero%23;
        
        //si está dentro del rango de la letra se coge la posición de la letra
        if (pos >= 0 && pos < letra.length) {
            return letra[pos];
        }
        return (char)35;
    }
    
    //método para renovar el dni
    public void renovar(LocalDate fechaSolicitudRenovacion) {
        this.fechaCaducidad = fechaSolicitudRenovacion.plusYears(10);
        System.out.println("Fecha de caducidad extendida a dentro de 10 años"
                + ", en concreto el " + this.fechaCaducidad.getDayOfMonth()
        + "/" + this.fechaCaducidad.getMonthValue()+ "/" + this.fechaCaducidad.getYear());
    }
}