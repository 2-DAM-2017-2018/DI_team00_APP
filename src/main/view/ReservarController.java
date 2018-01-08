/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.view;

import java.net.URL;
import java.time.LocalDateTime;
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
    @FXML
    private TextField dniField;
    @FXML
    private TextField telephoneField;
    @FXML
    private TextField emailField;

    private Stage dialogStage;
    private Clase clase;
    private boolean okClicked = false;
    private final String PATTERN_EMAIL
            = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$";

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
        dniField.setText(clase.getDni());
        telephoneField.setText(Integer.toString(clase.getTelephone()));
        emailField.setText(clase.getEmail());

    }

    @FXML
    private void handleOk() {
        if (isInputValid()) {
            clase.setNombreClase(claseField.getText());
            clase.setHoraReserva(horaField.getText());
           // clase.setFechaReserva(fechaField.getText());
            clase.setNombre(nombreField.getText());
            clase.setApellido(apellidosField.getText());
            clase.setDni(dniField.getText());
            clase.setTelephone(Integer.parseInt(telephoneField.getText()));
            clase.setEmail(emailField.getText());

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

        if (telephoneField.getText() == null || telephoneField.getText().length() == 0) {
            errorMessage += "Telefono no valido!\n";
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(telephoneField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Telefono no valido (debe ser un entero)!\n";
            }
        }

        if (emailField.getText() == null || emailField.getText().length() == 0) {
            errorMessage += "Email no valido!\n";
        } else {

            try {

                Pattern pattern = Pattern.compile(PATTERN_EMAIL);
                Matcher matcher = pattern.matcher(emailField.getText());
                if (!matcher.matches()) {
                    errorMessage += "Email no valido!/";
                }
            } catch (NumberFormatException e) {
                errorMessage += "Email no valido!/n";
            }
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
