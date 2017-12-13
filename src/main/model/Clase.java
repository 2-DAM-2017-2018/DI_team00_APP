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
    private final StringProperty horaSalida;
    private final StringProperty nombre;
    private final StringProperty apellido;
    private final StringProperty dni;
    private final IntegerProperty telephone;
    private final StringProperty email;

 
    
    
    public Clase(String nombreClase) {
        this.nombreClase = new SimpleStringProperty(nombreClase);
        this.horaReserva = new SimpleStringProperty("00:00");
        this.horaSalida = new SimpleStringProperty("00:00");
        this.nombre = new SimpleStringProperty(" ");
        this.apellido = new SimpleStringProperty(" ");
        this.dni = new SimpleStringProperty("00000000Z");
        this.telephone = new SimpleIntegerProperty(654987321);
        this.email = new SimpleStringProperty("example@email.com");
        
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
    
    public String getHoraSalida() {
        return horaReserva.get();
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida.set(horaSalida);
    }

    public StringProperty horaSalidaProperty() {
        return horaSalida;
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
    
    public String getDni() {
        return dni.get();
    }

    public void setDni(String dni) {
        this.dni.set(dni);
    }

    public StringProperty dniProperty() {
        return dni;
    }
    
    public int getTelephone() {
        return telephone.get();
    }

    public void setTelephone(int telephone) {
        this.telephone.set(telephone);
    }

    public IntegerProperty telephoneProperty() {
        return telephone;
    }
    
    public String getEmail() {
        return dni.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }
    
    

  
    
    
    

    
    
    
    
    
    
}
