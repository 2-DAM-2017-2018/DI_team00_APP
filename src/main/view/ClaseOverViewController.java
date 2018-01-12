package main.view;

//import java.time.LocalDateTime;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import main.MainApp;
import main.model.Clase;

public class ClaseOverViewController {

    @FXML
    private Button reservaButton;
    
    @FXML
    private TableView<Clase> claseTable;
    @FXML
    private TableColumn<Clase, String> claseColumn;

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
        // comment
    }

    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        claseColumn.setCellValueFactory(cellData -> cellData.getValue().nombreClaseProperty());
        
        showClaseDetails(null);
        
        claseTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showClaseDetails(newValue));
        // omment
    }
    private void showClaseDetails(Clase clase){
        
        if(clase != null){
            //SEGUIR AQUI************************************************************************************************
            //****************
            //********
        }
        
    }

    @FXML
    private void handleNewReserva() {
        Clase tempclase = new Clase();
        boolean okClicked = mainApp.showReservar(tempclase);
        if (okClicked) {
            mainApp.getClaseData().add(tempclase);
        }
    }
}
