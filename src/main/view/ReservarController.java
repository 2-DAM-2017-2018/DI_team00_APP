/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    private TextField claseField;
    @FXML
    private TextField horaReservaField;
    @FXML
    private TextField horaSalidaField;
    @FXML
    private TextField nombreField;
    @FXML
    private TextField apellidosField;
    @FXML
    private TextField dniField;
    @FXML
    private TextField telefonoField;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     

}