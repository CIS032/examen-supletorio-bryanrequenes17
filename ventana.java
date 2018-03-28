
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bryan Requenes
 */
public class ventana extends javax.swing.JFrame {

    /**
     * Creates new form ventana
     */
    public ventana() {
        initComponents();
        abrirBD();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("mostrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("descuento");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("nombre y precio");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("precio");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jButton5.setText("MEMORIAS");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(35, 35, 35)
                .addComponent(jButton2)
                .addGap(31, 31, 31)
                .addComponent(jButton3)
                .addGap(29, 29, 29)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jButton5)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
String cadena="";
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        abrirBD();
    
         try {
            Statement comando = conexion.createStatement();
            ResultSet registro = comando.executeQuery("select *from Articulo");
            while (registro.next() ) {
               int id = registro.getInt("codigo");
                String nombre = registro.getString("nombre");
                int precio = registro.getInt("precio");
                int id_f = registro.getInt("id_f");
                
                cadena+= id + " "+nombre+" "+precio+ " "+id_f+"\n";

            }
            
               jTextArea1.setText(cadena);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        //setText(cadena);        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1ActionPerformed
String s=" ";
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         abrirBD();
    
         try {
            Statement comando = conexion.createStatement();
            ResultSet registro = comando.executeQuery("select*from Articulo where precio>=450");
            while (registro.next() ) {
               int id = registro.getInt("codigo");
                String nombre = registro.getString("nombre");
                int precio = registro.getInt("precio");
                int id_f = registro.getInt("id_f");
                 precio = precio-10;
                 //registro.update;
                s+= id + " "+nombre+"    "+precio+ "\n ";

            }
            
               jTextArea1.setText(s);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         abrirBD();
    
         try {
            Statement comando = conexion.createStatement();
            ResultSet registro = comando.executeQuery("select*from Articulo where precio>=100 AND precio<=350");
            while (registro.next() ) {
               int id = registro.getInt("codigo");
                String nombre = registro.getString("nombre");
                int precio = registro.getInt("precio");
                
                int id_f = registro.getInt("id_f");
                s+= id + " "+nombre+" "+precio+ "\n ";

            }
            
               jTextArea1.setText(s);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
       
         
    }//GEN-LAST:event_jButton4ActionPerformed
String p="";
String p1="";
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         abrirBD();
    
         try {
            Statement comando = conexion.createStatement();
            ResultSet registro = comando.executeQuery("select*from Articulo");
            while (registro.next() ) {
               int id = registro.getInt("codigo");
                String nombre = registro.getString("nombre");
                int precio = registro.getInt("precio");
                p+= id + " "+nombre+" "+precio+ "\n ";

            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
         try {
            Statement comando = conexion.createStatement();
            ResultSet registro = comando.executeQuery("select*from fabricante");
            while (registro.next() ) {
               int id = registro.getInt("id_f");
                String nombre = registro.getString("nombre");
                p1+= id + " "+nombre+"\n ";
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
         jTextArea1.setText("Articulo"+"                        "+"Fabricante"+"\n"+p+"                                                        "+p1);
         
    }//GEN-LAST:event_jButton3ActionPerformed
String f="";
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
         abrirBD();
    
         try {
            Statement comando = conexion.createStatement();
            ResultSet registro = comando.executeQuery("select*from Articulo where nombre='memoria Ram' OR nombre='USB'");
            while (registro.next() ) {
               int id = registro.getInt("codigo");
                String nombre = registro.getString("nombre");
                int precio = registro.getInt("precio");
                //int id_f = registro.getInt("id_f");
                f+= id + " "+nombre+" "+precio+ "\n ";

            }
            
               jTextArea1.setText(f);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
 Connection conexion=null;
     public void abrirBD(){
     
       try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("Driver cargado !!!");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error al cargar Driver "+cnfe);   
        }
        
        try {
            String urlbd="jdbc:derby://localhost:1527/TIENDITA";
            conexion = DriverManager.getConnection(urlbd,"usuario","1234");
             System.out.println("Conexion satisfactoria !!!");
        } catch (SQLException sqlex) {
            System.out.println("Error al establecer conexion a la BD: "+sqlex);
        }

     


     }
     
}