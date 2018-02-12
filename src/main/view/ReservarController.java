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

    @FXML
    private TextField nombreClaseField;
    @FXML
    private TextField fechaField;
    @FXML
    private TextField nombreField;
    @FXML
    private DatePicker calendario = new DatePicker();
    @FXML
    private ChoiceBox nombreClaseField2;
    @FXML
    private TextField horaField;
    @FXML
    private ChoiceBox horaField2;

    @FXML
    private ComboBox<String> listaClases;

    @FXML
    private Button ok;
    @FXML
    private Button cancelar;
    @FXML
    private Button nuevaClase;

    private Stage dialogStage;
    private Clase clase;
    private boolean okClicked = false;
    private ObservableList<String> clases = FXCollections.observableArrayList();

    public ReservarController() {

    }

    @FXML
    private void initialize() {

    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setClase(Clase clase) {
        this.clase = clase;

        //nombreClaseField.setText(clase.getNombreClase());
        nombreClaseField2.setItems(FXCollections.observableArrayList("Aula 1", "Aula 2", "Aula 3", "Aula de informática", "Taller", "Gimnasio"));
        horaField2.setItems(FXCollections.observableArrayList("08:00-09:00", "09:00-10:00", "10:00-11:00", "11:30-12:30", "12:30-13:30", "13:30-12:30", "17:00-18:00", "18:00-19:00"));
        nombreField.setText(clase.getNombre());

    }

    public boolean isOkClicked() {
        return okClicked;

    }

    @FXML
    private void handleOk() {

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

    @FXML
    private void handleCancel() {

        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";
        
        /*if () {
            errorMessage += "Nombre de clase no válido!\n"; 
        }*/
       /* if (calendario.getValue().format(DateTimeFormatter.ISO_DATE) == null || calendario.getValue().format(DateTimeFormatter.ISO_DATE).length() == 0 ) 
        {
            errorMessage += "Fecha no valida!\n"; 
        }*/
       
      //*******************************************
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

        if (errorMessage.length() == 0) {
            return true;
        } else {
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
