package main.view;

//import java.time.LocalDateTime;
import java.io.File;
import java.util.Optional;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.StageStyle;

import main.MainApp;
import main.model.Clase;
import org.controlsfx.dialog.Dialogs;

public class ClaseOverViewController {

    @FXML
    private Button reservaButton;
    @FXML
    private Button deleteButton;
    @FXML
    private TableView<Clase> claseTable;
    @FXML
    private TableColumn<Clase, String> claseColumn;
    @FXML
    private TableColumn<Clase, String> fechaColumn;
    @FXML
    private TableColumn<Clase, String> horaColumn;

    @FXML
    private Label nombreClaseLabel;
    @FXML
    private Label fechaLabel;
    @FXML
    private Label nombreLabel;
    @FXML
    private Label horaLabel;
    
    private MainApp mainApp;

    public ClaseOverViewController() {

    }

    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        claseColumn.setCellValueFactory(cellData -> cellData.getValue().nombreClaseProperty());
        fechaColumn.setCellValueFactory(cellData -> cellData.getValue().fechaReservaProperty());
        horaColumn.setCellValueFactory(cellData -> cellData.getValue().horaReservaProperty());
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
            nombreLabel.setText(clase.getNombre());
            horaLabel.setText(clase.getHoraReserva());
        } else {

            nombreClaseLabel.setText("");
            fechaLabel.setText("");
            nombreLabel.setText("");
            horaLabel.setText("");
        }

    }

    @FXML
    private void handleNewReserva() {
        Clase tempclase = new Clase();
        //boolean okClicked = mainApp.showReservar(tempclase);
        boolean okClicked = mainApp.showReservar(tempclase);
        if (okClicked) {
            mainApp.getClaseData().add(tempclase);
        }
    }

    @FXML
    private void handleDeletePerson() {
        int selectedIndex = claseTable.getSelectionModel().getSelectedIndex();
        
        if (selectedIndex >= 0) {
            Alert dialogoAlerta = new Alert(Alert.AlertType.CONFIRMATION);
            dialogoAlerta.setTitle("Ventana de Confirmacion");
            dialogoAlerta.setHeaderText(null);
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            dialogoAlerta.setContentText("¿Realmente quieres borrar la reserva?");
            Optional<ButtonType> result = dialogoAlerta.showAndWait();
            if(result.get() == ButtonType.OK){
                claseTable.getItems().remove(selectedIndex);
            }
            

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No hay nada seleccionado");
            alert.setHeaderText("No hay clases seleccionadas");
            alert.setContentText("Por favor, selecciona una clase en la tabla");

            alert.showAndWait();
        }
    }

    /**
     * Creates an empty address book.
     */
    @FXML
    private void handleOpen() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

        if (file != null) {
            mainApp.loadClaseDataFromFile(file);
        }
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }

    @FXML
    private void handleSave() {
        File claseFile = mainApp.getClaseFilePath();
        if (claseFile != null) {
            mainApp.saveClaseDataToFile(claseFile);
        } else {
            handleSaveAs();
        }
    }

    /**
     * Opens a FileChooser to let the user select a file to save to.
     */
    @FXML
    private void handleSaveAs() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            mainApp.saveClaseDataToFile(file);
        }
    }
}
