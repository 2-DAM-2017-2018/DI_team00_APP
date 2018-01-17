package main.view;

//import java.time.LocalDateTime;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    @FXML
    private TableColumn<Clase, String> fechaColumn;

    @FXML
    private Label nombreClaseLabel;
    @FXML
    private Label fechaLabel;
    
    
    private MainApp mainApp;

    public ClaseOverViewController() {

    }

    

    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        claseColumn.setCellValueFactory(cellData -> cellData.getValue().nombreClaseProperty());
        fechaColumn.setCellValueFactory(cellData -> cellData.getValue().fechaReservaProperty());
        showClaseDetails(null);

        claseTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showClaseDetails(newValue));
        // omment
    }
    
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        claseTable.setItems(mainApp.getClaseData());

        // comment
    }
    

    private void showClaseDetails(Clase clase) {

        if (clase != null) {
            nombreClaseLabel.setText(clase.getNombreClase());
            fechaLabel.setText(clase.getFechaReserva());
        } else {

            nombreClaseLabel.setText("");
            fechaLabel.setText("");
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

    @FXML
    private void handleDeletePerson() {
        int selectedIndex = claseTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            claseTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }
}
