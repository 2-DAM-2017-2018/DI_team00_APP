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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author pedro
 */
public class Clase {

    private final StringProperty nombreClase;
    private final StringProperty fechaReserva;

    public Clase() {

        this.nombreClase = new SimpleStringProperty("");
        this.fechaReserva = new SimpleStringProperty("");
        
    }

    public Clase(String nombreClase, String fechaReserva) {
        this.nombreClase = new SimpleStringProperty(nombreClase);
        this.fechaReserva = new SimpleStringProperty(fechaReserva);
        
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


    public String getFechaReserva() {
        return fechaReserva.get();
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva.set(fechaReserva);
    }

    public StringProperty fechaReservaProperty() {
        return fechaReserva;
    }

}
