/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.ModUsuario;
import conexionBD.CRUD_ListaExperimentos;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.lang.System.exit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import sonidos.ReproSonidos;

/**
 *
 * @author Fercho
 */
public class V2ColocacionHardware extends javax.swing.JPanel {

    /**
     * Creates new form V2ColocacionHardware
     */
    ModUsuario usuario;
    boolean UsoHuella;

    public V2ColocacionHardware(ModUsuario usuario, boolean UsoHuella) {

        initComponents();
        this.usuario = usuario;
        this.UsoHuella = UsoHuella;
        estilo_btn();
        configuracionBtn();

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
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbl_n_user = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_atras = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(79, 84, 93));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Iniciar experimento");
        add(jLabel1);
        jLabel1.setBounds(1110, 410, 920, 50);

        jToggleButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/V2Colocacion/btn_epoc.png"))); // NOI18N
        jToggleButton1.setText("Emotiv EPOC+");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        add(jToggleButton1);
        jToggleButton1.setBounds(510, 350, 300, 110);

        jToggleButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/V2Colocacion/btn_ritmo.png"))); // NOI18N
        jToggleButton2.setText("ECG");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        add(jToggleButton2);
        jToggleButton2.setBounds(510, 480, 300, 120);

        jToggleButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/V2Colocacion/btn_gsr.png"))); // NOI18N
        jToggleButton3.setText("GSR");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });
        add(jToggleButton3);
        jToggleButton3.setBounds(510, 620, 300, 120);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Ir a la Ventana principal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(1070, 480, 400, 120);

        jPanel1.setBackground(new java.awt.Color(79, 84, 93));
        jPanel1.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boy/hombre (3).png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(46, 40, 64, 70);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Bienvendido");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 150, 130, 17);

        lbl_n_user.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_n_user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_n_user.setText("Usuario: ");
        jPanel1.add(lbl_n_user);
        lbl_n_user.setBounds(10, 120, 130, 20);

        jLabel5.setBackground(new java.awt.Color(79, 84, 93));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/V2Colocacion/250 188.png"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(0, 0, 160, 200);

        add(jPanel1);
        jPanel1.setBounds(1700, 10, 150, 250);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo_unsis.png"))); // NOI18N
        add(jLabel4);
        jLabel4.setBounds(10, 10, 220, 220);

        btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras/flecha-hacia-la-izquierda (2).png"))); // NOI18N
        btn_atras.setToolTipText("Regresar");
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });
        add(btn_atras);
        btn_atras.setBounds(910, 10, 40, 40);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/V2Colocacion/Untitled (2).png"))); // NOI18N
        add(jLabel6);
        jLabel6.setBounds(1630, 840, 230, 90);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("¿Cómo configurar los sensores?");
        add(jLabel7);
        jLabel7.setBounds(400, 280, 920, 50);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/V4Principal/salida.png"))); // NOI18N
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(1520, 870, 110, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        CargarDatos(1);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.removeAll();
        this.updateUI();

        V4ProgramaPrincipal p;
        try {
            p = new V4ProgramaPrincipal(usuario, UsoHuella);
            p.setSize(1900, 1000);
            this.add(p);

        } catch (SQLException ex) {
            Logger.getLogger(V2ColocacionHardware.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Desea regresar a la ventana Login?", "Advertencia",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            this.removeAll();
            this.updateUI();

            V1Login p = new V1Login();
            p.setSize(1900, 1000);
            this.add(p);

            this.revalidate();
            this.repaint();
        }
    }//GEN-LAST:event_btn_atrasActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        CargarDatos(2);
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        CargarDatos(3);
    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "¿Desea salir de la aplicación?", "Confirmación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            exit(0);
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JLabel lbl_n_user;
    // End of variables declaration//GEN-END:variables

    private void configuracionBtn() {
        try {
            lbl_n_user.setText(lbl_n_user.getText() + this.usuario.getUsuario_nombre());
            //btn_sesion.setContentAreaFilled(false);
            //btn_sesion.setBorder(null);

            btn_atras.setContentAreaFilled(false);
            btn_atras.setBorder(null);
        } catch (Exception c) {
            lbl_n_user.setText("Error Aquí");
        }

    }

    private void CargarDatos(int i) {
        this.removeAll();
        this.updateUI();
        //System.out.println("Ver "+UsoHuella);
        V3PasosColocacionHw p = new V3PasosColocacionHw(usuario, i, UsoHuella);
        p.setSize(1900, 1000);
        this.add(p);
        this.revalidate();
        this.repaint();
    }

    private void estilo_btn() {
        agregar_estilo_a(jToggleButton1);
        agregar_estilo_a(jToggleButton2);
        agregar_estilo_a(jToggleButton3);
        agregar_estilo_a(jButton1);
    }

    private void agregar_estilo_a(JToggleButton Button) {
        //Button.setBorder(new btn_redondo(20));

        Color verde = new Color(229, 231, 233);
        Color verde2 = new Color(115, 153, 198);
        Button.setBackground(verde);
        Button.setBorderPainted(false);
        Button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent arg0) {
                Button.setBackground(verde2);
                Button.setForeground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Button.setBackground(verde);
                Button.setForeground(Color.BLACK);
            }
        });
        Button.setForeground(Color.BLACK);
        // Button.setBorder(new design_btn_redondo(5));

    }

    private void agregar_estilo_a(JButton Button) {
        Color verde = new Color(66, 192, 170);
        Color verde2 = new Color(41, 139, 122);
        Button.setBackground(verde);
        Button.setBorderPainted(false);
        Button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent arg0) {
                Button.setBackground(verde2);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Button.setBackground(verde);
            }
        });
        Button.setForeground(Color.WHITE);
    }
}
