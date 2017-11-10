
package app_reserva_view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ClaseOverViewController {
    
     @FXML
    private TableView<Clases> clasesTable;
    @FXML
    private TableColumn<Clases, String> clasesColumn;
    
    @FXML
    private Button reservaButton;
    
}
