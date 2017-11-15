/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.view.ClaseOverViewController;
/**
 *
 * @author pedro
 */
public class App_ReservaClases extends Application {
    private Stage primaryStage;
    private AnchorPane rootLayout;
    
    @Override
    public void start(Stage primaryStage){
        
         this.primaryStage = primaryStage;
         this.primaryStage.setTitle("ReservaClases");
         
         initRootLayout();
        
    }

    public App_ReservaClases() {

    }
    
    public static void main(String[] args) {
         launch(args);
    }

    private void initRootLayout() {
        
        try {
             // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App_ReservaClases.class.getResource("view/ClaseOverView.fxml"));
            rootLayout = (AnchorPane)loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
}
