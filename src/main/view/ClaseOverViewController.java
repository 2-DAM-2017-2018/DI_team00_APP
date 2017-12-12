package main.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

import main.MainApp;
import main.model.Clase;

public class ClaseOverViewController {

    @FXML
    private Button reservaButton;

    @FXML
    private TableColumn<Clase, String> claseColumn;

    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        claseColumn.setCellValueFactory(cellData -> cellData.getValue().nombreClaseProperty());
        // omment
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
