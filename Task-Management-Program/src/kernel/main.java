package kernel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
//test IDK 
/**
 * Two important instruments have been created in this area, 
 * namely the Competitiveness and Innovation Framework Programme 
 * and the Green Programme.
 * 
 * @author zieloni
 * @version 1.0 ALPHA
 */
public class main extends Application {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    public static Stage Gstage;

    @Override
    public void start(Stage Gstage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLs/FXML_logowanie.fxml"));
        Scene scene = new Scene(root);
        Gstage.setMaxWidth(858);
        Gstage.setMaxHeight(801);
        Gstage.setTitle("Logowanie do systemu");
        Gstage.setScene(scene);
        Gstage.show();
        Gstage.getIcons().add(new Image("image/ico.png"));
    }
    
    public static void main(String[] args) {
        launch(args);

    }

}
