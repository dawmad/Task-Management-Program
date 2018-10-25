package kernel;

import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * You can add projects to an existing User using its context menu.
 * 
 * @author zieloni
 * @version 1.0 ALPHA
 */
public class menuController implements Initializable {

    public static String id;
    public static String uprawnienia;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    String uprawnienia_low =  "";
    
    @FXML
    public Label login1;
    @FXML
    private Label button_test;
    @FXML
    public ListView list1;
    @FXML
    private ListView list2;
    @FXML
    public Pane nowy_projekt;
    @FXML
    public TextField nazwa_projektu;

    String user_login = logowanieController.user_login;

    @FXML
    public void nowy_projekt_press(ActionEvent event) {
        nowy_projekt.setVisible(true);
    }

    @FXML
    public void projekt_wyjscie(ActionEvent event) {
        nowy_projekt.setVisible(false);
    }

    @FXML
    public void utworz_projekt(ActionEvent event) throws SQLException {

        if (nazwa_projektu.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Nowy projekt");
            alert.setHeaderText("Błąd !");
            alert.setContentText("Błędna nazwa projektu.");
            alert.showAndWait();
        } else {
            try {
                String sql1 = "INSERT INTO projekty(admin_login, nazwa ,okno_1,okno_2,okno_3,okno_4) VALUES"
                        + " ('" + user_login + "','" + nazwa_projektu.getText() + "','Do zrobienia','Do poprawki','Testowane','Zrobione')";
                pst = con.prepareStatement(sql1);
                pst.executeUpdate(sql1);
                pst.close();

            } catch (SQLException e) {
                System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
            }
            
            
            String temp="";
            String yay= "";
            try {
                con = connection.ConnectDB();
                String sql = "SELECT id from projekty ORDER BY id DESC LIMIT 1;";

                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {

                    temp = rs.getString("id");  
                }
               

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }
            System.out.println(temp);

            try {
                con = connection.ConnectDB();
                String sql1 = "INSERT INTO `projekty_data` (`id`, `okno_1_1_title`, `okno_1_1_user`, `okno_1_1_data`, `okno_2_1_text`, `okno_1_1_color`, `okno_1_2_color`, `okno_1_2_data`, `okno_1_2_text`, `okno_1_2_title`, `okno_1_2_user`, `okno_1_3_color`, `okno_1_3_data`, `okno_1_3_text`, `okno_1_3_title`, `okno_1_3_user`, `okno_1_4_color`, `okno_1_4_data`, `okno_1_4_text`, `okno_1_4_title`, `okno_1_4_user`, `okno_1_1_text`, `okno_2_1_title`, `okno_2_1_user`, `okno_2_1_data`, `okno_2_1_color`, `okno_2_2_color`, `okno_2_2_data`, `okno_2_2_text`, `okno_2_2_title`, `okno_2_2_user`, `okno_2_3_color`, `okno_2_3_data`, `okno_2_3_text`, `okno_2_3_title`, `okno_2_3_user`, `okno_2_4_color`, `okno_2_4_data`, `okno_2_4_text`, `okno_2_4_title`, `okno_2_4_user`, `okno_3_1_color`, `okno_3_1_data`, `okno_3_1_text`, `okno_3_1_title`, `okno_3_1_user`, `okno_3_2_color`, `okno_3_2_data`, `okno_3_2_text`, `okno_3_2_title`, `okno_3_2_user`, `okno_3_3_color`, `okno_3_3_data`, `okno_3_3_text`, `okno_3_3_title`, `okno_3_3_user`, `okno_3_4_color`, `okno_3_4_data`, `okno_3_4_text`, `okno_3_4_title`, `okno_3_4_user`, `okno_4_1_color`, `okno_4_1_data`, `okno_4_1_text`, `okno_4_1_title`, `okno_4_1_user`, `okno_4_2_color`, `okno_4_2_data`, `okno_4_2_text`, `okno_4_2_title`, `okno_4_2_user`, `okno_4_3_color`, `okno_4_3_data`, `okno_4_3_text`, `okno_4_3_title`, `okno_4_3_user`, `okno_4_4_color`, `okno_4_4_data`, `okno_4_4_text`, `okno_4_4_title`, `okno_4_4_user`) VALUES\n" +
                "('"+temp+"', '','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','','')";
                
                pst = con.prepareStatement(sql1);
                pst.executeUpdate(sql1);
                pst.close();

            } catch (SQLException e) {
                System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
            }
          
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Nowy projekt");
            alert.setHeaderText("Sukces !");
            alert.setContentText("Projekt zotał utworzony.");
            alert.showAndWait();

            nowy_projekt.setVisible(false);

            wczytajProjekty();
        }

    }

    @FXML
    public void wyloguj(ActionEvent event) throws IOException {
        button_test.setText("Wyloguj");
        Stage stage = new Stage();
        stage.setTitle("Logowanie do systemu");
        Parent root = FXMLLoader.load(getClass().getResource("FXMLs/FXML_logowanie.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        ((Node) (event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    public void wczytaj_projekt_press(ActionEvent event) throws IOException {
          System.out.println("clicked on " + list2.getSelectionModel().getSelectedItem());
        button_test.setText("Wczytaj projekt");

        String project_name = "";
        
        try {
        String first = list1.getSelectionModel().getSelectedItem().toString();
        project_name = first;
        uprawnienia = "Admin";
        }
        catch ( Exception err ) {
        System.out.println( err.getMessage( ) );
        String second = list2.getSelectionModel().getSelectedItem().toString();
        project_name = second;
        uprawnienia = uprawnienia_low;
        }
        
        
        con = connection.ConnectDB();
        String sql = "select id from projekty where nazwa = '" + project_name + "' ";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("id");
                id = add1;
            }
            Stage stage = new Stage();
            stage.setTitle("System zarządzania");
            Parent root = FXMLLoader.load(getClass().getResource("FXMLs/FXML_projekt.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            ((Node) (event.getSource())).getScene().getWindow().hide();

        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
    }

    public void wczytajProjektyUczestnik(){
        con = connection.ConnectDB();
    
        String id_projektu = "";
       
        String sql = "select * from projekty_uzytkownik where login = '" + user_login + "' ";

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                id_projektu = rs.getString("id_projektu");
                uprawnienia_low = rs.getString("uprawnienia");
               
            }

        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
        
      List<String> results = new ArrayList<>();

        con = connection.ConnectDB();
        String sql2 = "select * from projekty where id = '" + id_projektu + "' ";
        try {
            pst = con.prepareStatement(sql2);
            rs = pst.executeQuery();
            while (rs.next()) {
                results.add(rs.getString("nazwa"));
            }

            ObservableList<String> ids = FXCollections.observableArrayList(results);
            list2.setItems(ids);

        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }  
        
        
    }
    public void wczytajProjekty() {
        List<String> results = new ArrayList<>();

        con = connection.ConnectDB();
        String sql = "select * from projekty where admin_login = '" + user_login + "' ";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                results.add(rs.getString("nazwa"));
            }

            ObservableList<String> ids = FXCollections.observableArrayList(results);
            list1.setItems(ids);
            

        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        login1.setText(user_login);

        nowy_projekt.setVisible(false);

        wczytajProjekty();
        wczytajProjektyUczestnik();

    }

}
