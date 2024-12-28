/*
 * http://wiki.netbeans.org/ReportesEnNetBeansConIReport
 */
package Vistas;

import Datos.CopiarDatos;
import GUI.hiloExperimento;
import Modelo.ModExpedienteSujetoPruebas;
import Modelo.ModExperimento;
import Modelo.ModUsuario;
import Reportes.Reporte;
import static Vistas.V1Login.TEMPLATE_PROPERTY;
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
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import conexionBD.CRUD_ListaExperimentos;
import conexionBD.CRUD_Usuario;
import conexionBD.CRUD_ExpedienteSujetoPruebas;
import conexionBD.CRUD_HuellaDigital;
import conexionBD.CRUD_TablasGenerales;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import static java.lang.System.exit;
import java.net.InetAddress;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;

/**
 * @author Fercho
 */
public class V4ProgramaPrincipal extends javax.swing.JPanel {

    /**
     * Creates new form V4ProgramaPrincipal
     */
    Webcam webcam = null;
    WebcamPanel panel = null;
    ModUsuario usuario;
    ModExpedienteSujetoPruebas eu;
    Executor exegutor = Executors.newSingleThreadExecutor();
    AtomicBoolean initilized = new AtomicBoolean(false);
    hiloExperimento hiloEjecucionExperimento;
    int idModificar = 0;
    boolean UsoHuella;

    public V4ProgramaPrincipal(ModUsuario usuario, boolean UsoHuella) throws SQLException {
        initComponents();

        jLabel60.setVisible(false);
        this.usuario = usuario;
        //Carga el combo box con los datos para eliminar o consultar
        LeerDatosEC();
        configuracionBtn();
        e_txt_nombre.setEditable(false);
        //llenadoTablaExperimentos();
        setTabla(1);

        setTabla2(1);

        lbl_editar.setVisible(false);
        this.UsoHuella = UsoHuella;
        jButton10.setEnabled(false);
        jButton9.setEnabled(false);
        jButton8.setEnabled(false);
        jTextArea2.setEditable(false);
        LlenarDatosPersonales(usuario);
        if (usuario.getUsuario_tipo().equals("1")) {
            PerfilOpcionesUsuario.setVisible(true);
            LlenarComboBoxUsuarios();

        } else {
            PerfilOpcionesUsuario.setVisible(false);
            PerfilNuevo.setVisible(false);
            PerfilCancelar.setVisible(false);
            PerfilEliminar.setVisible(false);
        }
        if (usuario.getUsuario_tipo().equals("3")) {
            jButton18.setEnabled(false);
            jButton20.setEnabled(false);
            jButton21.setEnabled(false);
        }
        ActualizaLista(d0.getText());
        OcultarValidaciones(false);

        CargarEstilosBotonesVerdes();

        LlenarComboBoxReportes(usuario.getIdUsuario() + "");
        LLenarComboBoxInformacionGeneral();
        ActivarDesactivarEdicion(false);
    }

    protected void LeerDatosEC() throws SQLException {
        e_txt_nombre.removeAllItems();
        e_txt_nombre1.removeAllItems();

        List<String> datos;
        CRUD_ExpedienteSujetoPruebas val = new CRUD_ExpedienteSujetoPruebas();
        datos = val.RetornaListaExpedientes();
        try {
            for (int i = 0; i < datos.size(); i++) {
                e_txt_nombre.addItem(datos.get(i));
                e_txt_nombre1.addItem(datos.get(i));
            }
        } catch (Exception e) {
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        btn_iniciar_e = new javax.swing.JButton();
        txt_ie_ip = new javax.swing.JTextField();
        txt_ie_puerto = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        e_txt_nombre1 = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txt_nombre_experimento = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        t1 = new javax.swing.JTextField();
        t2 = new javax.swing.JTextField();
        t3 = new javax.swing.JTextField();
        b1 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        t0 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        lbl_editar = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jLabel63 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        e_txt_nombre = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        e0 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        e1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        e2 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        e3 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        e7 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        cbCarrera = new javax.swing.JComboBox<>();
        cbReligion = new javax.swing.JComboBox<>();
        cbEstadoCivil = new javax.swing.JComboBox<>();
        cbSexo = new javax.swing.JComboBox<>();
        cbLengua = new javax.swing.JComboBox<>();
        cbIdioma = new javax.swing.JComboBox<>();
        jPanel11 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel68 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel70 = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jButton19 = new javax.swing.JButton();
        jLabel74 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel77 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel10 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        List = new javax.swing.JList<>();
        jLabel51 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton9 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        d1 = new javax.swing.JTextPane();
        jLabel52 = new javax.swing.JLabel();
        d3 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        d4 = new javax.swing.JPasswordField();
        jLabel54 = new javax.swing.JLabel();
        d5 = new javax.swing.JPasswordField();
        d6 = new javax.swing.JComboBox<>();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        d7 = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        PerfilOpcionesUsuario = new javax.swing.JComboBox<>();
        jButton11 = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        d0 = new javax.swing.JTextField();
        PerfilNuevo = new javax.swing.JButton();
        PerfilCancelar = new javax.swing.JButton();
        PerfilEliminar = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        txt_nombre = new javax.swing.JTextField();
        txt_ap_pat = new javax.swing.JTextField();
        txt_ap_mat = new javax.swing.JTextField();
        fecha = new javax.swing.JTextField();
        txt_curp = new javax.swing.JTextField();
        calendario = new com.toedter.calendar.JCalendar();
        v1 = new javax.swing.JLabel();
        v7 = new javax.swing.JLabel();
        v2 = new javax.swing.JLabel();
        cbestadocivil = new javax.swing.JComboBox<>();
        cb_carrera = new javax.swing.JComboBox<>();
        cb_religion = new javax.swing.JComboBox<>();
        cb_sexo = new javax.swing.JComboBox<>();
        cb_lm = new javax.swing.JComboBox<>();
        cb_oi = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        btn_atras = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lbl_n_user = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();

        setBackground(new java.awt.Color(79, 84, 93));
        setLayout(null);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel4.setLayout(null);

        btn_iniciar_e.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_iniciar_e.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/V4Principal/iniciar.png"))); // NOI18N
        btn_iniciar_e.setText("Iniciar");
        btn_iniciar_e.setEnabled(false);
        btn_iniciar_e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciar_eActionPerformed(evt);
            }
        });
        jPanel4.add(btn_iniciar_e);
        btn_iniciar_e.setBounds(570, 310, 130, 50);

        txt_ie_ip.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_ie_ip.setText("127.0.0.1");
        jPanel4.add(txt_ie_ip);
        txt_ie_ip.setBounds(590, 70, 170, 30);

        txt_ie_puerto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_ie_puerto.setText("2402");
        jPanel4.add(txt_ie_puerto);
        txt_ie_puerto.setBounds(590, 110, 170, 30);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Configuracion/ajustes (2).png"))); // NOI18N
        jLabel13.setText(" Configuración del experimento");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(20, 10, 1230, 32);
        jPanel4.add(jSeparator2);
        jSeparator2.setBounds(10, 150, 1230, 10);

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("Dirección Ip del dispositivo Linux:");
        jPanel4.add(jLabel37);
        jLabel37.setBounds(360, 80, 270, 14);

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setText("Puerto de conexión:");
        jPanel4.add(jLabel38);
        jLabel38.setBounds(440, 120, 280, 20);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Probar Conexión");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);
        jButton1.setBounds(780, 110, 170, 30);
        jPanel4.add(jSeparator4);
        jSeparator4.setBounds(20, 50, 1230, 3);

        e_txt_nombre1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        e_txt_nombre1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona un elemento" }));
        e_txt_nombre1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                e_txt_nombre1ItemStateChanged(evt);
            }
        });
        e_txt_nombre1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                e_txt_nombre1PropertyChange(evt);
            }
        });
        e_txt_nombre1.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                e_txt_nombre1VetoableChange(evt);
            }
        });
        jPanel4.add(e_txt_nombre1);
        e_txt_nombre1.setBounds(540, 200, 310, 40);

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setText("Sujeto de pruebas:");
        jPanel4.add(jLabel39);
        jLabel39.setBounds(400, 200, 200, 40);

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setText("Nombre del Experimento:");
        jPanel4.add(jLabel40);
        jLabel40.setBounds(360, 260, 200, 40);

        txt_nombre_experimento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel4.add(txt_nombre_experimento);
        txt_nombre_experimento.setBounds(540, 260, 310, 30);
        jPanel4.add(jSeparator5);
        jSeparator5.setBounds(10, 400, 1230, 10);

        jLabel32.setText("* La siguiente lista muestra la Información de los experimentos que aún no han sido subidos a la Base de datos");
        jPanel4.add(jLabel32);
        jLabel32.setBounds(340, 430, 900, 19);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Fecha", "Sujeto", "Nombre del experimento", "Editar", "Eliminar", "Guardar BD"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel4.add(jScrollPane2);
        jScrollPane2.setBounds(10, 472, 1240, 280);

        jButton4.setText("Actualizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4);
        jButton4.setBounds(1000, 410, 130, 50);

        jLabel58.setText("* Si no aparecen los datos de su último experimento pulsa el botón actualizar");
        jPanel4.add(jLabel58);
        jLabel58.setBounds(10, 760, 800, 19);

        jLabel30.setForeground(new java.awt.Color(0, 51, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Nota: Antes de dar click en el botón Iniciar verifique su conexión pulsando el botón \"Probar Conexión\"");
        jPanel4.add(jLabel30);
        jLabel30.setBounds(10, 370, 1230, 20);

        jTabbedPane1.addTab("Iniciar experimento         ", new javax.swing.ImageIcon(getClass().getResource("/img/V4Principal/iniciar.png")), jPanel4, ""); // NOI18N

        jPanel3.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Fecha", "Sujeto", "Nombre del Experimento", "Editar", "Eliminar", "Exportar", "Ver"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(3);
        }

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(20, 110, 1210, 470);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(null);

        t1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t1KeyPressed(evt);
            }
        });
        jPanel9.add(t1);
        t1.setBounds(210, 80, 210, 20);

        t2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t2KeyPressed(evt);
            }
        });
        jPanel9.add(t2);
        t2.setBounds(440, 80, 210, 20);

        t3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                t3KeyPressed(evt);
            }
        });
        jPanel9.add(t3);
        t3.setBounds(670, 80, 210, 20);

        b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Buscar/buscar (2).png"))); // NOI18N
        b1.setText("Buscar");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        jPanel9.add(b1);
        b1.setBounds(900, 70, 140, 40);

        b3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x/error (1).png"))); // NOI18N
        b3.setText("Cancelar");
        b3.setEnabled(false);
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });
        jPanel9.add(b3);
        b3.setBounds(1060, 70, 130, 40);

        jLabel31.setText("Filtros de búsqueda de Información");
        jPanel9.add(jLabel31);
        jLabel31.setBounds(20, 20, 380, 19);
        jPanel9.add(t0);
        t0.setBounds(20, 80, 170, 25);

        jLabel41.setText("Id:");
        jPanel9.add(jLabel41);
        jLabel41.setBounds(20, 50, 170, 19);

        jLabel42.setText("Fecha de Experimento:");
        jPanel9.add(jLabel42);
        jLabel42.setBounds(210, 50, 170, 19);

        jLabel43.setText("Sujeto de pruebas:");
        jPanel9.add(jLabel43);
        jLabel43.setBounds(440, 50, 170, 19);

        jLabel44.setText("Nombre del experimento:");
        jPanel9.add(jLabel44);
        jLabel44.setBounds(670, 50, 190, 19);

        jPanel3.add(jPanel9);
        jPanel9.setBounds(20, 600, 1230, 120);

        lbl_editar.setForeground(new java.awt.Color(255, 0, 51));
        lbl_editar.setText("*Modiifque los datos de la fila correspondiente");
        jPanel3.add(lbl_editar);
        lbl_editar.setBounds(870, 60, 370, 19);

        jLabel59.setText("* Si no aparecen los datos de su último experimento pulse el botón para actualizar la página");
        jPanel3.add(jLabel59);
        jLabel59.setBounds(130, 70, 870, 19);

        jButton12.setText("Acutalizar");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton12);
        jButton12.setBounds(20, 60, 100, 40);

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel63.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel63.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Editar/escritura (2).png"))); // NOI18N
        jLabel63.setText("Historial de los experimentos");
        jPanel3.add(jLabel63);
        jLabel63.setBounds(20, 10, 1160, 32);
        jPanel3.add(jSeparator7);
        jSeparator7.setBounds(20, 50, 1150, 10);

        jTabbedPane1.addTab("Historial de experimentos", new javax.swing.ImageIcon(getClass().getResource("/img/V4Principal/historial.png")), jPanel3); // NOI18N

        jPanel2.setLayout(null);

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Editar/escritura (2).png"))); // NOI18N
        jLabel36.setText(" Editar o Eliminar usuario de Expediente clínico");
        jPanel2.add(jLabel36);
        jLabel36.setBounds(20, 10, 1160, 32);
        jPanel2.add(jSeparator3);
        jSeparator3.setBounds(20, 50, 1150, 10);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Seleccione la persona que desea editar");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(210, 100, 340, 20);

        e_txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        e_txt_nombre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona un elemento" }));
        e_txt_nombre.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                e_txt_nombreItemStateChanged(evt);
            }
        });
        e_txt_nombre.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                e_txt_nombrePropertyChange(evt);
            }
        });
        e_txt_nombre.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                e_txt_nombreVetoableChange(evt);
            }
        });
        jPanel2.add(e_txt_nombre);
        e_txt_nombre.setBounds(470, 90, 260, 40);

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Edit/editar (1).png"))); // NOI18N
        jButton6.setText("EDITAR");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6);
        jButton6.setBounds(760, 90, 160, 40);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Nombre:");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(400, 160, 270, 20);

        e0.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        e0.setEnabled(false);
        jPanel2.add(e0);
        e0.setBounds(470, 160, 430, 26);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Apellido Paterno:");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(400, 190, 300, 20);

        e1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        e1.setEnabled(false);
        jPanel2.add(e1);
        e1.setBounds(520, 190, 380, 26);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Apellido Materno:");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(400, 220, 280, 20);

        e2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        e2.setEnabled(false);
        jPanel2.add(e2);
        e2.setBounds(520, 220, 380, 20);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Fecha de Nacimiento:");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(400, 250, 340, 20);

        e3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        e3.setEnabled(false);
        jPanel2.add(e3);
        e3.setBounds(540, 250, 360, 26);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Carrera:");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(400, 290, 70, 20);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Religión:");
        jPanel2.add(jLabel23);
        jLabel23.setBounds(400, 320, 70, 20);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Estado Civil:");
        jPanel2.add(jLabel24);
        jLabel24.setBounds(400, 350, 90, 20);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("CURP:");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(400, 380, 80, 20);

        e7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        e7.setEnabled(false);
        jPanel2.add(e7);
        e7.setBounds(460, 380, 440, 26);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Otro idioma:");
        jPanel2.add(jLabel25);
        jLabel25.setBounds(400, 480, 90, 20);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Lengua Materna:");
        jPanel2.add(jLabel26);
        jLabel26.setBounds(400, 450, 120, 20);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Sexo:");
        jPanel2.add(jLabel27);
        jLabel27.setBounds(400, 420, 60, 20);

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Agregar/agregar-usuario (1).png"))); // NOI18N
        jButton7.setText("Guardar Cambios");
        jButton7.setEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7);
        jButton7.setBounds(450, 650, 160, 40);

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Borrar/borrar (1).png"))); // NOI18N
        jButton5.setText("Eliminar Datos");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(680, 650, 160, 40);

        cbCarrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbCarrera);
        cbCarrera.setBounds(460, 290, 440, 25);

        cbReligion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbReligion);
        cbReligion.setBounds(460, 320, 440, 25);

        cbEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbEstadoCivil);
        cbEstadoCivil.setBounds(480, 350, 420, 25);

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbSexo);
        cbSexo.setBounds(450, 420, 450, 25);

        cbLengua.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbLengua);
        cbLengua.setBounds(520, 450, 380, 25);

        cbIdioma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(cbIdioma);
        cbIdioma.setBounds(490, 480, 410, 25);
        jPanel2.add(jPanel11);
        jPanel11.setBounds(400, 520, 500, 70);

        jTabbedPane1.addTab("Consultar/Eliminar EC     ", new javax.swing.ImageIcon(getClass().getResource("/img/V4Principal/edit.png")), jPanel2); // NOI18N

        jPanel7.setLayout(null);

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("Lista de Historial de Experimentos");
        jPanel7.add(jLabel67);
        jLabel67.setBounds(470, 130, 750, 20);
        jPanel7.add(jSeparator8);
        jSeparator8.setBounds(20, 50, 1230, 3);

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/V4Principal/reportar.png"))); // NOI18N
        jLabel68.setText("Generar reportes");
        jPanel7.add(jLabel68);
        jLabel68.setBounds(20, 10, 1230, 24);

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/V4Principal/pdf.png"))); // NOI18N
        jButton16.setText("Exportar");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton16);
        jButton16.setBounds(1010, 90, 180, 90);
        jPanel7.add(jSeparator9);
        jSeparator9.setBounds(20, 230, 1230, 10);
        jPanel7.add(jSeparator12);
        jSeparator12.setBounds(20, 390, 1230, 10);
        jPanel7.add(jSeparator13);
        jSeparator13.setBounds(20, 600, 1230, 10);

        jLabel70.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel70.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel70.setText("Lista de Idiomas en Pacientes");
        jPanel7.add(jLabel70);
        jLabel70.setBounds(940, 420, 280, 20);

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/V4Principal/pdf.png"))); // NOI18N
        jButton18.setText("Exportar");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton18);
        jButton18.setBounds(90, 450, 190, 90);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setEnabled(false);
        jPanel7.add(jComboBox1);
        jComboBox1.setBounds(440, 110, 240, 30);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setEnabled(false);
        jPanel7.add(jComboBox2);
        jComboBox2.setBounds(440, 150, 240, 30);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel7.add(jComboBox3);
        jComboBox3.setBounds(100, 130, 240, 30);

        jRadioButton1.setText("Uno");
        jRadioButton1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton1StateChanged(evt);
            }
        });
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jRadioButton1);
        jRadioButton1.setBounds(80, 70, 140, 23);

        jRadioButton2.setText("Rango");
        jRadioButton2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton2StateChanged(evt);
            }
        });
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel7.add(jRadioButton2);
        jRadioButton2.setBounds(420, 70, 180, 23);

        jLabel71.setText("Seleccione:");
        jPanel7.add(jLabel71);
        jLabel71.setBounds(30, 140, 90, 19);

        jLabel72.setText("Hasta:");
        jPanel7.add(jLabel72);
        jLabel72.setBounds(390, 160, 40, 19);

        jLabel73.setText("Desde:");
        jPanel7.add(jLabel73);
        jLabel73.setBounds(390, 120, 50, 19);

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/V4Principal/pdf.png"))); // NOI18N
        jButton19.setText("Exportar");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton19);
        jButton19.setBounds(1010, 270, 180, 90);

        jLabel74.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel74.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel74.setText("Lista de Experimentos Temporales");
        jPanel7.add(jLabel74);
        jLabel74.setBounds(470, 310, 750, 20);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox4.setEnabled(false);
        jPanel7.add(jComboBox4);
        jComboBox4.setBounds(440, 330, 240, 30);

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox5.setEnabled(false);
        jPanel7.add(jComboBox5);
        jComboBox5.setBounds(440, 290, 240, 30);

        jRadioButton3.setText("Rango");
        jRadioButton3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton3StateChanged(evt);
            }
        });
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        jPanel7.add(jRadioButton3);
        jRadioButton3.setBounds(420, 250, 180, 23);

        jLabel75.setText("Desde:");
        jPanel7.add(jLabel75);
        jLabel75.setBounds(390, 300, 50, 19);

        jLabel76.setText("Hasta:");
        jPanel7.add(jLabel76);
        jLabel76.setBounds(390, 340, 40, 19);

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel7.add(jComboBox6);
        jComboBox6.setBounds(100, 310, 240, 30);

        jLabel77.setText("Seleccione:");
        jPanel7.add(jLabel77);
        jLabel77.setBounds(30, 320, 90, 19);

        jRadioButton4.setText("Uno");
        jRadioButton4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton4StateChanged(evt);
            }
        });
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        jPanel7.add(jRadioButton4);
        jRadioButton4.setBounds(80, 250, 150, 23);

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/V4Principal/pdf.png"))); // NOI18N
        jButton20.setText("Exportar");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton20);
        jButton20.setBounds(1010, 450, 180, 90);

        jButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/V4Principal/pdf.png"))); // NOI18N
        jButton21.setText("Exportar");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton21);
        jButton21.setBounds(560, 450, 180, 90);

        jLabel78.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel78.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel78.setText("Lista de Expedientes Clínicos");
        jPanel7.add(jLabel78);
        jLabel78.setBounds(50, 420, 260, 20);

        jLabel79.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("Lista de Enfermedades de Pacientes");
        jPanel7.add(jLabel79);
        jLabel79.setBounds(510, 420, 280, 20);

        jTabbedPane1.addTab("Reportes                       ", new javax.swing.ImageIcon(getClass().getResource("/img/V4Principal/reportar.png")), jPanel7); // NOI18N

        jPanel6.setLayout(null);

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/V4Principal/usuario.png"))); // NOI18N
        jLabel46.setText("Perfil de Usuario");
        jPanel6.add(jLabel46);
        jLabel46.setBounds(20, 10, 1230, 24);
        jPanel6.add(jSeparator6);
        jSeparator6.setBounds(20, 50, 1230, 3);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(null);

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/huella/1 (2).png"))); // NOI18N
        jPanel10.add(jLabel47);
        jLabel47.setBounds(810, 90, 250, 270);

        jLabel48.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel48.setText("Descripción de Huella del Usuario");
        jPanel10.add(jLabel48);
        jLabel48.setBounds(800, 370, 280, 19);

        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Información");
        jPanel10.add(jLabel50);
        jLabel50.setBounds(810, 70, 290, 19);

        jButton10.setText("Guardar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton10);
        jButton10.setBounds(670, 450, 123, 39);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        jPanel10.add(jScrollPane3);
        jScrollPane3.setBounds(60, 500, 1070, 70);

        List.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        List.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListMouseClicked(evt);
            }
        });
        List.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ListKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(List);

        jPanel10.add(jScrollPane4);
        jScrollPane4.setBounds(560, 110, 220, 330);

        jLabel51.setText("Lista de Huellas Registradas");
        jPanel10.add(jLabel51);
        jLabel51.setBounds(560, 90, 390, 19);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("Descripción de la Huella");
        jScrollPane5.setViewportView(jTextArea2);

        jPanel10.add(jScrollPane5);
        jScrollPane5.setBounds(800, 386, 280, 50);

        jButton9.setText("Eliminar Actual");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton9);
        jButton9.setBounds(1010, 450, 120, 40);

        jButton2.setText("Capturar Nueva Huella");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton2);
        jButton2.setBounds(730, 10, 310, 30);

        jButton8.setText("Actualizar Descripcion");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton8);
        jButton8.setBounds(810, 450, 180, 40);

        jLabel45.setText("Nombre completo:");
        jPanel10.add(jLabel45);
        jLabel45.setBounds(100, 150, 90, 19);

        d1.setEnabled(false);
        jScrollPane6.setViewportView(d1);

        jPanel10.add(jScrollPane6);
        jScrollPane6.setBounds(200, 140, 240, 30);

        jLabel52.setText("Nombre de Usuario:");
        jPanel10.add(jLabel52);
        jLabel52.setBounds(100, 200, 140, 19);

        d3.setEnabled(false);
        jPanel10.add(d3);
        d3.setBounds(220, 190, 220, 30);

        jLabel53.setText("Contraseña:");
        jPanel10.add(jLabel53);
        jLabel53.setBounds(100, 250, 110, 19);

        d4.setEnabled(false);
        jPanel10.add(d4);
        d4.setBounds(180, 240, 260, 30);

        jLabel54.setText("Repite Contraseña:");
        jPanel10.add(jLabel54);
        jLabel54.setBounds(100, 290, 130, 30);

        d5.setEnabled(false);
        d5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                d5FocusLost(evt);
            }
        });
        d5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                d5KeyPressed(evt);
            }
        });
        jPanel10.add(d5);
        d5.setBounds(220, 290, 220, 30);

        d6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Usuario normal", "Invitado" }));
        d6.setEnabled(false);
        jPanel10.add(d6);
        d6.setBounds(200, 340, 240, 30);

        jLabel55.setText("Tipo de Usuario:");
        jPanel10.add(jLabel55);
        jLabel55.setBounds(100, 350, 100, 19);

        jLabel56.setText("Correo Electrónico:");
        jPanel10.add(jLabel56);
        jLabel56.setBounds(100, 400, 120, 19);

        d7.setEnabled(false);
        jPanel10.add(d7);
        d7.setBounds(220, 390, 220, 30);

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel57.setText("Datos Personales:");
        jPanel10.add(jLabel57);
        jLabel57.setBounds(100, 60, 240, 26);

        PerfilOpcionesUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        PerfilOpcionesUsuario.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                PerfilOpcionesUsuarioItemStateChanged(evt);
            }
        });
        PerfilOpcionesUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerfilOpcionesUsuarioActionPerformed(evt);
            }
        });
        PerfilOpcionesUsuario.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                PerfilOpcionesUsuarioPropertyChange(evt);
            }
        });
        jPanel10.add(PerfilOpcionesUsuario);
        PerfilOpcionesUsuario.setBounds(100, 10, 340, 30);

        jButton11.setText("Editar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton11);
        jButton11.setBounds(100, 430, 130, 40);

        jLabel49.setText("Id:");
        jPanel10.add(jLabel49);
        jLabel49.setBounds(100, 100, 60, 19);

        d0.setEnabled(false);
        jPanel10.add(d0);
        d0.setBounds(120, 90, 110, 30);

        PerfilNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Agregar/agregar-usuario.png"))); // NOI18N
        PerfilNuevo.setText("Nuevo");
        PerfilNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerfilNuevoActionPerformed(evt);
            }
        });
        jPanel10.add(PerfilNuevo);
        PerfilNuevo.setBounds(450, 10, 90, 30);

        PerfilCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/x/error (2).png"))); // NOI18N
        PerfilCancelar.setText("Cancelar");
        PerfilCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerfilCancelarActionPerformed(evt);
            }
        });
        jPanel10.add(PerfilCancelar);
        PerfilCancelar.setBounds(550, 10, 100, 30);

        PerfilEliminar.setText("Eliminar Actual");
        PerfilEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerfilEliminarActionPerformed(evt);
            }
        });
        jPanel10.add(PerfilEliminar);
        PerfilEliminar.setBounds(320, 430, 120, 40);

        jLabel60.setBackground(new java.awt.Color(255, 51, 51));
        jLabel60.setText("*Las contraseñas no coiciden");
        jPanel10.add(jLabel60);
        jLabel60.setBounds(220, 320, 220, 19);

        jPanel6.add(jPanel10);
        jPanel10.setBounds(70, 100, 1160, 610);

        jTabbedPane1.addTab("Perfil                             ", new javax.swing.ImageIcon(getClass().getResource("/img/V4Principal/usuario.png")), jPanel6); // NOI18N

        jPanel8.setLayout(null);

        jLabel64.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel64.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/V4Principal/advertencia (1).png"))); // NOI18N
        jPanel8.add(jLabel64);
        jLabel64.setBounds(34, 103, 1210, 280);

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel65.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel65.setText("Si deseas finalizar tu sesión ha click en Cerrar Sesión o en Calcelar para continuar trabajando");
        jPanel8.add(jLabel65);
        jLabel65.setBounds(20, 450, 1230, 32);

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel66.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel66.setText("Advertencia!!!");
        jPanel8.add(jLabel66);
        jLabel66.setBounds(20, 410, 1230, 20);

        jButton13.setText("Cancelar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton13);
        jButton13.setBounds(650, 520, 210, 50);

        jButton14.setText("Cerrar Sesión");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton14);
        jButton14.setBounds(430, 520, 210, 50);

        jTabbedPane1.addTab("Cerrar Sesión               ", new javax.swing.ImageIcon(getClass().getResource("/img/V4Principal/salida.png")), jPanel8); // NOI18N

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add/mas (2).png"))); // NOI18N
        jLabel2.setText("  Agregar un nuevo usuario de Expediente clínico");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 10, 1160, 32);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(20, 50, 1150, 10);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(350, 80, 100, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Apellido Paterno:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(350, 110, 130, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Apellido Materno:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(350, 140, 110, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Fecha de Nacimiento:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(350, 170, 170, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("CURP:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(350, 310, 80, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Carrera:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(350, 220, 70, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Religión:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(350, 250, 70, 20);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Estado Civil:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(350, 280, 90, 20);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Otro idioma:");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(350, 420, 90, 20);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Lengua Materna:");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(350, 390, 120, 20);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Sexo:");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(350, 360, 60, 20);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Agregar/agregar-usuario (2).png"))); // NOI18N
        jButton3.setText("Guardar Datos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(490, 610, 300, 40);

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nombreKeyPressed(evt);
            }
        });
        jPanel1.add(txt_nombre);
        txt_nombre.setBounds(430, 80, 360, 26);

        txt_ap_pat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_ap_pat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ap_patKeyPressed(evt);
            }
        });
        jPanel1.add(txt_ap_pat);
        txt_ap_pat.setBounds(470, 110, 320, 26);

        txt_ap_mat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_ap_mat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_ap_matKeyPressed(evt);
            }
        });
        jPanel1.add(txt_ap_mat);
        txt_ap_mat.setBounds(470, 140, 320, 26);

        fecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fecha.setEnabled(false);
        jPanel1.add(fecha);
        fecha.setBounds(490, 170, 300, 26);

        txt_curp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_curp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_curpFocusLost(evt);
            }
        });
        txt_curp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_curpKeyPressed(evt);
            }
        });
        jPanel1.add(txt_curp);
        txt_curp.setBounds(400, 310, 390, 26);

        calendario.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calendarioPropertyChange(evt);
            }
        });
        jPanel1.add(calendario);
        calendario.setBounds(830, 170, 238, 172);

        v1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check/exito.png"))); // NOI18N
        jPanel1.add(v1);
        v1.setBounds(800, 80, 30, 20);

        v7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check/exito.png"))); // NOI18N
        jPanel1.add(v7);
        v7.setBounds(800, 310, 30, 20);

        v2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/check/exito.png"))); // NOI18N
        jPanel1.add(v2);
        v2.setBounds(800, 110, 30, 20);

        cbestadocivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbestadocivil);
        cbestadocivil.setBounds(440, 280, 350, 25);

        cb_carrera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cb_carrera);
        cb_carrera.setBounds(420, 220, 370, 25);

        cb_religion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cb_religion);
        cb_religion.setBounds(420, 250, 370, 25);

        cb_sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cb_sexo);
        cb_sexo.setBounds(420, 360, 370, 25);

        cb_lm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cb_lm);
        cb_lm.setBounds(460, 390, 330, 25);

        cb_oi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cb_oi);
        cb_oi.setBounds(440, 420, 350, 25);
        jPanel1.add(jPanel5);
        jPanel5.setBounds(350, 460, 440, 90);

        jTabbedPane1.addTab("Expediente Clínico (EC)   ", new javax.swing.ImageIcon(getClass().getResource("/img/V4Principal/mas.png")), jPanel1); // NOI18N

        add(jTabbedPane1);
        jTabbedPane1.setBounds(190, 80, 1480, 760);

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo_unsis.png"))); // NOI18N
        add(jLabel33);
        jLabel33.setBounds(10, 10, 220, 220);

        btn_atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/atras/flecha-hacia-la-izquierda (2).png"))); // NOI18N
        btn_atras.setToolTipText("Regresar");
        btn_atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atrasActionPerformed(evt);
            }
        });
        add(btn_atras);
        btn_atras.setBounds(910, 10, 40, 40);

        jPanel12.setBackground(new java.awt.Color(79, 84, 93));
        jPanel12.setLayout(null);

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boy/hombre (3).png"))); // NOI18N
        jPanel12.add(jLabel34);
        jLabel34.setBounds(46, 40, 64, 70);

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Bienvendido");
        jLabel35.setToolTipText("");
        jPanel12.add(jLabel35);
        jLabel35.setBounds(10, 150, 130, 20);

        lbl_n_user.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_n_user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_n_user.setText("Usuario: ");
        jPanel12.add(lbl_n_user);
        lbl_n_user.setBounds(0, 120, 150, 20);

        jLabel61.setBackground(new java.awt.Color(79, 84, 93));
        jLabel61.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/V2Colocacion/250 188.png"))); // NOI18N
        jPanel12.add(jLabel61);
        jLabel61.setBounds(0, 0, 160, 200);

        add(jPanel12);
        jPanel12.setBounds(1700, 10, 250, 190);

        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/V2Colocacion/Untitled (2).png"))); // NOI18N
        add(jLabel62);
        jLabel62.setBounds(1630, 840, 230, 90);

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/V4Principal/salida.png"))); // NOI18N
        jButton15.setText("Salir");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        add(jButton15);
        jButton15.setBounds(1520, 870, 110, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (JOptionPane.showConfirmDialog(null, "Desea almacenar el expediente clínico?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            String sex = "M";

            if (!txt_nombre.getText().equals("")&&!txt_ap_pat.getText().equals("")&&!txt_curp.getText().equals("")){
                if(!cb_lm.getSelectedItem().equals(cb_oi.getSelectedItem())){
                    System.out.println("00 "+cb_lm.getSelectedItem());
                    System.out.println("00 "+cb_oi.getSelectedItem());
                ModExpedienteSujetoPruebas eu;
                boolean opc = false;

                eu = new ModExpedienteSujetoPruebas(txt_nombre.getText(), txt_ap_pat.getText(), txt_ap_mat.getText(), fecha.getText(), txt_curp.getText(), cbestadocivil.getSelectedItem().toString(), cb_sexo.getSelectedItem().toString(), cb_religion.getSelectedItem().toString());

                CRUD_ExpedienteSujetoPruebas cew = new CRUD_ExpedienteSujetoPruebas();

                try {
                    System.out.println("1");
                    cew.InsertarExpedienteUsuario(eu);
                    System.out.println("2");
                    //RELACIONES
                    cew.InsertarRelacionCarrera(txt_nombre.getText(), cb_carrera.getSelectedItem().toString());
                    System.out.println("3");
                    cew.InsertarRelacionIdioma(txt_nombre.getText(), cb_lm.getSelectedItem().toString());
                    System.out.println("4");
                    cew.InsertarRelacionIdioma(txt_nombre.getText(), cb_oi.getSelectedItem().toString());

                    ComponentesPanel(jPanel5, txt_nombre.getText());
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                    limpiarDatosAgregar();
                    LeerDatosEC();
                    OcultarValidaciones(false);
                } catch (SQLException ex) {
                }
            }

            } else {
                JOptionPane.showMessageDialog(null, "Existen campos vacíos");
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void limpiarDatosAgregar() {
        txt_nombre.setText("");
        txt_ap_pat.setText("");
        txt_ap_mat.setText("");
        fecha.setText("");
        //txt_ec.setText("");
        txt_curp.setText("");

    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "Desea eliminar el expediente clínico?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

            if (e_txt_nombre.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(null, "Escriba un nombre para Eliminar");

            } else {
                CRUD_ExpedienteSujetoPruebas crud = new CRUD_ExpedienteSujetoPruebas();
                try {
                    crud.DeleteExpedienteUsuario(eu.getIdExpedienteUsuario());
                    JOptionPane.showMessageDialog(null, "Eliminación exitosa");
                    ActualizarEditExpClin();
                    ActivarDesactivarEdicion(false);
                    if (!jButton6.getText().equals("EDITAR")) {
                        jButton6.setText("EDITAR");
                        jButton6.setIcon(new ImageIcon("src/img/Edit/editar (1).png"));
                    }
                    LeerDatosEC();
                } catch (SQLException ex) {
                    //System.out.println("Error al Eliminar");
                }
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (jButton6.getText().equals("EDITAR")) {
            BuscarSeleccionado();
            jButton6.setText("CANCELAR");
            jButton6.setIcon(new ImageIcon("src/img/x/error (1).png"));
            ActivarDesactivarEdicion(true);
        } else {
            jButton6.setText("EDITAR");
            jButton6.setIcon(new ImageIcon("src/img/Edit/editar (1).png"));
            ActivarDesactivarEdicion(false);
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void BuscarSeleccionado() {
        try {
            String n = (String) e_txt_nombre.getSelectedItem();
            idModificar = 0;
            for (int j = 0; j < n.length() && idModificar == 0; j++) {
                if (n.charAt(j) == ')') {
                    idModificar = j;
                }
            }
            eu = new ModExpedienteSujetoPruebas();
            CRUD_ExpedienteSujetoPruebas crud = new CRUD_ExpedienteSujetoPruebas();
            try {
                eu = crud.RetornaExpedienteUsuariosiExisteId(n.substring(0, idModificar));
                if (eu != null) {
                    e0.setText(eu.getExpedienteUsuario_nombre());
                    e1.setText(eu.getExpedienteUsuario_ap_pat());
                    e2.setText(eu.getExpedienteUsuario_ap_mat());
                    e3.setText(eu.getExpedienteUsuario_fecha_nac());
                    e7.setText(eu.getExpedienteUsuario_curp());
                    try {
                        System.out.println("" + eu.getExpedienteUsuario_religion());
                        cbReligion.setSelectedIndex(Integer.parseInt(eu.getExpedienteUsuario_religion()) - 1);
                        System.out.println("" + eu.getExpedienteUsuario_ec());
                        cbEstadoCivil.setSelectedIndex(Integer.parseInt(eu.getExpedienteUsuario_ec()) - 1);
                        System.out.println("" + eu.getExpedienteUsuario_s());
                        cbSexo.setSelectedIndex(Integer.parseInt(eu.getExpedienteUsuario_s()) - 1);
                    } catch (Exception c) {
                        System.out.println("Error en RES" + c.toString());
                    }
                    try {
                        System.out.println("CLI --- VER"+eu);
                        System.out.println("1- " + eu.getExpedienteUsuario_carrera());
                        cbCarrera.setSelectedIndex(Integer.parseInt(eu.getExpedienteUsuario_carrera()) - 1);
                        System.out.println("2- " + eu.getExpedienteUsuario_lm());
                        cbLengua.setSelectedIndex(Integer.parseInt(eu.getExpedienteUsuario_lm()) - 1);
                        System.out.println("3- " + eu.getExpedienteUsuario_oi());
                        cbIdioma.setSelectedIndex(Integer.parseInt(eu.getExpedienteUsuario_oi()) - 1);
                    } catch (Exception s) {
                        System.out.println("Error en CLI" + s.toString());
                        System.out.println(""+s.getMessage());
                    }

                    jPanel11.removeAll();
                    jPanel11.updateUI();
                    jPanel11.revalidate();
                    jPanel11.repaint();

                    Vector v = new Vector();
                    CRUD_TablasGenerales oks = new CRUD_TablasGenerales();
                    ArrayList<String> var1 = oks.RetornaListaEnfermedades();
                    v.add("Lista de Enfermedades del sujeto de prueba");
                    Boolean band = false;
                    try {
                        for (int i = 0; i < var1.size(); i++) {
                            if (!eu.getEnf1().equals("") && i == 0) {
                                band = true;
                            }
                            if (!eu.getEnf2().equals("") && i == 1) {
                                band = true;
                            }
                            if (!eu.getEnf3().equals("") && i == 2) {
                                band = true;
                            }
                            if (!eu.getEnf4().equals("") && i == 3) {
                                band = true;
                            }
                            if (!eu.getEnf5().equals("") && i == 4) {
                                band = true;
                            }
                            if (!eu.getEnf6().equals("") && i == 5) {
                                band = true;
                            }
                            if (!eu.getEnf7().equals("") && i == 6) {
                                band = true;
                            }
                            if (!eu.getEnf8().equals("") && i == 7) {
                                band = true;
                            }
                            if (!eu.getEnf9().equals("") && i == 8) {
                                band = true;
                            }
                            if (!eu.getEnf10().equals("") && i == 9) {
                                band = true;
                            }
                            v.add(new JCheckBox(var1.get(i), band));
                            band = false;
                        }
                    } catch (Exception e) {
                    }
                    jPanel11.add(new JComboCheckBox(v));

                } else {
                    System.out.println("La consulta Regresa Null");
                }
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        } catch (Exception w) {
            System.out.println("No existen más elementos");
        }
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "¿Desea almacenar los cambios realizados?", "Confirmar", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            //    //System.out.println("\n"+e_txt_nombre.getSelectedItem()+"\n"+ e1.getText()+"\n"+e2.getText()+"\n"+ e3.getText()+"\n"+ e4.getText()+"\n"+ e5.getText()+"\n"+ e6.getText()+"\n"+ e7.getText()+"\n"+ sex+"\n"+ e9.getText()+"\n"+ e10.getText());
            if (!Existe_campo_vacio_almacenar(e0.getText(), e1.getText(), e2.getText(), e3.getText(), cbCarrera.getSelectedItem().toString(), cbReligion.getSelectedItem().toString(), cbEstadoCivil.getSelectedItem().toString(), e7.getText(), cbSexo.getSelectedItem().toString(), cbLengua.getSelectedItem().toString(), cbIdioma.getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(null, "Existen Campos vacíos");
            } else {
                CRUD_ExpedienteSujetoPruebas crud = new CRUD_ExpedienteSujetoPruebas();
                ModExpedienteSujetoPruebas eu2 = new ModExpedienteSujetoPruebas(e0.getText(), e1.getText(), e2.getText(), e3.getText(), cbCarrera.getSelectedItem().toString(), cbReligion.getSelectedItem().toString(), cbEstadoCivil.getSelectedItem().toString(), e7.getText(), cbSexo.getSelectedItem().toString(), cbLengua.getSelectedItem().toString(), cbIdioma.getSelectedItem().toString());
                try {
                    //Actualización de La información de los expedientes clínicos
                    crud.UpdateExpedienteUsuario(eu.getIdExpedienteUsuario(), eu2);
                    //Actualización de la Infromación de la tabla de enfermedades
                    crud.UpdateExpedienteUsuario(eu, jPanel11);
                    JOptionPane.showMessageDialog(null, "Actualización exitosa");
                    ActualizarEditExpClin();
                    ActivarDesactivarEdicion(false);
                    if (!jButton6.getText().equals("EDITAR")) {
                        jButton6.setText("EDITAR");
                        jButton6.setIcon(new ImageIcon("src/img/Edit/editar (1).png"));
                    }
                    LeerDatosEC();
                } catch (SQLException ex) {
                    //System.out.println("Error al Actualizar");
                }
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        FiltrarTabla();
        b3.setEnabled(true);
    }//GEN-LAST:event_b1ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        try {
            ResetBotonesBusqueda();
        } catch (SQLException ex) {
            Logger.getLogger(V4ProgramaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_b3ActionPerformed

    private void btn_iniciar_eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciar_eActionPerformed
        try {
            agregar_estilo_verde(jButton1);
            agregar_estilo_default(btn_iniciar_e);
            hiloEjecucionExperimento = new hiloExperimento(txt_ie_ip.getText(), txt_ie_puerto.getText(), usuario, (String) e_txt_nombre1.getSelectedItem(), " " + txt_nombre_experimento.getText(), 1);
            hiloEjecucionExperimento.start();
            btn_iniciar_e.setEnabled(false);
        } catch (Exception c) {
            System.out.println("Detalles en el btn_iniciar_e");
        }
    }//GEN-LAST:event_btn_iniciar_eActionPerformed

    private void btn_atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atrasActionPerformed

        IrVentanaPasosColocacionHW();

    }//GEN-LAST:event_btn_atrasActionPerformed

    private void calendarioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calendarioPropertyChange
        String anio = Integer.toString(calendario.getCalendar().get(java.util.Calendar.YEAR));
        String mes = Integer.toString(calendario.getCalendar().get(java.util.Calendar.MONTH) + 1);
        String dia = Integer.toString(calendario.getCalendar().get(java.util.Calendar.DATE));
        if (dia.length() == 1) {
            dia = "0" + dia;
        }
        fecha.setText(anio + "-" + mes + "-" + dia);
    }//GEN-LAST:event_calendarioPropertyChange

    private void e_txt_nombrePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_e_txt_nombrePropertyChange

    }//GEN-LAST:event_e_txt_nombrePropertyChange

    private void e_txt_nombreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_e_txt_nombreItemStateChanged
        try {
            System.out.println("Item Cambia VEAMOS");
            BuscarSeleccionado();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_e_txt_nombreItemStateChanged

    private void e_txt_nombreVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_e_txt_nombreVetoableChange

    }//GEN-LAST:event_e_txt_nombreVetoableChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        InetAddress ping;
        try {
            ping = InetAddress.getByName(txt_ie_ip.getText());
            if (ping.isReachable(2500)) {
                JOptionPane.showMessageDialog(null, "Conexión exitosa!!!");
                btn_iniciar_e.setEnabled(true);
                agregar_estilo_verde(btn_iniciar_e);
                agregar_estilo_default(jButton1);
            } else {
                JOptionPane.showMessageDialog(null, "Error Verifique su conexión");
            }
        } catch (IOException ex) {
            //System.out.println(ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void e_txt_nombre1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_e_txt_nombre1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_e_txt_nombre1ItemStateChanged

    private void e_txt_nombre1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_e_txt_nombre1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_e_txt_nombre1PropertyChange

    private void e_txt_nombre1VetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_e_txt_nombre1VetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_e_txt_nombre1VetoableChange

    private void t1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t1KeyPressed
    }//GEN-LAST:event_t1KeyPressed

    private void t2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t2KeyPressed
    }//GEN-LAST:event_t2KeyPressed

    private void t3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t3KeyPressed
    }//GEN-LAST:event_t3KeyPressed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        EliminarHuellaSeleccionada();
        ActualizaLista(d0.getText());
        jButton9.setEnabled(false);
        jButton8.setEnabled(false);
        jTextArea2.setEditable(false);
        jLabel47.setIcon(null);
        jTextArea2.setText("");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jButton8.setEnabled(false);
        jButton9.setEnabled(false);
        ActivarHuella();
        jTextArea2.setEditable(true);
        jButton2.setEnabled(false);

        jLabel50.setForeground(Color.RED);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "¿Desea guardar la nueva huella digital?", "Confirmación",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.out.println("---::" + d0.getText());
            guardarHuella(d0.getText());
//            Reclutador.clear();
            jButton10.setEnabled(false);
            jLabel47.setIcon(null);
            jButton2.setEnabled(true);
            ActualizaLista(d0.getText());
            jLabel48.setText("Descripción de Huella del Usuario");
            jLabel48.setForeground(Color.BLACK);
        }


    }//GEN-LAST:event_jButton10ActionPerformed

    private void ListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ListKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListKeyPressed

    private void ListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListMouseClicked
        jLabel48.setText("Si lo desea puede modificar la descripción");
        jButton9.setEnabled(true);
        jButton8.setEnabled(true);
        jTextArea2.setEditable(true);
        CargarDatos();
    }//GEN-LAST:event_ListMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        ActualizarDescripcionHuella();
        jButton9.setEnabled(false);
        jButton8.setEnabled(false);
        jTextArea2.setEditable(false);
        ActualizaLista(d0.getText());
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if (jButton11.getText().equals("Editar")) {
            jButton11.setText("Guardar Cambios");
            ActivarElementosDatosPersonales(true);
        } else {

            String cad = (String) d6.getSelectedItem();
            String va1 = "";
            if (cad.equals("Administrador")) {
                va1 = "1";
            } else if (cad.equals("Usuario normal")) {
                va1 = "2";
            } else if (cad.equals("Invitado")) {
                va1 = "3";
            }
            //Cifrado inn = new Cifrado();
            ModUsuario us = new ModUsuario(d3.getText(), d4.getText(), d1.getText(), d7.getText(), va1);
            CRUD_Usuario u = new CRUD_Usuario();
            try {
                if (PerfilOpcionesUsuario.isEnabled()) {
                    if (JOptionPane.showConfirmDialog(null, "Desea actualizar la información?", "Advertencia",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        u.UpdateUsuario(Integer.parseInt(d0.getText()), us);

                        //System.out.println("Finaliza todo Guardar");
                        ActivarElementosDatosPersonales(false);
                        jButton11.setText("Editar");
                    }
                } else {
                    if (JOptionPane.showConfirmDialog(null, "Desea crear un nuevo Usuario", "Confirmación",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        u.InsertarUsuarioNuevo(us);
                        ActivarElementosDatosPersonales(false);
                        jButton11.setText("Editar");
                        PerfilOpcionesUsuario.setEnabled(true);
                        LlenarComboBoxUsuarios();
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(V4ProgramaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_jButton11ActionPerformed

    private void PerfilOpcionesUsuarioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_PerfilOpcionesUsuarioItemStateChanged
        ItemSeleccionado();
    }//GEN-LAST:event_PerfilOpcionesUsuarioItemStateChanged

    private void PerfilOpcionesUsuarioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_PerfilOpcionesUsuarioPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_PerfilOpcionesUsuarioPropertyChange

    private void PerfilNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerfilNuevoActionPerformed
        PerfilOpcionesUsuario.setEnabled(false);
        ActivarElementosDatosPersonales(true);
        LimpiarCajasEdicionDatosPersonales();
        jButton11.setText("Guardar Cambios");
        List.removeAll();
    }//GEN-LAST:event_PerfilNuevoActionPerformed

    private void PerfilCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerfilCancelarActionPerformed
        PerfilOpcionesUsuario.setEnabled(true);
        ActivarElementosDatosPersonales(false);
        jButton11.setText("Editar");
        ItemSeleccionado();
    }//GEN-LAST:event_PerfilCancelarActionPerformed

    private void PerfilOpcionesUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerfilOpcionesUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PerfilOpcionesUsuarioActionPerformed

    private void PerfilEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerfilEliminarActionPerformed
        try {
            EliminarUsuario();
        } catch (SQLException ex) {
            Logger.getLogger(V4ProgramaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PerfilEliminarActionPerformed

    private void txt_nombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyPressed
        if (txt_nombre.getText().length() > 2) {
            v1.setVisible(true);
        } else {
            v1.setVisible(false);
        }
    }//GEN-LAST:event_txt_nombreKeyPressed

    private void txt_ap_patKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ap_patKeyPressed
        if (txt_ap_pat.getText().length() > 2) {
            v2.setVisible(true);
        } else {
            v2.setVisible(false);
        }
    }//GEN-LAST:event_txt_ap_patKeyPressed

    private void txt_ap_matKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ap_matKeyPressed

    }//GEN-LAST:event_txt_ap_matKeyPressed

    private void txt_curpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_curpKeyPressed

    }//GEN-LAST:event_txt_curpKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ActualizarVentana(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        ActualizarVentana(1);

    }//GEN-LAST:event_jButton12ActionPerformed

    private void d5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_d5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_d5KeyPressed

    private void d5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_d5FocusLost
        if (!d5.getText().equals(d4.getText())) {
            jLabel60.setVisible(true);
        } else {
            jLabel60.setVisible(false);
        }
    }//GEN-LAST:event_d5FocusLost

    private void txt_curpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_curpFocusLost
        if (txt_curp.getText().length() == 18) {
            v7.setVisible(true);
        } else {
            v7.setVisible(false);
        }
    }//GEN-LAST:event_txt_curpFocusLost

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        ActualizarVentana(0);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "¿Desea cerrar su sesión?", "Confirmación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            this.removeAll();
            this.updateUI();
            V1Login p = new V1Login();
            p.setSize(1900, 1000);
            this.add(p);
            this.revalidate();
            this.repaint();
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        if (JOptionPane.showConfirmDialog(null, "¿Desea salir de la aplicación?", "Confirmación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            exit(0);
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jRadioButton1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton1StateChanged
        if (jRadioButton1.isSelected()) {
            jComboBox3.setEnabled(true);

        } else {
            jComboBox3.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton1StateChanged

    private void jRadioButton2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton2StateChanged
        if (jRadioButton2.isSelected()) {
            jComboBox1.setEnabled(true);
            jComboBox2.setEnabled(true);
        } else {
            jComboBox1.setEnabled(false);
            jComboBox2.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton2StateChanged

    private void jRadioButton4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton4StateChanged
        if (jRadioButton4.isSelected()) {
            jComboBox6.setEnabled(true);
        } else {
            jComboBox6.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton4StateChanged

    private void jRadioButton3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton3StateChanged
        if (jRadioButton3.isSelected()) {
            jComboBox4.setEnabled(true);
            jComboBox5.setEnabled(true);
        } else {
            jComboBox5.setEnabled(false);
            jComboBox4.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton3StateChanged

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        if (jRadioButton1.isSelected()) {
            jRadioButton2.setSelected(false);
        } else {
            jRadioButton2.setSelected(true);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        if (jRadioButton2.isSelected()) {
            jRadioButton1.setSelected(false);
        } else {
            jRadioButton1.setSelected(true);
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        if (jRadioButton4.isSelected()) {
            jRadioButton3.setSelected(false);
        } else {
            jRadioButton3.setSelected(true);
        }
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        if (jRadioButton3.isSelected()) {
            jRadioButton4.setSelected(false);
        } else {
            jRadioButton4.setSelected(true);
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        String Condicion;
        if (jRadioButton1.isSelected()) {
            try {
                ExportaReporteElemento(jComboBox3.getSelectedItem() + "");
            } catch (JRException ex) {
                Logger.getLogger(V4ProgramaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                //Emprime un rango
                ExportaReporteElemento(jComboBox1.getSelectedItem() + "", "" + jComboBox2.getSelectedItem());
            } catch (JRException ex) {
                Logger.getLogger(V4ProgramaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        if (!jRadioButton3.isSelected()) {
            //Imprimir uno sólo
            System.out.println("" + jComboBox6.getSelectedItem());
            try {
                ExportaReporteExperimentoTemporal("" + jComboBox6.getSelectedItem());
            } catch (JRException ex) {
                Logger.getLogger(V4ProgramaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //Emprime un rango
            System.out.println("" + jComboBox5.getSelectedItem());
            System.out.println("" + jComboBox4.getSelectedItem());
            try {
                ExportaReporteExperimentoTemporal("" + jComboBox5.getSelectedItem(), "" + jComboBox4.getSelectedItem());
            } catch (JRException ex) {
                Logger.getLogger(V4ProgramaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        try {
            ExportaReporteExpedientesClinicos();
        } catch (JRException ex) {
            Logger.getLogger(V4ProgramaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        try {
            ExportaIdiomas();
        } catch (JRException ex) {
            Logger.getLogger(V4ProgramaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        try {
            ExportaEnfermedaes();
        } catch (JRException ex) {
            Logger.getLogger(V4ProgramaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton21ActionPerformed
    public void guardarHuella(String idUsuario) {
        //Obtiene los datos del template de la huella actual
        //ByteArrayInputStream datosHuella = new ByteArrayInputStream(template.serialize());
        //Integer tamañoHuella = template.serialize().length;

        //Pregunta el nombre de la persona a la cual corresponde dicha huella
        //String nombre = JOptionPane.showInputDialog("Nombre:");
        CRUD_HuellaDigital dp = new CRUD_HuellaDigital(); //Si ocurre un error lo indica en la consola
        //con.desconectar();
        byte[] b = template.serialize();
        dp.insert(idUsuario, b, jTextArea2.getText());
        //Establece los valores para la sentencia SQL
        //Connection c = con.conectar(); //establece la conexion con la BD
        //PreparedStatement guardarStmt = c.prepareStatement("INSERT INTO somhue(huenombre, huehuella) values(?,?)");

        //guardarStmt.setString(1, nombre);
        //guardarStmt.setBinaryStream(2, datosHuella, tamañoHuella);
        //Ejecuta la sentencia
        //guardarStmt.execute();
        //guardarStmt.close();
        JOptionPane.showMessageDialog(null, "Huella Guardada Correctamente");
        //con.desconectar();
        //btnGuardar.setEnabled(false);
        //btnVerificar.grabFocus();
    }

    Thread hilo;
    public DPFPFeatureSet featuresinscripcion;
    public DPFPFeatureSet featuresverificacion;
//    private DPFPCapture Lector = DPFPGlobal.getCaptureFactory().createCapture();
//    private DPFPEnrollment Reclutador = DPFPGlobal.getEnrollmentFactory().createEnrollment();
//    private DPFPVerification Verificador = DPFPGlobal.getVerificationFactory().createVerification();

    private void ActivarHuella() {
        try {
            hilo = new Thread(new Runnable() {
                @Override
                public void run() {
                    Iniciar();
                    start();
                    EstadoHuellas();
                }
            });
            hilo.start();
        } catch (Exception c) {
            //System.out.println("Error en el Login");
        }
    }

    public void EnviarTexto(String string) {
        jTextArea1.append(string + "\n");
    }

    public void EstadoHuellas() {
        //EnviarTexto("Muestra de Huellas Necesarias para Guardar Template " + Reclutador.getFeaturesNeeded());
//        jLabel50.setText("Huellas Necesarias: " + Reclutador.getFeaturesNeeded());
    }

    public void start() {
        try {
//            Lector.startCapture();
            EnviarTexto("Utilizando el Lector de Huella Dactilar ");
        } catch (Exception cc) {

        }
    }

    public void ProcesarCaptura(DPFPSample sample) {
        // Procesar la muestra de la huella y crear un conjunto de características con el propósito de inscripción.
        featuresinscripcion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

        // Procesar la muestra de la huella y crear un conjunto de características con el propósito de verificacion.
        featuresverificacion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

        // Comprobar la calidad de la muestra de la huella y lo añade a su reclutador si es bueno
        if (featuresinscripcion != null) {
//            try {
//                //System.out.println("Las Caracteristicas de la Huella han sido creada");
////                Reclutador.addFeatures(featuresinscripcion);// Agregar las caracteristicas de la huella a la plantilla a crear
//
//                // Dibuja la huella dactilar capturada.
//                Image image = CrearImagenHuella(sample);
//                DibujarHuella(image);
//
//            } catch (DPFPImageQualityException ex) {
//                //System.err.println("Error: " + ex.getMessage());
//            } finally {
//                EstadoHuellas();
//                // Comprueba si la plantilla se ha creado.
//                switch (Reclutador.getTemplateStatus()) {
//                    case TEMPLATE_STATUS_READY:	// informe de éxito y detiene  la captura de huellas
//                        stop();
//                        setTemplate(Reclutador.getTemplate());
//                        EnviarTexto("La Plantilla de la Huella ha Sido Creada, ya puede Verificarla o Identificarla");
//                        jButton10.setEnabled(true);
//                        jLabel50.setForeground(Color.BLACK);
//                        jLabel48.setText("Agrega una descripción de la Huella");
//                        jLabel48.setForeground(Color.BLUE);
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

    public void stop() {
//        Lector.stopCapture();
        EnviarTexto("No se está usando el Lector de Huella Dactilar ");
    }

    protected void Iniciar() {
//        Lector.addDataListener(new DPFPDataAdapter() {
//            @Override
//            public void dataAcquired(final DPFPDataEvent e) {
//                SwingUtilities.invokeLater(new Runnable() {
//                    public void run() {
//                        EnviarTexto("La Huella Digital ha sido Capturada");
//                        ProcesarCaptura(e.getSample());
//                    }
//                });
//            }
//        });
//
//        Lector.addReaderStatusListener(new DPFPReaderStatusAdapter() {
//            @Override
//            public void readerConnected(final DPFPReaderStatusEvent e) {
//                SwingUtilities.invokeLater(new Runnable() {
//                    public void run() {
//                        EnviarTexto("El Sensor de Huella Digital esta Activado o Conectado");
//                    }
//                });
//            }
//
//            @Override
//            public void readerDisconnected(final DPFPReaderStatusEvent e) {
//                SwingUtilities.invokeLater(new Runnable() {
//                    public void run() {
//                        EnviarTexto("El Sensor de Huella Digital esta Desactivado o no Conectado");
//                    }
//                });
//            }
//        });
//
//        Lector.addSensorListener(new DPFPSensorAdapter() {
//            @Override
//            public void fingerTouched(final DPFPSensorEvent e) {
//                SwingUtilities.invokeLater(new Runnable() {
//                    public void run() {
//                        EnviarTexto("El dedo ha sido colocado sobre el Lector de Huella");
//                    }
//                });
//            }
//
//            @Override
//            public void fingerGone(final DPFPSensorEvent e) {
//                SwingUtilities.invokeLater(new Runnable() {
//                    public void run() {
//                        EnviarTexto("El dedo ha sido quitado del Lector de Huella");
//                    }
//                });
//            }
//        });
//
//        Lector.addErrorListener(new DPFPErrorAdapter() {
//            public void errorReader(final DPFPErrorEvent e) {
//                SwingUtilities.invokeLater(new Runnable() {
//                    public void run() {
//                        EnviarTexto("Error: " + e.getError());
//                    }
//                });
//            }
//        });
    }

    public DPFPTemplate getTemplate() {
        return template;
    }
    private DPFPTemplate template;

    public DPFPFeatureSet extraerCaracteristicas(DPFPSample sample, DPFPDataPurpose purpose) {
        DPFPFeatureExtraction extractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
        try {
            return extractor.createFeatureSet(sample, purpose);
        } catch (Exception e) {
            //System.out.println("Me vale 3");
            return null;
        }
    }

    public Image CrearImagenHuella(DPFPSample sample) {
        return DPFPGlobal.getSampleConversionFactory().createImage(sample);
    }

    public void setTemplate(DPFPTemplate template) {
        DPFPTemplate old = this.template;
        this.template = template;
        firePropertyChange(TEMPLATE_PROPERTY, old, template);
    }

    public void DibujarHuella(Image image) {
        jLabel47.setIcon(new ImageIcon(image.getScaledInstance(jLabel47.getWidth(), jLabel47.getHeight(), Image.SCALE_DEFAULT)));
        repaint();
    }

    private boolean Existe_campo_vacio_almacenar(String text, String text1, String text2, String text3, String text4, String text5, String text6, String text7, String sex, String text8, String text9) {

        ArrayList<String> NoNumero = new ArrayList<>();
        NoNumero.add(text);
        NoNumero.add(text1);
        NoNumero.add(text2);
        NoNumero.add(text4);
        NoNumero.add(text5);
        NoNumero.add(text6);
        NoNumero.add(text8);
        NoNumero.add(text9);

        ArrayList<String> FormatoCorrecto = new ArrayList<>();
        FormatoCorrecto.add(text3);
        FormatoCorrecto.add(text7);

        if (HayNumeros(NoNumero)) {
            JOptionPane.showMessageDialog(null, "Algunos datos no pueden contener números");
            return false;
        }
        if (FormatoIncorrecto(FormatoCorrecto)) {
            if (text3.length() != 10 && text7.length() != 18) {
                JOptionPane.showMessageDialog(null, "Formato incorrecto de CURP o Fecha");
                return true;
            }
            return false;
        }
        return !(text.isEmpty() || text1.isEmpty() || text3.isEmpty() || text4.isEmpty() || text5.isEmpty() || text6.isEmpty() || text7.isEmpty() || sex.isEmpty() || text8.isEmpty() || text9.isEmpty());
    }

    private boolean HayNumeros(ArrayList<String> NoNumero) {
        for (int i = 0; i < NoNumero.size(); i++) {
            if (TieneNumero(NoNumero.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean TieneNumero(String cadena) {
        if (cadena.contains("0") || cadena.contains("1") || cadena.contains("2") || cadena.contains("3") || cadena.contains("4") || cadena.contains("5") || cadena.contains("6") || cadena.contains("7") || cadena.contains("8") || cadena.contains("9")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean FormatoIncorrecto(ArrayList<String> Formato) {
        return false;
    }

    private void ActualizarEditExpClin() throws SQLException {
        e_txt_nombre.removeAllItems();
        e_txt_nombre1.removeAllItems();

        List<String> datos;
        CRUD_ExpedienteSujetoPruebas val = new CRUD_ExpedienteSujetoPruebas();
        datos = val.RetornaListaExpedientes();
        try {
            for (int i = 0; i < datos.size(); i++) {
                e_txt_nombre.addItem(datos.get(i));
                e_txt_nombre1.addItem(datos.get(i));
            }
        } catch (Exception e) {

        }
    }

    private void LimpiarElementos() {
        jButton7.setEnabled(false);
        jButton5.setEnabled(false);
        e_txt_nombre.setEditable(false);

        e_txt_nombre.setEditable(false);
        e0.setText("");
        e1.setText("");
        e2.setText("");
        e3.setText("");
        e7.setText("");

    }

    protected void ResetBotonesBusqueda() throws SQLException {
        t0.setText("");
        t1.setText("");
        t2.setText("");
        t3.setText("");
        b3.setEnabled(false);
        setTabla(1);
    }

    public void CerrarAplicacion() {

    }

    private void configuracionBtn() {

        lbl_n_user.setText(lbl_n_user.getText() + this.usuario.getUsuario_nombre());

        btn_atras.setContentAreaFilled(false);
        btn_atras.setBorder(null);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> List;
    private javax.swing.JButton PerfilCancelar;
    private javax.swing.JButton PerfilEliminar;
    private javax.swing.JButton PerfilNuevo;
    private javax.swing.JComboBox<String> PerfilOpcionesUsuario;
    private javax.swing.JButton b1;
    private javax.swing.JButton b3;
    private javax.swing.JButton btn_atras;
    private javax.swing.JButton btn_iniciar_e;
    private com.toedter.calendar.JCalendar calendario;
    private javax.swing.JComboBox<String> cbCarrera;
    private javax.swing.JComboBox<String> cbEstadoCivil;
    private javax.swing.JComboBox<String> cbIdioma;
    private javax.swing.JComboBox<String> cbLengua;
    private javax.swing.JComboBox<String> cbReligion;
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JComboBox<String> cb_carrera;
    private javax.swing.JComboBox<String> cb_lm;
    private javax.swing.JComboBox<String> cb_oi;
    private javax.swing.JComboBox<String> cb_religion;
    private javax.swing.JComboBox<String> cb_sexo;
    private javax.swing.JComboBox<String> cbestadocivil;
    private javax.swing.JTextField d0;
    private javax.swing.JTextPane d1;
    private javax.swing.JTextField d3;
    private javax.swing.JPasswordField d4;
    private javax.swing.JPasswordField d5;
    private javax.swing.JComboBox<String> d6;
    private javax.swing.JTextField d7;
    private javax.swing.JTextField e0;
    private javax.swing.JTextField e1;
    private javax.swing.JTextField e2;
    private javax.swing.JTextField e3;
    private javax.swing.JTextField e7;
    private javax.swing.JComboBox<String> e_txt_nombre;
    private javax.swing.JComboBox<String> e_txt_nombre1;
    private javax.swing.JTextField fecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel lbl_editar;
    private javax.swing.JLabel lbl_n_user;
    private javax.swing.JTextField t0;
    private javax.swing.JTextField t1;
    private javax.swing.JTextField t2;
    private javax.swing.JTextField t3;
    private javax.swing.JTextField txt_ap_mat;
    private javax.swing.JTextField txt_ap_pat;
    private javax.swing.JTextField txt_curp;
    private javax.swing.JTextField txt_ie_ip;
    private javax.swing.JTextField txt_ie_puerto;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_nombre_experimento;
    private javax.swing.JLabel v1;
    private javax.swing.JLabel v2;
    private javax.swing.JLabel v7;
    // End of variables declaration//GEN-END:variables

    private void IrVentanaPasosColocacionHW() {
        this.removeAll();
        this.updateUI();
        V2ColocacionHardware p = new V2ColocacionHardware(usuario, false);
        p.setSize(1900, 1000);
        this.add(p);
        this.revalidate();
        this.repaint();
    }

    private void ActivarDesactivarEdicion(boolean b) {
        e0.setEnabled(b);
        e1.setEnabled(b);
        e2.setEnabled(b);
        e3.setEnabled(b);
        cbCarrera.setEnabled(b);
        cbReligion.setEnabled(b);
        cbEstadoCivil.setEnabled(b);
        e7.setEnabled(b);
        cbSexo.setEnabled(b);
        cbLengua.setEnabled(b);
        cbIdioma.setEnabled(b);
        jPanel11.setEnabled(b);

        jButton7.setEnabled(b);
        jButton5.setEnabled(b);
    }

    private void TamanioTabla2() {
        TableColumnModel columnModel1 = jTable2.getColumnModel();
        columnModel1.getColumn(0).setPreferredWidth(25);
        columnModel1.getColumn(1).setPreferredWidth(150);
        columnModel1.getColumn(2).setPreferredWidth(180);
        columnModel1.getColumn(3).setPreferredWidth(200);
        columnModel1.getColumn(4).setPreferredWidth(75);
        columnModel1.getColumn(5).setPreferredWidth(75);
        columnModel1.getColumn(6).setPreferredWidth(75);
        jTable2.setRowHeight(35);
    }

    private void TamanioTablA1() {

        TableColumnModel columnModel = jTable1.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(25);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(180);
        columnModel.getColumn(3).setPreferredWidth(200);
        columnModel.getColumn(4).setPreferredWidth(50);
        columnModel.getColumn(5).setPreferredWidth(50);
        columnModel.getColumn(6).setPreferredWidth(50);
        columnModel.getColumn(7).setPreferredWidth(50);

        jTable1.setRowHeight(35);
    }

    private void setTabla(int valor) throws SQLException {
        jTable1.setEditingRow(1);
        jTable1.getTableHeader().setReorderingAllowed(false);
        // Esta lista contiene los nombres que se mostrarán en el encabezado de cada columna de la grilla
        // Estos son los tipos de datos de cada columna de la lista

        // Agrego los registros que contendrá la grilla.
        // Observen que el último campo es un botón
        PreparacionDatosTabla(valor);
        QuitarEdicionTabla(datos, tiposColumnas, columnas);

        TamanioTablA1();

        // El objetivo de la siguiente línea es indicar el CellRenderer que será utilizado para dibujar el botón
        jTable1
                .setDefaultRenderer(JButton.class,
                        new TableCellRenderer() {
                    @Override
                    public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                        /**
                         * Observen que todo lo que hacemos en éste método es
                         * retornar el objeto que se va a dibujar en la celda.
                         * Esto significa que se dibujará en la celda el objeto
                         * que devuelva el TableModel. También significa que
                         * este renderer nos permitiría dibujar cualquier objeto
                         * gráfico en la grilla, pues retorna el objeto tal y
                         * como lo recibe.
                         */
                        return (Component) objeto;
                    }
                });

        /**
         * Por último, agregamos un listener que nos permita saber cuando fue
         * pulsada la celda que contiene el botón. Noten que estamos capturando
         * el clic sobre JTable, no el clic sobre el JButton. Esto también
         * implica que en lugar de poner un botón en la celda, simplemente
         * pudimos definir un CellRenderer que hiciera parecer que la celda
         * contiene un botón. Es posible capturar el clic del botón, pero a mi
         * parecer el efecto es el mismo y hacerlo de esta forma es más "simple"
         */
        jTable1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = jTable1.rowAtPoint(e.getPoint());
                int columna = jTable1.columnAtPoint(e.getPoint());
                /**
                 * Preguntamos si hicimos clic sobre la celda que contiene el
                 * botón, si tuviéramos más de un botón por fila tendríamos que
                 * además preguntar por el contenido del botón o el nombre de la
                 * columna
                 */

                if (jTable1.getModel().getColumnClass(columna).equals(JButton.class
                )) {
                    /**
                     * Aquí pueden poner lo que quieran, para efectos de este
                     * ejemplo, voy a mostrar en un cuadro de dialogo todos los
                     * campos de la fila que no sean un botón.
                     */
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < jTable1.getModel().getColumnCount(); i++) {
                        if (!jTable1.getModel().getColumnClass(i).equals(JButton.class
                        )) {
                            sb.append("\n").append(jTable1.getModel().getColumnName(i)).append(": ").append(jTable1.getModel().getValueAt(fila, i));
                        }
                    }
                    //JOptionPane.showMessageDialog(null, "Seleccionada la fila " + fila + sb.toString());
                    //JOptionPane.showMessageDialog(null, "Ha precionado el botón");

                    ////System.out.println(""+jTable1.getModel().getColumnName(3));
                }
                if (columna == 4) {
                    try {
                        EditarElemento(fila, columna, jTable1.getModel().getValueAt(fila, 0) + "", jTable1.getModel().getValueAt(fila, 1) + "", jTable1.getModel().getValueAt(fila, 2) + "", jTable1.getModel().getValueAt(fila, 3) + "");

                    } catch (SQLException ex) {
                        System.out.println(""+ex.toString());
                    }
                }
                if (columna == 5) {
                    try {
                        EliminarElemento(fila, columna, jTable1.getModel().getValueAt(fila, 0) + "");

                    } catch (SQLException ex) {
                        Logger.getLogger(V4ProgramaPrincipal.class
                                .getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(V4ProgramaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (columna == 6) {
                    //JFileChooser file = new JFileChooser();
                    //file.showOpenDialog(null);

                    JFileChooser fc = new JFileChooser();
                    fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    int respuesta = fc.showSaveDialog(null);
                    if (respuesta == JFileChooser.APPROVE_OPTION) {
                        String id = jTable1.getModel().getValueAt(fila, 0) + "";
                        CRUD_ListaExperimentos et = new CRUD_ListaExperimentos();
                        List<String> dato;
                        try {
                            dato = et.NombreArchivoForIdExp(id);
                            //aqui va un for}

                            CopiarDatos c = new CopiarDatos();

                            //System.out.println("" + dato.get(0));
                            try {
                                c.copiaraUbicacion(dato.get(0), "" + fc.getSelectedFile() + "\\" + id + " Información exportada del Sistema SIBIB");
                                //String sDirectorio = c.imprimeDirectorioActual() + "\\" + dato.get(0).substring(2);
                            } catch (IOException ex) {
                                Logger.getLogger(V4ProgramaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            JOptionPane.showMessageDialog(null, "Exportación exitosa del elemento");
                        } catch (SQLException ex) {
                            Logger.getLogger(V4ProgramaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                }
                if (columna == 7) {
                    hiloExperimento verExperimento = new hiloExperimento((String) jTable1.getModel().getValueAt(fila, 0), (String) jTable1.getModel().getValueAt(fila, 1), (String) jTable1.getModel().getValueAt(fila, 2), (String) jTable1.getModel().getValueAt(fila, 3), 2);
                    verExperimento.start();
                }

            }

            private void EditarElemento(int fila, int col, String id, String fecha, String sujeto, String nombre_exp) throws SQLException {
                JButton b = (JButton) jTable1.getModel().getValueAt(fila, col);
                if (b.getText().equals((new JButton("Guardar")).getText())) {
                    if (JOptionPane.showConfirmDialog(null, "Desea guardar cambios?", "Confirmación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        for (int i = 0; i < datos.length; i++) {
                            System.out.println("Holi"+id+"  --  "+datos[i][0]);
                            if (id.equals(datos[i][0])) {
                                System.out.println("Actualizamos el igual");
                                datos[i][1] = jTable1.getModel().getValueAt(fila, 1);
                                datos[i][2] = jTable1.getModel().getValueAt(fila, 2);
                                datos[i][3] = jTable1.getModel().getValueAt(fila, 3);
                                ModExperimento ex = new ModExperimento(Integer.parseInt(id), fecha, sujeto, nombre_exp,"");
                                CRUD_ListaExperimentos cew = new CRUD_ListaExperimentos();
                                cew.UpdateExperimento(ex);
                            }
                        }
                        QuitarEdicionTabla(datos, tiposColumnas, columnas);
                        TamanioTablA1();
                        System.out.println("Fila = " + fila + " Col = " + col);
                        jTable1.getModel().setValueAt(agregar_estilo_a(new JButton("Editar")), fila, col);
                        lbl_editar.setVisible(false);
                        JOptionPane.showMessageDialog(null, "Se han almacenado los cambios de manera exitosa");
                    }
                } else {
                    jTable1.setModel(new javax.swing.table.DefaultTableModel(
                            datos,
                            columnas) {
                        // Esta variable nos permite conocer de antemano los tipos de datos de cada columna, dentro del TableModel
                        Class[] tipos = tiposColumnas;

                        @Override
                        public Class getColumnClass(int columnIndex) {
                            // Este método es invocado por el CellRenderer para saber que dibujar en la celda,
                            // observen que estamos retornando la clase que definimos de antemano.
                            try {
                                return tipos[columnIndex];
                            } catch (Exception d) {
                                return null;
                            }

                        }

                        @Override
                        public boolean isCellEditable(int row, int column) {
                            // Sobrescribimos este método para evitar que la columna que contiene los botones sea editada.
                            return !(this.getColumnClass(column).equals(JButton.class
                            )) && fila == row && column != 0;
                        }
                    });
                    lbl_editar.setVisible(true);
                    jTable1.getModel().setValueAt(agregar_estilo_a(new JButton("Guardar")), fila, col);
                    jTable1.getModel().setValueAt(agregar_estilo_a(new JButton("Cancelar")), fila, col + 1);
                    TamanioTablA1();
                }

            }

            private void EliminarElemento(int fila, int col, String id) throws SQLException, IOException {
                JButton b = (JButton) jTable1.getModel().getValueAt(fila, col);
                if (b.getText().equals((new JButton("Eliminar")).getText())) {
                    if (JOptionPane.showConfirmDialog(null, "Desea eliminar el elemento?", "Advertencia", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        //System.out.println("Eliminando");
                        //System.out.println("" + fila);
                        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
                        if (fila >= 0) {
                            /*Aqui va código de eliminacion de carpeta*/

                            String id2 = jTable1.getModel().getValueAt(fila, 0) + "";
                            CRUD_ListaExperimentos et = new CRUD_ListaExperimentos();
                            List<String> dato = et.NombreArchivoForIdExp(id2);
                            String sDirectorio = "C:\\Experimentos" + "\\" + dato.get(0);

                            funcionEliminarCarpeta1(new File(sDirectorio));

                            modelo.removeRow(fila);
                            CRUD_ListaExperimentos cew = new CRUD_ListaExperimentos();
                            cew.DeleteExperimento(id);
                            PreparacionDatosTabla(valor);
                            JOptionPane.showMessageDialog(null, "Eliminación exitosa");
                        } else {
                            JOptionPane.showMessageDialog(null, "No Selecciono Ninguna Fila", "Aviso", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    //System.out.println("Cancelando");
                    QuitarEdicionTabla(datos, tiposColumnas, columnas);
                    TamanioTablA1();
                    jTable1.getModel().setValueAt(agregar_estilo_a(new JButton("Eliminar")), fila, col);
                    jTable1.getModel().setValueAt(agregar_estilo_a(new JButton("Editar")), fila, col - 1);
                    //Aquí actualizamos para la base de datos
                    lbl_editar.setVisible(false);
                }
            }
        });
    }

    private void setTabla2(int valor) throws SQLException {
        jTable2.setEditingRow(1);
        jTable2.getTableHeader().setReorderingAllowed(false);
        // Esta lista contiene los nombres que se mostrarán en el encabezado de cada columna de la grilla
        // Estos son los tipos de datos de cada columna de la lista

        // Agrego los registros que contendrá la grilla.
        // Observen que el último campo es un botón
        PreparacionDatosTabla2(valor);

        QuitarEdicionTabla2(datos2, tiposColumnas2, columnas2);

        TamanioTabla2();
        // El objetivo de la siguiente línea es indicar el CellRenderer que será utilizado para dibujar el botón
        jTable2.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                /**
                 * Observen que todo lo que hacemos en éste método es retornar
                 * el objeto que se va a dibujar en la celda. Esto significa que
                 * se dibujará en la celda el objeto que devuelva el TableModel.
                 * También significa que este renderer nos permitiría dibujar
                 * cualquier objeto gráfico en la grilla, pues retorna el objeto
                 * tal y como lo recibe.
                 */
                return (Component) objeto;
            }
        });

        /**
         * Por último, agregamos un listener que nos permita saber cuando fue
         * pulsada la celda que contiene el botón. Noten que estamos capturando
         * el clic sobre JTable, no el clic sobre el JButton. Esto también
         * implica que en lugar de poner un botón en la celda, simplemente
         * pudimos definir un CellRenderer que hiciera parecer que la celda
         * contiene un botón. Es posible capturar el clic del botón, pero a mi
         * parecer el efecto es el mismo y hacerlo de esta forma es más "simple"
         */
        jTable2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = jTable2.rowAtPoint(e.getPoint());
                int columna = jTable2.columnAtPoint(e.getPoint());
                /**
                 * Preguntamos si hicimos clic sobre la celda que contiene el
                 * botón, si tuviéramos más de un botón por fila tendríamos que
                 * además preguntar por el contenido del botón o el nombre de la
                 * columna
                 */

                if (jTable2.getModel().getColumnClass(columna).equals(JButton.class
                )) {
                    /**
                     * Aquí pueden poner lo que quieran, para efectos de este
                     * ejemplo, voy a mostrar en un cuadro de dialogo todos los
                     * campos de la fila que no sean un botón.
                     */
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < jTable2.getModel().getColumnCount(); i++) {
                        if (!jTable2.getModel().getColumnClass(i).equals(JButton.class
                        )) {
                            sb.append("\n").append(jTable2.getModel().getColumnName(i)).append(": ").append(jTable2.getModel().getValueAt(fila, i));
                        }
                    }
                    //JOptionPane.showMessageDialog(null, "Seleccionada la fila " + fila + sb.toString());
                    //JOptionPane.showMessageDialog(null, "Ha precionado el botón");

                    ////System.out.println(""+jTable1.getModel().getColumnName(3));
                }
                if (columna == 4) {
                    try {
                        EditarElemento(fila, columna, jTable2.getModel().getValueAt(fila, 0) + "", jTable2.getModel().getValueAt(fila, 1) + "", jTable2.getModel().getValueAt(fila, 2) + "", jTable2.getModel().getValueAt(fila, 3) + "");

                    } catch (SQLException ex) {
                        Logger.getLogger(V4ProgramaPrincipal.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (columna == 5) {
                    try {

                        EliminarElemento(fila, columna, jTable2.getModel().getValueAt(fila, 0) + "");

                    } catch (SQLException ex) {
                        Logger.getLogger(V4ProgramaPrincipal.class
                                .getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(V4ProgramaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (columna == 6) {
                    try {

                        if (JOptionPane.showConfirmDialog(null, "¿Desea almacenar el experimento temporal?", "Confirmación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            String id = jTable2.getModel().getValueAt(fila, 0) + "";
                            CRUD_ListaExperimentos et = new CRUD_ListaExperimentos();
                            List<String> dato = et.NombreArchivoForIdExpTemp(id);
                            CopiarDatos c = new CopiarDatos();

                            System.out.println("" + dato.get(0));
                            c.copiarDirectorio(dato.get(0));

                            String sDirectorio = c.imprimeDirectorioActual() + "\\" + dato.get(0).substring(2);

                            funcionEliminarCarpeta1(new File(sDirectorio));
//System.out.println("Eliminando");
                            //System.out.println("" + fila);
                            DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
                            if (fila >= 0) {
                                modelo.removeRow(fila);
                                //et.DeleteExperimento(dato.get(1));
                                et.UpdateExperimentoTemp(Integer.parseInt(dato.get(1)));
                                PreparacionDatosTabla2(valor);
                                JOptionPane.showMessageDialog(null, "Experimento temporal agregado exitosamente");
                            } else {
                                JOptionPane.showMessageDialog(null, "No Selecciono Ninguna Fila", "Aviso", JOptionPane.ERROR_MESSAGE);
                            }
                            //CRUD_ListaExperimentos LE = new CRUD_ListaExperimentos();
                            //LE.InsertarExperimentoNuevo(usuario.getIdUsuario(), dato.get(4), dato.get(5), dato.get(0).substring(2));
                        }
                    } catch (SQLException | IOException ex) {
                        Logger.getLogger(V4ProgramaPrincipal.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            private void EditarElemento(int fila, int col, String id, String fecha, String sujeto, String nombre_exp) throws SQLException {
                JButton b = (JButton) jTable2.getModel().getValueAt(fila, col);
                if (b.getText().equals((new JButton("Guardar")).getText())) {
                    if (JOptionPane.showConfirmDialog(null, "Desea guardar los cambios generados en el experimento temporal?", "Confirmación", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        for (int i = 0; i < datos2.length; i++) {
                            if (id.equals(datos2[i][0])) {
                                datos2[i][1] = jTable2.getModel().getValueAt(fila, 1);
                                datos2[i][2] = jTable2.getModel().getValueAt(fila, 2);
                                datos2[i][3] = jTable2.getModel().getValueAt(fila, 3);

                                ModExperimento ex = new ModExperimento(Integer.parseInt(id), fecha, sujeto, nombre_exp, "");
                                CRUD_ListaExperimentos cew = new CRUD_ListaExperimentos();
                                cew.UpdateExperimento(ex);
                                JOptionPane.showMessageDialog(null, "Cambios almacenados exitosamente");
                            }
                        }
                        QuitarEdicionTabla2(datos2, tiposColumnas2, columnas2);
                        TamanioTabla2();
                        jTable2.getModel().setValueAt(agregar_estilo_a(new JButton("Editar")), fila, col);
                        //lbl_editar.setVisible(false);
                    }
                } else {
                    jTable2.setModel(new javax.swing.table.DefaultTableModel(
                            datos2,
                            columnas2) {
                        // Esta variable nos permite conocer de antemano los tipos de datos de cada columna, dentro del TableModel
                        Class[] tipos = tiposColumnas2;

                        @Override
                        public Class getColumnClass(int columnIndex) {
                            // Este método es invocado por el CellRenderer para saber que dibujar en la celda,
                            // observen que estamos retornando la clase que definimos de antemano.
                            try {
                                return tipos[columnIndex];
                            } catch (Exception cc) {

                            }
                            return null;
                        }

                        @Override
                        public boolean isCellEditable(int row, int column) {
                            // Sobrescribimos este método para evitar que la columna que contiene los botones sea editada.
                            return !(this.getColumnClass(column).equals(JButton.class
                            )) && fila == row && column != 0;
                        }
                    });
                    //lbl_editar.setVisible(true);
                    jTable2.getModel().setValueAt(agregar_estilo_a(new JButton("Guardar")), fila, col);
                    jTable2.getModel().setValueAt(agregar_estilo_a(new JButton("Cancelar")), fila, col + 1);
                    TamanioTabla2();
                }

            }

            private void EliminarElemento(int fila, int col, String id) throws SQLException, IOException {
                JButton b = (JButton) jTable2.getModel().getValueAt(fila, col);
                if (b.getText().equals((new JButton("Eliminar")).getText())) {
                    if (JOptionPane.showConfirmDialog(null, "Desea eliminar el experimento temporal?", "Advertencia", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        System.out.println("Eliminando");
                        //System.out.println("" + fila);
                        DefaultTableModel modelo = (DefaultTableModel) jTable2.getModel();
                        if (fila >= 0) {
                            String id2 = jTable2.getModel().getValueAt(fila, 0) + "";
                            CRUD_ListaExperimentos et = new CRUD_ListaExperimentos();
                            List<String> dato = et.NombreArchivoForIdExpTemp(id2);
                            CopiarDatos c = new CopiarDatos();

                            System.out.println("" + dato.get(0));

                            String sDirectorio = c.imprimeDirectorioActual() + "\\" + dato.get(0).substring(2);

                            funcionEliminarCarpeta1(new File(sDirectorio));

                            modelo.removeRow(fila);
                            CRUD_ListaExperimentos cew = new CRUD_ListaExperimentos();
                            cew.DeleteExperimento(id);
                            PreparacionDatosTabla2(valor);
                            JOptionPane.showMessageDialog(null, "Experimento temporal eliminado exitosamente");
                        } else {
                            JOptionPane.showMessageDialog(null, "No Selecciono Ninguna Fila", "Aviso", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    //System.out.println("Cancelando");
                    QuitarEdicionTabla2(datos2, tiposColumnas2, columnas2);
                    TamanioTabla2();
                    jTable2.getModel().setValueAt(agregar_estilo_a(new JButton("Eliminar")), fila, col);
                    jTable2.getModel().setValueAt(agregar_estilo_a(new JButton("Editar")), fila, col - 1);
                    //Aquí actualizamos para la base de datos
                    //lbl_editar.setVisible(false);
                }
            }

        });
        TamanioTabla2();
    }

    private static void funcionEliminarCarpeta1(File pArchivo) {
        if (!pArchivo.exists()) {
            return;
        }

        if (pArchivo.isDirectory()) {
            for (File f : pArchivo.listFiles()) {
                funcionEliminarCarpeta1(f);
            }
        }
        pArchivo.delete();
    } // Cerramos funcion.

    private void QuitarEdicionTabla(Object[][] datos, Class[] tiposColumnas, String[] columnas) {

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                columnas) {
            // Esta variable nos permite conocer de antemano los tipos de datos de cada columna, dentro del TableModel
            Class[] tipos = tiposColumnas;

            @Override
            public Class getColumnClass(int columnIndex) {
                // Este método es invocado por el CellRenderer para saber que dibujar en la celda,
                // observen que estamos retornando la clase que definimos de antemano.
                return tipos[columnIndex];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                // Sobrescribimos este método para evitar que la columna que contiene los botones sea editada.
                return false;//!(this.getColumnClass(column).equals(JButton.class));
            }
        });

    }

    private void QuitarEdicionTabla2(Object[][] datos, Class[] tiposColumnas, String[] columnas) {

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                datos,
                columnas) {
            // Esta variable nos permite conocer de antemano los tipos de datos de cada columna, dentro del TableModel
            Class[] tipos = tiposColumnas;

            @Override
            public Class getColumnClass(int columnIndex) {
                // Este método es invocado por el CellRenderer para saber que dibujar en la celda,
                // observen que estamos retornando la clase que definimos de antemano.
                try {
                    return tipos[columnIndex];
                } catch (Exception x) {

                }
                return null;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                // Sobrescribimos este método para evitar que la columna que contiene los botones sea editada.
                return false;//!(this.getColumnClass(column).equals(JButton.class));
            }
        });

    }

    private void llenadoDatosTabla(List<String> datosBD, Object[][] datos, int xx) {
        Object[] objectConstructor = null;
        int j = 0, k = 0;
        for (int i = 0; i < xx; i++) {
            objectConstructor = new Object[]{datosBD.get(k), datosBD.get(k + 1), datosBD.get(k + 2), datosBD.get(k + 3), agregar_estilo_a(new JButton("Editar")), agregar_estilo_a(new JButton("Eliminar")), agregar_estilo_a(new JButton("Exportar")), agregar_estilo_a(new JButton("Ver"))};
            datos[j] = objectConstructor;
            j++;
            k += 4;
        }

    }

    private void llenadoDatosTabla2(List<String> datosBD, Object[][] datos, int xx) {
        Object[] objectConstructor = null;
        int j = 0, k = 0;
        for (int i = 0; i < xx; i++) {
            objectConstructor = new Object[]{datosBD.get(k), datosBD.get(k + 1), datosBD.get(k + 2), datosBD.get(k + 3), agregar_estilo_a(new JButton("Editar")), agregar_estilo_a(new JButton("Eliminar")), agregar_estilo_a(new JButton("Almacenar"))};
            datos[j] = objectConstructor;
            j++;
            k += 4;
        }
        //meme te amo
    }

    private void PreparacionDatosTabla(int valor) throws SQLException {
        datosBD = null;
        datos = null;
        xx = 0;
        CRUD_ListaExperimentos le = new CRUD_ListaExperimentos();
        if (valor == 1) {
            datosBD = le.RetornaListaExperimentos(this.usuario.getIdUsuario());
        } else {
            datosBD = le.RetornaListaExperimentos(Condiciones, this.usuario.getIdUsuario());
        }
        xx = datosBD.size() / 4;
        //System.out.println("xx = " + xx);
        datos = new Object[xx][];
        llenadoDatosTabla(datosBD, datos, xx);

    }

    List<String> datosBD2 = null;
    Object[][] datos2 = null;

    final Class[] tiposColumnas2 = new Class[]{
        java.lang.String.class,
        java.lang.String.class,
        java.lang.String.class,
        java.lang.String.class,
        JButton.class, // <- noten que aquí se especifica que la última columna es un botón
        JButton.class,
        JButton.class

    };
    String[] columnas2 = new String[]{"Id", "Fecha", "Sujeto", "Nombre de experimento", "Editar", "Eliminar", "Guardar BD"};

    private void PreparacionDatosTabla2(int valor) throws SQLException {
        datosBD2 = null;
        datos2 = null;
        xx = 0;

        CRUD_ListaExperimentos le = new CRUD_ListaExperimentos();
        try {
            if (valor == 1) {
                datosBD2 = le.RetornaListaExperimentosTemporales(this.usuario.getIdUsuario());
            } else {
                datosBD2 = le.RetornaListaExperimentosTemporales(Condiciones, this.usuario.getIdUsuario());
            }
            xx = datosBD2.size() / 4;
            datos2 = new Object[xx][];
            llenadoDatosTabla2(datosBD2, datos2, xx);
        } catch (Exception w) {
            JOptionPane.showMessageDialog(null, "No contiene información para guardar en la BD");
        }
    }

    List<String> datosBD = null;
    Object[][] datos = null;
    int xx = 0;
    final Class[] tiposColumnas = new Class[]{
        java.lang.String.class,
        java.lang.String.class,
        java.lang.String.class,
        java.lang.String.class,
        JButton.class, // <- noten que aquí se especifica que la última columna es un botón
        JButton.class,
        JButton.class,
        JButton.class

    };
    String[] columnas = new String[]{"Id", "Fecha", "Sujeto", "Nombre de experimento", "Editar", "Eliminar", "Exportar", "Ver"};
    String Condiciones = "";

    private void FiltrarTabla() {
        Condiciones = "";
        if (!t0.getText().isEmpty()) {
            Condiciones += " AND idListaExperimentos LIKE '%" + t0.getText() + "%'";
        }

        if (!t1.getText().isEmpty()) {
            Condiciones += " AND Fecha LIKE '%" + t1.getText() + "%'";
        }
        if (!t2.getText().isEmpty()) {
            Condiciones += " AND SujetoPrueba LIKE '%" + t2.getText() + "%'";
        }
        if (!t3.getText().isEmpty()) {
            Condiciones += " AND NombreExperimento LIKE '%" + t3.getText() + "%'";
        }

        if (t0.getText().isEmpty() && t1.getText().isEmpty() && t2.getText().isEmpty() && t3.getText().isEmpty()) {
            try {
                setTabla(1);

            } catch (SQLException ex) {
                Logger.getLogger(V4ProgramaPrincipal.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                setTabla(2);

            } catch (SQLException ex) {
                Logger.getLogger(V4ProgramaPrincipal.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void PushDedo(String dedo) {
        //System.out.println(dedo);
    }

    private void VerificacionHuellasBD() throws SQLException {

    }

    private void RegistrarNuevaHuella(String Dedo) {
        CRUD_HuellaDigital dp = new CRUD_HuellaDigital();
        dp.listReaders();
        DPFPTemplate temp = dp.getTemplate(null, 1);
        byte[] b = temp.serialize();
        dp.insert(usuario.getIdUsuario() + "", b, Dedo);
    }

    private void ActualizaLista(String idUsuario) {
        List.removeAll();
        DefaultListModel modelo = new DefaultListModel();
        CRUD_HuellaDigital hd = new CRUD_HuellaDigital();
        ArrayList<String> nuevo = hd.getList(idUsuario);
        if (nuevo != null) {
            for (int i = 0; i < nuevo.size(); i++) {
                modelo.addElement(nuevo.get(i));
            }
        }
        List.setModel(modelo);
    }
    int val_img = 0;

    private void CargarDatos() {
        try {
            String cad = List.getSelectedValue();
            int val = 0;
            for (int i = 1; i < cad.length(); i++) {
                if (cad.charAt(i) == ' ') {
                    ////System.out.println("" + cad.substring(0, i));
                    val = Integer.parseInt(cad.substring(0, i));
                    i = cad.length();
                }
            }
            CRUD_HuellaDigital hd = new CRUD_HuellaDigital();
            jTextArea2.setText(hd.get(val));
            try {

                //System.out.println("" + val_img);
                if (val_img == 0) {
                    jLabel47.setIcon(new ImageIcon("src/img/huella/1 (2).png"));
                }
                if (val_img == 1) {
                    jLabel47.setIcon(new ImageIcon("src/img/huella/2 (2).png"));
                }
                if (val_img == 2) {
                    jLabel47.setIcon(new ImageIcon("src/img/huella/3.jpg"));
                }
                val_img++;
                if (val_img == 3) {
                    val_img = 0;
                }
            } catch (Exception c) {
                //System.out.println("Me vale 2" + c.toString());
            }
        } catch (Exception e) {

        }

    }

    private void EliminarHuellaSeleccionada() {
        String cad = List.getSelectedValue();
        if (JOptionPane.showConfirmDialog(null, "Desea Eliminar la Huella seleccionada?", "Confirmación",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            int val = 0;
            for (int i = 1; i < cad.length(); i++) {
                if (cad.charAt(i) == ' ') {
                    val = Integer.parseInt(cad.substring(0, i));
                    i = cad.length();
                }
            }
            CRUD_HuellaDigital hd = new CRUD_HuellaDigital();
            hd.Delete(val);
        }

    }

    private void ActualizarDescripcionHuella() {
        String cad2 = jTextArea2.getText();
        String cad = List.getSelectedValue();
        if (JOptionPane.showConfirmDialog(null, "Desea Actualizar la Descripción de la Huella seleccionada?", "Confirmación",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            int val = 0;
            for (int i = 1; i < cad.length(); i++) {
                if (cad.charAt(i) == ' ') {
                    val = Integer.parseInt(cad.substring(0, i));
                    i = cad.length();
                }
            }
            CRUD_HuellaDigital hd = new CRUD_HuellaDigital();
            if (!cad2.isEmpty());
            hd.Update(cad2, val);
        }
    }

    private void ActivarElementosDatosPersonales(boolean b) {
        d1.setEnabled(b);
        d3.setEnabled(b);
        d4.setEnabled(b);
        d5.setEnabled(b);
        if (usuario.getUsuario_tipo().equals("1")) {
            d6.setEnabled(b);
        }
        d7.setEnabled(b);
    }

    private void LlenarDatosPersonales(ModUsuario x) throws SQLException {
        CRUD_Usuario c = new CRUD_Usuario();
        d0.setText(x.getIdUsuario() + "");
        d1.setText(x.getUsuario_fullname());
        d3.setText(x.getUsuario_nombre());
        d4.setText(x.getUsuario_pass());
        d5.setText(x.getUsuario_pass());
        //System.out.println("" + x.getUsuario_tipo());
        if (x.getUsuario_tipo().equals("1")) {
            d6.setSelectedIndex(0);
        }
        if (x.getUsuario_tipo().equals("2")) {
            d6.setSelectedIndex(1);
        }
        if (x.getUsuario_tipo().equals("3")) {
            d6.setSelectedIndex(2);
        }
        d7.setText(x.getUsuario_email());
    }

    private void LlenarComboBoxUsuarios() throws SQLException {
        PerfilOpcionesUsuario.removeAllItems();
        ArrayList<String> datos1 = new ArrayList<>();
        CRUD_Usuario val1 = new CRUD_Usuario();
        datos1 = val1.RetornaListaUsuarios();
        int band = 0;
        try {
            for (int i = 0; i < datos1.size(); i++) {
                ////System.out.println("**"+datos1.get(i));
                if (usuario.getIdUsuario() != 1 && band != 1) {
                    band = 1;
                    i++;
                }
                PerfilOpcionesUsuario.addItem(datos1.get(i));
            }
        } catch (Exception e) {
            ////System.out.println(""+e.toString());
        }
    }

    private void LlenarComboBoxReportes(String id) throws SQLException {
        jRadioButton1.setSelected(true);
        jRadioButton4.setSelected(true);

        System.out.println(">>>" + id);

        jComboBox1.removeAllItems();
        jComboBox2.removeAllItems();
        jComboBox3.removeAllItems();
        jComboBox4.removeAllItems();
        jComboBox5.removeAllItems();
        jComboBox6.removeAllItems();

        ArrayList<String> datos1 = new ArrayList<>();
        CRUD_ListaExperimentos val1 = new CRUD_ListaExperimentos();
        datos1 = (ArrayList<String>) val1.RetornaListaFechaExperimentos(id);
        try {
            for (int i = 0; i < datos1.size(); i++) {
                jComboBox1.addItem(datos1.get(i));
                jComboBox2.addItem(datos1.get(i));
                jComboBox3.addItem(datos1.get(i));
            }
        } catch (Exception e) {
        }

        ArrayList<String> datos2 = new ArrayList<>();
        CRUD_ListaExperimentos val2 = new CRUD_ListaExperimentos();
        datos2 = (ArrayList<String>) val2.RetornaListaFechaExperimentosTemporales(id);
        try {
            for (int i = 0; i < datos2.size(); i++) {
                jComboBox4.addItem(datos2.get(i));
                jComboBox5.addItem(datos2.get(i));
                jComboBox6.addItem(datos2.get(i));
            }
        } catch (Exception e) {
        }
    }

    private void LLenarComboBoxInformacionGeneral() throws SQLException, SQLException {
        CRUD_TablasGenerales oks = new CRUD_TablasGenerales();
        ArrayList<String> var1 = oks.RetornaListaEstadoCivil();
        try {
            cbestadocivil.removeAllItems();
            cbEstadoCivil.removeAllItems();
            for (int i = 0; i < var1.size(); i++) {
                cbestadocivil.addItem(var1.get(i));
                cbEstadoCivil.addItem(var1.get(i));
            }
        } catch (Exception e) {
        }
        var1 = oks.RetornaListaCarrera();
        try {
            cbCarrera.removeAllItems();
            cb_carrera.removeAllItems();
            for (int i = 0; i < var1.size(); i++) {
                cb_carrera.addItem(var1.get(i));
                cbCarrera.addItem(var1.get(i));
            }
        } catch (Exception e) {
        }
        var1 = oks.RetornaListaReligiones();
        try {
            cbReligion.removeAllItems();
            cb_religion.removeAllItems();
            for (int i = 0; i < var1.size(); i++) {
                cb_religion.addItem(var1.get(i));
                cbReligion.addItem(var1.get(i));
            }
        } catch (Exception e) {
        }
        var1 = oks.RetornaListaSexo();
        try {
            cbSexo.removeAllItems();
            cb_sexo.removeAllItems();
            for (int i = 0; i < var1.size(); i++) {
                cb_sexo.addItem(var1.get(i));
                cbSexo.addItem(var1.get(i));
            }
        } catch (Exception e) {
        }
        var1 = oks.RetornaListaIdioma();
        try {
            cbLengua.removeAllItems();
            cbIdioma.removeAllItems();
            cb_lm.removeAllItems();
            cb_oi.removeAllItems();
            for (int i = 0; i < var1.size(); i++) {
                cb_lm.addItem(var1.get(i));
                cb_oi.addItem(var1.get(i));
                cbLengua.addItem(var1.get(i));
                cbIdioma.addItem(var1.get(i));
            }
        } catch (Exception e) {
        }

        LlenarComboBoxCheck();
    }

    private void LlenarComboBoxCheck() throws SQLException {

        jPanel5.removeAll();
        jPanel5.updateUI();

        jPanel5.revalidate();
        jPanel5.repaint();

        Vector v = new Vector();
        CRUD_TablasGenerales oks = new CRUD_TablasGenerales();
        ArrayList<String> var1 = oks.RetornaListaEnfermedades();
        v.add("¿Padece alguna de las siguientes enfermedades?");

        try {
            for (int i = 0; i < var1.size(); i++) {
                v.add(new JCheckBox(var1.get(i), false));
            }
        } catch (Exception e) {
        }

        jPanel5.add(new JComboCheckBox(v));
    }

    private void LimpiarCajasEdicionDatosPersonales() {
        d0.setText("");
        d1.setText("");
        d3.setText("");
        d4.setText("");
        d5.setText("");
        d7.setText("");
    }

    private void ItemSeleccionado() {
        try {
            //System.out.println("" + jComboBox2.getSelectedItem());
            String cad = (String) PerfilOpcionesUsuario.getSelectedItem();
            System.out.println("cad = " + cad);
            int val = 0;
            for (int i = 1; i < cad.length(); i++) {
                if (cad.charAt(i) == ' ') {
                    ////System.out.println("" + cad.substring(0, i));
                    val = Integer.parseInt(cad.substring(0, i));
                    i = cad.length();
                }
            }
            CRUD_Usuario c = new CRUD_Usuario();
            try {
                LlenarDatosPersonales(c.RetornaUsuariosiExiste(val));
                ActualizaLista(d0.getText());

            } catch (SQLException ex) {
                Logger.getLogger(V4ProgramaPrincipal.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception w) {
            ////System.out.println("Primer");
        }
    }

    private void EliminarUsuario() throws SQLException {
        if (JOptionPane.showConfirmDialog(null, "Desea eliminar el usuario Actual?", "Advertencia",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            CRUD_Usuario c = new CRUD_Usuario();
            if (d0.getText().equals("1")) {
                //System.out.println("Checar");
                //
            } else {
                c.DeleteUsuario(Integer.parseInt(d0.getText()));
            }
            LlenarComboBoxUsuarios();
        }
    }

    private void OcultarValidaciones(boolean b) {
        v1.setVisible(b);
        v2.setVisible(b);
        v7.setVisible(b);
    }

    private void ActualizarVentana(int num) {
        this.removeAll();
        this.updateUI();

        V4ProgramaPrincipal p;
        try {
            p = new V4ProgramaPrincipal(usuario, UsoHuella);
            p.setSize(1900, 1000);
            //abrir el panel que se necesita
            p.jTabbedPane1.setSelectedIndex(num);
            this.add(p);

        } catch (SQLException ex) {
            Logger.getLogger(V2ColocacionHardware.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.revalidate();
        this.repaint();
    }

    private JButton agregar_estilo_a(JButton Button) {
        if (Button.getText().equals("Editar")) {
            Button.setIcon(new ImageIcon("src/img/V4Principal/t_editar.png"));
        } else if (Button.getText().equals("Eliminar")) {
            Button.setIcon(new ImageIcon("src/img/V4Principal/t_borrar.png"));
        } else if (Button.getText().equals("Exportar")) {
            Button.setIcon(new ImageIcon("src/img/V4Principal/t_exportar.png"));
        } else if (Button.getText().equals("Ver")) {
            Button.setIcon(new ImageIcon("src/img/V4Principal/t_ver.png"));
        } else if (Button.getText().equals("Guardar")) {
            Button.setIcon(new ImageIcon("src/img/V4Principal/t_guardar.png"));
        } else if (Button.getText().equals("Cancelar")) {
            Button.setIcon(new ImageIcon("src/img/V4Principal/t_cancelar.png"));
        } else if (Button.getText().equals("Almacenar")) {
            Button.setIcon(new ImageIcon("src/img/V4Principal/t_bd.png"));
        }
        return Button;
    }

    private void agregar_estilo_verde(JButton Button) {
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

    private void agregar_estilo_default(JButton Button) {
        Button.setBackground(new JButton().getBackground());
        Button.setBorderPainted(true);
        Button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent arg0) {
                Button.setBackground(new JButton().getBackground());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Button.setBackground(new JButton().getBackground());
            }
        });
        Button.setForeground(new JButton().getForeground());
    }

    private void CargarEstilosBotonesVerdes() {

        agregar_estilo_verde(jButton1);
    }

    private void ExportaReporteElemento(String igual) throws JRException {
        Reporte r = new Reporte();
        r.GenerarPDFHistorialExperimentos(usuario.getIdUsuario(), EncuentraCaracter(igual));
    }

    private void ExportaReporteElemento(String min, String max) throws JRException {
        System.out.println("" + min + " -- " + max);
        Reporte r = new Reporte();
        r.GenerarPDFHistorialExperimentos(usuario.getIdUsuario(), EncuentraCaracter(min), EncuentraCaracter(max));
    }

    private void ExportaReporteExperimentoTemporal(String igual) throws JRException {
        System.out.println("--- " + igual);
        Reporte r = new Reporte();
        r.GenerarPDFHistorialExperimentosTemporales(usuario.getIdUsuario(), EncuentraCaracter(igual));
    }

    private void ExportaReporteExperimentoTemporal(String menor, String mayor) throws JRException {
        System.out.println("" + menor + " -- " + mayor);
        Reporte r = new Reporte();
        r.GenerarPDFHistorialExperimentosTemporales(usuario.getIdUsuario(), EncuentraCaracter(menor), EncuentraCaracter(mayor));
    }

    private void ExportaReporteExpedientesClinicos() throws JRException {
        Reporte r = new Reporte();
        r.GenerarPDFListaExpedientesClinicos();
    }

    private void ExportaIdiomas() throws JRException {
        Reporte r = new Reporte();
        r.GenerarPDFListaIdiomasPaciente();
    }

    private void ExportaEnfermedaes() throws JRException {
        Reporte r = new Reporte();
        r.GenerarPDFListaEnfermedadesPaciente();
    }

    private String EncuentraCaracter(String igual) {
        System.out.println("" + igual);
        int band = 0;
        for (int i = 0; i < igual.length(); i++) {
            if (igual.charAt(i) == '|') {
                System.out.println("| >>" + i);
                band = i - 1;
                return igual.substring(0, band);
            }
        }
        return "";
    }

    private void ComponentesPanel(JPanel jPanel5, String id) throws SQLException {
        try {
            JComboCheckBox nue = (JComboCheckBox) jPanel5.getComponent(0);
            Vector v = new Vector();
            for (int i = 0; i < nue.getItemCount(); i++) {
                System.out.println("--" + nue.getItemAt(i));
                v.add(nue.getItemAt(i));
            }
            System.out.println("Items Seleccionados");
            for (int i = 1; i < v.size(); i++) {
                JCheckBox val = (JCheckBox) v.get(i);
                System.out.println("Accediendo al Vector " + i + " " + val.getText() + " " + val.isSelected());
                if (val.isSelected()) {
                    System.out.println("Agregando elemento ..");
                    CRUD_ExpedienteSujetoPruebas cew2 = new CRUD_ExpedienteSujetoPruebas();
                    cew2.InsertarRelacionEnfermedades(id, val.getText());
                }
            }
        } catch (Exception c) {
            System.out.println("ComponentesPanel ERROR " + c.toString());
        }
    }
}
