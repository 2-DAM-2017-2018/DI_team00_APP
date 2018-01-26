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
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
        
        nombreClaseField.setText(clase.getNombreClase());
        fechaField.setText(clase.getFechaReserva());
        nombreField.setText(clase.getNombre());
        

    }
    
    public boolean isOkClicked() {
        return okClicked;

    }

    @FXML
    private void handleOk() {
        
        if (isInputValid()) {
            
            clase.setNombreClase(nombreClaseField.getText());
            clase.setFechaReserva(fechaField.getText());
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

        if (nombreClaseField.getText() == null || nombreClaseField.getText().length() == 0) {
            errorMessage += "Nombre de clase no válido!\n"; 
        }
        if (fechaField.getText() == null || fechaField.getText().length() == 0 ) {
            errorMessage += "Fecha no valida!\n"; 
        }
        
        if (nombreField.getText() == null || nombreField.getText().length() == 0) {
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
