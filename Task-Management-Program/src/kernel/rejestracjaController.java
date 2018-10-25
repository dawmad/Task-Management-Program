package kernel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * 
 * @author zieloni
 * @version 1.0 ALPHA
 */
public class rejestracjaController {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    @FXML
    private TextField imie;
    @FXML
    private TextField nazwisko;
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField password2;
    Stage stage2 = new Stage();

    @FXML
    private void actionback(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();

        Stage stage1 = new Stage();
        stage1.setTitle("Logowanie do systemu");
        Parent root1 = FXMLLoader.load(getClass().getResource("FXMLs/FXML_logowanie.fxml"));
        Scene scene = new Scene(root1);
        stage1.setMaxWidth(858);
        stage1.setMaxHeight(801);
        stage1.setScene(scene);
        stage1.getIcons().add(new Image("image/ico.png"));
        stage1.show();

    }

    @FXML

    private void rejestruj(ActionEvent event) throws IOException, SQLException {
        String loginS = login.getText();
        con = connection.ConnectDB();

        if (imie.getText().equals("") || nazwisko.getText().equals("") || login.equals("") || password.getText().equals("")) {

            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Rejestracja");
            alert.setHeaderText("Błąd !");
            alert.setContentText("Uzupełnij wszystkie pola.");
            alert.showAndWait();

        } else {
            String sql = "Select * from  uzytkownicy where login = '" + loginS + "' ";
            try {
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();

                if (rs.next()) {

                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Rejestracja");
                    alert.setHeaderText("Błąd !");
                    alert.setContentText("Login jest zajęty.");

                    alert.showAndWait();

                } else {
                    con = connection.ConnectDB();
                    String passwordH = password2.getText();
                    if (password2.getText().equals(password.getText())) {

                        try {

                            String sql1 = "INSERT INTO uzytkownicy(imie ,nazwisko,login,haslo,zalogowany) VALUES"
                                    + " ('" + imie.getText() + "','" + nazwisko.getText() + "','" + login.getText() + "','" + getHash(passwordH, "MD5") + "','" + 0 + "')";
                            pst = con.prepareStatement(sql1);
                            pst.executeUpdate(sql1);
                            pst.close();

                            Alert alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Rejestracja");
                            alert.setHeaderText("Sukces !");
                            alert.setContentText("Możesz już się zalogować.");

                            alert.showAndWait();

                            //konto zalozone zamykam okno i otwieram logowanie 
                            ((Node) (event.getSource())).getScene().getWindow().hide();

                            Stage stage1 = new Stage();
                            stage1.setTitle("Logowanie do systemu");
                            Parent root1 = FXMLLoader.load(getClass().getResource("FXMLs/FXML_logowanie.fxml"));
                            Scene scene = new Scene(root1);
                            stage1.setMaxWidth(858);
                            stage1.setMaxHeight(801);
                            stage1.setScene(scene);
                            stage1.getIcons().add(new Image("image/ico.png"));
                            stage1.show();

                        } catch (SQLException e) {
                            System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                        }
                    } else {
                        Alert alert = new Alert(AlertType.WARNING);
                        alert.setTitle("Rejestracja");
                        alert.setHeaderText("Błąd !");
                        alert.setContentText("Hasła różnią się");

                        alert.showAndWait();

                    }
                }
            } catch (SQLException e) {
                System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
            }
        }
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
            //error action
        }
        return null;
    }

}
