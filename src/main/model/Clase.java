/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.model;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author pedro
 */
public class Clase {
    
    private final StringProperty nombreClase;
    private final StringProperty horaReserva;
    private final StringProperty fechaReserva;
    private final StringProperty nombre;
    private final StringProperty apellido;
    

    
    public Clase(String nombreClase) {
        this.nombreClase = new SimpleStringProperty(nombreClase);
        this.horaReserva = new SimpleStringProperty(" ");
        this.fechaReserva = new SimpleStringProperty("");
        this.nombre = new SimpleStringProperty(" ");
        this.apellido = new SimpleStringProperty(" ");
        
        
    }
 
    public Clase() {
         this(null);
    }


    public String getNombreClase() {
        return nombreClase.get();
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase.set(nombreClase);
    }

    public StringProperty nombreClaseProperty() {
        return nombreClase;
    }
    
    public String getHoraReserva() {
        return horaReserva.get();
    }

    public void setHoraReserva(String horaReserva) {
        this.horaReserva.set(horaReserva);
    }

    public StringProperty horaReservaProperty() {
        return horaReserva;
    }
    
    public String getFechaReserva() {
        return fechaReserva.get();
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva.set(fechaReserva);
    }

    public StringProperty fechaReservaProperty() {
        return fechaReserva;
    }
    
    public String getNombre() {
        return horaReserva.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public StringProperty nombreProperty() {
        return nombre;
    }
    
    public String getApellido() {
        return apellido.get();
    }

    public void setApellido(String apellido) {
        this.apellido.set(apellido);
    }

    public StringProperty apellidoProperty() {
        return apellido;
    }
       
}
