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
  
    
    
    private Stage primaryStage;//Crea la primera ventana
    private AnchorPane rootLayout; //Creación de un "Anchor Pane"
    
    private ObservableList<Clase> claseData = FXCollections.observableArrayList();//Array de listas que almacena los datos de la clase 
    
    /**
     * Metodo que inicializa la aplicación
     * @param stage 
     */
    @Override
    public void start(Stage stage) 
    {
      
        this.primaryStage = stage;//Inicia la app
        this.primaryStage.setTitle("App de Reserva");//Titulo de la app
   
        initClaseOverView();//Metodo que llama a la ventana
        

    }
    /**
     * Main
     */
    public MainApp() 
    {
        claseData.add(new Clase("Aula 1", "2018-01-09", "Pedro", "08:00-09:00"));//Agregamos datos por defecto al Array
        claseData.add(new Clase("Aula 1", "2018-02-10", "Antonio", "09:00-10:00"));//Agregamos datos por defecto al Array
      
    }
    /**
     * Metodo get
     * @return Devuelve las reservas realizadas
     */
    public ObservableList<Clase> getClaseData() 
    {
        return claseData;
    }

    /**
     * Metodo que inicia la ventana clase
     */
    public void initClaseOverView() 
    {
        try 
        {
             // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/ClaseOverView.fxml"));
            rootLayout = (AnchorPane) loader.load();

            // Muestra la escena que contiene el diseño de la raíz.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            //Da el acceso al controlador a la aplicación principal.
            ClaseOverViewController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();//Lanza una excepcion es caso de error
        }

        
    } 
    
    
    
    /**
     * Inicia la ventana pulsando el boton reservar
     * @param clase objeto
     * @return devuelve la ventana
     */
    public boolean showReservar(Clase clase) 
    {
        try {
            //Cargua el archivo fxml y cree una nueva etapa para el diálogo emergente.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/Reservar.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            //Creaa el cuadro de la etapa de dialogo.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Reservar");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            //Configura a la reserva en el controlador.
            ReservarController controller = loader.getController();
            
            controller.setDialogStage(dialogStage);
            controller.setClase(clase);


            //Muestra la ventana reservar y esperar hasta que el usuario lo cierre
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Metodo get
     * @return devuelve la ventana principal
     */
    public Stage getPrimaryStage()
    {
        return primaryStage;
    }

   
    public static void main(String[] args) 
    {
        launch(args);
    }
    /**
     * Metodo get
     * @return 
     */
    public File getClaseFilePath() 
    {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        String filePath = prefs.get("filePath", null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }
    /**
     * Metodo set
     * @param file 
     */
    public void setClaseFilePath(File file) 
    {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        if (file != null) {
            prefs.put("filePath", file.getPath());

            // Actualiza el título de la etapa.
            primaryStage.setTitle("App de reserva - " + file.getName());
        } else {
            prefs.remove("filePath");

            // Actualiza el título de la etapa.
            primaryStage.setTitle("App de reserva");
        }
    }
    /**
     * Metodo que guarda los datos
     * @param file 
     */
    public void saveClaseDataToFile(File file) 
    {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(ClaseListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Envolviendo la información.
            ClaseListWrapper wrapper = new ClaseListWrapper();
            wrapper.setClases(claseData);

            //lineación y guardado de XML en el archivo.
            m.marshal(wrapper, file);

            //Guarde la ruta del archivo en el registro.
            setClaseFilePath(file);
        } catch (Exception e) 
        { // catches ANY exception
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

       } 
       catch (Exception e) 
       { // catches ANY exception
   //        Dialogs.create()
   //                .title("Error")
   //                .masthead("Could not load data from file:\n" + file.getPath())
   //                .showException(e);
       }
    }
  
}

