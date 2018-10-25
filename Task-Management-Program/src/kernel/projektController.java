package kernel;

import java.awt.Desktop.Action;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import java.io.FileOutputStream;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.lang.reflect.Member;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

/**
 * With this wide range of stakeholders we are working together to implement the
 * plan and are developing the coordination and cooperation mechanisms to do so.
 *
 * @author zieloni
 */
public class projektController implements Initializable {

    String user_login = logowanieController.user_login;
    String id = menuController.id;
    String edycja = "";
    String edycja_zapisz = "";
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    public static final String IMAGE = "src/image/PDF.png";

    private static Font opis = FontFactory.getFont("c:/Windows/Fonts/Calibri.ttf",
    BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 14, Font.NORMAL, BaseColor.WHITE);
    
    @FXML public Pane czat;
    @FXML public Pane ustawienia_okna;
    @FXML public Pane dodaj_notatke;
    @FXML public Label okno_1_title;
    @FXML public Label okno_2_title;
    @FXML public Label okno_3_title;
    @FXML public Label okno_4_title;
    @FXML public ChoiceBox notatki;
    @FXML public TextField tytul_edycja;
    @FXML public TextArea opis_edycja;
    @FXML public ChoiceBox miejsce_docelowe;
    @FXML public TextField dodaj_tytul;
    @FXML public TextArea dodaj_opis_st;
    @FXML public RadioButton kolor_1;
    @FXML public RadioButton kolor_2;
    @FXML public RadioButton kolor_3;
    @FXML public RadioButton kolor_4;
    @FXML public TextFlow czat_zes;
    @FXML public TextField czat_wiad;
    @FXML public AnchorPane czat_fix;
    
    @FXML public Pane PDF;
    @FXML public Button dodaj_1;
    @FXML public Button edycja_1;
    @FXML public Button dodaj_2;
    @FXML public Button edycja_2;
    @FXML public Button dodaj_3;
    @FXML public Button edycja_3;
    @FXML public Button dodaj_4;
    @FXML public Button edycja_4;
    @FXML public ImageView PDF_back;
    @FXML public Label system_time;
    @FXML public Label panel_user_name;
    @FXML public Pane uzytkownicy_okno;
    @FXML public Pane ustawienia_okno;
    @FXML public Label project_name;
    @FXML public TextField uzytkownik_login;
    @FXML public ChoiceBox uzytkownik_uprawnienia;
    @FXML public Button users_window_1;
    @FXML public Button settings_window_1;
    @FXML public ChoiceBox ustawienia_edycja_okno;
    @FXML public TextField ustawienia_edycja_nazwa;
    
    
    //okno 1_1
    @FXML public Pane okno_1_1_pane;
    @FXML public Label okno_1_1_title;
    @FXML public Label okno_1_1_data;
    @FXML public Label okno_1_1_user;
    @FXML public TextArea okno_1_1_text;
    @FXML public Pane okno_1_1_color;

    //okno 1_2
    @FXML public Label okno_1_2_title;
    @FXML public Label okno_1_2_data;
    @FXML public Label okno_1_2_user;
    @FXML public TextArea okno_1_2_text;
    @FXML public Pane okno_1_2_color;
    @FXML public Pane okno_1_2_pane;

    //okno 1_3
    @FXML public Label okno_1_3_title;
    @FXML public Label okno_1_3_data;
    @FXML public Label okno_1_3_user;
    @FXML public TextArea okno_1_3_text;
    @FXML public Pane okno_1_3_color;
    @FXML public Pane okno_1_3_pane;

    //okno 1_4
    @FXML public Label okno_1_4_title;
    @FXML public Label okno_1_4_data;
    @FXML public Label okno_1_4_user;
    @FXML public TextArea okno_1_4_text;
    @FXML public Pane okno_1_4_color;
    @FXML public Pane okno_1_4_pane;

    //okno 2_1
    @FXML public Pane okno_2_1_pane;
    @FXML public Label okno_2_1_title;
    @FXML public Label okno_2_1_data;
    @FXML public Label okno_2_1_user;
    @FXML public TextArea okno_2_1_text;
    @FXML public Pane okno_2_1_color;

    //okno 2_2
    @FXML public Label okno_2_2_title;
    @FXML public Label okno_2_2_data;
    @FXML public Label okno_2_2_user;
    @FXML public TextArea okno_2_2_text;
    @FXML public Pane okno_2_2_color;
    @FXML public Pane okno_2_2_pane;

    //okno 2_3
    @FXML public Label okno_2_3_title;
    @FXML public Label okno_2_3_data;
    @FXML public Label okno_2_3_user;
    @FXML public TextArea okno_2_3_text;
    @FXML public Pane okno_2_3_color;
    @FXML public Pane okno_2_3_pane;

    //okno 2_4
    @FXML public Label okno_2_4_title;
    @FXML public Label okno_2_4_data;
    @FXML public Label okno_2_4_user;
    @FXML public TextArea okno_2_4_text;
    @FXML public Pane okno_2_4_color;
    @FXML public Pane okno_2_4_pane;

    //okno 3_1
    @FXML public Pane okno_3_1_pane;
    @FXML public Label okno_3_1_title;
    @FXML public Label okno_3_1_data;
    @FXML public Label okno_3_1_user;
    @FXML public TextArea okno_3_1_text;
    @FXML public Pane okno_3_1_color;

    //okno 3_2
    @FXML public Label okno_3_2_title;
    @FXML public Label okno_3_2_data;
    @FXML public Label okno_3_2_user;
    @FXML public TextArea okno_3_2_text;
    @FXML public Pane okno_3_2_color;
    @FXML public Pane okno_3_2_pane;

    //okno 3_3
    @FXML public Label okno_3_3_title;
    @FXML public Label okno_3_3_data;
    @FXML public Label okno_3_3_user;
    @FXML public TextArea okno_3_3_text;
    @FXML public Pane okno_3_3_color;
    @FXML public Pane okno_3_3_pane;

    //okno 3_4
    @FXML public Label okno_3_4_title;
    @FXML public Label okno_3_4_data;
    @FXML public Label okno_3_4_user;
    @FXML public TextArea okno_3_4_text;
    @FXML public Pane okno_3_4_color;
    @FXML public Pane okno_3_4_pane;

    //okno 4_1
    @FXML public Pane okno_4_1_pane;
    @FXML public Label okno_4_1_title;
    @FXML public Label okno_4_1_data;
    @FXML public Label okno_4_1_user;
    @FXML public TextArea okno_4_1_text;
    @FXML public Pane okno_4_1_color;

    //okno 4_2
    @FXML public Label okno_4_2_title;
    @FXML public Label okno_4_2_data;
    @FXML public Label okno_4_2_user;
    @FXML public TextArea okno_4_2_text;
    @FXML public Pane okno_4_2_color;
    @FXML public Pane okno_4_2_pane;

    //okno 4_3
    @FXML public Label okno_4_3_title;
    @FXML public Label okno_4_3_data;
    @FXML public Label okno_4_3_user;
    @FXML public TextArea okno_4_3_text;
    @FXML public Pane okno_4_3_color;
    @FXML public Pane okno_4_3_pane;

    //okno 4_4
    @FXML public Label okno_4_4_title;
    @FXML public Label okno_4_4_data;
    @FXML public Label okno_4_4_user;
    @FXML public TextArea okno_4_4_text;
    @FXML public Pane okno_4_4_color;
    @FXML public Pane okno_4_4_pane;

    public void czat_init() {
        
       
        String login_czat;
        String text_czat;
        String data_czat;
                
        double wysokosc = 0;
        try {
                con = connection.ConnectDB();
                String sql = "select * from czat where id = '" + id + "' ";

                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {

                    
                    login_czat = rs.getString("login");
                    text_czat = rs.getString("text");
                    data_czat = rs.getString("data");
                    
                    Text login = new Text(login_czat+": ");
                    login.setStyle("-fx-font-weight: bold");

                    Text text = new Text(text_czat + System.lineSeparator()+ System.lineSeparator());
                    text.setStyle("-fx-font-weight: regular");
                    
                    Text data = new Text(data_czat + System.lineSeparator());
                    data.setStyle("-fx-font-size: 8");

                    
                    
                    czat_zes.getChildren().addAll(data,login, text);
                    
                    wysokosc = czat_zes.getHeight();
                    czat_fix.setMinHeight(wysokosc+10);
                   
                }

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }

        

    }

    @FXML
    public void czat_wyslij(ActionEvent event) throws IOException {
        
    String wiadomosc = czat_wiad.getText();
    String time = new SimpleDateFormat("dd.MM.yyy HH:mm").format(Calendar.getInstance().getTime());

     try {
             con = connection.ConnectDB();
             String sql1 = "INSERT INTO czat(id,login ,text,data) VALUES"
                                    + " ('"+id+"', '" +user_login+ "','" +wiadomosc+ "','" +time+ "')";
                            pst = con.prepareStatement(sql1);
                            pst.executeUpdate(sql1);
                            pst.close();
             
             } catch (SQLException e) {
                            System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                        }
     

     czat_zes.getChildren().clear();
     czat_init();
     czat_wiad.clear();
        
        
    }
    //POTRZEBNE DO OBSŁUGI METOD (NOTATKI)
    String text_number = "";
    String title_number = "";

    String window_title = "";

    // OKNO DODAJ - DODAWANIE NOWEJ NOTATKI
    @FXML
    public void dodaj_zamknij(ActionEvent event) throws IOException {
        dodaj_notatke.setVisible(false);
    }

    @FXML
    public void dodaj_zapisz(ActionEvent event) throws IOException {
        String title1 = "";
        String title2 = "";
        String title3 = "";
        String title4 = "";

        String dodaj_tytul_string, dodaj_opis_string;

        String kolor = "black";
        String time = new SimpleDateFormat("dd.MM.yyy HH:mm").format(Calendar.getInstance().getTime());

        if (kolor_1.isSelected() == true) {
            kolor = "red";
        } else if (kolor_2.isSelected() == true) {
            kolor = "blue";
        } else if (kolor_3.isSelected() == true) {
            kolor = "green";
        } else if (kolor_4.isSelected() == true) {
            kolor = "grey";
        }

        if (dodaj_numer == 1) {

            try {
                con = connection.ConnectDB();
                String sql = "select * from projekty_data where id = '" + id + "' ";

                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {

                    title1 = rs.getString("okno_1_1_title");
                    title2 = rs.getString("okno_1_2_title");
                    title3 = rs.getString("okno_1_3_title");
                    title4 = rs.getString("okno_1_4_title");

                }

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }

            if (title1.isEmpty()) {
                dodaj_tytul_string = dodaj_tytul.getText();
                dodaj_opis_string = dodaj_opis_st.getText();

                try {
                    con = connection.ConnectDB();

                    String query1 = "update projekty_data set okno_1_1_title = '" + dodaj_tytul_string + "', okno_1_1_user = '" + user_login + "', okno_1_1_data = '" + time + "', okno_1_1_text = '" + dodaj_opis_string + "', okno_1_1_color = '" + kolor + "'    where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);
                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Sukces");
                    alert.setHeaderText("Dodano !");
                    alert.setContentText("Dodano notatkę numer 1.");
                    alert.showAndWait();
                    okno_1_init();
                } catch (SQLException e) {
                    System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                }

            } else if (title2.isEmpty()) {
                dodaj_tytul_string = dodaj_tytul.getText();
                dodaj_opis_string = dodaj_opis_st.getText();

                try {
                    con = connection.ConnectDB();

                    String query1 = "update projekty_data set okno_1_2_title = '" + dodaj_tytul_string + "', okno_1_2_user = '" + user_login + "', okno_1_2_data = '" + time + "', okno_1_2_text = '" + dodaj_opis_string + "', okno_1_2_color = '" + kolor + "'    where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);
                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Sukces");
                    alert.setHeaderText("Dodano !");
                    alert.setContentText("Dodano notatkę numer 2.");
                    alert.showAndWait();
                    okno_1_init();

                } catch (SQLException e) {
                    System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                }

            } else if (title3.isEmpty()) {
                dodaj_tytul_string = dodaj_tytul.getText();
                dodaj_opis_string = dodaj_opis_st.getText();

                try {
                    con = connection.ConnectDB();

                    String query1 = "update projekty_data set okno_1_3_title = '" + dodaj_tytul_string + "', okno_1_3_user = '" + user_login + "', okno_1_3_data = '" + time + "', okno_1_3_text = '" + dodaj_opis_string + "', okno_1_3_color = '" + kolor + "'    where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);
                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Sukces");
                    alert.setHeaderText("Dodano !");
                    alert.setContentText("Dodano notatkę numer 3.");
                    alert.showAndWait();
                    okno_1_init();
                } catch (SQLException e) {
                    System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                }

            } else if (title4.isEmpty()) {
                dodaj_tytul_string = dodaj_tytul.getText();
                dodaj_opis_string = dodaj_opis_st.getText();

                try {
                    con = connection.ConnectDB();

                    String query1 = "update projekty_data set okno_1_4_title = '" + dodaj_tytul_string + "', okno_1_4_user = '" + user_login + "', okno_1_4_data = '" + time + "', okno_1_4_text = '" + dodaj_opis_string + "', okno_1_4_color = '" + kolor + "'    where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);
                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Sukces");
                    alert.setHeaderText("Dodano !");
                    alert.setContentText("Dodano notatkę numer 4.");
                    alert.showAndWait();
                    okno_1_init();

                } catch (SQLException e) {
                    System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Edycja");
                alert.setHeaderText("Błąd !");
                alert.setContentText("Brak miejsca w oknie.");
                alert.showAndWait();
            }

        } else if (dodaj_numer == 2) {

            try {
                con = connection.ConnectDB();
                String sql = "select * from projekty_data where id = '" + id + "' ";

                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {

                    title1 = rs.getString("okno_2_1_title");
                    title2 = rs.getString("okno_2_2_title");
                    title3 = rs.getString("okno_2_3_title");
                    title4 = rs.getString("okno_2_4_title");

                }

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }

            if (title1.isEmpty()) {
                dodaj_tytul_string = dodaj_tytul.getText();
                dodaj_opis_string = dodaj_opis_st.getText();

                try {
                    con = connection.ConnectDB();

                    String query1 = "update projekty_data set okno_2_1_title = '" + dodaj_tytul_string + "', okno_2_1_user = '" + user_login + "', okno_2_1_data = '" + time + "', okno_2_1_text = '" + dodaj_opis_string + "', okno_2_1_color = '" + kolor + "'    where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);
                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Sukces");
                    alert.setHeaderText("Dodano !");
                    alert.setContentText("Dodano notatkę numer 1.");
                    alert.showAndWait();
                    okno_2_init();
                } catch (SQLException e) {
                    System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                }

            } else if (title2.isEmpty()) {
                dodaj_tytul_string = dodaj_tytul.getText();
                dodaj_opis_string = dodaj_opis_st.getText();

                try {
                    con = connection.ConnectDB();

                    String query1 = "update projekty_data set okno_2_2_title = '" + dodaj_tytul_string + "', okno_2_2_user = '" + user_login + "', okno_2_2_data = '" + time + "', okno_2_2_text = '" + dodaj_opis_string + "', okno_2_2_color = '" + kolor + "'    where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);
                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Sukces");
                    alert.setHeaderText("Dodano !");
                    alert.setContentText("Dodano notatkę numer 2.");
                    alert.showAndWait();
                    okno_2_init();

                } catch (SQLException e) {
                    System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                }

            } else if (title3.isEmpty()) {
                dodaj_tytul_string = dodaj_tytul.getText();
                dodaj_opis_string = dodaj_opis_st.getText();

                try {
                    con = connection.ConnectDB();

                    String query1 = "update projekty_data set okno_2_3_title = '" + dodaj_tytul_string + "', okno_2_3_user = '" + user_login + "', okno_2_3_data = '" + time + "', okno_2_3_text = '" + dodaj_opis_string + "', okno_2_3_color = '" + kolor + "'    where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);
                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Sukces");
                    alert.setHeaderText("Dodano !");
                    alert.setContentText("Dodano notatkę numer 3.");
                    alert.showAndWait();
                    okno_2_init();
                } catch (SQLException e) {
                    System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                }

            } else if (title4.isEmpty()) {
                dodaj_tytul_string = dodaj_tytul.getText();
                dodaj_opis_string = dodaj_opis_st.getText();

                try {
                    con = connection.ConnectDB();

                    String query1 = "update projekty_data set okno_2_4_title = '" + dodaj_tytul_string + "', okno_2_4_user = '" + user_login + "', okno_2_4_data = '" + time + "', okno_2_4_text = '" + dodaj_opis_string + "', okno_2_4_color = '" + kolor + "'    where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);
                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Sukces");
                    alert.setHeaderText("Dodano !");
                    alert.setContentText("Dodano notatkę numer 4.");
                    alert.showAndWait();
                    okno_2_init();

                } catch (SQLException e) {
                    System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Edycja");
                alert.setHeaderText("Błąd !");
                alert.setContentText("Brak miejsca w oknie.");
                alert.showAndWait();

            }

        } else if (dodaj_numer == 3) {

            try {
                con = connection.ConnectDB();
                String sql = "select * from projekty_data where id = '" + id + "' ";

                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {

                    title1 = rs.getString("okno_3_1_title");
                    title2 = rs.getString("okno_3_2_title");
                    title3 = rs.getString("okno_3_3_title");
                    title4 = rs.getString("okno_3_4_title");

                }

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }

            if (title1.isEmpty()) {
                dodaj_tytul_string = dodaj_tytul.getText();
                dodaj_opis_string = dodaj_opis_st.getText();

                try {
                    con = connection.ConnectDB();

                    String query1 = "update projekty_data set okno_3_1_title = '" + dodaj_tytul_string + "', okno_3_1_user = '" + user_login + "', okno_3_1_data = '" + time + "', okno_3_1_text = '" + dodaj_opis_string + "', okno_3_1_color = '" + kolor + "'    where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);
                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Sukces");
                    alert.setHeaderText("Dodano !");
                    alert.setContentText("Dodano notatkę numer 1.");
                    alert.showAndWait();
                    okno_3_init();
                } catch (SQLException e) {
                    System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                }

            } else if (title2.isEmpty()) {
                dodaj_tytul_string = dodaj_tytul.getText();
                dodaj_opis_string = dodaj_opis_st.getText();

                try {
                    con = connection.ConnectDB();

                    String query1 = "update projekty_data set okno_3_2_title = '" + dodaj_tytul_string + "', okno_3_2_user = '" + user_login + "', okno_3_2_data = '" + time + "', okno_3_2_text = '" + dodaj_opis_string + "', okno_3_2_color = '" + kolor + "'    where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);
                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Sukces");
                    alert.setHeaderText("Dodano !");
                    alert.setContentText("Dodano notatkę numer 2.");
                    alert.showAndWait();
                    okno_3_init();

                } catch (SQLException e) {
                    System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                }

            } else if (title3.isEmpty()) {
                dodaj_tytul_string = dodaj_tytul.getText();
                dodaj_opis_string = dodaj_opis_st.getText();

                try {
                    con = connection.ConnectDB();

                    String query1 = "update projekty_data set okno_3_3_title = '" + dodaj_tytul_string + "', okno_3_3_user = '" + user_login + "', okno_3_3_data = '" + time + "', okno_3_3_text = '" + dodaj_opis_string + "', okno_3_3_color = '" + kolor + "'    where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);
                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Sukces");
                    alert.setHeaderText("Dodano !");
                    alert.setContentText("Dodano notatkę numer 3.");
                    alert.showAndWait();
                    okno_3_init();
                } catch (SQLException e) {
                    System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                }

            } else if (title4.isEmpty()) {
                dodaj_tytul_string = dodaj_tytul.getText();
                dodaj_opis_string = dodaj_opis_st.getText();

                try {
                    con = connection.ConnectDB();

                    String query1 = "update projekty_data set okno_3_4_title = '" + dodaj_tytul_string + "', okno_3_4_user = '" + user_login + "', okno_3_4_data = '" + time + "', okno_3_4_text = '" + dodaj_opis_string + "', okno_3_4_color = '" + kolor + "'    where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);
                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Sukces");
                    alert.setHeaderText("Dodano !");
                    alert.setContentText("Dodano notatkę numer 4.");
                    alert.showAndWait();
                    okno_3_init();

                } catch (SQLException e) {
                    System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Edycja");
                alert.setHeaderText("Błąd !");
                alert.setContentText("Brak miejsca w oknie.");
                alert.showAndWait();

            }

        } else if (dodaj_numer == 4) {

            try {
                con = connection.ConnectDB();
                String sql = "select * from projekty_data where id = '" + id + "' ";

                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {

                    title1 = rs.getString("okno_4_1_title");
                    title2 = rs.getString("okno_4_2_title");
                    title3 = rs.getString("okno_4_3_title");
                    title4 = rs.getString("okno_4_4_title");

                }

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }

            if (title1.isEmpty()) {
                dodaj_tytul_string = dodaj_tytul.getText();
                dodaj_opis_string = dodaj_opis_st.getText();

                try {
                    con = connection.ConnectDB();

                    String query1 = "update projekty_data set okno_4_1_title = '" + dodaj_tytul_string + "', okno_4_1_user = '" + user_login + "', okno_4_1_data = '" + time + "', okno_4_1_text = '" + dodaj_opis_string + "', okno_4_1_color = '" + kolor + "'    where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);
                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Sukces");
                    alert.setHeaderText("Dodano !");
                    alert.setContentText("Dodano notatkę numer 1.");
                    alert.showAndWait();
                    okno_4_init();
                } catch (SQLException e) {
                    System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                }

            } else if (title2.isEmpty()) {
                dodaj_tytul_string = dodaj_tytul.getText();
                dodaj_opis_string = dodaj_opis_st.getText();

                try {
                    con = connection.ConnectDB();

                    String query1 = "update projekty_data set okno_4_2_title = '" + dodaj_tytul_string + "', okno_4_2_user = '" + user_login + "', okno_4_2_data = '" + time + "', okno_4_2_text = '" + dodaj_opis_string + "', okno_4_2_color = '" + kolor + "'    where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);
                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Sukces");
                    alert.setHeaderText("Dodano !");
                    alert.setContentText("Dodano notatkę numer 2.");
                    alert.showAndWait();
                    okno_4_init();

                } catch (SQLException e) {
                    System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                }

            } else if (title3.isEmpty()) {
                dodaj_tytul_string = dodaj_tytul.getText();
                dodaj_opis_string = dodaj_opis_st.getText();

                try {
                    con = connection.ConnectDB();

                    String query1 = "update projekty_data set okno_4_3_title = '" + dodaj_tytul_string + "', okno_4_3_user = '" + user_login + "', okno_4_3_data = '" + time + "', okno_4_3_text = '" + dodaj_opis_string + "', okno_4_3_color = '" + kolor + "'    where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);
                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Sukces");
                    alert.setHeaderText("Dodano !");
                    alert.setContentText("Dodano notatkę numer 3.");
                    alert.showAndWait();
                    okno_4_init();
                } catch (SQLException e) {
                    System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                }

            } else if (title4.isEmpty()) {
                dodaj_tytul_string = dodaj_tytul.getText();
                dodaj_opis_string = dodaj_opis_st.getText();

                try {
                    con = connection.ConnectDB();

                    String query1 = "update projekty_data set okno_4_4_title = '" + dodaj_tytul_string + "', okno_4_4_user = '" + user_login + "', okno_4_4_data = '" + time + "', okno_4_4_text = '" + dodaj_opis_string + "', okno_4_4_color = '" + kolor + "'    where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);
                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Sukces");
                    alert.setHeaderText("Dodano !");
                    alert.setContentText("Dodano notatkę numer 4.");
                    alert.showAndWait();
                    okno_4_init();

                } catch (SQLException e) {
                    System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                }

            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Edycja");
                alert.setHeaderText("Błąd !");
                alert.setContentText("Brak miejsca w oknie.");
                alert.showAndWait();

            }

        }

        okno_1_init();
        okno_2_init();
        okno_3_init();
        okno_4_init();
    }

    int dodaj_numer = 0;

    @FXML
    public void dodaj_1(ActionEvent event) throws IOException {

        dodaj_numer = 1;
        ustawienia_okna.setVisible(false);
        dodaj_notatke.setVisible(true);

    }

    @FXML
    public void dodaj_2(ActionEvent event) throws IOException {

        dodaj_numer = 2;
        ustawienia_okna.setVisible(false);
        dodaj_notatke.setVisible(true);

    }

    @FXML
    public void dodaj_3(ActionEvent event) throws IOException {

        dodaj_numer = 3;
        ustawienia_okna.setVisible(false);
        dodaj_notatke.setVisible(true);

    }

    @FXML
    public void dodaj_4(ActionEvent event) throws IOException {

        dodaj_numer = 4;
        ustawienia_okna.setVisible(false);
        dodaj_notatke.setVisible(true);

    }

    // OKNO EDYCJI - EDYCJA
    @FXML
    public void edycja_edytuj(ActionEvent event) throws IOException {
        edycja_zapisz = "edytuj";

        tytul_edycja.setDisable(false);
        opis_edycja.setDisable(false);

        if (edycja.equals("okno_1")) {

            String title = notatki.getSelectionModel().getSelectedItem().toString();
            int selectedInted = notatki.getSelectionModel().getSelectedIndex() + 1;
            tytul_edycja.setText(title);

            if (selectedInted == 1) {
                text_number = "okno_1_1_text";
                title_number = "okno_1_1_title";
            }
            if (selectedInted == 2) {
                text_number = "okno_1_2_text";
                title_number = "okno_1_2_title";
            }
            if (selectedInted == 3) {
                text_number = "okno_1_3_text";
                title_number = "okno_1_3_title";
            }
            if (selectedInted == 4) {
                text_number = "okno_1_4_text";
                title_number = "okno_1_4_title";
            }

            con = connection.ConnectDB();
            String sql = "select * from projekty_data where id = '" + id + "' ";
            try {
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String add1 = rs.getString(text_number);
                    opis_edycja.setText(add1);
                }

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }
        } else if (edycja.equals("okno_2")) {

            String title = notatki.getSelectionModel().getSelectedItem().toString();
            int selectedInted = notatki.getSelectionModel().getSelectedIndex() + 1;
            tytul_edycja.setText(title);

            if (selectedInted == 1) {
                text_number = "okno_2_1_text";
                title_number = "okno_2_1_title";
            }
            if (selectedInted == 2) {
                text_number = "okno_2_2_text";
                title_number = "okno_2_2_title";
            }
            if (selectedInted == 3) {
                text_number = "okno_2_3_text";
                title_number = "okno_2_3_title";
            }
            if (selectedInted == 4) {
                text_number = "okno_2_4_text";
                title_number = "okno_2_4_title";
            }

            con = connection.ConnectDB();
            String sql = "select * from projekty_data where id = '" + id + "' ";
            try {
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String add1 = rs.getString(text_number);
                    opis_edycja.setText(add1);
                }

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }
        } else if (edycja.equals("okno_3")) {

            String title = notatki.getSelectionModel().getSelectedItem().toString();
            int selectedInted = notatki.getSelectionModel().getSelectedIndex() + 1;
            tytul_edycja.setText(title);

            if (selectedInted == 1) {
                text_number = "okno_3_1_text";
                title_number = "okno_3_1_title";
            }
            if (selectedInted == 2) {
                text_number = "okno_3_2_text";
                title_number = "okno_3_2_title";
            }
            if (selectedInted == 3) {
                text_number = "okno_3_3_text";
                title_number = "okno_3_3_title";
            }
            if (selectedInted == 4) {
                text_number = "okno_3_4_text";
                title_number = "okno_3_4_title";
            }

            con = connection.ConnectDB();
            String sql = "select * from projekty_data where id = '" + id + "' ";
            try {
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String add1 = rs.getString(text_number);
                    opis_edycja.setText(add1);
                }

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }
        } else if (edycja.equals("okno_4")) {

            String title = notatki.getSelectionModel().getSelectedItem().toString();
            int selectedInted = notatki.getSelectionModel().getSelectedIndex() + 1;
            tytul_edycja.setText(title);

            if (selectedInted == 1) {
                text_number = "okno_4_1_text";
                title_number = "okno_4_1_title";
            }
            if (selectedInted == 2) {
                text_number = "okno_4_2_text";
                title_number = "okno_4_2_title";
            }
            if (selectedInted == 3) {
                text_number = "okno_4_3_text";
                title_number = "okno_4_3_title";
            }
            if (selectedInted == 4) {
                text_number = "okno_4_4_text";
                title_number = "okno_4_4_title";
            }

            con = connection.ConnectDB();
            String sql = "select * from projekty_data where id = '" + id + "' ";
            try {
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String add1 = rs.getString(text_number);
                    opis_edycja.setText(add1);
                }

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }
        }
    }

    @FXML
    public void edycja_zapisz(ActionEvent event) throws IOException {
        if (edycja_zapisz.equals("edytuj")) {
            try {
                con = connection.ConnectDB();

                String query1 = "update projekty_data set " + title_number + " = '" + tytul_edycja.getText() + "', " + text_number + " = '" + opis_edycja.getText() + "' where id=" + "'" + id + "'";
                pst.executeUpdate(query1);
                pst.close();
                con.close();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Edycja");
                alert.setHeaderText("Sukces !");
                alert.setContentText("Zmiany zostały zapisane");
                alert.showAndWait();

                ustawienia_zamknij(event);

            } catch (SQLException e) {
                System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());

            }
            okno_1_init();
            okno_2_init();
            okno_3_init();
            okno_4_init();
        }
        //////////////////////////////////////////////////////////////////

        if (edycja_zapisz.equals("przenies")) {

            //text_numer - notatka do przeniesienia
            // window_title - okno do którego przenosimy
            String title = "";
            String text = "";
            String data = new SimpleDateFormat("dd.MM.yyy HH:mm").format(Calendar.getInstance().getTime());
            String user = "";
            String color = "";

            if (window_title.equals("okno_1")) {
                dodaj_numer = 1;
            } else if (window_title.equals("okno_2")) {
                dodaj_numer = 2;
            } else if (window_title.equals("okno_3")) {
                dodaj_numer = 3;
            } else if (window_title.equals("okno_4")) {
                dodaj_numer = 4;
            }

            try {
                con = connection.ConnectDB();
                String sql = "select * from projekty_data where id = '" + id + "' ";

                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {

                    // okno_1
                    if (title_number.equals("okno_1_1_title")) {
                        title = rs.getString("okno_1_1_title");
                        text = rs.getString("okno_1_1_text");
                        user = rs.getString("okno_1_1_user");
                        color = rs.getString("okno_1_1_color");
                    } else if (title_number.equals("okno_1_2_title")) {
                        title = rs.getString("okno_1_2_title");
                        text = rs.getString("okno_1_2_text");
                        user = rs.getString("okno_1_2_user");
                        color = rs.getString("okno_1_2_color");
                    } else if (title_number.equals("okno_1_3_title")) {
                        title = rs.getString("okno_1_3_title");
                        text = rs.getString("okno_1_3_text");
                        user = rs.getString("okno_1_3_user");
                        color = rs.getString("okno_1_3_color");
                    } else if (title_number.equals("okno_1_4_title")) {
                        title = rs.getString("okno_1_4_title");
                        text = rs.getString("okno_1_4_text");
                        user = rs.getString("okno_1_4_user");
                        color = rs.getString("okno_1_4_color");
                    } // okno_2
                    else if (title_number.equals("okno_2_1_title")) {
                        title = rs.getString("okno_2_1_title");
                        text = rs.getString("okno_2_1_text");
                        user = rs.getString("okno_2_1_user");
                        color = rs.getString("okno_2_1_color");
                    } else if (title_number.equals("okno_2_2_title")) {
                        title = rs.getString("okno_2_2_title");
                        text = rs.getString("okno_2_2_text");
                        user = rs.getString("okno_2_2_user");
                        color = rs.getString("okno_2_2_color");
                    } else if (title_number.equals("okno_2_3_title")) {
                        title = rs.getString("okno_2_3_title");
                        text = rs.getString("okno_2_3_text");
                        user = rs.getString("okno_2_3_user");
                        color = rs.getString("okno_2_3_color");
                    } else if (title_number.equals("okno_2_4_title")) {
                        title = rs.getString("okno_2_4_title");
                        text = rs.getString("okno_2_4_text");
                        user = rs.getString("okno_2_4_user");
                        color = rs.getString("okno_2_4_color");
                    } // okno_3
                    else if (title_number.equals("okno_3_1_title")) {
                        title = rs.getString("okno_3_1_title");
                        text = rs.getString("okno_3_1_text");
                        user = rs.getString("okno_3_1_user");
                        color = rs.getString("okno_3_1_color");
                    } else if (title_number.equals("okno_3_2_title")) {
                        title = rs.getString("okno_3_2_title");
                        text = rs.getString("okno_3_2_text");
                        user = rs.getString("okno_3_2_user");
                        color = rs.getString("okno_3_2_color");
                    } else if (title_number.equals("okno_3_3_title")) {
                        title = rs.getString("okno_3_3_title");
                        text = rs.getString("okno_3_3_text");
                        user = rs.getString("okno_3_3_user");
                        color = rs.getString("okno_3_3_color");
                    } else if (title_number.equals("okno_3_4_title")) {
                        title = rs.getString("okno_3_4_title");
                        text = rs.getString("okno_3_4_text");
                        user = rs.getString("okno_3_4_user");
                        color = rs.getString("okno_3_4_color");
                    } // okno_4
                    else if (title_number.equals("okno_4_1_title")) {
                        title = rs.getString("okno_4_1_title");
                        text = rs.getString("okno_4_1_text");
                        user = rs.getString("okno_4_1_user");
                        color = rs.getString("okno_4_1_color");
                    } else if (title_number.equals("okno_4_2_title")) {
                        title = rs.getString("okno_4_2_title");
                        text = rs.getString("okno_4_2_text");
                        user = rs.getString("okno_4_2_user");
                        color = rs.getString("okno_4_2_color");
                    } else if (title_number.equals("okno_4_3_title")) {
                        title = rs.getString("okno_4_3_title");
                        text = rs.getString("okno_4_3_text");
                        user = rs.getString("okno_4_3_user");
                        color = rs.getString("okno_4_3_color");
                    } else if (title_number.equals("okno_4_4_title")) {
                        title = rs.getString("okno_4_4_title");
                        text = rs.getString("okno_4_4_text");
                        user = rs.getString("okno_4_4_user");
                        color = rs.getString("okno_4_4_color");
                    }

                }

                ustawienia_zamknij(event);

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }

            String title1 = "";
            String title2 = "";
            String title3 = "";
            String title4 = "";
            String empty = "";
            if (dodaj_numer == 1) {

                try {
                    con = connection.ConnectDB();
                    String sql = "select * from projekty_data where id = '" + id + "' ";

                    pst = con.prepareStatement(sql);
                    rs = pst.executeQuery();

                    if (rs.next()) {

                        title1 = rs.getString("okno_1_1_title");
                        title2 = rs.getString("okno_1_2_title");
                        title3 = rs.getString("okno_1_3_title");
                        title4 = rs.getString("okno_1_4_title");

                    }

                } catch (SQLException | HeadlessException e) {
                    System.out.println(e);
                }

                if (title1.isEmpty()) {

                    try {
                        con = connection.ConnectDB();

                        String query1 = "update projekty_data set okno_1_1_title = '" + title + "', okno_1_1_user = '" + user + "', okno_1_1_data = '" + data + "', okno_1_1_text = '" + text + "', okno_1_1_color = '" + color + "'    where id=" + "'" + id + "'";

                        pst.executeUpdate(query1);
                        przenoszenie_sort();

                        pst.close();
                        con.close();

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Sukces");
                        alert.setHeaderText("Dodano !");
                        alert.setContentText("Dodano notatkę numer 1.");
                        alert.showAndWait();
                        okno_1_init();
                    } catch (SQLException e) {
                        System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                    }

                } else if (title2.isEmpty()) {

                    try {
                        con = connection.ConnectDB();

                        String query1 = "update projekty_data set okno_1_2_title = '" + title + "', okno_1_2_user = '" + user + "', okno_1_2_data = '" + data + "', okno_1_2_text = '" + text + "', okno_1_2_color = '" + color + "'    where id=" + "'" + id + "'";

                        pst.executeUpdate(query1);
                        przenoszenie_sort();

                        pst.close();
                        con.close();

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Sukces");
                        alert.setHeaderText("Dodano !");
                        alert.setContentText("Dodano notatkę numer 2.");
                        alert.showAndWait();
                        okno_1_init();

                    } catch (SQLException e) {
                        System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                    }

                } else if (title3.isEmpty()) {

                    try {
                        con = connection.ConnectDB();

                        String query1 = "update projekty_data set okno_1_3_title = '" + title + "', okno_1_3_user = '" + user + "', okno_1_3_data = '" + data + "', okno_1_3_text = '" + text + "', okno_1_3_color = '" + color + "'    where id=" + "'" + id + "'";

                        pst.executeUpdate(query1);
                        przenoszenie_sort();

                        pst.close();
                        con.close();

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Sukces");
                        alert.setHeaderText("Dodano !");
                        alert.setContentText("Dodano notatkę numer 3.");
                        alert.showAndWait();
                        okno_1_init();
                    } catch (SQLException e) {
                        System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                    }

                } else if (title4.isEmpty()) {

                    try {
                        con = connection.ConnectDB();

                        String query1 = "update projekty_data set okno_1_4_title = '" + title + "', okno_1_4_user = '" + user + "', okno_1_4_data = '" + data + "', okno_1_4_text = '" + text + "', okno_1_4_color = '" + color + "'    where id=" + "'" + id + "'";

                        pst.executeUpdate(query1);
                        przenoszenie_sort();

                        pst.close();
                        con.close();

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Sukces");
                        alert.setHeaderText("Dodano !");
                        alert.setContentText("Dodano notatkę numer 4.");
                        alert.showAndWait();
                        okno_1_init();

                    } catch (SQLException e) {
                        System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                    }

                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Edycja");
                    alert.setHeaderText("Błąd !");
                    alert.setContentText("Brak miejsca w oknie.");
                    alert.showAndWait();
                }

            } else if (dodaj_numer == 2) {

                try {
                    con = connection.ConnectDB();
                    String sql = "select * from projekty_data where id = '" + id + "' ";

                    pst = con.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs.next()) {

                        title1 = rs.getString("okno_2_1_title");
                        title2 = rs.getString("okno_2_2_title");
                        title3 = rs.getString("okno_2_3_title");
                        title4 = rs.getString("okno_2_4_title");

                    }

                } catch (SQLException | HeadlessException e) {
                    System.out.println(e);
                }

                if (title1.isEmpty()) {

                    try {
                        con = connection.ConnectDB();

                        String query1 = "update projekty_data set okno_2_1_title = '" + title + "', okno_2_1_user = '" + user + "', okno_2_1_data = '" + data + "', okno_2_1_text = '" + text + "', okno_2_1_color = '" + color + "'    where id=" + "'" + id + "'";

                        pst.executeUpdate(query1);
                        przenoszenie_sort();

                        pst.close();
                        con.close();

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Sukces");
                        alert.setHeaderText("Dodano !");
                        alert.setContentText("Dodano notatkę numer 1.");
                        alert.showAndWait();
                        okno_2_init();
                    } catch (SQLException e) {
                        System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                    }

                } else if (title2.isEmpty()) {
                    //////////////////////////////////////////////////////////////////////////////////////////
                    try {
                        con = connection.ConnectDB();

                        String query1 = "update projekty_data set okno_2_2_title = '" + title + "', okno_2_2_user = '" + user + "', okno_2_2_data = '" + data + "', okno_2_2_text = '" + text + "', okno_2_2_color = '" + color + "'    where id=" + "'" + id + "'";

                        pst.executeUpdate(query1);
                        przenoszenie_sort();

                        pst.close();
                        con.close();

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Sukces");
                        alert.setHeaderText("Dodano !");
                        alert.setContentText("Dodano notatkę numer 2.");
                        alert.showAndWait();
                        okno_2_init();

                    } catch (SQLException e) {
                        System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                    }

                } else if (title3.isEmpty()) {

                    try {
                        con = connection.ConnectDB();

                        String query1 = "update projekty_data set okno_2_3_title = '" + title + "', okno_2_3_user = '" + user + "', okno_2_3_data = '" + data + "', okno_2_3_text = '" + text + "', okno_2_3_color = '" + color + "'    where id=" + "'" + id + "'";

                        pst.executeUpdate(query1);
                        przenoszenie_sort();

                        pst.close();
                        con.close();

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Sukces");
                        alert.setHeaderText("Dodano !");
                        alert.setContentText("Dodano notatkę numer 3.");
                        alert.showAndWait();
                        okno_2_init();
                    } catch (SQLException e) {
                        System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                    }

                } else if (title4.isEmpty()) {

                    try {
                        con = connection.ConnectDB();

                        String query1 = "update projekty_data set okno_2_4_title = '" + title + "', okno_2_4_user = '" + user + "', okno_2_4_data = '" + data + "', okno_2_4_text = '" + text + "', okno_2_4_color = '" + color + "'    where id=" + "'" + id + "'";

                        pst.executeUpdate(query1);
                        przenoszenie_sort();

                        pst.close();
                        con.close();

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Sukces");
                        alert.setHeaderText("Dodano !");
                        alert.setContentText("Dodano notatkę numer 4.");
                        alert.showAndWait();
                        okno_2_init();

                    } catch (SQLException e) {
                        System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                    }

                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Edycja");
                    alert.setHeaderText("Błąd !");
                    alert.setContentText("Brak miejsca w oknie.");
                    alert.showAndWait();

                }

            } else if (dodaj_numer == 3) {

                try {
                    con = connection.ConnectDB();
                    String sql = "select * from projekty_data where id = '" + id + "' ";

                    pst = con.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs.next()) {

                        title1 = rs.getString("okno_3_1_title");
                        title2 = rs.getString("okno_3_2_title");
                        title3 = rs.getString("okno_3_3_title");
                        title4 = rs.getString("okno_3_4_title");

                    }

                } catch (SQLException | HeadlessException e) {
                    System.out.println(e);
                }

                if (title1.isEmpty()) {

                    try {
                        con = connection.ConnectDB();

                        String query1 = "update projekty_data set okno_3_1_title = '" + title + "', okno_3_1_user = '" + user + "', okno_3_1_data = '" + data + "', okno_3_1_text = '" + text + "', okno_3_1_color = '" + color + "'    where id=" + "'" + id + "'";

                        pst.executeUpdate(query1);
                        przenoszenie_sort();

                        pst.close();
                        con.close();

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Sukces");
                        alert.setHeaderText("Dodano !");
                        alert.setContentText("Dodano notatkę numer 1.");
                        alert.showAndWait();
                        okno_3_init();
                    } catch (SQLException e) {
                        System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                    }

                } else if (title2.isEmpty()) {

                    try {
                        con = connection.ConnectDB();

                        String query1 = "update projekty_data set okno_3_2_title = '" + title + "', okno_3_2_user = '" + user + "', okno_3_2_data = '" + data + "', okno_3_2_text = '" + text + "', okno_3_2_color = '" + color + "'    where id=" + "'" + id + "'";

                        pst.executeUpdate(query1);
                        przenoszenie_sort();

                        pst.close();
                        con.close();

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Sukces");
                        alert.setHeaderText("Dodano !");
                        alert.setContentText("Dodano notatkę numer 2.");
                        alert.showAndWait();
                        okno_3_init();

                    } catch (SQLException e) {
                        System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                    }

                } else if (title3.isEmpty()) {

                    try {
                        con = connection.ConnectDB();

                        String query1 = "update projekty_data set okno_3_3_title = '" + title + "', okno_3_3_user = '" + user + "', okno_3_3_data = '" + data + "', okno_3_3_text = '" + text + "', okno_3_3_color = '" + color + "'    where id=" + "'" + id + "'";

                        pst.executeUpdate(query1);
                        przenoszenie_sort();

                        pst.close();
                        con.close();

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Sukces");
                        alert.setHeaderText("Dodano !");
                        alert.setContentText("Dodano notatkę numer 3.");
                        alert.showAndWait();
                        okno_3_init();
                    } catch (SQLException e) {
                        System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                    }

                } else if (title4.isEmpty()) {

                    try {
                        con = connection.ConnectDB();

                        String query1 = "update projekty_data set okno_3_4_title = '" + title + "', okno_3_4_user = '" + user + "', okno_3_4_data = '" + data + "', okno_3_4_text = '" + text + "', okno_3_4_color = '" + color + "'    where id=" + "'" + id + "'";

                        pst.executeUpdate(query1);
                        przenoszenie_sort();

                        pst.close();
                        con.close();

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Sukces");
                        alert.setHeaderText("Dodano !");
                        alert.setContentText("Dodano notatkę numer 4.");
                        alert.showAndWait();
                        okno_3_init();

                    } catch (SQLException e) {
                        System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                    }

                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Edycja");
                    alert.setHeaderText("Błąd !");
                    alert.setContentText("Brak miejsca w oknie.");
                    alert.showAndWait();

                }

            } else if (dodaj_numer == 4) {

                try {
                    con = connection.ConnectDB();
                    String sql = "select * from projekty_data where id = '" + id + "' ";

                    pst = con.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs.next()) {

                        title1 = rs.getString("okno_4_1_title");
                        title2 = rs.getString("okno_4_2_title");
                        title3 = rs.getString("okno_4_3_title");
                        title4 = rs.getString("okno_4_4_title");

                    }

                } catch (SQLException | HeadlessException e) {
                    System.out.println(e);
                }

                if (title1.isEmpty()) {

                    try {
                        con = connection.ConnectDB();

                        String query1 = "update projekty_data set okno_4_1_title = '" + title + "', okno_4_1_user = '" + user + "', okno_4_1_data = '" + data + "', okno_4_1_text = '" + text + "', okno_4_1_color = '" + color + "'    where id=" + "'" + id + "'";

                        pst.executeUpdate(query1);
                        przenoszenie_sort();

                        pst.close();
                        con.close();

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Sukces");
                        alert.setHeaderText("Dodano !");
                        alert.setContentText("Dodano notatkę numer 1.");
                        alert.showAndWait();
                        okno_4_init();
                    } catch (SQLException e) {
                        System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                    }

                } else if (title2.isEmpty()) {

                    try {
                        con = connection.ConnectDB();

                        String query1 = "update projekty_data set okno_4_2_title = '" + title + "', okno_4_2_user = '" + user + "', okno_4_2_data = '" + data + "', okno_4_2_text = '" + text + "', okno_4_2_color = '" + color + "'    where id=" + "'" + id + "'";

                        pst.executeUpdate(query1);
                        przenoszenie_sort();

                        pst.close();
                        con.close();

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Sukces");
                        alert.setHeaderText("Dodano !");
                        alert.setContentText("Dodano notatkę numer 2.");
                        alert.showAndWait();
                        okno_4_init();

                    } catch (SQLException e) {
                        System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                    }

                } else if (title3.isEmpty()) {

                    try {
                        con = connection.ConnectDB();

                        String query1 = "update projekty_data set okno_4_3_title = '" + title + "', okno_4_3_user = '" + user + "', okno_4_3_data = '" + data + "', okno_4_3_text = '" + text + "', okno_4_3_color = '" + color + "'    where id=" + "'" + id + "'";

                        pst.executeUpdate(query1);
                        przenoszenie_sort();

                        pst.close();
                        con.close();

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Sukces");
                        alert.setHeaderText("Dodano !");
                        alert.setContentText("Dodano notatkę numer 3.");
                        alert.showAndWait();
                        okno_4_init();
                    } catch (SQLException e) {
                        System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                    }

                } else if (title4.isEmpty()) {

                    try {
                        con = connection.ConnectDB();

                        String query1 = "update projekty_data set okno_4_4_title = '" + title + "', okno_4_4_user = '" + user + "', okno_4_4_data = '" + data + "', okno_4_4_text = '" + text + "', okno_4_4_color = '" + color + "'    where id=" + "'" + id + "'";

                        pst.executeUpdate(query1);
                        przenoszenie_sort();

                        pst.close();
                        con.close();

                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Sukces");
                        alert.setHeaderText("Dodano !");
                        alert.setContentText("Dodano notatkę numer 4.");
                        alert.showAndWait();
                        okno_4_init();

                    } catch (SQLException e) {
                        System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                    }

                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Edycja");
                    alert.setHeaderText("Błąd !");
                    alert.setContentText("Brak miejsca w oknie.");
                    alert.showAndWait();

                }

            }

            okno_1_init();
            okno_2_init();
            okno_3_init();
            okno_4_init();

        }

        //////////////////////////////////////////////////////////////////
        String empty = "";
        if (edycja_zapisz.equals("usun")) {

            if (title_number.equals("okno_1_1_title")) {
                // Sytuacja jest taka, że jak usuniemy 1 pozycję to na miejsce 1 wchodi 2 na 2=3 a na 3=4, 4 idzie do kosza.    
                String title2 = "";
                String text2 = "";
                String data2 = "";
                String user2 = "";
                String color2 = "";
                String title3 = "";
                String text3 = "";
                String data3 = "";
                String user3 = "";
                String color3 = "";
                String title4 = "";
                String text4 = "";
                String data4 = "";
                String user4 = "";
                String color4 = "";

                //Tak mi wygodniej :)
                String okno_1_1_title = "okno_1_1_title";
                String okno_1_1_text = "okno_1_1_text";
                String okno_1_1_data = "okno_1_1_data";
                String okno_1_1_user = "okno_1_1_user";
                String okno_1_1_color = "okno_1_1_color";

                String okno_1_2_title = "okno_1_2_title";
                String okno_1_2_text = "okno_1_2_text";
                String okno_1_2_data = "okno_1_2_data";
                String okno_1_2_user = "okno_1_2_user";
                String okno_1_2_color = "okno_1_2_color";

                String okno_1_3_title = "okno_1_3_title";
                String okno_1_3_text = "okno_1_3_text";
                String okno_1_3_data = "okno_1_3_data";
                String okno_1_3_user = "okno_1_3_user";
                String okno_1_3_color = "okno_1_3_color";

                String okno_1_4_title = "okno_1_4_title";

                try {
                    con = connection.ConnectDB();
                    String sql = "select * from projekty_data where id = '" + id + "' ";

                    pst = con.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs.next()) {

                        title2 = rs.getString("okno_1_2_title");
                        text2 = rs.getString("okno_1_2_text");
                        data2 = rs.getString("okno_1_2_data");
                        user2 = rs.getString("okno_1_2_user");
                        color2 = rs.getString("okno_1_2_color");
                        title3 = rs.getString("okno_1_3_title");
                        text3 = rs.getString("okno_1_3_text");
                        data3 = rs.getString("okno_1_3_data");
                        user3 = rs.getString("okno_1_3_user");
                        color3 = rs.getString("okno_1_3_color");
                        title4 = rs.getString("okno_1_4_title");
                        text4 = rs.getString("okno_1_4_text");
                        data4 = rs.getString("okno_1_4_data");
                        user4 = rs.getString("okno_1_4_user");
                        color4 = rs.getString("okno_1_4_color");

                    }

                    String query0 = "update projekty_data set " + okno_1_1_title + " = '" + title2 + "', " + okno_1_1_text + " = '" + text2 + "', " + okno_1_1_data + " = '" + data2 + "', " + okno_1_1_user + " = '" + user2 + "', " + okno_1_1_color + " = '" + color2 + "'  where id=" + "'" + id + "'";
                    pst.executeUpdate(query0);

                    String query1 = "update projekty_data set " + okno_1_2_title + " = '" + title3 + "', " + okno_1_2_text + " = '" + text3 + "', " + okno_1_2_data + " = '" + data3 + "', " + okno_1_2_user + " = '" + user3 + "', " + okno_1_2_color + " = '" + color3 + "'  where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);

                    String query2 = "update projekty_data set " + okno_1_3_title + " = '" + title4 + "', " + okno_1_3_text + " = '" + text4 + "', " + okno_1_3_data + " = '" + data4 + "', " + okno_1_3_user + " = '" + user4 + "', " + okno_1_3_color + " = '" + color4 + "'  where id=" + "'" + id + "'";
                    pst.executeUpdate(query2);

                    String sql2 = "update projekty_data set " + okno_1_4_title + " = '" + empty + "' where id=" + "'" + id + "'";
                    pst.executeUpdate(sql2);

                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Edycja");
                    alert.setHeaderText("Sukces !");
                    alert.setContentText("Usunięto !");
                    alert.showAndWait();

                    ustawienia_zamknij(event);

                } catch (SQLException | HeadlessException e) {
                    System.out.println(e);
                }

            }

            if (title_number.equals("okno_1_2_title")) {

                // Sytuacja jest taka, że jak usuwany 2 pozycję na na miejsce 2 wchodzi 3 a na 3 pozycję 4 pozycję.
                String title3 = "";
                String text3 = "";
                String data3 = "";
                String user3 = "";
                String color3 = "";
                String title4 = "";
                String text4 = "";
                String data4 = "";
                String user4 = "";
                String color4 = "";

                //Tak mi wygodniej :)
                String okno_1_2_title = "okno_1_2_title";
                String okno_1_2_text = "okno_1_2_text";
                String okno_1_2_data = "okno_1_2_data";
                String okno_1_2_user = "okno_1_2_user";
                String okno_1_2_color = "okno_1_2_color";

                String okno_1_3_title = "okno_1_3_title";
                String okno_1_3_text = "okno_1_3_text";
                String okno_1_3_data = "okno_1_3_data";
                String okno_1_3_user = "okno_1_3_user";
                String okno_1_3_color = "okno_1_3_color";

                String okno_1_4_title = "okno_1_4_title";
                try {
                    con = connection.ConnectDB();
                    String sql = "select * from projekty_data where id = '" + id + "' ";

                    pst = con.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs.next()) {

                        title3 = rs.getString("okno_1_3_title");
                        text3 = rs.getString("okno_1_3_text");
                        data3 = rs.getString("okno_1_3_data");
                        user3 = rs.getString("okno_1_3_user");
                        color3 = rs.getString("okno_1_3_color");
                        title4 = rs.getString("okno_1_4_title");
                        text4 = rs.getString("okno_1_4_text");
                        data4 = rs.getString("okno_1_4_data");
                        user4 = rs.getString("okno_1_4_user");
                        color4 = rs.getString("okno_1_4_color");

                    }

                    String query1 = "update projekty_data set " + okno_1_2_title + " = '" + title3 + "', " + okno_1_2_text + " = '" + text3 + "', " + okno_1_2_data + " = '" + data3 + "', " + okno_1_2_user + " = '" + user3 + "', " + okno_1_2_color + " = '" + color3 + "'  where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);

                    String query2 = "update projekty_data set " + okno_1_3_title + " = '" + title4 + "', " + okno_1_3_text + " = '" + text4 + "', " + okno_1_3_data + " = '" + data4 + "', " + okno_1_3_user + " = '" + user4 + "', " + okno_1_3_color + " = '" + color4 + "'  where id=" + "'" + id + "'";
                    pst.executeUpdate(query2);

                    String sql2 = "update projekty_data set " + okno_1_4_title + " = '" + empty + "' where id=" + "'" + id + "'";
                    pst.executeUpdate(sql2);

                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Edycja");
                    alert.setHeaderText("Sukces !");
                    alert.setContentText("Usunięto !");
                    alert.showAndWait();

                    ustawienia_zamknij(event);

                } catch (SQLException | HeadlessException e) {
                    System.out.println(e);
                }

            }

            if (title_number.equals("okno_1_3_title")) {
                String title = "";
                String text = "";
                String data = "";
                String user = "";
                String color = "";

                String okno_1_3_title = "okno_1_3_title";
                String okno_1_3_text = "okno_1_3_text";
                String okno_1_4_data = "okno_1_4_data";
                String okno_1_4_user = "okno_1_4_user";
                String okno_1_4_color = "okno_1_4_color";

                String okno_1_4_title = "okno_1_4_title";
                try {
                    con = connection.ConnectDB();
                    String sql = "select * from projekty_data where id = '" + id + "' ";

                    pst = con.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs.next()) {

                        title = rs.getString("okno_1_4_title");
                        text = rs.getString("okno_1_4_text");
                        data = rs.getString("okno_1_4_data");
                        user = rs.getString("okno_1_4_user");
                        color = rs.getString("okno_1_4_color");

                    }
                    String query1 = "update projekty_data set " + okno_1_3_title + " = '" + title + "', " + okno_1_3_text + " = '" + text + "', " + okno_1_4_data + " = '" + data + "', " + okno_1_4_user + " = '" + user + "', " + okno_1_4_color + " = '" + color + "'  where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);

                    String sql2 = "update projekty_data set " + okno_1_4_title + " = '" + empty + "' where id=" + "'" + id + "'";
                    pst.executeUpdate(sql2);
                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Edycja");
                    alert.setHeaderText("Sukces !");
                    alert.setContentText("Usunięto");
                    alert.showAndWait();

                    ustawienia_zamknij(event);

                } catch (SQLException | HeadlessException e) {
                    System.out.println(e);
                }
            }

            if (title_number.equals("okno_1_4_title")) {
                try {
                    con = connection.ConnectDB();
                    String sql = "update projekty_data set " + title_number + " = '" + empty + "' where id=" + "'" + id + "'";
                    pst.executeUpdate(sql);
                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Edycja");
                    alert.setHeaderText("Sukces !");
                    alert.setContentText("Usunięto");
                    alert.showAndWait();

                    ustawienia_zamknij(event);
                    // DOKOŃCZYĆ
                } catch (SQLException e) {
                    System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                }
            }

            ////////////////////////
            if (title_number.equals("okno_2_1_title")) {
                // Sytuacja jest taka, że jak usuniemy 1 pozycję to na miejsce 1 wchodi 2 na 2=3 a na 3=4, 4 idzie do kosza.    
                String title2 = "";
                String text2 = "";
                String data2 = "";
                String user2 = "";
                String color2 = "";
                String title3 = "";
                String text3 = "";
                String data3 = "";
                String user3 = "";
                String color3 = "";
                String title4 = "";
                String text4 = "";
                String data4 = "";
                String user4 = "";
                String color4 = "";

                //Tak mi wygodniej :)
                String okno_2_1_title = "okno_2_1_title";
                String okno_2_1_text = "okno_2_1_text";
                String okno_2_1_data = "okno_2_1_data";
                String okno_2_1_user = "okno_2_1_user";
                String okno_2_1_color = "okno_2_1_color";

                String okno_2_2_title = "okno_2_2_title";
                String okno_2_2_text = "okno_2_2_text";
                String okno_2_2_data = "okno_2_2_data";
                String okno_2_2_user = "okno_2_2_user";
                String okno_2_2_color = "okno_2_2_color";

                String okno_2_3_title = "okno_2_3_title";
                String okno_2_3_text = "okno_2_3_text";
                String okno_2_3_data = "okno_2_3_data";
                String okno_2_3_user = "okno_2_3_user";
                String okno_2_3_color = "okno_2_3_color";

                String okno_2_4_title = "okno_2_4_title";

                try {
                    con = connection.ConnectDB();
                    String sql = "select * from projekty_data where id = '" + id + "' ";

                    pst = con.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs.next()) {

                        title2 = rs.getString("okno_2_2_title");
                        text2 = rs.getString("okno_2_2_text");
                        data2 = rs.getString("okno_2_2_data");
                        user2 = rs.getString("okno_2_2_user");
                        color2 = rs.getString("okno_2_2_color");
                        title3 = rs.getString("okno_2_3_title");
                        text3 = rs.getString("okno_2_3_text");
                        data3 = rs.getString("okno_2_3_data");
                        user3 = rs.getString("okno_2_3_user");
                        color3 = rs.getString("okno_2_3_color");
                        title4 = rs.getString("okno_2_4_title");
                        text4 = rs.getString("okno_2_4_text");
                        data4 = rs.getString("okno_2_4_data");
                        user4 = rs.getString("okno_2_4_user");
                        color4 = rs.getString("okno_2_4_color");

                    }

                    String query0 = "update projekty_data set " + okno_2_1_title + " = '" + title2 + "', " + okno_2_1_text + " = '" + text2 + "', " + okno_2_1_data + " = '" + data2 + "', " + okno_2_1_user + " = '" + user2 + "', " + okno_2_1_color + " = '" + color2 + "'  where id=" + "'" + id + "'";
                    pst.executeUpdate(query0);

                    String query1 = "update projekty_data set " + okno_2_2_title + " = '" + title3 + "', " + okno_2_2_text + " = '" + text3 + "', " + okno_2_2_data + " = '" + data3 + "', " + okno_2_2_user + " = '" + user3 + "', " + okno_2_2_color + " = '" + color3 + "'  where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);

                    String query2 = "update projekty_data set " + okno_2_3_title + " = '" + title4 + "', " + okno_2_3_text + " = '" + text4 + "', " + okno_2_3_data + " = '" + data4 + "', " + okno_2_3_user + " = '" + user4 + "', " + okno_2_3_color + " = '" + color4 + "'  where id=" + "'" + id + "'";
                    pst.executeUpdate(query2);

                    String sql2 = "update projekty_data set " + okno_2_4_title + " = '" + empty + "' where id=" + "'" + id + "'";
                    pst.executeUpdate(sql2);

                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Edycja");
                    alert.setHeaderText("Sukces !");
                    alert.setContentText("Usunięto !");
                    alert.showAndWait();

                    ustawienia_zamknij(event);

                } catch (SQLException | HeadlessException e) {
                    System.out.println(e);
                }

            }

            if (title_number.equals("okno_2_2_title")) {

                // Sytuacja jest taka, że jak usuwany 2 pozycję na na miejsce 2 wchodzi 3 a na 3 pozycję 4 pozycję.
                String title3 = "";
                String text3 = "";
                String data3 = "";
                String user3 = "";
                String color3 = "";
                String title4 = "";
                String text4 = "";
                String data4 = "";
                String user4 = "";
                String color4 = "";

                //Tak mi wygodniej :)
                String okno_2_2_title = "okno_2_2_title";
                String okno_2_2_text = "okno_2_2_text";
                String okno_2_2_data = "okno_2_2_data";
                String okno_2_2_user = "okno_2_2_user";
                String okno_2_2_color = "okno_2_2_color";

                String okno_2_3_title = "okno_2_3_title";
                String okno_2_3_text = "okno_2_3_text";
                String okno_2_3_data = "okno_2_3_data";
                String okno_2_3_user = "okno_2_3_user";
                String okno_2_3_color = "okno_2_3_color";

                String okno_2_4_title = "okno_2_4_title";
                try {
                    con = connection.ConnectDB();
                    String sql = "select * from projekty_data where id = '" + id + "' ";

                    pst = con.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs.next()) {

                        title3 = rs.getString("okno_2_3_title");
                        text3 = rs.getString("okno_2_3_text");
                        data3 = rs.getString("okno_2_3_data");
                        user3 = rs.getString("okno_2_3_user");
                        color3 = rs.getString("okno_2_3_color");
                        title4 = rs.getString("okno_2_4_title");
                        text4 = rs.getString("okno_2_4_text");
                        data4 = rs.getString("okno_2_4_data");
                        user4 = rs.getString("okno_2_4_user");
                        color4 = rs.getString("okno_2_4_color");

                    }

                    String query1 = "update projekty_data set " + okno_2_2_title + " = '" + title3 + "', " + okno_2_2_text + " = '" + text3 + "', " + okno_2_2_data + " = '" + data3 + "', " + okno_2_2_user + " = '" + user3 + "', " + okno_2_2_color + " = '" + color3 + "'  where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);

                    String query2 = "update projekty_data set " + okno_2_3_title + " = '" + title4 + "', " + okno_2_3_text + " = '" + text4 + "', " + okno_2_3_data + " = '" + data4 + "', " + okno_2_3_user + " = '" + user4 + "', " + okno_2_3_color + " = '" + color4 + "'  where id=" + "'" + id + "'";
                    pst.executeUpdate(query2);

                    String sql2 = "update projekty_data set " + okno_2_4_title + " = '" + empty + "' where id=" + "'" + id + "'";
                    pst.executeUpdate(sql2);

                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Edycja");
                    alert.setHeaderText("Sukces !");
                    alert.setContentText("Usunięto !");
                    alert.showAndWait();

                    ustawienia_zamknij(event);

                } catch (SQLException | HeadlessException e) {
                    System.out.println(e);
                }

            }

            if (title_number.equals("okno_2_3_title")) {
                String title = "";
                String text = "";
                String data = "";
                String user = "";
                String color = "";

                String okno_2_3_title = "okno_2_3_title";
                String okno_2_3_text = "okno_2_3_text";
                String okno_2_4_data = "okno_2_4_data";
                String okno_2_4_user = "okno_2_4_user";
                String okno_2_4_color = "okno_2_4_color";

                String okno_2_4_title = "okno_2_4_title";
                try {
                    con = connection.ConnectDB();
                    String sql = "select * from projekty_data where id = '" + id + "' ";

                    pst = con.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs.next()) {

                        title = rs.getString("okno_2_4_title");
                        text = rs.getString("okno_2_4_text");
                        data = rs.getString("okno_2_4_data");
                        user = rs.getString("okno_2_4_user");
                        color = rs.getString("okno_2_4_color");

                    }
                    String query1 = "update projekty_data set " + okno_2_3_title + " = '" + title + "', " + okno_2_3_text + " = '" + text + "', " + okno_2_4_data + " = '" + data + "', " + okno_2_4_user + " = '" + user + "', " + okno_2_4_color + " = '" + color + "'  where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);

                    String sql2 = "update projekty_data set " + okno_2_4_title + " = '" + empty + "' where id=" + "'" + id + "'";
                    pst.executeUpdate(sql2);
                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Edycja");
                    alert.setHeaderText("Sukces !");
                    alert.setContentText("Usunięto");
                    alert.showAndWait();

                    ustawienia_zamknij(event);

                } catch (SQLException | HeadlessException e) {
                    System.out.println(e);
                }
            }

            if (title_number.equals("okno_2_4_title")) {
                try {
                    con = connection.ConnectDB();
                    String sql = "update projekty_data set " + title_number + " = '" + empty + "' where id=" + "'" + id + "'";
                    pst.executeUpdate(sql);
                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Edycja");
                    alert.setHeaderText("Sukces !");
                    alert.setContentText("Usunięto");
                    alert.showAndWait();

                    ustawienia_zamknij(event);

                } catch (SQLException e) {
                    System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                }
            }

            ////////////////////////
            ////////////////////////
            if (title_number.equals("okno_3_1_title")) {
                // Sytuacja jest taka, że jak usuniemy 1 pozycję to na miejsce 1 wchodi 2 na 2=3 a na 3=4, 4 idzie do kosza.    
                String title2 = "";
                String text2 = "";
                String data2 = "";
                String user2 = "";
                String color2 = "";
                String title3 = "";
                String text3 = "";
                String data3 = "";
                String user3 = "";
                String color3 = "";
                String title4 = "";
                String text4 = "";
                String data4 = "";
                String user4 = "";
                String color4 = "";

                //Tak mi wygodniej :)
                String okno_3_1_title = "okno_3_1_title";
                String okno_3_1_text = "okno_3_1_text";
                String okno_3_1_data = "okno_3_1_data";
                String okno_3_1_user = "okno_3_1_user";
                String okno_3_1_color = "okno_3_1_color";

                String okno_3_2_title = "okno_3_2_title";
                String okno_3_2_text = "okno_3_2_text";
                String okno_3_2_data = "okno_3_2_data";
                String okno_3_2_user = "okno_3_2_user";
                String okno_3_2_color = "okno_3_2_color";

                String okno_3_3_title = "okno_3_3_title";
                String okno_3_3_text = "okno_3_3_text";
                String okno_3_3_data = "okno_3_3_data";
                String okno_3_3_user = "okno_3_3_user";
                String okno_3_3_color = "okno_3_3_color";

                String okno_3_4_title = "okno_3_4_title";

                try {
                    con = connection.ConnectDB();
                    String sql = "select * from projekty_data where id = '" + id + "' ";

                    pst = con.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs.next()) {

                        title2 = rs.getString("okno_3_2_title");
                        text2 = rs.getString("okno_3_2_text");
                        data2 = rs.getString("okno_3_2_data");
                        user2 = rs.getString("okno_3_2_user");
                        color2 = rs.getString("okno_3_2_color");
                        title3 = rs.getString("okno_3_3_title");
                        text3 = rs.getString("okno_3_3_text");
                        data3 = rs.getString("okno_3_3_data");
                        user3 = rs.getString("okno_3_3_user");
                        color3 = rs.getString("okno_3_3_color");
                        title4 = rs.getString("okno_3_4_title");
                        text4 = rs.getString("okno_3_4_text");
                        data4 = rs.getString("okno_3_4_data");
                        user4 = rs.getString("okno_3_4_user");
                        color4 = rs.getString("okno_3_4_color");

                    }

                    String query0 = "update projekty_data set " + okno_3_1_title + " = '" + title2 + "', " + okno_3_1_text + " = '" + text2 + "', " + okno_3_1_data + " = '" + data2 + "', " + okno_3_1_user + " = '" + user2 + "', " + okno_3_1_color + " = '" + color2 + "'  where id=" + "'" + id + "'";
                    pst.executeUpdate(query0);

                    String query1 = "update projekty_data set " + okno_3_2_title + " = '" + title3 + "', " + okno_3_2_text + " = '" + text3 + "', " + okno_3_2_data + " = '" + data3 + "', " + okno_3_2_user + " = '" + user3 + "', " + okno_3_2_color + " = '" + color3 + "'  where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);

                    String query2 = "update projekty_data set " + okno_3_3_title + " = '" + title4 + "', " + okno_3_3_text + " = '" + text4 + "', " + okno_3_3_data + " = '" + data4 + "', " + okno_3_3_user + " = '" + user4 + "', " + okno_3_3_color + " = '" + color4 + "'  where id=" + "'" + id + "'";
                    pst.executeUpdate(query2);

                    String sql2 = "update projekty_data set " + okno_3_4_title + " = '" + empty + "' where id=" + "'" + id + "'";
                    pst.executeUpdate(sql2);

                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Edycja");
                    alert.setHeaderText("Sukces !");
                    alert.setContentText("Usunięto !");
                    alert.showAndWait();

                    ustawienia_zamknij(event);

                } catch (SQLException | HeadlessException e) {
                    System.out.println(e);
                }

            }

            if (title_number.equals("okno_3_2_title")) {

                // Sytuacja jest taka, że jak usuwany 2 pozycję na na miejsce 2 wchodzi 3 a na 3 pozycję 4 pozycję.
                String title3 = "";
                String text3 = "";
                String data3 = "";
                String user3 = "";
                String color3 = "";
                String title4 = "";
                String text4 = "";
                String data4 = "";
                String user4 = "";
                String color4 = "";

                //Tak mi wygodniej :)
                String okno_3_2_title = "okno_3_2_title";
                String okno_3_2_text = "okno_3_2_text";
                String okno_3_2_data = "okno_3_2_data";
                String okno_3_2_user = "okno_3_2_user";
                String okno_3_2_color = "okno_3_2_color";

                String okno_3_3_title = "okno_3_3_title";
                String okno_3_3_text = "okno_3_3_text";
                String okno_3_3_data = "okno_3_3_data";
                String okno_3_3_user = "okno_3_3_user";
                String okno_3_3_color = "okno_3_3_color";

                String okno_3_4_title = "okno_3_4_title";
                try {
                    con = connection.ConnectDB();
                    String sql = "select * from projekty_data where id = '" + id + "' ";

                    pst = con.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs.next()) {

                        title3 = rs.getString("okno_3_3_title");
                        text3 = rs.getString("okno_3_3_text");
                        data3 = rs.getString("okno_3_3_data");
                        user3 = rs.getString("okno_3_3_user");
                        color3 = rs.getString("okno_3_3_color");
                        title4 = rs.getString("okno_3_4_title");
                        text4 = rs.getString("okno_3_4_text");
                        data4 = rs.getString("okno_3_4_data");
                        user4 = rs.getString("okno_3_4_user");
                        color4 = rs.getString("okno_3_4_color");

                    }

                    String query1 = "update projekty_data set " + okno_3_2_title + " = '" + title3 + "', " + okno_3_2_text + " = '" + text3 + "', " + okno_3_2_data + " = '" + data3 + "', " + okno_3_2_user + " = '" + user3 + "', " + okno_3_2_color + " = '" + color3 + "'  where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);

                    String query2 = "update projekty_data set " + okno_3_3_title + " = '" + title4 + "', " + okno_3_3_text + " = '" + text4 + "', " + okno_3_3_data + " = '" + data4 + "', " + okno_3_3_user + " = '" + user4 + "', " + okno_3_3_color + " = '" + color4 + "'  where id=" + "'" + id + "'";
                    pst.executeUpdate(query2);

                    String sql2 = "update projekty_data set " + okno_3_4_title + " = '" + empty + "' where id=" + "'" + id + "'";
                    pst.executeUpdate(sql2);

                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Edycja");
                    alert.setHeaderText("Sukces !");
                    alert.setContentText("Usunięto !");
                    alert.showAndWait();

                    ustawienia_zamknij(event);

                } catch (SQLException | HeadlessException e) {
                    System.out.println(e);
                }

            }

            if (title_number.equals("okno_3_3_title")) {
                String title = "";
                String text = "";
                String data = "";
                String user = "";
                String color = "";

                String okno_3_3_title = "okno_3_3_title";
                String okno_3_3_text = "okno_3_3_text";
                String okno_3_4_data = "okno_3_4_data";
                String okno_3_4_user = "okno_3_4_user";
                String okno_3_4_color = "okno_3_4_color";

                String okno_3_4_title = "okno_3_4_title";
                try {
                    con = connection.ConnectDB();
                    String sql = "select * from projekty_data where id = '" + id + "' ";

                    pst = con.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs.next()) {

                        title = rs.getString("okno_3_4_title");
                        text = rs.getString("okno_3_4_text");
                        data = rs.getString("okno_3_4_data");
                        user = rs.getString("okno_3_4_user");
                        color = rs.getString("okno_3_4_color");

                    }
                    String query1 = "update projekty_data set " + okno_3_3_title + " = '" + title + "', " + okno_3_3_text + " = '" + text + "', " + okno_3_4_data + " = '" + data + "', " + okno_3_4_user + " = '" + user + "', " + okno_3_4_color + " = '" + color + "'  where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);

                    String sql2 = "update projekty_data set " + okno_3_4_title + " = '" + empty + "' where id=" + "'" + id + "'";
                    pst.executeUpdate(sql2);
                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Edycja");
                    alert.setHeaderText("Sukces !");
                    alert.setContentText("Usunięto");
                    alert.showAndWait();

                    ustawienia_zamknij(event);

                } catch (SQLException | HeadlessException e) {
                    System.out.println(e);
                }
            }

            if (title_number.equals("okno_3_4_title")) {
                try {
                    con = connection.ConnectDB();
                    String sql = "update projekty_data set " + title_number + " = '" + empty + "' where id=" + "'" + id + "'";
                    pst.executeUpdate(sql);
                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Edycja");
                    alert.setHeaderText("Sukces !");
                    alert.setContentText("Usunięto");
                    alert.showAndWait();

                    ustawienia_zamknij(event);

                } catch (SQLException e) {
                    System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                }
            }

            ////////////////////////
            ////////////////////////
            if (title_number.equals("okno_4_1_title")) {
                // Sytuacja jest taka, że jak usuniemy 1 pozycję to na miejsce 1 wchodi 2 na 2=3 a na 3=4, 4 idzie do kosza.    
                String title2 = "";
                String text2 = "";
                String data2 = "";
                String user2 = "";
                String color2 = "";
                String title3 = "";
                String text3 = "";
                String data3 = "";
                String user3 = "";
                String color3 = "";
                String title4 = "";
                String text4 = "";
                String data4 = "";
                String user4 = "";
                String color4 = "";

                //Tak mi wygodniej :)
                String okno_4_1_title = "okno_4_1_title";
                String okno_4_1_text = "okno_4_1_text";
                String okno_4_1_data = "okno_4_1_data";
                String okno_4_1_user = "okno_4_1_user";
                String okno_4_1_color = "okno_4_1_color";

                String okno_4_2_title = "okno_4_2_title";
                String okno_4_2_text = "okno_4_2_text";
                String okno_4_2_data = "okno_4_2_data";
                String okno_4_2_user = "okno_4_2_user";
                String okno_4_2_color = "okno_4_2_color";

                String okno_4_3_title = "okno_4_3_title";
                String okno_4_3_text = "okno_4_3_text";
                String okno_4_3_data = "okno_4_3_data";
                String okno_4_3_user = "okno_4_3_user";
                String okno_4_3_color = "okno_4_3_color";

                String okno_4_4_title = "okno_4_4_title";

                try {
                    con = connection.ConnectDB();
                    String sql = "select * from projekty_data where id = '" + id + "' ";

                    pst = con.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs.next()) {

                        title2 = rs.getString("okno_4_2_title");
                        text2 = rs.getString("okno_4_2_text");
                        data2 = rs.getString("okno_4_2_data");
                        user2 = rs.getString("okno_4_2_user");
                        color2 = rs.getString("okno_4_2_color");
                        title3 = rs.getString("okno_4_3_title");
                        text3 = rs.getString("okno_4_3_text");
                        data3 = rs.getString("okno_4_3_data");
                        user3 = rs.getString("okno_4_3_user");
                        color3 = rs.getString("okno_4_3_color");
                        title4 = rs.getString("okno_4_4_title");
                        text4 = rs.getString("okno_4_4_text");
                        data4 = rs.getString("okno_4_4_data");
                        user4 = rs.getString("okno_4_4_user");
                        color4 = rs.getString("okno_4_4_color");

                    }

                    String query0 = "update projekty_data set " + okno_4_1_title + " = '" + title2 + "', " + okno_4_1_text + " = '" + text2 + "', " + okno_4_1_data + " = '" + data2 + "', " + okno_4_1_user + " = '" + user2 + "', " + okno_4_1_color + " = '" + color2 + "'  where id=" + "'" + id + "'";
                    pst.executeUpdate(query0);

                    String query1 = "update projekty_data set " + okno_4_2_title + " = '" + title3 + "', " + okno_4_2_text + " = '" + text3 + "', " + okno_4_2_data + " = '" + data3 + "', " + okno_4_2_user + " = '" + user3 + "', " + okno_4_2_color + " = '" + color3 + "'  where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);

                    String query2 = "update projekty_data set " + okno_4_3_title + " = '" + title4 + "', " + okno_4_3_text + " = '" + text4 + "', " + okno_4_3_data + " = '" + data4 + "', " + okno_4_3_user + " = '" + user4 + "', " + okno_4_3_color + " = '" + color4 + "'  where id=" + "'" + id + "'";
                    pst.executeUpdate(query2);

                    String sql2 = "update projekty_data set " + okno_4_4_title + " = '" + empty + "' where id=" + "'" + id + "'";
                    pst.executeUpdate(sql2);

                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Edycja");
                    alert.setHeaderText("Sukces !");
                    alert.setContentText("Usunięto !");
                    alert.showAndWait();

                    ustawienia_zamknij(event);

                } catch (SQLException | HeadlessException e) {
                    System.out.println(e);
                }

            }

            if (title_number.equals("okno_4_2_title")) {

                // Sytuacja jest taka, że jak usuwany 2 pozycję na na miejsce 2 wchodzi 3 a na 3 pozycję 4 pozycję.
                String title3 = "";
                String text3 = "";
                String data3 = "";
                String user3 = "";
                String color3 = "";
                String title4 = "";
                String text4 = "";
                String data4 = "";
                String user4 = "";
                String color4 = "";

                //Tak mi wygodniej :)
                String okno_4_2_title = "okno_4_2_title";
                String okno_4_2_text = "okno_4_2_text";
                String okno_4_2_data = "okno_4_2_data";
                String okno_4_2_user = "okno_4_2_user";
                String okno_4_2_color = "okno_4_2_color";

                String okno_4_3_title = "okno_4_3_title";
                String okno_4_3_text = "okno_4_3_text";
                String okno_4_3_data = "okno_4_3_data";
                String okno_4_3_user = "okno_4_3_user";
                String okno_4_3_color = "okno_4_3_color";

                String okno_4_4_title = "okno_4_4_title";
                try {
                    con = connection.ConnectDB();
                    String sql = "select * from projekty_data where id = '" + id + "' ";

                    pst = con.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs.next()) {

                        title3 = rs.getString("okno_4_3_title");
                        text3 = rs.getString("okno_4_3_text");
                        data3 = rs.getString("okno_4_3_data");
                        user3 = rs.getString("okno_4_3_user");
                        color3 = rs.getString("okno_4_3_color");
                        title4 = rs.getString("okno_4_4_title");
                        text4 = rs.getString("okno_4_4_text");
                        data4 = rs.getString("okno_4_4_data");
                        user4 = rs.getString("okno_4_4_user");
                        color4 = rs.getString("okno_4_4_color");

                    }

                    String query1 = "update projekty_data set " + okno_4_2_title + " = '" + title3 + "', " + okno_4_2_text + " = '" + text3 + "', " + okno_4_2_data + " = '" + data3 + "', " + okno_4_2_user + " = '" + user3 + "', " + okno_4_2_color + " = '" + color3 + "'  where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);

                    String query2 = "update projekty_data set " + okno_4_3_title + " = '" + title4 + "', " + okno_4_3_text + " = '" + text4 + "', " + okno_4_3_data + " = '" + data4 + "', " + okno_4_3_user + " = '" + user4 + "', " + okno_4_3_color + " = '" + color4 + "'  where id=" + "'" + id + "'";
                    pst.executeUpdate(query2);

                    String sql2 = "update projekty_data set " + okno_4_4_title + " = '" + empty + "' where id=" + "'" + id + "'";
                    pst.executeUpdate(sql2);

                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Edycja");
                    alert.setHeaderText("Sukces !");
                    alert.setContentText("Usunięto !");
                    alert.showAndWait();

                    ustawienia_zamknij(event);

                } catch (SQLException | HeadlessException e) {
                    System.out.println(e);
                }

            }

            if (title_number.equals("okno_4_3_title")) {
                String title = "";
                String text = "";
                String data = "";
                String user = "";
                String color = "";

                String okno_4_3_title = "okno_4_3_title";
                String okno_4_3_text = "okno_4_3_text";
                String okno_4_4_data = "okno_4_4_data";
                String okno_4_4_user = "okno_4_4_user";
                String okno_4_4_color = "okno_4_4_color";

                String okno_4_4_title = "okno_4_4_title";
                try {
                    con = connection.ConnectDB();
                    String sql = "select * from projekty_data where id = '" + id + "' ";

                    pst = con.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs.next()) {

                        title = rs.getString("okno_4_4_title");
                        text = rs.getString("okno_4_4_text");
                        data = rs.getString("okno_4_4_data");
                        user = rs.getString("okno_4_4_user");
                        color = rs.getString("okno_4_4_color");

                    }
                    String query1 = "update projekty_data set " + okno_4_3_title + " = '" + title + "', " + okno_4_3_text + " = '" + text + "', " + okno_4_4_data + " = '" + data + "', " + okno_4_4_user + " = '" + user + "', " + okno_4_4_color + " = '" + color + "'  where id=" + "'" + id + "'";
                    pst.executeUpdate(query1);

                    String sql2 = "update projekty_data set " + okno_4_4_title + " = '" + empty + "' where id=" + "'" + id + "'";
                    pst.executeUpdate(sql2);
                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Edycja");
                    alert.setHeaderText("Sukces !");
                    alert.setContentText("Usunięto");
                    alert.showAndWait();

                    ustawienia_zamknij(event);

                } catch (SQLException | HeadlessException e) {
                    System.out.println(e);
                }
            }

            if (title_number.equals("okno_4_4_title")) {
                try {
                    con = connection.ConnectDB();
                    String sql = "update projekty_data set " + title_number + " = '" + empty + "' where id=" + "'" + id + "'";
                    pst.executeUpdate(sql);
                    pst.close();
                    con.close();

                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Edycja");
                    alert.setHeaderText("Sukces !");
                    alert.setContentText("Usunięto");
                    alert.showAndWait();

                    ustawienia_zamknij(event);

                } catch (SQLException e) {
                    System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                }
            }

            ////////////////////////
        }
        okno_1_init();
        okno_2_init();
        okno_3_init();
        okno_4_init();

    }

    public void przenoszenie_sort() {
        String empty = "";

        if (title_number.equals("okno_1_1_title")) {
            // Sytuacja jest taka, że jak usuniemy 1 pozycję to na miejsce 1 wchodi 2 na 2=3 a na 3=4, 4 idzie do kosza.    
            String title2 = "";
            String text2 = "";
            String data2 = "";
            String user2 = "";
            String color2 = "";
            String title3 = "";
            String text3 = "";
            String data3 = "";
            String user3 = "";
            String color3 = "";
            String title4 = "";
            String text4 = "";
            String data4 = "";
            String user4 = "";
            String color4 = "";

            //Tak mi wygodniej :)
            String okno_1_1_title = "okno_1_1_title";
            String okno_1_1_text = "okno_1_1_text";
            String okno_1_1_data = "okno_1_1_data";
            String okno_1_1_user = "okno_1_1_user";
            String okno_1_1_color = "okno_1_1_color";

            String okno_1_2_title = "okno_1_2_title";
            String okno_1_2_text = "okno_1_2_text";
            String okno_1_2_data = "okno_1_2_data";
            String okno_1_2_user = "okno_1_2_user";
            String okno_1_2_color = "okno_1_2_color";

            String okno_1_3_title = "okno_1_3_title";
            String okno_1_3_text = "okno_1_3_text";
            String okno_1_3_data = "okno_1_3_data";
            String okno_1_3_user = "okno_1_3_user";
            String okno_1_3_color = "okno_1_3_color";

            String okno_1_4_title = "okno_1_4_title";

            try {
                con = connection.ConnectDB();
                String sql = "select * from projekty_data where id = '" + id + "' ";

                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {

                    title2 = rs.getString("okno_1_2_title");
                    text2 = rs.getString("okno_1_2_text");
                    data2 = rs.getString("okno_1_2_data");
                    user2 = rs.getString("okno_1_2_user");
                    color2 = rs.getString("okno_1_2_color");
                    title3 = rs.getString("okno_1_3_title");
                    text3 = rs.getString("okno_1_3_text");
                    data3 = rs.getString("okno_1_3_data");
                    user3 = rs.getString("okno_1_3_user");
                    color3 = rs.getString("okno_1_3_color");
                    title4 = rs.getString("okno_1_4_title");
                    text4 = rs.getString("okno_1_4_text");
                    data4 = rs.getString("okno_1_4_data");
                    user4 = rs.getString("okno_1_4_user");
                    color4 = rs.getString("okno_1_4_color");

                }

                String query0 = "update projekty_data set " + okno_1_1_title + " = '" + title2 + "', " + okno_1_1_text + " = '" + text2 + "', " + okno_1_1_data + " = '" + data2 + "', " + okno_1_1_user + " = '" + user2 + "', " + okno_1_1_color + " = '" + color2 + "'  where id=" + "'" + id + "'";
                pst.executeUpdate(query0);

                String query1 = "update projekty_data set " + okno_1_2_title + " = '" + title3 + "', " + okno_1_2_text + " = '" + text3 + "', " + okno_1_2_data + " = '" + data3 + "', " + okno_1_2_user + " = '" + user3 + "', " + okno_1_2_color + " = '" + color3 + "'  where id=" + "'" + id + "'";
                pst.executeUpdate(query1);

                String query2 = "update projekty_data set " + okno_1_3_title + " = '" + title4 + "', " + okno_1_3_text + " = '" + text4 + "', " + okno_1_3_data + " = '" + data4 + "', " + okno_1_3_user + " = '" + user4 + "', " + okno_1_3_color + " = '" + color4 + "'  where id=" + "'" + id + "'";
                pst.executeUpdate(query2);

                String sql2 = "update projekty_data set " + okno_1_4_title + " = '" + empty + "' where id=" + "'" + id + "'";
                pst.executeUpdate(sql2);

                pst.close();
                con.close();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Edycja");
                alert.setHeaderText("Sukces !");
                alert.setContentText("Usunięto !");
                alert.showAndWait();

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }

        }

        if (title_number.equals("okno_1_2_title")) {

            // Sytuacja jest taka, że jak usuwany 2 pozycję na na miejsce 2 wchodzi 3 a na 3 pozycję 4 pozycję.
            String title3 = "";
            String text3 = "";
            String data3 = "";
            String user3 = "";
            String color3 = "";
            String title4 = "";
            String text4 = "";
            String data4 = "";
            String user4 = "";
            String color4 = "";

            //Tak mi wygodniej :)
            String okno_1_2_title = "okno_1_2_title";
            String okno_1_2_text = "okno_1_2_text";
            String okno_1_2_data = "okno_1_2_data";
            String okno_1_2_user = "okno_1_2_user";
            String okno_1_2_color = "okno_1_2_color";

            String okno_1_3_title = "okno_1_3_title";
            String okno_1_3_text = "okno_1_3_text";
            String okno_1_3_data = "okno_1_3_data";
            String okno_1_3_user = "okno_1_3_user";
            String okno_1_3_color = "okno_1_3_color";

            String okno_1_4_title = "okno_1_4_title";
            try {
                con = connection.ConnectDB();
                String sql = "select * from projekty_data where id = '" + id + "' ";

                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {

                    title3 = rs.getString("okno_1_3_title");
                    text3 = rs.getString("okno_1_3_text");
                    data3 = rs.getString("okno_1_3_data");
                    user3 = rs.getString("okno_1_3_user");
                    color3 = rs.getString("okno_1_3_color");
                    title4 = rs.getString("okno_1_4_title");
                    text4 = rs.getString("okno_1_4_text");
                    data4 = rs.getString("okno_1_4_data");
                    user4 = rs.getString("okno_1_4_user");
                    color4 = rs.getString("okno_1_4_color");

                }

                String query1 = "update projekty_data set " + okno_1_2_title + " = '" + title3 + "', " + okno_1_2_text + " = '" + text3 + "', " + okno_1_2_data + " = '" + data3 + "', " + okno_1_2_user + " = '" + user3 + "', " + okno_1_2_color + " = '" + color3 + "'  where id=" + "'" + id + "'";
                pst.executeUpdate(query1);

                String query2 = "update projekty_data set " + okno_1_3_title + " = '" + title4 + "', " + okno_1_3_text + " = '" + text4 + "', " + okno_1_3_data + " = '" + data4 + "', " + okno_1_3_user + " = '" + user4 + "', " + okno_1_3_color + " = '" + color4 + "'  where id=" + "'" + id + "'";
                pst.executeUpdate(query2);

                String sql2 = "update projekty_data set " + okno_1_4_title + " = '" + empty + "' where id=" + "'" + id + "'";
                pst.executeUpdate(sql2);

                pst.close();
                con.close();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Edycja");
                alert.setHeaderText("Sukces !");
                alert.setContentText("Usunięto !");
                alert.showAndWait();

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }

        }

        if (title_number.equals("okno_1_3_title")) {
            String title = "";
            String text = "";
            String data = "";
            String user = "";
            String color = "";

            String okno_1_3_title = "okno_1_3_title";
            String okno_1_3_text = "okno_1_3_text";
            String okno_1_4_data = "okno_1_4_data";
            String okno_1_4_user = "okno_1_4_user";
            String okno_1_4_color = "okno_1_4_color";

            String okno_1_4_title = "okno_1_4_title";
            try {
                con = connection.ConnectDB();
                String sql = "select * from projekty_data where id = '" + id + "' ";

                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {

                    title = rs.getString("okno_1_4_title");
                    text = rs.getString("okno_1_4_text");
                    data = rs.getString("okno_1_4_data");
                    user = rs.getString("okno_1_4_user");
                    color = rs.getString("okno_1_4_color");

                }
                String query1 = "update projekty_data set " + okno_1_3_title + " = '" + title + "', " + okno_1_3_text + " = '" + text + "', " + okno_1_4_data + " = '" + data + "', " + okno_1_4_user + " = '" + user + "', " + okno_1_4_color + " = '" + color + "'  where id=" + "'" + id + "'";
                pst.executeUpdate(query1);

                String sql2 = "update projekty_data set " + okno_1_4_title + " = '" + empty + "' where id=" + "'" + id + "'";
                pst.executeUpdate(sql2);
                pst.close();
                con.close();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Edycja");
                alert.setHeaderText("Sukces !");
                alert.setContentText("Usunięto");
                alert.showAndWait();

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }
        }

        if (title_number.equals("okno_1_4_title")) {
            try {
                con = connection.ConnectDB();
                String sql = "update projekty_data set " + title_number + " = '" + empty + "' where id=" + "'" + id + "'";
                pst.executeUpdate(sql);
                pst.close();
                con.close();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Edycja");
                alert.setHeaderText("Sukces !");
                alert.setContentText("Usunięto");
                alert.showAndWait();

                // DOKOŃCZYĆ
            } catch (SQLException e) {
                System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
            }
        }

        ////////////////////////
        if (title_number.equals("okno_2_1_title")) {
            // Sytuacja jest taka, że jak usuniemy 1 pozycję to na miejsce 1 wchodi 2 na 2=3 a na 3=4, 4 idzie do kosza.    
            String title2 = "";
            String text2 = "";
            String data2 = "";
            String user2 = "";
            String color2 = "";
            String title3 = "";
            String text3 = "";
            String data3 = "";
            String user3 = "";
            String color3 = "";
            String title4 = "";
            String text4 = "";
            String data4 = "";
            String user4 = "";
            String color4 = "";

            //Tak mi wygodniej :)
            String okno_2_1_title = "okno_2_1_title";
            String okno_2_1_text = "okno_2_1_text";
            String okno_2_1_data = "okno_2_1_data";
            String okno_2_1_user = "okno_2_1_user";
            String okno_2_1_color = "okno_2_1_color";

            String okno_2_2_title = "okno_2_2_title";
            String okno_2_2_text = "okno_2_2_text";
            String okno_2_2_data = "okno_2_2_data";
            String okno_2_2_user = "okno_2_2_user";
            String okno_2_2_color = "okno_2_2_color";

            String okno_2_3_title = "okno_2_3_title";
            String okno_2_3_text = "okno_2_3_text";
            String okno_2_3_data = "okno_2_3_data";
            String okno_2_3_user = "okno_2_3_user";
            String okno_2_3_color = "okno_2_3_color";

            String okno_2_4_title = "okno_2_4_title";

            try {
                con = connection.ConnectDB();
                String sql = "select * from projekty_data where id = '" + id + "' ";

                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {

                    title2 = rs.getString("okno_2_2_title");
                    text2 = rs.getString("okno_2_2_text");
                    data2 = rs.getString("okno_2_2_data");
                    user2 = rs.getString("okno_2_2_user");
                    color2 = rs.getString("okno_2_2_color");
                    title3 = rs.getString("okno_2_3_title");
                    text3 = rs.getString("okno_2_3_text");
                    data3 = rs.getString("okno_2_3_data");
                    user3 = rs.getString("okno_2_3_user");
                    color3 = rs.getString("okno_2_3_color");
                    title4 = rs.getString("okno_2_4_title");
                    text4 = rs.getString("okno_2_4_text");
                    data4 = rs.getString("okno_2_4_data");
                    user4 = rs.getString("okno_2_4_user");
                    color4 = rs.getString("okno_2_4_color");

                }

                String query0 = "update projekty_data set " + okno_2_1_title + " = '" + title2 + "', " + okno_2_1_text + " = '" + text2 + "', " + okno_2_1_data + " = '" + data2 + "', " + okno_2_1_user + " = '" + user2 + "', " + okno_2_1_color + " = '" + color2 + "'  where id=" + "'" + id + "'";
                pst.executeUpdate(query0);

                String query1 = "update projekty_data set " + okno_2_2_title + " = '" + title3 + "', " + okno_2_2_text + " = '" + text3 + "', " + okno_2_2_data + " = '" + data3 + "', " + okno_2_2_user + " = '" + user3 + "', " + okno_2_2_color + " = '" + color3 + "'  where id=" + "'" + id + "'";
                pst.executeUpdate(query1);

                String query2 = "update projekty_data set " + okno_2_3_title + " = '" + title4 + "', " + okno_2_3_text + " = '" + text4 + "', " + okno_2_3_data + " = '" + data4 + "', " + okno_2_3_user + " = '" + user4 + "', " + okno_2_3_color + " = '" + color4 + "'  where id=" + "'" + id + "'";
                pst.executeUpdate(query2);

                String sql2 = "update projekty_data set " + okno_2_4_title + " = '" + empty + "' where id=" + "'" + id + "'";
                pst.executeUpdate(sql2);

                pst.close();
                con.close();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Edycja");
                alert.setHeaderText("Sukces !");
                alert.setContentText("Usunięto !");
                alert.showAndWait();

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }

        }

        if (title_number.equals("okno_2_2_title")) {

            // Sytuacja jest taka, że jak usuwany 2 pozycję na na miejsce 2 wchodzi 3 a na 3 pozycję 4 pozycję.
            String title3 = "";
            String text3 = "";
            String data3 = "";
            String user3 = "";
            String color3 = "";
            String title4 = "";
            String text4 = "";
            String data4 = "";
            String user4 = "";
            String color4 = "";

            //Tak mi wygodniej :)
            String okno_2_2_title = "okno_2_2_title";
            String okno_2_2_text = "okno_2_2_text";
            String okno_2_2_data = "okno_2_2_data";
            String okno_2_2_user = "okno_2_2_user";
            String okno_2_2_color = "okno_2_2_color";

            String okno_2_3_title = "okno_2_3_title";
            String okno_2_3_text = "okno_2_3_text";
            String okno_2_3_data = "okno_2_3_data";
            String okno_2_3_user = "okno_2_3_user";
            String okno_2_3_color = "okno_2_3_color";

            String okno_2_4_title = "okno_2_4_title";
            try {
                con = connection.ConnectDB();
                String sql = "select * from projekty_data where id = '" + id + "' ";

                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {

                    title3 = rs.getString("okno_2_3_title");
                    text3 = rs.getString("okno_2_3_text");
                    data3 = rs.getString("okno_2_3_data");
                    user3 = rs.getString("okno_2_3_user");
                    color3 = rs.getString("okno_2_3_color");
                    title4 = rs.getString("okno_2_4_title");
                    text4 = rs.getString("okno_2_4_text");
                    data4 = rs.getString("okno_2_4_data");
                    user4 = rs.getString("okno_2_4_user");
                    color4 = rs.getString("okno_2_4_color");

                }

                String query1 = "update projekty_data set " + okno_2_2_title + " = '" + title3 + "', " + okno_2_2_text + " = '" + text3 + "', " + okno_2_2_data + " = '" + data3 + "', " + okno_2_2_user + " = '" + user3 + "', " + okno_2_2_color + " = '" + color3 + "'  where id=" + "'" + id + "'";
                pst.executeUpdate(query1);

                String query2 = "update projekty_data set " + okno_2_3_title + " = '" + title4 + "', " + okno_2_3_text + " = '" + text4 + "', " + okno_2_3_data + " = '" + data4 + "', " + okno_2_3_user + " = '" + user4 + "', " + okno_2_3_color + " = '" + color4 + "'  where id=" + "'" + id + "'";
                pst.executeUpdate(query2);

                String sql2 = "update projekty_data set " + okno_2_4_title + " = '" + empty + "' where id=" + "'" + id + "'";
                pst.executeUpdate(sql2);

                pst.close();
                con.close();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Edycja");
                alert.setHeaderText("Sukces !");
                alert.setContentText("Usunięto !");
                alert.showAndWait();

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }

        }

        if (title_number.equals("okno_2_3_title")) {
            String title = "";
            String text = "";
            String data = "";
            String user = "";
            String color = "";

            String okno_2_3_title = "okno_2_3_title";
            String okno_2_3_text = "okno_2_3_text";
            String okno_2_4_data = "okno_2_4_data";
            String okno_2_4_user = "okno_2_4_user";
            String okno_2_4_color = "okno_2_4_color";

            String okno_2_4_title = "okno_2_4_title";
            try {
                con = connection.ConnectDB();
                String sql = "select * from projekty_data where id = '" + id + "' ";

                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {

                    title = rs.getString("okno_2_4_title");
                    text = rs.getString("okno_2_4_text");
                    data = rs.getString("okno_2_4_data");
                    user = rs.getString("okno_2_4_user");
                    color = rs.getString("okno_2_4_color");

                }
                String query1 = "update projekty_data set " + okno_2_3_title + " = '" + title + "', " + okno_2_3_text + " = '" + text + "', " + okno_2_4_data + " = '" + data + "', " + okno_2_4_user + " = '" + user + "', " + okno_2_4_color + " = '" + color + "'  where id=" + "'" + id + "'";
                pst.executeUpdate(query1);

                String sql2 = "update projekty_data set " + okno_2_4_title + " = '" + empty + "' where id=" + "'" + id + "'";
                pst.executeUpdate(sql2);
                pst.close();
                con.close();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Edycja");
                alert.setHeaderText("Sukces !");
                alert.setContentText("Usunięto");
                alert.showAndWait();

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }
        }

        if (title_number.equals("okno_2_4_title")) {
            try {
                con = connection.ConnectDB();
                String sql = "update projekty_data set " + title_number + " = '" + empty + "' where id=" + "'" + id + "'";
                pst.executeUpdate(sql);
                pst.close();
                con.close();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Edycja");
                alert.setHeaderText("Sukces !");
                alert.setContentText("Usunięto");
                alert.showAndWait();

            } catch (SQLException e) {
                System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
            }
        }

        ////////////////////////
        ////////////////////////
        if (title_number.equals("okno_3_1_title")) {
            // Sytuacja jest taka, że jak usuniemy 1 pozycję to na miejsce 1 wchodi 2 na 2=3 a na 3=4, 4 idzie do kosza.    
            String title2 = "";
            String text2 = "";
            String data2 = "";
            String user2 = "";
            String color2 = "";
            String title3 = "";
            String text3 = "";
            String data3 = "";
            String user3 = "";
            String color3 = "";
            String title4 = "";
            String text4 = "";
            String data4 = "";
            String user4 = "";
            String color4 = "";

            //Tak mi wygodniej :)
            String okno_3_1_title = "okno_3_1_title";
            String okno_3_1_text = "okno_3_1_text";
            String okno_3_1_data = "okno_3_1_data";
            String okno_3_1_user = "okno_3_1_user";
            String okno_3_1_color = "okno_3_1_color";

            String okno_3_2_title = "okno_3_2_title";
            String okno_3_2_text = "okno_3_2_text";
            String okno_3_2_data = "okno_3_2_data";
            String okno_3_2_user = "okno_3_2_user";
            String okno_3_2_color = "okno_3_2_color";

            String okno_3_3_title = "okno_3_3_title";
            String okno_3_3_text = "okno_3_3_text";
            String okno_3_3_data = "okno_3_3_data";
            String okno_3_3_user = "okno_3_3_user";
            String okno_3_3_color = "okno_3_3_color";

            String okno_3_4_title = "okno_3_4_title";

            try {
                con = connection.ConnectDB();
                String sql = "select * from projekty_data where id = '" + id + "' ";

                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {

                    title2 = rs.getString("okno_3_2_title");
                    text2 = rs.getString("okno_3_2_text");
                    data2 = rs.getString("okno_3_2_data");
                    user2 = rs.getString("okno_3_2_user");
                    color2 = rs.getString("okno_3_2_color");
                    title3 = rs.getString("okno_3_3_title");
                    text3 = rs.getString("okno_3_3_text");
                    data3 = rs.getString("okno_3_3_data");
                    user3 = rs.getString("okno_3_3_user");
                    color3 = rs.getString("okno_3_3_color");
                    title4 = rs.getString("okno_3_4_title");
                    text4 = rs.getString("okno_3_4_text");
                    data4 = rs.getString("okno_3_4_data");
                    user4 = rs.getString("okno_3_4_user");
                    color4 = rs.getString("okno_3_4_color");

                }

                String query0 = "update projekty_data set " + okno_3_1_title + " = '" + title2 + "', " + okno_3_1_text + " = '" + text2 + "', " + okno_3_1_data + " = '" + data2 + "', " + okno_3_1_user + " = '" + user2 + "', " + okno_3_1_color + " = '" + color2 + "'  where id=" + "'" + id + "'";
                pst.executeUpdate(query0);

                String query1 = "update projekty_data set " + okno_3_2_title + " = '" + title3 + "', " + okno_3_2_text + " = '" + text3 + "', " + okno_3_2_data + " = '" + data3 + "', " + okno_3_2_user + " = '" + user3 + "', " + okno_3_2_color + " = '" + color3 + "'  where id=" + "'" + id + "'";
                pst.executeUpdate(query1);

                String query2 = "update projekty_data set " + okno_3_3_title + " = '" + title4 + "', " + okno_3_3_text + " = '" + text4 + "', " + okno_3_3_data + " = '" + data4 + "', " + okno_3_3_user + " = '" + user4 + "', " + okno_3_3_color + " = '" + color4 + "'  where id=" + "'" + id + "'";
                pst.executeUpdate(query2);

                String sql2 = "update projekty_data set " + okno_3_4_title + " = '" + empty + "' where id=" + "'" + id + "'";
                pst.executeUpdate(sql2);

                pst.close();
                con.close();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Edycja");
                alert.setHeaderText("Sukces !");
                alert.setContentText("Usunięto !");
                alert.showAndWait();

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }

        }

        if (title_number.equals("okno_3_2_title")) {

            // Sytuacja jest taka, że jak usuwany 2 pozycję na na miejsce 2 wchodzi 3 a na 3 pozycję 4 pozycję.
            String title3 = "";
            String text3 = "";
            String data3 = "";
            String user3 = "";
            String color3 = "";
            String title4 = "";
            String text4 = "";
            String data4 = "";
            String user4 = "";
            String color4 = "";

            //Tak mi wygodniej :)
            String okno_3_2_title = "okno_3_2_title";
            String okno_3_2_text = "okno_3_2_text";
            String okno_3_2_data = "okno_3_2_data";
            String okno_3_2_user = "okno_3_2_user";
            String okno_3_2_color = "okno_3_2_color";

            String okno_3_3_title = "okno_3_3_title";
            String okno_3_3_text = "okno_3_3_text";
            String okno_3_3_data = "okno_3_3_data";
            String okno_3_3_user = "okno_3_3_user";
            String okno_3_3_color = "okno_3_3_color";

            String okno_3_4_title = "okno_3_4_title";
            try {
                con = connection.ConnectDB();
                String sql = "select * from projekty_data where id = '" + id + "' ";

                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {

                    title3 = rs.getString("okno_3_3_title");
                    text3 = rs.getString("okno_3_3_text");
                    data3 = rs.getString("okno_3_3_data");
                    user3 = rs.getString("okno_3_3_user");
                    color3 = rs.getString("okno_3_3_color");
                    title4 = rs.getString("okno_3_4_title");
                    text4 = rs.getString("okno_3_4_text");
                    data4 = rs.getString("okno_3_4_data");
                    user4 = rs.getString("okno_3_4_user");
                    color4 = rs.getString("okno_3_4_color");

                }

                String query1 = "update projekty_data set " + okno_3_2_title + " = '" + title3 + "', " + okno_3_2_text + " = '" + text3 + "', " + okno_3_2_data + " = '" + data3 + "', " + okno_3_2_user + " = '" + user3 + "', " + okno_3_2_color + " = '" + color3 + "'  where id=" + "'" + id + "'";
                pst.executeUpdate(query1);

                String query2 = "update projekty_data set " + okno_3_3_title + " = '" + title4 + "', " + okno_3_3_text + " = '" + text4 + "', " + okno_3_3_data + " = '" + data4 + "', " + okno_3_3_user + " = '" + user4 + "', " + okno_3_3_color + " = '" + color4 + "'  where id=" + "'" + id + "'";
                pst.executeUpdate(query2);

                String sql2 = "update projekty_data set " + okno_3_4_title + " = '" + empty + "' where id=" + "'" + id + "'";
                pst.executeUpdate(sql2);

                pst.close();
                con.close();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Edycja");
                alert.setHeaderText("Sukces !");
                alert.setContentText("Usunięto !");
                alert.showAndWait();

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }

        }

        if (title_number.equals("okno_3_3_title")) {
            String title = "";
            String text = "";
            String data = "";
            String user = "";
            String color = "";

            String okno_3_3_title = "okno_3_3_title";
            String okno_3_3_text = "okno_3_3_text";
            String okno_3_4_data = "okno_3_4_data";
            String okno_3_4_user = "okno_3_4_user";
            String okno_3_4_color = "okno_3_4_color";

            String okno_3_4_title = "okno_3_4_title";
            try {
                con = connection.ConnectDB();
                String sql = "select * from projekty_data where id = '" + id + "' ";

                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {

                    title = rs.getString("okno_3_4_title");
                    text = rs.getString("okno_3_4_text");
                    data = rs.getString("okno_3_4_data");
                    user = rs.getString("okno_3_4_user");
                    color = rs.getString("okno_3_4_color");

                }
                String query1 = "update projekty_data set " + okno_3_3_title + " = '" + title + "', " + okno_3_3_text + " = '" + text + "', " + okno_3_4_data + " = '" + data + "', " + okno_3_4_user + " = '" + user + "', " + okno_3_4_color + " = '" + color + "'  where id=" + "'" + id + "'";
                pst.executeUpdate(query1);

                String sql2 = "update projekty_data set " + okno_3_4_title + " = '" + empty + "' where id=" + "'" + id + "'";
                pst.executeUpdate(sql2);
                pst.close();
                con.close();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Edycja");
                alert.setHeaderText("Sukces !");
                alert.setContentText("Usunięto");
                alert.showAndWait();

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }
        }

        if (title_number.equals("okno_3_4_title")) {
            try {
                con = connection.ConnectDB();
                String sql = "update projekty_data set " + title_number + " = '" + empty + "' where id=" + "'" + id + "'";
                pst.executeUpdate(sql);
                pst.close();
                con.close();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Edycja");
                alert.setHeaderText("Sukces !");
                alert.setContentText("Usunięto");
                alert.showAndWait();

            } catch (SQLException e) {
                System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
            }
        }

        ////////////////////////
        ////////////////////////
        if (title_number.equals("okno_4_1_title")) {
            // Sytuacja jest taka, że jak usuniemy 1 pozycję to na miejsce 1 wchodi 2 na 2=3 a na 3=4, 4 idzie do kosza.    
            String title2 = "";
            String text2 = "";
            String data2 = "";
            String user2 = "";
            String color2 = "";
            String title3 = "";
            String text3 = "";
            String data3 = "";
            String user3 = "";
            String color3 = "";
            String title4 = "";
            String text4 = "";
            String data4 = "";
            String user4 = "";
            String color4 = "";

            //Tak mi wygodniej :)
            String okno_4_1_title = "okno_4_1_title";
            String okno_4_1_text = "okno_4_1_text";
            String okno_4_1_data = "okno_4_1_data";
            String okno_4_1_user = "okno_4_1_user";
            String okno_4_1_color = "okno_4_1_color";

            String okno_4_2_title = "okno_4_2_title";
            String okno_4_2_text = "okno_4_2_text";
            String okno_4_2_data = "okno_4_2_data";
            String okno_4_2_user = "okno_4_2_user";
            String okno_4_2_color = "okno_4_2_color";

            String okno_4_3_title = "okno_4_3_title";
            String okno_4_3_text = "okno_4_3_text";
            String okno_4_3_data = "okno_4_3_data";
            String okno_4_3_user = "okno_4_3_user";
            String okno_4_3_color = "okno_4_3_color";

            String okno_4_4_title = "okno_4_4_title";

            try {
                con = connection.ConnectDB();
                String sql = "select * from projekty_data where id = '" + id + "' ";

                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {

                    title2 = rs.getString("okno_4_2_title");
                    text2 = rs.getString("okno_4_2_text");
                    data2 = rs.getString("okno_4_2_data");
                    user2 = rs.getString("okno_4_2_user");
                    color2 = rs.getString("okno_4_2_color");
                    title3 = rs.getString("okno_4_3_title");
                    text3 = rs.getString("okno_4_3_text");
                    data3 = rs.getString("okno_4_3_data");
                    user3 = rs.getString("okno_4_3_user");
                    color3 = rs.getString("okno_4_3_color");
                    title4 = rs.getString("okno_4_4_title");
                    text4 = rs.getString("okno_4_4_text");
                    data4 = rs.getString("okno_4_4_data");
                    user4 = rs.getString("okno_4_4_user");
                    color4 = rs.getString("okno_4_4_color");

                }

                String query0 = "update projekty_data set " + okno_4_1_title + " = '" + title2 + "', " + okno_4_1_text + " = '" + text2 + "', " + okno_4_1_data + " = '" + data2 + "', " + okno_4_1_user + " = '" + user2 + "', " + okno_4_1_color + " = '" + color2 + "'  where id=" + "'" + id + "'";
                pst.executeUpdate(query0);

                String query1 = "update projekty_data set " + okno_4_2_title + " = '" + title3 + "', " + okno_4_2_text + " = '" + text3 + "', " + okno_4_2_data + " = '" + data3 + "', " + okno_4_2_user + " = '" + user3 + "', " + okno_4_2_color + " = '" + color3 + "'  where id=" + "'" + id + "'";
                pst.executeUpdate(query1);

                String query2 = "update projekty_data set " + okno_4_3_title + " = '" + title4 + "', " + okno_4_3_text + " = '" + text4 + "', " + okno_4_3_data + " = '" + data4 + "', " + okno_4_3_user + " = '" + user4 + "', " + okno_4_3_color + " = '" + color4 + "'  where id=" + "'" + id + "'";
                pst.executeUpdate(query2);

                String sql2 = "update projekty_data set " + okno_4_4_title + " = '" + empty + "' where id=" + "'" + id + "'";
                pst.executeUpdate(sql2);

                pst.close();
                con.close();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Edycja");
                alert.setHeaderText("Sukces !");
                alert.setContentText("Usunięto !");
                alert.showAndWait();

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }

        }

        if (title_number.equals("okno_4_2_title")) {

            // Sytuacja jest taka, że jak usuwany 2 pozycję na na miejsce 2 wchodzi 3 a na 3 pozycję 4 pozycję.
            String title3 = "";
            String text3 = "";
            String data3 = "";
            String user3 = "";
            String color3 = "";
            String title4 = "";
            String text4 = "";
            String data4 = "";
            String user4 = "";
            String color4 = "";

            //Tak mi wygodniej :)
            String okno_4_2_title = "okno_4_2_title";
            String okno_4_2_text = "okno_4_2_text";
            String okno_4_2_data = "okno_4_2_data";
            String okno_4_2_user = "okno_4_2_user";
            String okno_4_2_color = "okno_4_2_color";

            String okno_4_3_title = "okno_4_3_title";
            String okno_4_3_text = "okno_4_3_text";
            String okno_4_3_data = "okno_4_3_data";
            String okno_4_3_user = "okno_4_3_user";
            String okno_4_3_color = "okno_4_3_color";

            String okno_4_4_title = "okno_4_4_title";
            try {
                con = connection.ConnectDB();
                String sql = "select * from projekty_data where id = '" + id + "' ";

                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {

                    title3 = rs.getString("okno_4_3_title");
                    text3 = rs.getString("okno_4_3_text");
                    data3 = rs.getString("okno_4_3_data");
                    user3 = rs.getString("okno_4_3_user");
                    color3 = rs.getString("okno_4_3_color");
                    title4 = rs.getString("okno_4_4_title");
                    text4 = rs.getString("okno_4_4_text");
                    data4 = rs.getString("okno_4_4_data");
                    user4 = rs.getString("okno_4_4_user");
                    color4 = rs.getString("okno_4_4_color");

                }

                String query1 = "update projekty_data set " + okno_4_2_title + " = '" + title3 + "', " + okno_4_2_text + " = '" + text3 + "', " + okno_4_2_data + " = '" + data3 + "', " + okno_4_2_user + " = '" + user3 + "', " + okno_4_2_color + " = '" + color3 + "'  where id=" + "'" + id + "'";
                pst.executeUpdate(query1);

                String query2 = "update projekty_data set " + okno_4_3_title + " = '" + title4 + "', " + okno_4_3_text + " = '" + text4 + "', " + okno_4_3_data + " = '" + data4 + "', " + okno_4_3_user + " = '" + user4 + "', " + okno_4_3_color + " = '" + color4 + "'  where id=" + "'" + id + "'";
                pst.executeUpdate(query2);

                String sql2 = "update projekty_data set " + okno_4_4_title + " = '" + empty + "' where id=" + "'" + id + "'";
                pst.executeUpdate(sql2);

                pst.close();
                con.close();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Edycja");
                alert.setHeaderText("Sukces !");
                alert.setContentText("Usunięto !");
                alert.showAndWait();

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }

        }

        if (title_number.equals("okno_4_3_title")) {
            String title = "";
            String text = "";
            String data = "";
            String user = "";
            String color = "";

            String okno_4_3_title = "okno_4_3_title";
            String okno_4_3_text = "okno_4_3_text";
            String okno_4_4_data = "okno_4_4_data";
            String okno_4_4_user = "okno_4_4_user";
            String okno_4_4_color = "okno_4_4_color";

            String okno_4_4_title = "okno_4_4_title";
            try {
                con = connection.ConnectDB();
                String sql = "select * from projekty_data where id = '" + id + "' ";

                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {

                    title = rs.getString("okno_4_4_title");
                    text = rs.getString("okno_4_4_text");
                    data = rs.getString("okno_4_4_data");
                    user = rs.getString("okno_4_4_user");
                    color = rs.getString("okno_4_4_color");

                }
                String query1 = "update projekty_data set " + okno_4_3_title + " = '" + title + "', " + okno_4_3_text + " = '" + text + "', " + okno_4_4_data + " = '" + data + "', " + okno_4_4_user + " = '" + user + "', " + okno_4_4_color + " = '" + color + "'  where id=" + "'" + id + "'";
                pst.executeUpdate(query1);

                String sql2 = "update projekty_data set " + okno_4_4_title + " = '" + empty + "' where id=" + "'" + id + "'";
                pst.executeUpdate(sql2);
                pst.close();
                con.close();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Edycja");
                alert.setHeaderText("Sukces !");
                alert.setContentText("Usunięto");
                alert.showAndWait();

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }
        }

        if (title_number.equals("okno_4_4_title")) {
            try {
                con = connection.ConnectDB();
                String sql = "update projekty_data set " + title_number + " = '" + empty + "' where id=" + "'" + id + "'";
                pst.executeUpdate(sql);
                pst.close();
                con.close();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Edycja");
                alert.setHeaderText("Sukces !");
                alert.setContentText("Usunięto");
                alert.showAndWait();

            } catch (SQLException e) {
                System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
            }
        }
    }

    @FXML
    public void edycja_usun(ActionEvent event) throws IOException {
        edycja_zapisz = "usun";

        String title = notatki.getSelectionModel().getSelectedItem().toString();
        int selectedInted = notatki.getSelectionModel().getSelectedIndex() + 1;
        tytul_edycja.setText(title);

        if (edycja.equals("okno_1")) {
            if (selectedInted == 1) {
                text_number = "okno_1_1_text";
                title_number = "okno_1_1_title";

            }
            if (selectedInted == 2) {
                text_number = "okno_1_2_text";
                title_number = "okno_1_2_title";
            }
            if (selectedInted == 3) {
                text_number = "okno_1_3_text";
                title_number = "okno_1_3_title";
            }
            if (selectedInted == 4) {
                text_number = "okno_1_4_text";
                title_number = "okno_1_4_title";
            }
        } else if (edycja.equals("okno_2")) {
            if (selectedInted == 1) {
                text_number = "okno_2_1_text";
                title_number = "okno_2_1_title";
            }
            if (selectedInted == 2) {
                text_number = "okno_2_2_text";
                title_number = "okno_2_2_title";
            }
            if (selectedInted == 3) {
                text_number = "okno_2_3_text";
                title_number = "okno_2_3_title";
            }
            if (selectedInted == 4) {
                text_number = "okno_2_4_text";
                title_number = "okno_2_4_title";
            }
        } else if (edycja.equals("okno_3")) {
            if (selectedInted == 1) {
                text_number = "okno_3_1_text";
                title_number = "okno_3_1_title";
            }
            if (selectedInted == 2) {
                text_number = "okno_3_2_text";
                title_number = "okno_3_2_title";
            }
            if (selectedInted == 3) {
                text_number = "okno_3_3_text";
                title_number = "okno_3_3_title";
            }
            if (selectedInted == 4) {
                text_number = "okno_3_4_text";
                title_number = "okno_3_4_title";
            }
        } else if (edycja.equals("okno_4")) {
            if (selectedInted == 1) {
                text_number = "okno_4_1_text";
                title_number = "okno_4_1_title";
            }
            if (selectedInted == 2) {
                text_number = "okno_4_2_text";
                title_number = "okno_4_2_title";
            }
            if (selectedInted == 3) {
                text_number = "okno_4_3_text";
                title_number = "okno_4_3_title";
            }
            if (selectedInted == 4) {
                text_number = "okno_4_4_text";
                title_number = "okno_4_4_title";
            }
        }

    }

    @FXML
    public void edycja_przenies(ActionEvent event) throws IOException {
        edycja_zapisz = "przenies";

        String title = notatki.getSelectionModel().getSelectedItem().toString();
        int selectedInted = notatki.getSelectionModel().getSelectedIndex() + 1;
        int selectedWindow = miejsce_docelowe.getSelectionModel().getSelectedIndex() + 1;

        if (selectedWindow == 1) {
            window_title = "okno_1";
        }
        if (selectedWindow == 2) {
            window_title = "okno_2";
        }
        if (selectedWindow == 3) {
            window_title = "okno_3";
        }
        if (selectedWindow == 4) {
            window_title = "okno_4";
        }

        if (edycja.equals("okno_1")) {
            if (selectedInted == 1) {
                text_number = "okno_1_1_text";
                title_number = "okno_1_1_title";

            }
            if (selectedInted == 2) {
                text_number = "okno_1_2_text";
                title_number = "okno_1_2_title";
            }
            if (selectedInted == 3) {
                text_number = "okno_1_3_text";
                title_number = "okno_1_3_title";
            }
            if (selectedInted == 4) {
                text_number = "okno_1_4_text";
                title_number = "okno_1_4_title";
            }
        } else if (edycja.equals("okno_2")) {
            if (selectedInted == 1) {
                text_number = "okno_2_1_text";
                title_number = "okno_2_1_title";
            }
            if (selectedInted == 2) {
                text_number = "okno_2_2_text";
                title_number = "okno_2_2_title";
            }
            if (selectedInted == 3) {
                text_number = "okno_2_3_text";
                title_number = "okno_2_3_title";
            }
            if (selectedInted == 4) {
                text_number = "okno_2_4_text";
                title_number = "okno_2_4_title";
            }
        } else if (edycja.equals("okno_3")) {
            if (selectedInted == 1) {
                text_number = "okno_3_1_text";
                title_number = "okno_3_1_title";
            }
            if (selectedInted == 2) {
                text_number = "okno_3_2_text";
                title_number = "okno_3_2_title";
            }
            if (selectedInted == 3) {
                text_number = "okno_3_3_text";
                title_number = "okno_3_3_title";
            }
            if (selectedInted == 4) {
                text_number = "okno_3_4_text";
                title_number = "okno_3_4_title";
            }
        } else if (edycja.equals("okno_4")) {
            if (selectedInted == 1) {
                text_number = "okno_4_1_text";
                title_number = "okno_4_1_title";
            }
            if (selectedInted == 2) {
                text_number = "okno_4_2_text";
                title_number = "okno_4_2_title";
            }
            if (selectedInted == 3) {
                text_number = "okno_4_3_text";
                title_number = "okno_4_3_title";
            }
            if (selectedInted == 4) {
                text_number = "okno_4_4_text";
                title_number = "okno_4_4_title";
            }
        }
        tytul_edycja.setText(title);

    }

    @FXML
    public void edycja_1(ActionEvent event) throws IOException {
        edycja = "okno_1";
        edycja_okna();
    }

    @FXML
    public void edycja_2(ActionEvent event) throws IOException {
        edycja = "okno_2";
        edycja_okna();
    }

    @FXML
    public void edycja_3(ActionEvent event) throws IOException {
        edycja = "okno_3";
        edycja_okna();
    }

    @FXML
    public void edycja_4(ActionEvent event) throws IOException {
        edycja = "okno_4";
        edycja_okna();
    }

    @FXML
    public void users_window(ActionEvent event) throws IOException {
        
        
        uzytkownik_uprawnienia.getItems().add("Edycja");
        uzytkownik_uprawnienia.getItems().add("Podglad");
        
        uzytkownicy_okno.setVisible(true);
    
    }
    
    @FXML
    public void settings_window(ActionEvent event) throws IOException {
       
        String sql2 = "select * from projekty where id = '" + id + "' ";
        
        String add1 = "";
        String add2 = "";
        String add3 = "";
        String add4 = "";
        try {
            pst = con.prepareStatement(sql2);
            rs = pst.executeQuery();
            if (rs.next()) {
                add1 = rs.getString("okno_1");
                
                add2 = rs.getString("okno_2");
                
                add3 = rs.getString("okno_3");
                
                add4 = rs.getString("okno_4");
                
            }

        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
        ustawienia_edycja_okno.getItems().add(add1);
        ustawienia_edycja_okno.getItems().add(add2);
        ustawienia_edycja_okno.getItems().add(add3);
        ustawienia_edycja_okno.getItems().add(add4);
        
        ustawienia_okno.setVisible(true);
    }
    
    @FXML
    public void users_exit(ActionEvent event) throws IOException {
        uzytkownicy_okno.setVisible(false);
    }
    
    @FXML
    public void settings_exit(ActionEvent event) throws IOException {
        ustawienia_okno.setVisible(false);
    }
    
    @FXML
    public void ustawienia_edycja_zapisz(ActionEvent event) throws IOException {
      
        
    String okno = "";
    String nazwa = "";
    
    int selectedInted = ustawienia_edycja_okno.getSelectionModel().getSelectedIndex() + 1;

    nazwa = ustawienia_edycja_nazwa.getText();
    
    if(selectedInted==1){
    try {
                con = connection.ConnectDB();

                String query1 = "update projekty set okno_1 = '" +nazwa+ "' where id=" + "'" + id + "'";
                pst.executeUpdate(query1);
                pst.close();
                con.close();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Edycja");
                alert.setHeaderText("Sukces !");
                alert.setContentText("Zmiany zostały zapisane");
                alert.showAndWait();

                ustawienia_zamknij(event);

            } catch (SQLException e) {
                System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());

            }
            okno_1_init();    
    }
    
    else if(selectedInted==2){
    try {
                con = connection.ConnectDB();

                String query1 = "update projekty set okno_2 = '" +nazwa+ "' where id=" + "'" + id + "'";
                pst.executeUpdate(query1);
                pst.close();
                con.close();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Edycja");
                alert.setHeaderText("Sukces !");
                alert.setContentText("Zmiany zostały zapisane");
                alert.showAndWait();

                ustawienia_zamknij(event);

            } catch (SQLException e) {
                System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());

            }
            okno_1_init();    
    }
    
    else if(selectedInted==3){
    try {
                con = connection.ConnectDB();

                String query1 = "update projekty set okno_3 = '" +nazwa+ "' where id=" + "'" + id + "'";
                pst.executeUpdate(query1);
                pst.close();
                con.close();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Edycja");
                alert.setHeaderText("Sukces !");
                alert.setContentText("Zmiany zostały zapisane");
                alert.showAndWait();

                ustawienia_zamknij(event);

            } catch (SQLException e) {
                System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());

            }
            okno_1_init();    
    }
    
    else if(selectedInted==4){
    try {
                con = connection.ConnectDB();

                String query1 = "update projekty set okno_4 = '" +nazwa+ "' where id=" + "'" + id + "'";
                pst.executeUpdate(query1);
                pst.close();
                con.close();

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Edycja");
                alert.setHeaderText("Sukces !");
                alert.setContentText("Zmiany zostały zapisane");
                alert.showAndWait();

                ustawienia_zamknij(event);

            } catch (SQLException e) {
                System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());

            }
            okno_1_init();    
    }
    
           
    }
    
    @FXML
    public void uzytkownicy_dodaj(ActionEvent event) throws IOException {
      
        
    String usr_login = uzytkownik_login.getText();
    String usr_perm =   (String) uzytkownik_uprawnienia.getSelectionModel().getSelectedItem();
    
   
    String try_login = "";
    try {
                con = connection.ConnectDB();
                String sql = "select * from uzytkownicy where login = '" + usr_login + "' ";

                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {

                    try_login = rs.getString("login");
                   
                }

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }
    
    if(try_login.equals(usr_login)){
        
         try {
             con = connection.ConnectDB();
             String sql1 = "INSERT INTO projekty_uzytkownik(id_projektu ,login,uprawnienia) VALUES"
                                    + " ('" +id+ "','" +try_login+ "','" +usr_perm+ "')";
                            pst = con.prepareStatement(sql1);
                            pst.executeUpdate(sql1);
                            pst.close();
             
             } catch (SQLException e) {
                            System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());
                        }
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Sukces !");
                    alert.setHeaderText("Dodano !");
                    alert.setContentText("Użytkownik został dodany !");
                    alert.showAndWait();
        
    }
    else
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Błąd !");
                    alert.setHeaderText("Błąd !");
                    alert.setContentText("Błędny login !");
                    alert.showAndWait();
    }
    
                   
    }
    
    @FXML
    public void ustawienia_zamknij(ActionEvent event) throws IOException {

        ustawienia_okna.setVisible(false);
        notatki.getItems().clear();
        miejsce_docelowe.getItems().clear();
        tytul_edycja.setText("");
        opis_edycja.setText("");

    }

    public void edycja_okna() {
        ustawienia_okna.setVisible(true);
        dodaj_notatke.setVisible(false);

        //miejsce_docelowe.setDisable(true);
        if (edycja.equals("okno_1")) {

            con = connection.ConnectDB();
            String sql = "select * from projekty_data where id = '" + id + "' ";
            try {
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String add1 = rs.getString("okno_1_1_title");
                    notatki.getItems().add(add1);
                    String add2 = rs.getString("okno_1_2_title");
                    notatki.getItems().add(add2);
                    String add3 = rs.getString("okno_1_3_title");
                    notatki.getItems().add(add3);
                    String add4 = rs.getString("okno_1_4_title");
                    notatki.getItems().add(add4);
                }

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }
        } else if (edycja.equals("okno_2")) {
            con = connection.ConnectDB();
            String sql = "select * from projekty_data where id = '" + id + "' ";
            try {
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String add1 = rs.getString("okno_2_1_title");
                    notatki.getItems().add(add1);
                    String add2 = rs.getString("okno_2_2_title");
                    notatki.getItems().add(add2);
                    String add3 = rs.getString("okno_2_3_title");
                    notatki.getItems().add(add3);
                    String add4 = rs.getString("okno_2_4_title");
                    notatki.getItems().add(add4);
                }

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }
        } else if (edycja.equals("okno_3")) {
            con = connection.ConnectDB();
            String sql = "select * from projekty_data where id = '" + id + "' ";
            try {
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String add1 = rs.getString("okno_3_1_title");
                    notatki.getItems().add(add1);
                    String add2 = rs.getString("okno_3_2_title");
                    notatki.getItems().add(add2);
                    String add3 = rs.getString("okno_3_3_title");
                    notatki.getItems().add(add3);
                    String add4 = rs.getString("okno_3_4_title");
                    notatki.getItems().add(add4);
                }

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }
        } else if (edycja.equals("okno_4")) {
            con = connection.ConnectDB();
            String sql = "select * from projekty_data where id = '" + id + "' ";
            try {
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String add1 = rs.getString("okno_4_1_title");
                    notatki.getItems().add(add1);
                    String add2 = rs.getString("okno_4_2_title");
                    notatki.getItems().add(add2);
                    String add3 = rs.getString("okno_4_3_title");
                    notatki.getItems().add(add3);
                    String add4 = rs.getString("okno_4_4_title");
                    notatki.getItems().add(add4);
                }

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }
        }

        miejsce_docelowe.setDisable(false);

        con = connection.ConnectDB();
        String add1 = "";
        String add2 = "";
        String add3 = "";
        String add4 = "";

        String sql = "select * from projekty where id = '" + id + "' ";

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                add1 = rs.getString("okno_1");
                okno_1_title.setText(add1);
                add2 = rs.getString("okno_2");
                okno_2_title.setText(add2);
                add3 = rs.getString("okno_3");
                okno_3_title.setText(add3);
                add4 = rs.getString("okno_4");
                okno_4_title.setText(add4);
            }

        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
        miejsce_docelowe.getItems().clear();

        miejsce_docelowe.getItems().add(add1);
        miejsce_docelowe.getItems().add(add2);
        miejsce_docelowe.getItems().add(add3);
        miejsce_docelowe.getItems().add(add4);

    }

    // OKNO CZATU - OBSŁUGA
    @FXML
    public void wylacz_czat(ActionEvent event) throws IOException {

        czat.setVisible(false);

    }

    // FUNKCJE UŻYTKOWNIKA
    @FXML
    public void wyloguj(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();

        Stage stage1 = new Stage();
        stage1.setTitle("Logowanie do systemu");
        Parent root1 = FXMLLoader.load(getClass().getResource("FXMLs/FXML_logowanie.fxml"));
        Scene scene = new Scene(root1);
        stage1.setMaxWidth(858);
        stage1.setMaxHeight(801);
        stage1.setScene(scene);
//        stage1.getIcons().add(new Image("image/ico.png"));
        stage1.show();
    }

    @FXML
    public void loggedout(Action Event) throws IOException {
        // con = connection.ConnectDB();
        try {
            con = connection.ConnectDB();

            String query1 = "Update uzytkownicy set zalogowany='0' where login=" + "'" + user_login + "'";
            pst.executeUpdate(query1);
            pst.close();
            con.close();
            Stage stage1 = new Stage();
            stage1.setTitle("Menu");
            Parent root1 = FXMLLoader.load(getClass().getResource("FXMLs/FXML_logowanie.fxml"));
            Scene scene = new Scene(root1);

            stage1.setScene(scene);
            stage1.show();

        } catch (SQLException e) {
            System.err.println("Nie można wykonać tego zapytania: " + e.getMessage());

        }

    }

    // METODY ŁADUJĄCE DANE DO NOTATEK
    public void okno_1_init() {
       
        con = connection.ConnectDB();
        String sql = "select * from projekty where id = '" + id + "' ";

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("okno_1");
                okno_1_title.setText(add1);
                String add2 = rs.getString("okno_2");
                okno_2_title.setText(add2);
                String add3 = rs.getString("okno_3");
                okno_3_title.setText(add3);
                String add4 = rs.getString("okno_4");
                okno_4_title.setText(add4);
            }

        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
        //Adds data to specyfic windows.
        String sql2 = "select * from projekty_data where id = '" + id + "' ";

        try {
            pst = con.prepareStatement(sql2);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("okno_1_1_title");

                if (add1.isEmpty()) {
                    okno_1_1_pane.setVisible(false);
                } else {
                    okno_1_1_pane.setVisible(true);
                    okno_1_1_title.setText(add1);
                    String add2 = rs.getString("okno_1_1_text");
                    okno_1_1_text.setText(add2);
                    String add3 = rs.getString("okno_1_1_data");
                    okno_1_1_data.setText(add3);
                    String add4 = rs.getString("okno_1_1_user");
                    okno_1_1_user.setText(add4);
                    String add5 = rs.getString("okno_1_1_color");
                    okno_1_1_color.setStyle("-fx-background-color: " + add5 + "; -fx-background-radius: 15");
                }
                //okno 1_2
                String add6 = rs.getString("okno_1_2_title");
                if (add6.isEmpty()) {
                    okno_1_2_pane.setVisible(false);
                } else {
                    okno_1_2_pane.setVisible(true);
                    okno_1_2_title.setText(add6);
                    String add7 = rs.getString("okno_1_2_text");
                    okno_1_2_text.setText(add7);
                    String add8 = rs.getString("okno_1_2_data");
                    okno_1_2_data.setText(add8);
                    String add9 = rs.getString("okno_1_2_user");
                    okno_1_2_user.setText(add9);
                    String add10 = rs.getString("okno_1_2_color");
                    okno_1_2_color.setStyle("-fx-background-color: " + add10 + "; -fx-background-radius: 15");
                }

                //okno 1_3
                String add11 = rs.getString("okno_1_3_title");
                if (add11.isEmpty()) {
                    okno_1_3_pane.setVisible(false);
                } else {
                    okno_1_3_pane.setVisible(true);
                    okno_1_3_title.setText(add11);
                    String add12 = rs.getString("okno_1_3_text");
                    okno_1_3_text.setText(add12);
                    String add13 = rs.getString("okno_1_3_data");
                    okno_1_3_data.setText(add13);
                    String add14 = rs.getString("okno_1_3_user");
                    okno_1_3_user.setText(add14);
                    String add15 = rs.getString("okno_1_3_color");
                    okno_1_3_color.setStyle("-fx-background-color: " + add15 + "; -fx-background-radius: 15");
                }

                //okno 1_4
                String add16 = rs.getString("okno_1_4_title");
                if (add16.isEmpty()) {
                    okno_1_4_pane.setVisible(false);
                } else {
                    okno_1_4_pane.setVisible(true);
                    okno_1_4_title.setText(add16);
                    String add17 = rs.getString("okno_1_4_text");
                    okno_1_4_text.setText(add17);
                    String add18 = rs.getString("okno_1_4_data");
                    okno_1_4_data.setText(add18);
                    String add19 = rs.getString("okno_1_4_user");
                    okno_1_4_user.setText(add19);
                    String add20 = rs.getString("okno_1_4_color");
                    okno_1_4_color.setStyle("-fx-background-color: " + add20 + "; -fx-background-radius: 15");
                }

            }

        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
    }

    public void okno_2_init() {
        String sql2 = "select * from projekty_data where id = '" + id + "' ";

        try {
            pst = con.prepareStatement(sql2);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("okno_2_1_title");
                // okno 2_1
                if (add1.isEmpty()) {
                    okno_2_1_pane.setVisible(false);
                } else {
                    okno_2_1_pane.setVisible(true);
                    okno_2_1_title.setText(add1);
                    String add2 = rs.getString("okno_2_1_text");
                    okno_2_1_text.setText(add2);
                    String add3 = rs.getString("okno_2_1_data");
                    okno_2_1_data.setText(add3);
                    String add4 = rs.getString("okno_2_1_user");
                    okno_2_1_user.setText(add4);
                    String add5 = rs.getString("okno_2_1_color");
                    okno_2_1_color.setStyle("-fx-background-color: " + add5 + "; -fx-background-radius: 15");
                }
                //okno 2_2
                String add6 = rs.getString("okno_2_2_title");
                if (add6.isEmpty()) {
                    okno_2_2_pane.setVisible(false);
                } else {
                    okno_2_2_pane.setVisible(true);
                    okno_2_2_title.setText(add6);
                    String add7 = rs.getString("okno_2_2_text");
                    okno_2_2_text.setText(add7);
                    String add8 = rs.getString("okno_2_2_data");
                    okno_2_2_data.setText(add8);
                    String add9 = rs.getString("okno_2_2_user");
                    okno_2_2_user.setText(add9);
                    String add10 = rs.getString("okno_2_2_color");
                    okno_2_2_color.setStyle("-fx-background-color: " + add10 + "; -fx-background-radius: 15");
                }

                //okno 2_3
                String add11 = rs.getString("okno_2_3_title");
                if (add11.isEmpty()) {
                    okno_2_3_pane.setVisible(false);
                } else {
                    okno_2_3_pane.setVisible(true);
                    okno_2_3_title.setText(add11);
                    String add12 = rs.getString("okno_2_3_text");
                    okno_2_3_text.setText(add12);
                    String add13 = rs.getString("okno_2_3_data");
                    okno_2_3_data.setText(add13);
                    String add14 = rs.getString("okno_2_3_user");
                    okno_2_3_user.setText(add14);
                    String add15 = rs.getString("okno_2_3_color");
                    okno_2_3_color.setStyle("-fx-background-color: " + add15 + "; -fx-background-radius: 15");
                }

                //okno 2_4
                String add16 = rs.getString("okno_2_4_title");
                if (add16.isEmpty()) {
                    okno_2_4_pane.setVisible(false);
                } else {
                    okno_2_4_pane.setVisible(true);
                    okno_2_4_title.setText(add16);
                    String add17 = rs.getString("okno_2_4_text");
                    okno_2_4_text.setText(add17);
                    String add18 = rs.getString("okno_2_4_data");
                    okno_2_4_data.setText(add18);
                    String add19 = rs.getString("okno_2_4_user");
                    okno_2_4_user.setText(add19);
                    String add20 = rs.getString("okno_2_4_color");
                    okno_2_4_color.setStyle("-fx-background-color: " + add20 + "; -fx-background-radius: 15");
                }

            }

        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
    }

    public void okno_3_init() {
        String sql2 = "select * from projekty_data where id = '" + id + "' ";

        try {
            pst = con.prepareStatement(sql2);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("okno_3_1_title");
                // okno 3_1
                if (add1.isEmpty()) {
                    okno_3_1_pane.setVisible(false);
                } else {
                    okno_3_1_pane.setVisible(true);
                    okno_3_1_title.setText(add1);
                    String add2 = rs.getString("okno_3_1_text");
                    okno_3_1_text.setText(add2);
                    String add3 = rs.getString("okno_3_1_data");
                    okno_3_1_data.setText(add3);
                    String add4 = rs.getString("okno_3_1_user");
                    okno_3_1_user.setText(add4);
                    String add5 = rs.getString("okno_3_1_color");
                    okno_3_1_color.setStyle("-fx-background-color: " + add5 + "; -fx-background-radius: 15");
                }
                //okno 3_2
                String add6 = rs.getString("okno_3_2_title");
                if (add6.isEmpty()) {
                    okno_3_2_pane.setVisible(false);
                } else {
                    okno_3_2_pane.setVisible(true);
                    okno_3_2_title.setText(add6);
                    String add7 = rs.getString("okno_3_2_text");
                    okno_3_2_text.setText(add7);
                    String add8 = rs.getString("okno_3_2_data");
                    okno_3_2_data.setText(add8);
                    String add9 = rs.getString("okno_3_2_user");
                    okno_3_2_user.setText(add9);
                    String add10 = rs.getString("okno_3_2_color");
                    okno_3_2_color.setStyle("-fx-background-color: " + add10 + "; -fx-background-radius: 15");
                }

                //okno 3_3
                String add11 = rs.getString("okno_3_3_title");
                if (add11.isEmpty()) {
                    okno_3_3_pane.setVisible(false);
                } else {
                    okno_3_3_pane.setVisible(true);
                    okno_3_3_title.setText(add11);
                    String add12 = rs.getString("okno_3_3_text");
                    okno_3_3_text.setText(add12);
                    String add13 = rs.getString("okno_3_3_data");
                    okno_3_3_data.setText(add13);
                    String add14 = rs.getString("okno_3_3_user");
                    okno_3_3_user.setText(add14);
                    String add15 = rs.getString("okno_3_3_color");
                    okno_3_3_color.setStyle("-fx-background-color: " + add15 + "; -fx-background-radius: 15");
                }

                //okno 3_4
                String add16 = rs.getString("okno_3_4_title");
                if (add16.isEmpty()) {
                    okno_3_4_pane.setVisible(false);
                } else {
                    okno_3_4_pane.setVisible(true);
                    okno_3_4_title.setText(add16);
                    String add17 = rs.getString("okno_3_4_text");
                    okno_3_4_text.setText(add17);
                    String add18 = rs.getString("okno_3_4_data");
                    okno_3_4_data.setText(add18);
                    String add19 = rs.getString("okno_3_4_user");
                    okno_3_4_user.setText(add19);
                    String add20 = rs.getString("okno_3_4_color");
                    okno_3_4_color.setStyle("-fx-background-color: " + add20 + "; -fx-background-radius: 15");
                }

            }

        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
    }

    public void okno_4_init() {
        String sql2 = "select * from projekty_data where id = '" + id + "' ";

        try {
            pst = con.prepareStatement(sql2);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("okno_4_1_title");
                // okno 4_1
                if (add1.isEmpty()) {
                    okno_4_1_pane.setVisible(false);
                } else {
                    okno_4_1_pane.setVisible(true);
                    okno_4_1_title.setText(add1);
                    String add2 = rs.getString("okno_4_1_text");
                    okno_4_1_text.setText(add2);
                    String add3 = rs.getString("okno_4_1_data");
                    okno_4_1_data.setText(add3);
                    String add4 = rs.getString("okno_4_1_user");
                    okno_4_1_user.setText(add4);
                    String add5 = rs.getString("okno_4_1_color");
                    okno_4_1_color.setStyle("-fx-background-color: " + add5 + "; -fx-background-radius: 15");
                }
                //okno 4_2
                String add6 = rs.getString("okno_4_2_title");
                if (add6.isEmpty()) {
                    okno_4_2_pane.setVisible(false);
                } else {
                    okno_4_2_pane.setVisible(true);
                    okno_4_2_title.setText(add6);
                    String add7 = rs.getString("okno_4_2_text");
                    okno_4_2_text.setText(add7);
                    String add8 = rs.getString("okno_4_2_data");
                    okno_4_2_data.setText(add8);
                    String add9 = rs.getString("okno_4_2_user");
                    okno_4_2_user.setText(add9);
                    String add10 = rs.getString("okno_4_2_color");
                    okno_4_2_color.setStyle("-fx-background-color: " + add10 + "; -fx-background-radius: 15");
                }

                //okno 4_3
                String add11 = rs.getString("okno_4_3_title");
                if (add11.isEmpty()) {
                    okno_4_3_pane.setVisible(false);
                } else {
                    okno_4_3_pane.setVisible(true);
                    okno_4_3_title.setText(add11);
                    String add12 = rs.getString("okno_4_3_text");
                    okno_4_3_text.setText(add12);
                    String add13 = rs.getString("okno_4_3_data");
                    okno_4_3_data.setText(add13);
                    String add14 = rs.getString("okno_4_3_user");
                    okno_4_3_user.setText(add14);
                    String add15 = rs.getString("okno_4_3_color");
                    okno_4_3_color.setStyle("-fx-background-color: " + add15 + "; -fx-background-radius: 15");
                }

                //okno 4_4
                String add16 = rs.getString("okno_4_4_title");
                if (add16.isEmpty()) {
                    okno_4_4_pane.setVisible(false);
                } else {
                    okno_4_4_pane.setVisible(true);
                    okno_4_4_title.setText(add16);
                    String add17 = rs.getString("okno_4_4_text");
                    okno_4_4_text.setText(add17);
                    String add18 = rs.getString("okno_4_4_data");
                    okno_4_4_data.setText(add18);
                    String add19 = rs.getString("okno_4_4_user");
                    okno_4_4_user.setText(add19);
                    String add20 = rs.getString("okno_4_4_color");
                    okno_4_4_color.setStyle("-fx-background-color: " + add20 + "; -fx-background-radius: 15");
                }

            }

        } catch (SQLException | HeadlessException e) {
            System.out.println(e);
        }
    }

    public void setData(){
    system_time.setText(new SimpleDateFormat("dd.MM.yyy").format(Calendar.getInstance().getTime()));
    
    String imie = "";
    String nazwisko = "";
     try {
                con = connection.ConnectDB();
                String sql = "select * from uzytkownicy where login = '" + user_login + "' ";

                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {

                    imie = rs.getString("imie");
                    nazwisko = rs.getString("nazwisko");
                    

                }

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }
     panel_user_name.setText(imie + " " + nazwisko);
     
     String nazwa = "";
     try {
                con = connection.ConnectDB();
                String sql = "select * from projekty where id = '" + id + "' ";

                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {

                    nazwa = rs.getString("nazwa");
                   
                }

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }
     
     project_name.setText(nazwa);
     
    }
    
    public void uprawnienia(){
    String status = "";
    
    status = menuController.uprawnienia;
    
    if(status.equals("Admin")){
    // admin ma full uprawnienia   
    }
    else if(status.equals("Edycja")){     
    // tylko edycja brak ustawien i edycji 
    
    users_window_1.setDisable(true);
    settings_window_1.setDisable(true);
    
    }
    else if(status.equals("Podglad")){
    // tylko opcja podglądu, brak edycji
    
    users_window_1.setDisable(true);
    settings_window_1.setDisable(true);
    
    dodaj_1.setDisable(true);
    edycja_1.setDisable(true);
    
    dodaj_2.setDisable(true);
    edycja_2.setDisable(true);
    
    dodaj_3.setDisable(true);
    edycja_3.setDisable(true);
    
    dodaj_4.setDisable(true);
    edycja_4.setDisable(true);
    
    }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        uprawnienia();
        PDF_back.setVisible(false);
        ustawienia_okna.setVisible(false);
        dodaj_notatke.setVisible(false);
        
        ustawienia_okno.setVisible(false);
        uzytkownicy_okno.setVisible(false);
        
        setData();

        okno_1_init();
        okno_2_init();
        okno_3_init();
        okno_4_init();
        czat_init();

    }

    public void kolor_1_click(ActionEvent event) throws IOException {
        kolor_2.setSelected(false);
        kolor_3.setSelected(false);
        kolor_4.setSelected(false);
    }

    public void kolor_2_click(ActionEvent event) throws IOException {
        kolor_1.setSelected(false);
        kolor_3.setSelected(false);
        kolor_4.setSelected(false);
    }

    public void kolor_3_click(ActionEvent event) throws IOException {
        kolor_1.setSelected(false);
        kolor_2.setSelected(false);
        kolor_4.setSelected(false);
    }

    public void kolor_4_click(ActionEvent event) throws IOException {
        kolor_1.setSelected(false);
        kolor_2.setSelected(false);
        kolor_3.setSelected(false);
    }

    public void saveAsPng() {  
    // TA METODA TO 200 IQ SOLUTION <3
    dodaj_1.setVisible(false);
    edycja_1.setVisible(false);
    dodaj_2.setVisible(false);
    edycja_2.setVisible(false);
    dodaj_3.setVisible(false);
    edycja_3.setVisible(false);
    dodaj_4.setVisible(false);
    edycja_4.setVisible(false);
    PDF_back.setVisible(true);
    
    WritableImage image = PDF.snapshot(new SnapshotParameters(), null);
   
    dodaj_1.setVisible(true);
    edycja_1.setVisible(true);
    dodaj_2.setVisible(true);
    edycja_2.setVisible(true);
    dodaj_3.setVisible(true);
    edycja_3.setVisible(true);
    dodaj_4.setVisible(true);
    edycja_4.setVisible(true);
    PDF_back.setVisible(false);
    
    
    File file = new File("src/image/PDF.png");

    try {
        ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
    } catch (IOException e) {
      
    }
}
    
    private void PDF_body(Document document) throws DocumentException, IOException {
        int indentation = 0;
        
        String time = new SimpleDateFormat("dd.MM.yyy HH:mm").format(Calendar.getInstance().getTime());

        Paragraph preface = new Paragraph(Element.ALIGN_CENTER);
      
        Image image = Image.getInstance(IMAGE);
        image.setAbsolutePosition(0, 0);
        
        float scaler = ((document.getPageSize().getWidth() - document.leftMargin()
               - document.rightMargin() - indentation) / image.getWidth()) * 110;

        image.scalePercent(scaler);

        preface.add(image);
        
        addEmptyLine(preface, 26);

        preface.add(new Paragraph(time,opis));
        
        document.add(preface);
     
        
        // Start a new page
       // document.newPage();
    }
    
    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
    
    @FXML
    public void gen_pdf(ActionEvent event) throws IOException {
    
    saveAsPng();
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        f.showSaveDialog(null);

        try {
            Document document = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(document, new FileOutputStream(f.getSelectedFile()+"/PDF.pdf"));          
            document.open();         
            PDF_body(document);           
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public String getProjectId(String id){
        id  = this.id;
        return id;
    }
    
    public String getUserLogin(String login){
        login = user_login;
        return login;
    }
    
    public boolean succesLogin(String login){
        if(login.equals(null)){
        return false;    
        }
        else
        return true;
    }
    
}
