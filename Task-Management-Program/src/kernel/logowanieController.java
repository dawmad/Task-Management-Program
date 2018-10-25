package kernel;

import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Use information specified here to login into MySQL servers as needed.
 * 
 * @author zieloni
 * @version 1.0 ALPHA
 */
public class logowanieController extends main implements Initializable {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public static String user_login;

    @FXML
    private AnchorPane rootPane;
    @FXML
    private Label login_info;
    @FXML
    public TextField login;
    @FXML
    private PasswordField haslo;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, SQLException {

        String passwordH = haslo.getText();

        if (haslo.getText().isEmpty() || login.getText().isEmpty()) {
            login_info.setText("Pola logowania są puste !");
        } else {

            con = connection.ConnectDB();
            String sql = "select * from uzytkownicy where login= '" + login.getText() + "' and haslo ='" + getHash(passwordH, "md5") + "'";
            try {
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    user_login = login.getText();

                    logged();

                    Stage stage1 = new Stage();
                    stage1.setTitle("Menu");
                    stage1.getIcons().add(new Image("image/ico.png"));
                    Parent root1 = FXMLLoader.load(getClass().getResource("FXMLs/FXML_menu.fxml"));
                    Scene scene = new Scene(root1);

                    stage1.setScene(scene);
                    stage1.show();

                    ((Node) (event.getSource())).getScene().getWindow().hide();

                } else {
                    login_info.setText("Błędne dane !");
                }
            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }
        }
    }

    @FXML
    public void logged() {
        String password = login.getText();
        String username = haslo.getText();
        try {
            con = connection.ConnectDB();

            String query1 = "Update uzytkownicy set zalogowany='1' where login=" + "'" + username + "'" + " AND haslo=" + "'" + password + "'";
            pst.executeUpdate(query1);
            pst.close();

            con.close();

        } catch (SQLException e) {
            System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
        }
    }

    @FXML
    public void handleButtonAction1(ActionEvent event) throws IOException {
        Stage stage1 = new Stage();

        Parent root1 = FXMLLoader.load(getClass().getResource("FXMLs/FXML_rejestracja.fxml"));
        Scene scene = new Scene(root1);
        stage1.setTitle("Rejestracja");
        stage1.setScene(scene);
        stage1.setMaxWidth(978);
        stage1.setMaxHeight(678);
        stage1.getIcons().add(new Image("image/ico.png"));
        stage1.show();

        ((Node) (event.getSource())).getScene().getWindow().hide();

    }

    public String getHash(String password, String hashType) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance(hashType);
            byte[] array = md.digest(password.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {

        }
        return null;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

}
