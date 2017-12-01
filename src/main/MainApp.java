/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.model.Clase;
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
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("reservaApp");
        
        // set the application icon
        
        
        initRootLayout();

    }

    public MainApp() {
        
        claseData.add(new Clase("Biblioteca"));
        claseData.add(new Clase("Gimnasio"));
        claseData.add(new Clase("Taller"));
        claseData.add(new Clase("Aula musica"));
        claseData.add(new Clase("Aula 1"));
        claseData.add(new Clase("Aula 2"));

    }
    
     public ObservableList<Clase> getClaseData() {
        return claseData;
    }

    public void initRootLayout() {
        try {
             // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ClaseOverView.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Give the controller access to the main app.
//            RootLayoutController controller = loader.getController();
//            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

        
    } 
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
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
            //controller.setReserva(dialogStage);
            //controller.setPerson(clase);

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
  
}

