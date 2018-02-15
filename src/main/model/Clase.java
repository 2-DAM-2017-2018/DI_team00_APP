/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.model;

import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author pedro
 */
public class Clase 
{

    /**
     * Declaración de variables de clase 
     */
    private final StringProperty nombreClase;//Variable de tipo String
    private final StringProperty fechaReserva;//Variable de tipo String
    private final StringProperty nombre;//Variable de tipo String
    private final StringProperty hora;//Variable de tipo String

    /**
     * Cosntructor por defecto
     */
    public Clase() 
    {

        this.nombreClase = new SimpleStringProperty("");
        this.fechaReserva = new SimpleStringProperty("");
        this.nombre = new SimpleStringProperty("");
        this.hora = new SimpleStringProperty("");
        
    }
    /**
     * Constructor con parametros 
     * @param nombreClase nombre de la clase
     * @param fechaReserva fecha en la que se reserva la clase
     * @param nombre nombre de la persona que reserva la clase
     * @param hora hora de la reserva de la clase
     */

    public Clase(String nombreClase, String fechaReserva, String nombre, String hora) 
    {
        
        this.nombreClase = new SimpleStringProperty(nombreClase);
        this.fechaReserva = new SimpleStringProperty(fechaReserva);
        this.nombre = new SimpleStringProperty(nombre);
        this.hora = new SimpleStringProperty(hora);
        
    }
    /**
     * Metodos get y set
     * 
     */
    public String getNombreClase()
    {
        return nombreClase.get();
    }
    public void setNombreClase(String nombreClase)
    {
        this.nombreClase.set(nombreClase);
    }

    public StringProperty nombreClaseProperty() 
    {
        return nombreClase;
    }


    public String getFechaReserva() 
    {
        return fechaReserva.get();
    }

    public void setFechaReserva(String fechaReserva) 
    {
        this.fechaReserva.set(fechaReserva);
    }

    public StringProperty fechaReservaProperty() 
    {
        return fechaReserva;
    }
    
    public String getHoraReserva() 
    {
        return hora.get();
    }

    public void setHoraReserva(String hora)
    {
        this.hora.set(hora);
    }

    public StringProperty horaReservaProperty() 
    {
        return hora;
    }
    
    public String getNombre() 
    {
        return nombre.get();
    }

    public void setNombre(String nombre)
    {
        this.nombre.set(nombre);
    }

    public StringProperty nombreProperty() 
    {
        return nombre;
    }
    
    
    

}
