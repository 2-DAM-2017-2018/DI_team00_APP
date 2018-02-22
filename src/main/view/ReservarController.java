/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.view;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.MainApp;
import main.model.Clase;


/**
 * FXML Controller class
 *
 * @author pedro
 */
public class ReservarController {

    /**
     * Variables de clase 
     */
    @FXML
    private TextField añadirClase;
    @FXML
    private TextField nombreClaseField;//Creación de un textField 
    @FXML
    private TextField fechaField;//Creación de un textField 
    @FXML
    private TextField nombreField;//Creación de un textField 
    @FXML
    private DatePicker calendario = new DatePicker();//Creación de un DatePicker(Calendario)
    @FXML
    private ChoiceBox nombreClaseField2;//Creación de un un ChoiceBox
    @FXML
    private TextField horaField;//Creación de un TextField
    @FXML
    private ChoiceBox horaField2;//Creación de un ChoiceBox

    @FXML
    private ComboBox<String> listaClases;//Creación de un comboBox

    @FXML
    private Button ok;//Creacion del boton "ok"
    @FXML
    private Button cancelar;//Creación del boton "cancelar"
    @FXML
    private Button nuevaClase;//Creaciónd del boton "nueva clase"
    @FXML 
    private Button añadir;
    
    private Stage dialogStage;//Creación de un obejeto
    private Clase clase;//Creación de obejeto 
    private boolean okClicked = false;//Variable de tipo boleano
    private ObservableList<String> clases = FXCollections.observableArrayList();//Creación de ArrayList

    public ReservarController() {

    }

    @FXML
    private void initialize() {

    }

    /**
     * Metdo set
     * @param dialogStage establece el dialogo
     */
    public void setDialogStage(Stage dialogStage) 
    {
        this.dialogStage = dialogStage;
    }

    /**
     * Metodo set
     * @param clase 
     */
    public void setClase(Clase clase) 
    {   
        
        this.clase = clase;
        
        //Inserta los valores 
        
        nombreClaseField2.setItems(FXCollections.observableArrayList("Aula 1", "Aula 2", "Aula 3", "Aula de informática", "Taller", "Gimnasio"));
        horaField2.setItems(FXCollections.observableArrayList("08:00-09:00", "09:00-10:00", "10:00-11:00", "11:30-12:30", "12:30-13:30", "13:30-12:30", "17:00-18:00", "18:00-19:00"));
        nombreField.setText(clase.getNombre());
        

    }
    /**
     * Metodo que inicia el boton "ok"
     * @return 
     */
    public boolean isOkClicked()
    {
        return okClicked;

    }
    /**
     * Una vez presionado el boton carga los datos 
     */
    @FXML
    private void handleOk() 
    {

        if (isInputValid()) {

            clase.setNombreClase(nombreClaseField2.getValue().toString());
            String date = calendario.getValue().format(DateTimeFormatter.ISO_DATE);
            clase.setFechaReserva(date);
            clase.setHoraReserva(horaField2.getValue().toString());
            clase.setNombre(nombreField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Boton que cancela lo que se este realizando y sale de la pantalla reservar
     */
    @FXML
    private void handleCancel() 
    {

        dialogStage.close();
    }

    /**
     * Mesange de error
     * @return devielve los mensajes de error
     */
    private boolean isInputValid() 
    {
        String errorMessage = "";
       
        
        
        if(nombreClaseField2.getValue() == null)
        {
            errorMessage += "¡Nombre de clase no valido!"
                          + " Seleccione un nombre.";
        }
        if (horaField2.getValue() == null )
        {
            errorMessage += "¡Hora no valida!\n"
                          + " Seleccione una hora.";
        }
        if (nombreField.getText() == null || nombreField.getText().length() == 0) 
        {
            errorMessage += "Nombre no válido\n";
        }

        if (errorMessage.length() == 0) 
        {
            return true;
        }
        else 
        {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

}
