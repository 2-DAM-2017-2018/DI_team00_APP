/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calendario;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.util.StringConverter;



/**
 *
 * @author Dani
 */
public class DatePickerController 
{
    //Creo el DatePicker
    @FXML
    private DatePicker datePicker = new DatePicker ();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
    
    @FXML
    public void initialize(URL url, ResourceBundle rb)
    {
        datePicker.setConverter(new StringConverter<LocalDate>()
        {
            @Override
            public String toString(LocalDate t) 
            {
                if(t != null)
                {
                    return formatter.format(t);
                }
                return null;
            }

            @Override
            public LocalDate fromString(String string) 
            {
                if(string != null && !string.trim().isEmpty())
                {
                    return LocalDate.parse(string, formatter);
                }
                return null;
                
            }
            
        });
        
        datePicker.setOnAction((ActionEvent event ) ->
        {
            System.out.println(formatter.format(datePicker.getValue()));
        });
    }
    
}
 

    
    
    
