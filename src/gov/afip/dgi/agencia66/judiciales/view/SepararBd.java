/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.afip.dgi.agencia66.judiciales.view;

import com.itextpdf.text.DocumentException;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import gov.afip.dgi.agencia66.judiciales.controller.ProcesarPid;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author u84062
 */
public class SepararBd extends javax.swing.JFrame {

    /**
     * Creates new form SepararBd
     */
    public SepararBd() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnElegirArchivo = new javax.swing.JButton();
        txtArchivo = new javax.swing.JTextField();
        lblPid = new javax.swing.JLabel();
        txtPid = new javax.swing.JTextField();
        btnProcesar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 14)); // NOI18N
        jLabel1.setText("Separacion de PID de Boletas de Deuda  por Agentes");

        btnElegirArchivo.setText("Seleccione archivo");
        btnElegirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirArchivoActionPerformed(evt);
            }
        });

        txtArchivo.setEditable(false);
        txtArchivo.setText("Seleccione el archivo a procesar...");
        txtArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtArchivoActionPerformed(evt);
            }
        });

        lblPid.setText("PID:");

        txtPid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPidActionPerformed(evt);
            }
        });

        btnProcesar.setText("Procesar");
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPid)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPid, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnElegirArchivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(btnProcesar)
                .addGap(74, 74, 74)
                .addComponent(btnLimpiar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnElegirArchivo)
                    .addComponent(txtArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPid)
                    .addComponent(txtPid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProcesar)
                    .addComponent(btnLimpiar))
                .addGap(13, 13, 13)
                .addComponent(btnSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnElegirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirArchivoActionPerformed
        JFileChooser fileChooser = new JFileChooser("D:\\Boletas de Deuda");
        int seleccion  = fileChooser.showOpenDialog(this);
        String rutaArchivo = null;
        if(seleccion == fileChooser.APPROVE_OPTION) {
            //Seleccionamos el fichero
            File fichero = fileChooser.getSelectedFile();

            //Ecribe la ruta del fichero seleccionado en el campo de texto
            rutaArchivo = fichero.getAbsolutePath();
            txtArchivo.setText(rutaArchivo);
        }
        if(rutaArchivo != null) {
            try {
                txtPid.setText(rutaArchivo.substring(78, 84));
            } catch (StringIndexOutOfBoundsException sobe) {
                txtPid.setText("Ingrese el PID por favor...");
                txtPid.setForeground(Color.RED);
                txtPid.setBackground(Color.YELLOW);
            }
        }
    }//GEN-LAST:event_btnElegirArchivoActionPerformed

    private void txtArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtArchivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtArchivoActionPerformed

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        try {
            confirma();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SepararBd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(SepararBd.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error:  " +ex.getMessage(),"Error de archivo: " ,JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(SepararBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnProcesarActionPerformed

    private void txtPidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPidActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarPantalla();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(SepararBd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SepararBd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SepararBd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SepararBd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SepararBd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnElegirArchivo;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnProcesar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblPid;
    private javax.swing.JTextField txtArchivo;
    private javax.swing.JTextField txtPid;
    // End of variables declaration//GEN-END:variables

    private void confirma() throws FileNotFoundException, DocumentException, IOException, Exception {
        int opcion;

        if(!txtPid.getText().isEmpty()) {
            opcion = JOptionPane.showConfirmDialog(null, "¿Realmente deseas procesar el pid " +txtPid.getText() , "ProcesaPid", JOptionPane.YES_NO_OPTION);
            if(opcion == 0) {
                ProcesarPid pp;
                pp = new ProcesarPid(txtPid.getText(), txtArchivo.getText());
                if(pp.procesar() == 1) {
                    JOptionPane.showMessageDialog(null, "Se generaron los archivos de salida para el PID: " +txtPid.getText());
                } else {
                    //JOptionPane.showMessageDialog(this, "Debe seleccionar un archivo" +mensajesDeError(), "Errores de Validación", JOptionPane.ERROR_MESSAGE );
                    JOptionPane.showMessageDialog(this, "Error", "Errores de Proceso", JOptionPane.ERROR_MESSAGE );
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un archivo...");
            
        }
    }

    private void limpiarPantalla() {
        txtArchivo.setText("");
        txtPid.setText("");
    }
}
