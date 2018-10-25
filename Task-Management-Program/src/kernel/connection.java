package kernel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;

/**
 * Standard connection to main system coming from within the MySQL.
 *
 * @author zieloni
 * @version 1.0 ALPHA
 */
public class connection {

    Connection con = null;
    private static final String FILENAME = "src/config.txt";

    private static String host_name = "";
    private static String database_name = "";
    private static String user_name = "";
    private static String user_pass = "";
    
    
    
    public static void cfg() {

        int loop = 0;
        
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                loop++;
                if(loop==1){
                host_name = sCurrentLine;    
                }
                else if(loop==3){
                database_name = sCurrentLine;    
                }
                else if(loop==5){
                user_name = sCurrentLine;    
                }
                else if(loop==7){
                user_pass = sCurrentLine;    
                }
                
              //  System.out.println(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Connection ConnectDB() {

        cfg();
        //System.out.print(host_name +" "+ database_name +" "+ user_name +" "+ user_pass +";" );
        String connectLine = "jdbc:mysql://"+host_name+"/"+database_name;      
        try {

            Class.forName("com.mysql.jdbc.Driver");
          //Connection con = DriverManager.getConnection("jdbc:mysql://localhost/greenproject", "root", "");
            Connection con = DriverManager.getConnection(connectLine, user_name, user_pass);
            System.out.print(con);
            return con;

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return null;
        }
    }

}
