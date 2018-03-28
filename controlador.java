
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static org.eclipse.persistence.logging.SessionLog.DDL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bryan Requenes
 */
public class controlador {
    String url = "jdbc:derby://localhost:1527/TIENDITA";
     String usuario = "usuario";
     String clave = "1234";
     Connection conexion;
    

    public controlador() {
        try {
            conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (SQLException ex) {
            System.out.println("error al establecer coneccion " + ex);

            Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String consulta() {
       
String s ="";
        try {
            java.sql.Statement sentencia = conexion.createStatement();
            ResultSet reg = sentencia.executeQuery("select*from Articulo");

            while (reg.next()) {
               int id = reg.getInt("codigo");
                String nombre = reg.getString("nombre");
                int precio = reg.getInt("precio");
                int id_f = reg.getInt("id_f");
                
                s+= id + " "+nombre+" "+precio+ " "+id_f;

             //  listita.add(s);
            }

            reg.close();
            sentencia.close();

        } catch (SQLException ex) {
            Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

        return s;
    }

    public String consultaprecio() {
       
        String s =" ";

        try {
            java.sql.Statement sentencia = conexion.createStatement();
            ResultSet reg = sentencia.executeQuery("select*from Articulo where precio>=100 AND precio<=350");

            while (reg.next()) {
               int id = reg.getInt("codigo");
                String nombre = reg.getString("nombre");
                int precio = reg.getInt("precio");
                int id_f = reg.getInt("id_f");
                s+= id + " "+nombre+" "+precio+ "\n ";

              // listita.add(s);
            }

            reg.close();
            sentencia.close();

        } catch (SQLException ex) {
            Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

        return s;
    }
    public String consultapreciodes() {
              String s =" ";

        try {
            java.sql.Statement sentencia = conexion.createStatement();
            ResultSet reg = sentencia.executeQuery("select*from Articulo where precio>=450");

            while (reg.next()) {
               int id = reg.getInt("codigo");
                String nombre = reg.getString("nombre");
                int precio = reg.getInt("precio");
                int id_f = reg.getInt("id_f");
                 precio = precio-10;
                s+= id + " "+nombre+" "+precio+ "\n ";

            //   listita.add(s);
            }

            reg.close();
            sentencia.close();

        } catch (SQLException ex) {
            Logger.getLogger(controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

        return s;

}
}