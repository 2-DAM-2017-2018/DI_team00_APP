/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.view;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.model.Clase;

/**
 * FXML Controller class
 *
 * @author pedro
 */
public class ReservarController {

    @FXML
    private SplitMenuButton claseField;
    @FXML
    private SplitMenuButton horaField;
    @FXML
    private DatePicker fechaField;
    @FXML
    private TextField nombreField;
    @FXML
    private TextField apellidosField;
    

    private Stage dialogStage;
    private Clase clase;
    private boolean okClicked = false;
    

    @FXML
    private void initialize() {
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isOkClicked() {
        return okClicked;

    }

    public void setClase(Clase clase) {
        this.clase = clase;

        claseField.setText(clase.getNombreClase());
        horaField.setText(clase.getHoraReserva());
        //fechaField.setText(clase.getFechaReserva()); 
        nombreField.setText(clase.getNombre());
        apellidosField.setText(clase.getApellido());
        

    }

    @FXML
    private void handleOk() {
        
        ArrayList<Clase> listaClasesReservadas = new ArrayList<>();
        
        if (isInputValid()) {
            clase.setNombreClase(claseField.getText());
            clase.setHoraReserva(horaField.getText());
           // clase.setFechaReserva(fechaField.getText());
            clase.setNombre(nombreField.getText());
            clase.setApellido(apellidosField.getText());
            
            
            listaClasesReservadas.add(clase);
        }
    }

    @FXML
    public void handleAñadirClase() {

    }

    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (horaField.getText() == null || horaField.getText().length() == 0) {
            errorMessage += "Hora de reserva no valida!\n";
        }

        if (claseField.getText() == null || claseField.getText().length() == 0) {
            errorMessage += "Clase no valida!\n";
        }

        if (nombreField.getText() == null || nombreField.getText().length() == 0) {
            errorMessage += "Nombre no valido!\n";
        }

        if (apellidosField.getText() == null || apellidosField.getText().length() == 0) {
            errorMessage += "Apellido no valido!\n";
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
