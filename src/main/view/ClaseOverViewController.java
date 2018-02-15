package main.view;

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

public class ClaseOverViewController 
{

    /**
     * Variables de clase
     */
    @FXML
    private Button reservaButton;//Creación de un boton
    @FXML
    private Button deleteButton;//Creación de un boton
    @FXML
    private TableView<Clase> claseTable;//Creación de una tabla
    @FXML
    private TableColumn<Clase, String> claseColumn;//Creación de una columna
    @FXML
    private TableColumn<Clase, String> fechaColumn;//Creación de una columna
    @FXML
    private TableColumn<Clase, String> horaColumn;//creación de una columna

    @FXML
    private Label nombreClaseLabel;//Label del nombre de la clase a reservar
    @FXML
    private Label fechaLabel;//Label de la fecha 
    @FXML
    private Label nombreLabel;//Label del nombre de la persona
    @FXML
    private Label horaLabel;//Label de la hora reservada
    
    private MainApp mainApp;//Main del proyecto

    public ClaseOverViewController() {

    }

    /**
     * Inicia la aplicación y carga los datos
     */
    @FXML
    private void initialize() 
    {
        //carga el nombre de la persona que reserva la clase
        claseColumn.setCellValueFactory(cellData -> cellData.getValue().nombreClaseProperty());
        //Carga la fecha en la que se ha reservado la clase
        fechaColumn.setCellValueFactory(cellData -> cellData.getValue().fechaReservaProperty());
        //Carga la hora en la que se ha resrvado la clase
        horaColumn.setCellValueFactory(cellData -> cellData.getValue().horaReservaProperty());
        showClaseDetails(null);

        claseTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showClaseDetails(newValue));
      
    }

    public void setMainApp(MainApp mainApp) 
    {
        this.mainApp = mainApp;

        claseTable.setItems(mainApp.getClaseData());

    }

    /**
     * Metodo que inicia la aplicación
     * @param clase clase de la reserva
     */
    private void showClaseDetails(Clase clase) 
    {

        if (clase != null) 
        {
            //Modifica y recoge el nuevo valor
            nombreClaseLabel.setText(clase.getNombreClase());
            fechaLabel.setText(clase.getFechaReserva());
            nombreLabel.setText(clase.getNombre());
            horaLabel.setText(clase.getHoraReserva());
        } 
        else 
        {

            //Lo deja por defecto
            nombreClaseLabel.setText("");
            fechaLabel.setText("");
            nombreLabel.setText("");
            horaLabel.setText("");
        }

    }

    /**
     * Inicia el boton para realizar una nueva reserva
     */
    @FXML
    private void handleNewReserva() 
    {
        //Creacion de objeto de clase
        Clase tempclase = new Clase();
        boolean okClicked = mainApp.showReservar(tempclase);
        //Si el boton es clicado 
        //Inicia la ventana de la reserva
        if (okClicked)
        {
            mainApp.getClaseData().add(tempclase);
        }
    }

    /**
     * Elimina la reserva seleccionada
     */
    @FXML
    private void handleDeletePerson() 
    {
        int selectedIndex = claseTable.getSelectionModel().getSelectedIndex();
        
        if (selectedIndex >= 0) 
        {
            Alert dialogoAlerta = new Alert(Alert.AlertType.CONFIRMATION);
            dialogoAlerta.setTitle("Ventana de Confirmacion");
            dialogoAlerta.setHeaderText(null);
            dialogoAlerta.initStyle(StageStyle.UTILITY);
            dialogoAlerta.setContentText("¿Realmente quieres borrar la reserva?");
            Optional<ButtonType> result = dialogoAlerta.showAndWait();
            if(result.get() == ButtonType.OK)
            {
                claseTable.getItems().remove(selectedIndex);
            }
            

        }
        else
        {
            //Nada seleccionado
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No hay nada seleccionado");
            alert.setHeaderText("No hay clases seleccionadas");
            alert.setContentText("Por favor, selecciona una clase en la tabla");

            alert.showAndWait();
        }
    }

    /**
     * Crea una nueva ventana 
     */
    @FXML
    private void handleOpen() 
    {
        FileChooser fileChooser = new FileChooser();

        //Establecer filtro de extensión
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        //Muestra el diálogo guardar archivo
        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

        if (file != null) 
        {
            mainApp.loadClaseDataFromFile(file);
        }
    }

    /**
     * Metodo que cierra la aplicación
     */
    @FXML
    private void handleExit() 
    {
        System.exit(0);
    }

    /**
     * Metodo que guarda la aplicación
     */
    @FXML
    private void handleSave() 
    {
        File claseFile = mainApp.getClaseFilePath();
        if (claseFile != null)
        {
            mainApp.saveClaseDataToFile(claseFile);
        } 
        else 
        {
            handleSaveAs();
        }
    }

    /**
     * Abre un FileChooser para permitir que el usuario seleccione un archivo para guardar.
     */
    @FXML
    private void handleSaveAs() 
    {
        FileChooser fileChooser = new FileChooser();

        // Establece filtro de extensión
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        //Muestra el dialogo al guardar el archivo
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

        if (file != null)
        {
            // Asegúra de que tenga la extensión correcta
            if (!file.getPath().endsWith(".xml")) 
            {
                file = new File(file.getPath() + ".xml");
            }
            mainApp.saveClaseDataToFile(file);
        }
    }
}
