/*
 * En esta ventana se realizará el Login de la aplicación
 */
package Vistas;

import Modelo.ModUsuario;
import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPErrorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPErrorEvent;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.capture.event.DPFPSensorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPSensorEvent;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import com.placeholder.PlaceHolder;
import conexionBD.CRUD_Usuario;
import conexionBD.CRUD_HuellaDigital;
import java.awt.Color;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import org.jfree.data.time.Millisecond;
import sonidos.ReproSonidos;

/**
 * @author Fercho
 */
public class V1Login extends javax.swing.JPanel {

    /**
     * Creates new form V1Login
     */
    private int IntentosHuella = 0;
    private int IntentosPass = 0;

    public V1Login() {
        initComponents();

        PlaceholderActivar();
        OcultarMostrarComponentes(true);
        ActivarHuella();

        lbl1.setVisible(false);
        lbl2.setVisible(false);
        jLabel6.setVisible(false);

        estilo_btn();
        ActualizarIntentosPass(IntentosPass);
        ActualizarIntentosHuella(IntentosHuella);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        panelLogin = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txt_pass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        lbl1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_stateSensor = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(79, 84, 93));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/unsis_large.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 1610, 260));

        panelLogin.setBackground(new java.awt.Color(79, 84, 93));
        panelLogin.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("Iniciar Sesión");
        panelLogin.add(jLabel11);
        jLabel11.setBounds(156, 90, 180, 40);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Intentos restantes: ");
        panelLogin.add(jLabel9);
        jLabel9.setBounds(20, 460, 410, 14);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Intentos restantes:");
        panelLogin.add(jLabel10);
        jLabel10.setBounds(480, 390, 290, 14);
        panelLogin.add(cLabel1);
        cLabel1.setBounds(590, 290, 40, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Ingresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });
        panelLogin.add(jButton1);
        jButton1.setBounds(30, 340, 390, 70);

        txt_pass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passKeyPressed(evt);
            }
        });
        panelLogin.add(txt_pass);
        txt_pass.setBounds(30, 280, 390, 50);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("           Contraseña: ");
        panelLogin.add(jLabel2);
        jLabel2.setBounds(110, 250, 166, 22);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Nombre de Usuario: ");
        panelLogin.add(jLabel1);
        jLabel1.setBounds(150, 150, 166, 22);

        txt_usuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usuarioActionPerformed(evt);
            }
        });
        txt_usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_usuarioKeyPressed(evt);
            }
        });
        panelLogin.add(txt_usuario);
        txt_usuario.setBounds(30, 180, 390, 50);

        lbl1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x/error (2).png"))); // NOI18N
        lbl1.setText("Usuario o contraseña incorrecto");
        panelLogin.add(lbl1);
        lbl1.setBounds(30, 420, 390, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/VLogin/sensor.png"))); // NOI18N
        panelLogin.add(jLabel5);
        jLabel5.setBounds(560, 190, 100, 170);

        lbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x/error (2).png"))); // NOI18N
        lbl2.setText("Huella no encontrada, intente de nuevo");
        panelLogin.add(lbl2);
        lbl2.setBounds(480, 360, 290, 30);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check/exito.png"))); // NOI18N
        jLabel6.setText("Huella encontrada");
        panelLogin.add(jLabel6);
        jLabel6.setBounds(470, 350, 280, 40);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Estado de Sensor:");
        panelLogin.add(jLabel7);
        jLabel7.setBounds(550, 140, 180, 22);

        lbl_stateSensor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_stateSensor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check/exito.png"))); // NOI18N
        lbl_stateSensor.setText("Disponible");
        lbl_stateSensor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lbl_stateSensorPropertyChange(evt);
            }
        });
        panelLogin.add(lbl_stateSensor);
        lbl_stateSensor.setBounds(470, 170, 290, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/VLogin/700 525.png"))); // NOI18N
        jLabel4.setText("Coloque su huella sobre el sensor o ingrese");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        panelLogin.add(jLabel4);
        jLabel4.setBounds(10, 0, 430, 530);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/VLogin/500 375.png"))); // NOI18N
        panelLogin.add(jLabel8);
        jLabel8.setBounds(470, 70, 320, 380);

        add(panelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, 800, 490));
    }// </editor-fold>//GEN-END:initComponents

    boolean UsoHuella = false;
    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            IngresarSesion(txt_usuario.getText(), txt_pass.getText());
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        IngresarSesion(txt_usuario.getText(), txt_pass.getText());
        if (IntentosPass == 3) {
            jButton1.setEnabled(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    boolean mensaje;

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked

    }//GEN-LAST:event_jLabel4MouseClicked

    private void lbl_stateSensorPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lbl_stateSensorPropertyChange
        lbl2.setVisible(false);
        jLabel6.setVisible(false);
    }//GEN-LAST:event_lbl_stateSensorPropertyChange

    private void txt_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usuarioActionPerformed

    private void txt_passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passKeyPressed
        if (IntentosPass != 3) {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                IngresarSesion(txt_usuario.getText(), txt_pass.getText());
            } else {
                lbl1.setVisible(false);
            }
        } else {
            jButton1.setEnabled(false);
        }
    }//GEN-LAST:event_txt_passKeyPressed

    private void txt_usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_usuarioKeyPressed
        if (IntentosPass != 3) {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                IngresarSesion(txt_usuario.getText(), txt_pass.getText());
            } else {
                lbl1.setVisible(false);
            }
        } else {
            jButton1.setEnabled(false);
        }
    }//GEN-LAST:event_txt_usuarioKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cLabel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl_stateSensor;
    public javax.swing.JPanel panelLogin;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables

    private void IngresarSesion(String text, String text1) {
        ModUsuario usuario = new ModUsuario(text, text1);
        CRUD_Usuario operacion = new CRUD_Usuario();
        try {
            if (operacion.ExisteUsuario(usuario)) {
                usuario = operacion.RetornaUsuariosiExiste(usuario);
                abrirVentanaPrincipal(usuario);
            } else {
                IntentosPass++;
                ActualizarIntentosPass(IntentosPass);
                lbl1.setVisible(true);
                jLabel6.setVisible(false);
                SonidoError();
            }
        } catch (SQLException ex) {
            System.out.println("Revisar conexión a BD");
        }
    }

    private void abrirVentanaPrincipal(ModUsuario usuario) {
        try {
            // Obtener el contenedor principal (JFrame)
            java.awt.Container container = this.getParent();
            while (!(container instanceof javax.swing.JFrame)) {
                container = container.getParent();
            }
            javax.swing.JFrame frame = (javax.swing.JFrame) container;

            // Crear y mostrar la ventana principal
            V4ProgramaPrincipal ventanaPrincipal = new V4ProgramaPrincipal(usuario, UsoHuella);
            ventanaPrincipal.setSize(1900, 1000);

            // Limpiar el frame y agregar la nueva ventana
            frame.getContentPane().removeAll();
            frame.getContentPane().add(ventanaPrincipal);
            frame.getContentPane().revalidate();
            frame.getContentPane().repaint();
        } catch (SQLException ex) {
            System.out.println("Error al abrir ventana principal: " + ex.getMessage());
        }
    }
    
    public void VentanaColocacionHW(ModUsuario usuario) {

        this.setLayout(null);
        this.removeAll();
        this.updateUI();
        V2ColocacionHardware p = new V2ColocacionHardware(usuario, UsoHuella);
        p.setSize(1900, 1000);
        try {
            this.add(p);
        } catch (Exception c) {
            System.out.println("Aquí está el Error " + c);
            System.out.println("" + c.toString());
        }
        this.revalidate();
        this.repaint();

//        }catch(Exception w){
//            System.out.println("Algo raro aquí");
//            System.out.println(""+w);
//            System.out.println(""+w.toString());
//        }
    }

    private void PlaceholderActivar() {
        //PlaceHolder holder = new PlaceHolder(txt_usuario, "Ej: Usuario123");
        PlaceHolder holder = new PlaceHolder(txt_pass, "Ej: Pass123");
    }

    private void OcultarMostrarComponentes(boolean b) {
        jLabel1.setVisible(b);
        jLabel2.setVisible(b);
        jLabel4.setVisible(b);

        jButton1.setVisible(b);

        txt_pass.setVisible(b);
        txt_usuario.setVisible(b);

    }
    private DPFPCapture Lector = DPFPGlobal.getCaptureFactory().createCapture();

    protected void Iniciar() {
        System.out.println("Preparación ");
        Lector.addDataListener(new DPFPDataAdapter() {
            @Override
            public void dataAcquired(final DPFPDataEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("La Huella Digital ha sido Capturada");
                        ProcesarCaptura(e.getSample());
                    }
                });
            }
        });

        Lector.addReaderStatusListener(new DPFPReaderStatusAdapter() {
            @Override
            public void readerConnected(final DPFPReaderStatusEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("El Sensor de Huella Digital esta Activado o Conectado");
                    }
                });
            }

            @Override
            public void readerDisconnected(final DPFPReaderStatusEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("El Sensor de Huella Digital esta Desactivado o no Conectado");
                    }
                });
            }
        });

        Lector.addSensorListener(new DPFPSensorAdapter() {
            @Override
            public void fingerTouched(final DPFPSensorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("El dedo ha sido colocado sobre el Lector de Huella");
                    }
                });
            }

            @Override
            public void fingerGone(final DPFPSensorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("El dedo ha sido quitado del Lector de Huella");
                    }
                });
            }
        });

        Lector.addErrorListener(new DPFPErrorAdapter() {
            public void errorReader(final DPFPErrorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        EnviarTexto("Error: " + e.getError());
                    }
                });
            }
        });
    }

    public void EnviarTexto(String x) {
        //System.out.println("-- >" + x);
    }
    public DPFPFeatureSet featuresinscripcion;
    public DPFPFeatureSet featuresverificacion;

    public DPFPFeatureSet extraerCaracteristicas(DPFPSample sample, DPFPDataPurpose purpose) {
        DPFPFeatureExtraction extractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
        try {
            return extractor.createFeatureSet(sample, purpose);
        } catch (Exception e) {
            System.out.println("Me vale 3");
            return null;
        }
    }

    public Image CrearImagenHuella(DPFPSample sample) {
        return DPFPGlobal.getSampleConversionFactory().createImage(sample);
    }

    public void DibujarHuella(Image image) {
        cLabel1.setIcon(new ImageIcon(
                image.getScaledInstance(cLabel1.getWidth(), cLabel1.getHeight(), Image.SCALE_DEFAULT)));
        repaint();
    }

    public void EstadoHuellas() {
//        EnviarTexto("Muestra de Huellas Necesarias para Guardar Template " + Reclutador.getFeaturesNeeded());
    }
//    private DPFPEnrollment Reclutador = DPFPGlobal.getEnrollmentFactory().createEnrollment();

//Esta variable tambien captura una huella del lector y crea sus caracteristcas para auntetificarla
// o verificarla con alguna guardada en la BD
//    private DPFPVerification Verificador = DPFPGlobal.getVerificationFactory().createVerification();
//Variable que para crear el template de la huella luego de que se hallan creado las caracteriticas
// necesarias de la huella si no ha ocurrido ningun problema
    private DPFPTemplate template;
    public static String TEMPLATE_PROPERTY = "template";

    public void ProcesarCaptura(DPFPSample sample) {
        // Procesar la muestra de la huella y crear un conjunto de características con el propósito de inscripción.
        featuresinscripcion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

        // Procesar la muestra de la huella y crear un conjunto de características con el propósito de verificacion.
        featuresverificacion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

        // Comprobar la calidad de la muestra de la huella y lo añade a su reclutador si es bueno
        if (featuresinscripcion != null) {
//            try {
//                System.out.println("Las Caracteristicas de la Huella han sido creada");
////                Reclutador.addFeatures(featuresinscripcion);// Agregar las caracteristicas de la huella a la plantilla a crear
//
//                // Dibuja la huella dactilar capturada.
//                Image image = CrearImagenHuella(sample);
//                DibujarHuella(image);
//
//                //btnVerificar.setEnabled(true);
//                //btnIdentificar.setEnabled(true);
//            } catch (DPFPImageQualityException ex) {
//                System.err.println("Error: " + ex.getMessage());
//            } finally {
//                EstadoHuellas();
//                // Comprueba si la plantilla se ha creado.
//                switch (Reclutador.getTemplateStatus()) {
//                    case TEMPLATE_STATUS_READY:	// informe de éxito y detiene  la captura de huellas
//                        stop();
//                        setTemplate(Reclutador.getTemplate());
//                        EnviarTexto("La Plantilla de la Huella ha Sido Creada, ya puede Verificarla o Identificarla");
//                        //btnIdentificar.setEnabled(false);
//                        //btnVerificar.setEnabled(false);
//                        //btnGuardar.setEnabled(true);
//                        //btnGuardar.grabFocus();
//                        break;
//
//                    case TEMPLATE_STATUS_FAILED: // informe de fallas y reiniciar la captura de huellas
//                        Reclutador.clear();
//                        stop();
//                        EstadoHuellas();
//                        setTemplate(null);
//                        JOptionPane.showMessageDialog(null, "La Plantilla de la Huella no pudo ser creada, Repita el Proceso", "Inscripcion de Huellas Dactilares", JOptionPane.ERROR_MESSAGE);
//                        start();
//                        break;
//                }
//            }
        }
    }

    public void start() {
        Lector.startCapture();
        EnviarTexto("Utilizando el Lector de Huella Dactilar ");
    }

    public void stop() {
        Lector.stopCapture();
        EnviarTexto("No se está usando el Lector de Huella Dactilar ");
    }

    public void setTemplate(DPFPTemplate template) {
        DPFPTemplate old = this.template;
        this.template = template;
        firePropertyChange(TEMPLATE_PROPERTY, old, template);
    }

    //ConexionBD con = new ConexionBD();
    public DPFPTemplate getTemplate() {
        return template;
    }

    private void ActivarHuella() {
        try {
            Thread hilo = new Thread(new Runnable() {

                CRUD_HuellaDigital dp;

                @Override
                public void run() {
                    do {
                        if (IntentosHuella != 3) {

                            dp = new CRUD_HuellaDigital();
                            DPFPSample sample = null;

                            try {
                                //Se Solicita la Huella
                                sample = dp.getSample(null, "Escanea tu dedo\n", lbl_stateSensor);
                                Image image = CrearImagenHuella(sample);
                                DibujarHuella(image);
                            } catch (Exception c) {
                                System.out.println("No usó huella");
                                //Si no usa huella se omite todo
                                return;
                            }
                            //Consulta de las huellas almacenadas en la BD
                            ArrayList<byte[]> ok = dp.get();
                            UsoHuella = false;
                            for (int i = 0; i < ok.size(); i++) {
                                //Se convierten las huellas en plantillas
                                DPFPTemplate referenceTemplate = DPFPGlobal.getTemplateFactory().createTemplate(ok.get(i));
                                setTemplate(referenceTemplate);
                                featuresverificacion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);
                                try {
//                                    DPFPVerificationResult result = Verificador.verify(featuresverificacion, getTemplate());
                                    //Si el resultado existe
//                                    if (result.isVerified()) {
//                                        CRUD_Usuario operacion = new CRUD_Usuario();
//                                        ModUsuario usuario;
//                                        try {
//                                            usuario = operacion.RetornaUsuariosiExiste(operacion.RetornaIdUsuariosiExisteContador(i));
//
//                                            //System.out.println("ModUsuario = "+usuario);
//                                            if (usuario != null) {
//                                                UsoHuella = true;
//                                                System.out.println("-->> " + usuario.getUsuario_nombre() + " - " + usuario.getUsuario_pass());
//                                                IngresarSesion(usuario.getUsuario_nombre(), usuario.getUsuario_pass());
//                                                //System.out.println("Tarda");
//                                            }
//                                        } catch (SQLException ex) {
//                                            System.out.println("Error aqui");
//                                            Logger.getLogger(V1Login.class.getName()).log(Level.SEVERE, null, ex);
//                                        }
//                                    }
                                } catch (Exception c) {
                                    System.out.println("Me vale 4");
                                    i = ok.size();
                                    lbl2.setVisible(true);
                                }
                            }
                            if (!UsoHuella) {
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            System.out.println("Activando etiqueta");
                                            lbl2.setVisible(true);
                                            System.out.println("Iniciando Sleep");
                                            Thread.sleep(3 * 1000);
                                            System.out.println("Desactivando etiqueta");
                                            lbl2.setVisible(false);
                                        } catch (Exception ca) {
                                        }
                                    }
                                }).start();
                                SonidoError();
                                IntentosHuella++;
                                //ActualizarIntentosHuella(IntentosHuella);
                            }
                            ActualizarIntentosHuella(IntentosHuella);
                        } else {
                            UsoHuella = true;
                            System.out.println("3 Intentos, Cerrando Sistema");
                        }

                    } while (!UsoHuella);

                    jLabel6.setVisible(false);
                    //System.out.println("Finalizando HIlo Normal");
                    //System.out.println("Hola " + UsoHuella);

                }
            });
            hilo.start();
        } catch (Exception c) {
            System.out.println("Error en el Login");
        }
    }

    private void estilo_btn() {
        agregar_estilo_a(jButton1);
    }

    private void SonidoError() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ReproSonidos x = new ReproSonidos();
                    x.SonidoError();
                } catch (Exception ca) {
                    System.out.println("" + ca);
                }
            }
        }).start();
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

    private void ActualizarIntentosPass(int val) {
        jLabel9.setText("Intentos restantes: " + (3 - val));
    }

    private void ActualizarIntentosHuella(int val) {
        jLabel10.setText("Intentos restantes: " + (3 - val));
    }
}
