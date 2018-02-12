/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.prefs.Preferences;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import main.model.Clase;
import main.model.ClaseListWrapper;
import main.view.ClaseOverViewController;
import main.view.ReservarController;
/**
 *
 * @author pedro
 */
public class MainApp extends Application {
  
    
    
    private Stage primaryStage;
    private AnchorPane rootLayout;
    
    private ObservableList<Clase> claseData = FXCollections.observableArrayList();
    
    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;
        this.primaryStage.setTitle("App de Reserva");
        
        // set the application icon
        
        
        initClaseOverView();
        

    }

    public MainApp() {
        claseData.add(new Clase("Aula 1", "2018-01-09", "Pedro", "08:00-09:00"));
        claseData.add(new Clase("Aula 1", "2018-02-10", "Antonio", "09:00-10:00"));
       
        

    }
    
     public ObservableList<Clase> getClaseData() {
        return claseData;
    }

    public void initClaseOverView() {
        try {
             // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ClaseOverView.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            ClaseOverViewController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        
    } 
    
    
    
    
    public boolean showReservar(Clase clase) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Reservar.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Reservar");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            ReservarController controller = loader.getController();
            
            controller.setDialogStage(dialogStage);
            controller.setClase(clase);

            // Set the dialog icon.
    //        dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public File getClaseFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }
    
    public void setClaseFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

            // Update the stage title.
            primaryStage.setTitle("App de reserva - " + file.getName());
        } else {
            prefs.remove("filePath");

            // Update the stage title.
            primaryStage.setTitle("App de reserva");
        }
    }
    
    public void saveClaseDataToFile(File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(ClaseListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our person data.
            ClaseListWrapper wrapper = new ClaseListWrapper();
            wrapper.setClases(claseData);

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, file);

            // Save the file path to the registry.
            setClaseFilePath(file);
        } catch (Exception e) { // catches ANY exception
    //                Dialogs.create().title("Error")
    //                .masthead("Could not save data to file:\n" + file.getPath())
    //                .showException(e);
        }
    }
    
    public void loadClaseDataFromFile(File file) {
       try {
           JAXBContext context = JAXBContext
                   .newInstance(ClaseListWrapper.class);
           Unmarshaller um = context.createUnmarshaller();

           // Reading XML from the file and unmarshalling.
           ClaseListWrapper wrapper = (ClaseListWrapper) um.unmarshal(file);

           claseData.clear();
           claseData.addAll(wrapper.getClase());

           // Save the file path to the registry.
           setClaseFilePath(file);

       } catch (Exception e) { // catches ANY exception
   //        Dialogs.create()
   //                .title("Error")
   //                .masthead("Could not load data from file:\n" + file.getPath())
   //                .showException(e);
       }
    }
  
}

