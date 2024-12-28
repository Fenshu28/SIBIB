/*
 * Este es el método principal y contiene el Panel que funacionará como base 
 * para el resto de los Paneles de la aplicación
 */
package Vistas;

import Modelo.ModMuestra;
import java.io.FileWriter;

/**
 * @author Fercho
 */
public class Interfaz extends javax.swing.JFrame {
    
    //Objeto que almacena cada una de las muestras generadas por experimento
    public ModMuestra miMuestra = new ModMuestra();
    //Tipo de dato archivos, para almacenar las muestras generadas durante el ex
    private FileWriter archivo, archivoMarcador;
    public Interfaz() {
        initComponents();
        PanelLogin();
    }

    public void PanelLogin(){
        //Se sobre-escribe el panel principal de la Interfaz por el panel Login
        V1Login p = new V1Login();
        //Se asigna un tamaño establecido al panel
        p.setSize(1900,1000);
        //Se añade el Panel nuevo al Panel de la Interfaz
        PanelInterfaz.add(p);
        //Se Sobre-escribe el Panel de la Interfaz
        PanelInterfaz.revalidate();
        PanelInterfaz.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelInterfaz = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelInterfaz.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout PanelInterfazLayout = new javax.swing.GroupLayout(PanelInterfaz);
        PanelInterfaz.setLayout(PanelInterfazLayout);
        PanelInterfazLayout.setHorizontalGroup(
            PanelInterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1448, Short.MAX_VALUE)
        );
        PanelInterfazLayout.setVerticalGroup(
            PanelInterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 906, Short.MAX_VALUE)
        );

        jLabel1.setText("Universidad de la Sierra Sur - Sistema Basado en Información Biométrica V.1.1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelInterfaz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelInterfaz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelInterfaz;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
