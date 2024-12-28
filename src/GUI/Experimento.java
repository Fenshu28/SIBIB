/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Modelo.ModExperimento;
import Modelo.ModMuestra;
import Modelo.ModUsuario;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import conexionBD.CRUD_ListaExperimentos;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

/**
 *
 * @author LFSM
 */
public class Experimento extends javax.swing.JFrame {

    //Objetos de Interacción con BD
    //Hilos necesarios para la ejecución
    //Este hilo actualiza el graficador al repetir el experiento
    Thread hilo2Rep;

    Thread hiloRep;
    Thread hiloPrincipal;
    public ModMuestra miMuestra = new ModMuestra();

    private FileWriter archivo, archivoMarcador;

    private ModUsuario usuario;

    private String carpeta;
    private String Sujeto;
    private String nombreExp;
    private int nuevo = 0;
    String idExperimento = "1";
    String fecha;

    public Experimento(ModUsuario usuario, String sujeto, String nombreExp, int nuevo) {
        initComponents();
        ColorFrame();
        setSize(1900, 1000);
        this.nuevo = nuevo;
        this.carpeta = sujeto + nombreExp;

        this.Sujeto = sujeto;
        this.nombreExp = nombreExp;
        this.usuario = usuario;

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.START.setEnabled(true);
        this.STOP.setEnabled(false);
        this.INICIAR.setEnabled(false);
        this.FINALIZAR.setEnabled(false);
        this.MARCADOR.setEnabled(false);

        this.RETARDO_INICIO.setEnabled(false);
        this.CARGAR_VIDEO.setEnabled(false);
        this.CARGAR_MUSICA.setEnabled(false);

        this.F3.setBackground(Color.BLACK);
        this.FC6.setBackground(Color.BLACK);
        this.P7.setBackground(Color.BLACK);
        this.T8.setBackground(Color.BLACK);
        this.F7.setBackground(Color.BLACK);
        this.F8.setBackground(Color.BLACK);
        this.T7.setBackground(Color.BLACK);
        this.P8.setBackground(Color.BLACK);
        this.AF4.setBackground(Color.BLACK);
        this.F4.setBackground(Color.BLACK);
        this.AF3.setBackground(Color.BLACK);
        this.O2.setBackground(Color.BLACK);
        this.O1.setBackground(Color.BLACK);
        this.FC5.setBackground(Color.BLACK);

        ActivarTodosSensoresGrafica();
        ActivarTimeSerieCollection("");

        this.jButton4.setEnabled(false);
        jTextArea1.setEditable(false);
        
    }

    public Experimento(String id, String sujeto, String nombreExp, int nuevo, String fecha) {
        initComponents();
        ColorFrame();
        setSize(1900, 1000);

        System.out.println("Hasta aqui vamos bien");

        this.Sujeto = sujeto;
        this.nombreExp = nombreExp;
        this.fecha = fecha;
        this.nuevo = nuevo;

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.START.setEnabled(true);
        this.STOP.setEnabled(false);
        this.INICIAR.setEnabled(false);
        this.FINALIZAR.setEnabled(false);
        this.MARCADOR.setEnabled(false);

        this.RETARDO_INICIO.setEnabled(false);
        this.CARGAR_VIDEO.setEnabled(false);
        this.CARGAR_MUSICA.setEnabled(false);

        this.F3.setBackground(Color.BLACK);
        this.FC6.setBackground(Color.BLACK);
        this.P7.setBackground(Color.BLACK);
        this.T8.setBackground(Color.BLACK);
        this.F7.setBackground(Color.BLACK);
        this.F8.setBackground(Color.BLACK);
        this.T7.setBackground(Color.BLACK);
        this.P8.setBackground(Color.BLACK);
        this.AF4.setBackground(Color.BLACK);
        this.F4.setBackground(Color.BLACK);
        this.AF3.setBackground(Color.BLACK);
        this.O2.setBackground(Color.BLACK);
        this.O1.setBackground(Color.BLACK);
        this.FC5.setBackground(Color.BLACK);

        INICIAR.setVisible(false);
        FINALIZAR.setVisible(false);
        idExperimento = id;

        System.out.println("Fecha = " + fecha);
        Date date = new Date(fecha);
        System.out.println("FECHA " + date);
        hora = date.getHours();
        minuto = date.getMinutes();
        segundo = date.getSeconds();
        dia = date.getDay();
        mes = date.getMonth() + 1;
        anio = date.getYear() + 1900;
        System.out.println("AÑO: " + anio);

        ActivarTodosSensoresGrafica();
        ActivarTimeSerieCollection("");

        
        jTextArea1.setEditable(false);
        btn_stop();
    }
    int hora = 0, minuto = 0, segundo = 0, dia = 12, mes = 10, anio = 2000;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        START = new javax.swing.JButton();
        STOP = new javax.swing.JButton();
        RECORDING = new java.awt.Canvas();
        TIEMPO_ETIQUETA = new javax.swing.JLabel();
        TIEMPO_ETIQUETA1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        RETARDO_INICIO = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        INICIAR = new javax.swing.JButton();
        FINALIZAR = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        CARGAR_VIDEO = new javax.swing.JButton();
        CARGAR_MUSICA = new javax.swing.JButton();
        MARCADOR = new javax.swing.JButton();
        graficaTR = new javax.swing.JPanel();
        graficaDatos = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        S_P7 = new javax.swing.JCheckBox();
        S_F3 = new javax.swing.JCheckBox();
        S_FC6 = new javax.swing.JCheckBox();
        S_T8 = new javax.swing.JCheckBox();
        S_F7 = new javax.swing.JCheckBox();
        S_F8 = new javax.swing.JCheckBox();
        S_O2 = new javax.swing.JCheckBox();
        S_AF3 = new javax.swing.JCheckBox();
        S_F4 = new javax.swing.JCheckBox();
        S_AF4 = new javax.swing.JCheckBox();
        S_P8 = new javax.swing.JCheckBox();
        S_T7 = new javax.swing.JCheckBox();
        S_O1 = new javax.swing.JCheckBox();
        S_FC5 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        StateSensors = new GUI.ImagenEpoc("imagenes/epoc_qc1.jpg");//new javax.swing.JPanel();
        AF3 = new java.awt.Canvas();
        F3 = new java.awt.Canvas();
        F7 = new java.awt.Canvas();
        FC5 = new java.awt.Canvas();
        T7 = new java.awt.Canvas();
        P7 = new java.awt.Canvas();
        O1 = new java.awt.Canvas();
        F4 = new java.awt.Canvas();
        AF4 = new java.awt.Canvas();
        FC6 = new java.awt.Canvas();
        T8 = new java.awt.Canvas();
        P8 = new java.awt.Canvas();
        O2 = new java.awt.Canvas();
        F8 = new java.awt.Canvas();
        RythmHeart = new GUI.ImagenEpoc("imagenes/heart.png");
        jLabel1 = new javax.swing.JLabel();
        LatidosCorazon = new javax.swing.JLabel();
        state_src = new javax.swing.JLabel();
        gsr = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        state_gsr = new javax.swing.JLabel();
        bat = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(44, 211, 227));
        jPanel2.setLayout(null);

        START.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        START.setText("Comenzar");
        START.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STARTActionPerformed(evt);
            }
        });
        jPanel2.add(START);
        START.setBounds(60, 50, 118, 50);

        STOP.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        STOP.setText("Detener");
        STOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STOPActionPerformed(evt);
            }
        });
        jPanel2.add(STOP);
        STOP.setBounds(190, 50, 144, 50);

        RECORDING.setBackground(new java.awt.Color(3, 5, 3));
        jPanel2.add(RECORDING);
        RECORDING.setBounds(650, 40, 30, 30);

        TIEMPO_ETIQUETA.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        TIEMPO_ETIQUETA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TIEMPO_ETIQUETA.setText("00:00:00");
        jPanel2.add(TIEMPO_ETIQUETA);
        TIEMPO_ETIQUETA.setBounds(700, 27, 200, 50);

        TIEMPO_ETIQUETA1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        TIEMPO_ETIQUETA1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TIEMPO_ETIQUETA1.setText("Tiempo:");
        jPanel2.add(TIEMPO_ETIQUETA1);
        TIEMPO_ETIQUETA1.setBounds(690, 27, 73, 50);

        jButton4.setText("Pausar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(350, 50, 150, 50);

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel9.setText("RETARDO(s):");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(860, 30, 91, 40);

        RETARDO_INICIO.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        RETARDO_INICIO.setEditor(new javax.swing.JSpinner.NumberEditor(RETARDO_INICIO, ""));
        jPanel2.add(RETARDO_INICIO);
        RETARDO_INICIO.setBounds(970, 30, 120, 40);

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Grabando:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(490, 30, 170, 50);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Visualización de  sensores");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(70, 0, 360, 50);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 10, 1110, 110);

        jPanel6.setBackground(new java.awt.Color(44, 211, 227));
        jPanel6.setLayout(null);

        INICIAR.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        INICIAR.setText("INICIAR");
        INICIAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                INICIARActionPerformed(evt);
            }
        });
        jPanel6.add(INICIAR);
        INICIAR.setBounds(10, 60, 150, 40);

        FINALIZAR.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        FINALIZAR.setText("FINALIZAR");
        FINALIZAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FINALIZARActionPerformed(evt);
            }
        });
        jPanel6.add(FINALIZAR);
        FINALIZAR.setBounds(211, 60, 170, 40);

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Almacenar información");
        jPanel6.add(jLabel8);
        jLabel8.setBounds(10, 10, 360, 50);

        getContentPane().add(jPanel6);
        jPanel6.setBounds(1130, 10, 390, 109);

        jPanel10.setBackground(new java.awt.Color(44, 211, 227));
        jPanel10.setLayout(null);

        CARGAR_VIDEO.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        CARGAR_VIDEO.setText("CARGAR VIDEO");
        CARGAR_VIDEO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CARGAR_VIDEOActionPerformed(evt);
            }
        });
        jPanel10.add(CARGAR_VIDEO);
        CARGAR_VIDEO.setBounds(40, 20, 154, 27);

        CARGAR_MUSICA.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        CARGAR_MUSICA.setText("CARGAR MÚSICA");
        CARGAR_MUSICA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CARGAR_MUSICAActionPerformed(evt);
            }
        });
        jPanel10.add(CARGAR_MUSICA);
        CARGAR_MUSICA.setBounds(40, 60, 154, 28);

        MARCADOR.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        MARCADOR.setText("MARCADOR");
        MARCADOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MARCADORActionPerformed(evt);
            }
        });
        jPanel10.add(MARCADOR);
        MARCADOR.setBounds(200, 20, 130, 68);

        getContentPane().add(jPanel10);
        jPanel10.setBounds(1535, 10, 350, 110);

        graficaTR.setBackground(new java.awt.Color(44, 211, 227));
        graficaTR.setLayout(null);

        javax.swing.GroupLayout graficaDatosLayout = new javax.swing.GroupLayout(graficaDatos);
        graficaDatos.setLayout(graficaDatosLayout);
        graficaDatosLayout.setHorizontalGroup(
            graficaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1110, Short.MAX_VALUE)
        );
        graficaDatosLayout.setVerticalGroup(
            graficaDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );

        graficaTR.add(graficaDatos);
        graficaDatos.setBounds(20, 10, 1110, 820);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Sensores:");
        graficaTR.add(jLabel3);
        jLabel3.setBounds(1150, 20, 100, 20);

        S_P7.setText("P7");
        graficaTR.add(S_P7);
        S_P7.setBounds(1140, 160, 90, 40);

        S_F3.setText("F3");
        graficaTR.add(S_F3);
        S_F3.setBounds(1140, 60, 90, 40);

        S_FC6.setText("FC6");
        graficaTR.add(S_FC6);
        S_FC6.setBounds(1140, 110, 90, 40);

        S_T8.setText("T8");
        graficaTR.add(S_T8);
        S_T8.setBounds(1140, 210, 90, 40);

        S_F7.setText("F7");
        S_F7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_F7ActionPerformed(evt);
            }
        });
        graficaTR.add(S_F7);
        S_F7.setBounds(1140, 260, 90, 30);

        S_F8.setText("F8");
        S_F8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                S_F8ActionPerformed(evt);
            }
        });
        graficaTR.add(S_F8);
        S_F8.setBounds(1140, 300, 90, 30);

        S_O2.setText("O2");
        graficaTR.add(S_O2);
        S_O2.setBounds(1140, 590, 90, 40);

        S_AF3.setText("AF3");
        graficaTR.add(S_AF3);
        S_AF3.setBounds(1140, 540, 90, 40);

        S_F4.setText("F4");
        graficaTR.add(S_F4);
        S_F4.setBounds(1140, 490, 90, 40);

        S_AF4.setText("AF4");
        graficaTR.add(S_AF4);
        S_AF4.setBounds(1140, 440, 90, 40);

        S_P8.setText("P8");
        graficaTR.add(S_P8);
        S_P8.setBounds(1140, 390, 90, 40);

        S_T7.setText("T7");
        graficaTR.add(S_T7);
        S_T7.setBounds(1140, 340, 90, 40);

        S_O1.setText("O1");
        graficaTR.add(S_O1);
        S_O1.setBounds(1140, 640, 90, 40);

        S_FC5.setText("FC5");
        graficaTR.add(S_FC5);
        S_FC5.setBounds(1140, 690, 90, 40);

        getContentPane().add(graficaTR);
        graficaTR.setBounds(290, 130, 1240, 840);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jTextField1.setText("Escriba aquí sus comentarios");
        jTextField1.setEnabled(false);
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(1540, 130, 350, 840);

        jPanel3.setBackground(new java.awt.Color(44, 211, 227));
        jPanel3.setLayout(null);

        StateSensors.setBackground(new java.awt.Color(255, 255, 255));

        AF3.setBackground(new java.awt.Color(66, 163, 64));

        F3.setBackground(new java.awt.Color(66, 163, 64));

        F7.setBackground(new java.awt.Color(66, 163, 64));
        F7.setName(""); // NOI18N

        FC5.setBackground(new java.awt.Color(66, 163, 64));

        T7.setBackground(new java.awt.Color(66, 163, 64));

        P7.setBackground(new java.awt.Color(66, 163, 64));

        O1.setBackground(new java.awt.Color(66, 163, 64));

        F4.setBackground(new java.awt.Color(66, 163, 64));

        AF4.setBackground(new java.awt.Color(66, 163, 64));

        FC6.setBackground(new java.awt.Color(66, 163, 64));

        T8.setBackground(new java.awt.Color(66, 163, 64));

        P8.setBackground(new java.awt.Color(66, 163, 64));

        O2.setBackground(new java.awt.Color(66, 163, 64));

        F8.setBackground(new java.awt.Color(66, 163, 64));

        javax.swing.GroupLayout StateSensorsLayout = new javax.swing.GroupLayout(StateSensors);
        StateSensors.setLayout(StateSensorsLayout);
        StateSensorsLayout.setHorizontalGroup(
            StateSensorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StateSensorsLayout.createSequentialGroup()
                .addGroup(StateSensorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StateSensorsLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(StateSensorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(StateSensorsLayout.createSequentialGroup()
                                .addComponent(P7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(P8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(StateSensorsLayout.createSequentialGroup()
                                .addComponent(FC5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(FC6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(StateSensorsLayout.createSequentialGroup()
                        .addGroup(StateSensorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(StateSensorsLayout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(O1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(O2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(StateSensorsLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(F7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(F3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(F4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(StateSensorsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(T7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 31, Short.MAX_VALUE)))
                .addGroup(StateSensorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StateSensorsLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(T8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StateSensorsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(F8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
            .addGroup(StateSensorsLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(AF3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AF4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        StateSensorsLayout.setVerticalGroup(
            StateSensorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StateSensorsLayout.createSequentialGroup()
                .addGroup(StateSensorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(StateSensorsLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(O2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(StateSensorsLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(StateSensorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AF3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AF4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(StateSensorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(StateSensorsLayout.createSequentialGroup()
                                .addGroup(StateSensorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(StateSensorsLayout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(F7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(F4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addComponent(FC5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(F3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StateSensorsLayout.createSequentialGroup()
                                .addComponent(F8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(FC6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(StateSensorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(T7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(T8, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(StateSensorsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(P7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(P8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addComponent(O1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel3.add(StateSensors);
        StateSensors.setBounds(10, 11, 250, 260);

        RythmHeart.setBackground(new java.awt.Color(44, 211, 227));
        RythmHeart.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(248, 236, 236));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LATIDOS x MINUTO");
        RythmHeart.add(jLabel1);
        jLabel1.setBounds(10, 47, 189, 35);

        LatidosCorazon.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        LatidosCorazon.setForeground(new java.awt.Color(251, 241, 241));
        LatidosCorazon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LatidosCorazon.setText("...");
        RythmHeart.add(LatidosCorazon);
        LatidosCorazon.setBounds(10, 88, 204, 48);

        state_src.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        state_src.setText("Sensor desconectado");
        RythmHeart.add(state_src);
        state_src.setBounds(30, 160, 170, 20);

        jPanel3.add(RythmHeart);
        RythmHeart.setBounds(20, 290, 230, 210);
        jPanel3.add(gsr);
        gsr.setBounds(90, 650, 170, 30);

        jLabel6.setText("GSR:");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(60, 660, 90, 19);

        state_gsr.setText("Sensor desconectado");
        jPanel3.add(state_gsr);
        state_gsr.setBounds(60, 680, 160, 20);
        jPanel3.add(bat);
        bat.setBounds(60, 760, 120, 30);

        jLabel4.setText("Batería de la EPOC+: ");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(60, 740, 130, 19);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(10, 130, 270, 840);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    static TimeSeries ts = new TimeSeries("Sensor F3");
    static TimeSeries ts2 = new TimeSeries("Sensor FC6");
    static TimeSeries ts3 = new TimeSeries("Sensor P7");
    static TimeSeries ts4 = new TimeSeries("Sensor T8");
    static TimeSeries ts5 = new TimeSeries("Sensor F7");
    static TimeSeries ts6 = new TimeSeries("Sensor F8");
    static TimeSeries ts7 = new TimeSeries("Sensor T7");
    static TimeSeries ts8 = new TimeSeries("Sensor P8");
    static TimeSeries ts9 = new TimeSeries("Sensor AF4");
    static TimeSeries ts10 = new TimeSeries("Sensor F4");
    static TimeSeries ts11 = new TimeSeries("Sensor AF3");
    static TimeSeries ts12 = new TimeSeries("Sensor O2");
    static TimeSeries ts13 = new TimeSeries("Sensor O1");
    static TimeSeries ts14 = new TimeSeries("Sensor FC5");

    String[] fila = null;

    Millisecond f = new Millisecond(0, hora, minuto, segundo, dia, mes, anio);
    int sumaLatidos = 0, contsumaLatidos = 0;
    int ValorActual = 0;
    int valili = 0;
    double valor = 0.3;

    int tiempo_segundo = 0;
    
    // En la clase Experimento.java, agregar estos métodos públicos:
    public void simularClickStart() {
        START.doClick();
    }

    public void simularClickIniciar() {
        INICIAR.doClick();
    }


    private void STARTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STARTActionPerformed
        System.out.println("Pulsa Start");
        this.START.setEnabled(false);
        this.STOP.setEnabled(true);
        this.INICIAR.setEnabled(true);
        this.FINALIZAR.setEnabled(false);
        this.MARCADOR.setEnabled(false);
        this.F3.setBackground(Color.RED);
        this.FC6.setBackground(Color.RED);
        this.P7.setBackground(Color.RED);
        this.T8.setBackground(Color.RED);
        this.F7.setBackground(Color.RED);
        this.F8.setBackground(Color.RED);
        this.T7.setBackground(Color.RED);
        this.P8.setBackground(Color.RED);
        this.AF4.setBackground(Color.RED);
        this.F4.setBackground(Color.RED);
        this.AF3.setBackground(Color.RED);
        this.O2.setBackground(Color.RED);
        this.O1.setBackground(Color.RED);
        this.FC5.setBackground(Color.RED);

        if (nuevo == 2) {
            System.out.println(">> Vamo a darle");
            ValorActual = 0;
            jButton4.setEnabled(true);
            ActivarTimeSerieCollection("");
            valor_de_minisec_f = 0;
            try {
                hiloRep = new Thread() {
                    @Override
                    public void run() {
                        CRUD_ListaExperimentos lect = new CRUD_ListaExperimentos();
                        List<String> direccion = null;
                        try {
                            direccion = lect.NombreArchivoForIdExp(idExperimento);
                        } catch (SQLException ex) {
                            Logger.getLogger(Experimento.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        try{
                        String archLog = "C:\\Experimentos\\" + direccion.get(0) + "\\marcadores.txt";
                        Scanner input = new Scanner(new File(archLog+""));
                        while (input.hasNextLine()) {
                            String line = input.nextLine();
                            jTextArea1.setText(jTextArea1.getText()+line);
                       }
                        }catch(Exception w){
                            
                        }

                        String archCSV = "C:\\Experimentos\\" + direccion.get(0) + "\\data_signals.csv";
                        System.out.println("Abriendo " + archCSV);
                        CSVReader csvReader = null;
                        try {
                            csvReader = new CSVReader(new FileReader(archCSV));
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(Experimento.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        try {
                            int primera = 0;

                            while ((fila = csvReader.readNext()) != null && !START.isEnabled()) {
                                LatidosCorazon.setText("" + fila[31]);
                                gsr.setText("" + fila[30]);
                                int num, hor, min, seg;
                                num = (int) Double.parseDouble(fila[0]);
                                hor = num / 3600;
                                min = (num - (3600 * hor)) / 60;
                                seg = num - ((hor * 3600) + (min * 60));
                                TIEMPO_ETIQUETA.setText(hor + ":" + min + ":" + seg + "");
                                if (primera == 0) {
                                    primera = 1;
                                    hilo2Rep = new Thread() {
                                        public void run() {
                                            while (!START.isEnabled() && fila != null) {
                                                try {
                                                    if (S_F3.isSelected()) {
                                                        ts.addOrUpdate(f, Integer.parseInt(fila[1]) * valor + 6000);
                                                    }
                                                    if (S_FC6.isSelected()) {
                                                        ts2.addOrUpdate(f, Integer.parseInt(fila[2]) * valor + 5000);
                                                    }
                                                    if (S_P7.isSelected()) {
                                                        ts3.addOrUpdate(f, Integer.parseInt(fila[3]) * valor + 4000);
                                                    }
                                                    if (S_T8.isSelected()) {
                                                        ts4.addOrUpdate(f, Integer.parseInt(fila[4]) * valor + 3000);
                                                    }
                                                    if (S_F7.isSelected()) {
                                                        ts5.addOrUpdate(f, Integer.parseInt(fila[5]) * valor + 2000);
                                                    }
                                                    if (S_F8.isSelected()) {
                                                        ts6.addOrUpdate(f, Integer.parseInt(fila[6]) * valor + 1000);
                                                    }
                                                    if (S_T7.isSelected()) {
                                                        ts7.addOrUpdate(f, Integer.parseInt(fila[7]) * valor);
                                                    }
                                                    if (S_P8.isSelected()) {
                                                        ts8.addOrUpdate(f, Integer.parseInt(fila[8]) * valor - 1000);
                                                    }
                                                    if (S_AF4.isSelected()) {
                                                        ts9.addOrUpdate(f, Integer.parseInt(fila[9]) * valor - 2000);
                                                    }
                                                    if (S_F4.isSelected()) {
                                                        ts10.addOrUpdate(f, Integer.parseInt(fila[10]) * valor - 3000);
                                                    }
                                                    if (S_AF3.isSelected()) {
                                                        ts11.addOrUpdate(f, Integer.parseInt(fila[11]) * valor - 4000);
                                                    }
                                                    if (S_O2.isSelected()) {
                                                        ts12.addOrUpdate(f, Integer.parseInt(fila[12]) * valor - 5000);
                                                    }
                                                    if (S_O1.isSelected()) {
                                                        ts13.addOrUpdate(f, Integer.parseInt(fila[13]) * valor - 6000);
                                                    }
                                                    if (S_FC5.isSelected()) {
                                                        ts14.addOrUpdate(f, Integer.parseInt(fila[14]) * valor - 7000);
                                                    }

                                                } catch (Exception ssd) {
                                                    System.out.println("Detalle en Hilo 2");
                                                    if (nuevo == 2) {
                                                        jButton4.setEnabled(false);
                                                    }
                                                }
                                            }
                                        }
                                    };
                                    hilo2Rep.start();
                                }
                                ModificarMillisegundosF(7);
                                Thread.sleep(7);
                            }
                            csvReader.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Experimento.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (CsvValidationException ex) {
                            Logger.getLogger(Experimento.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Experimento.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };
                hiloRep.start();
            } catch (Exception d) {
                System.out.println("" + d.toString());
            }
        }
        if (nuevo == 1) {
            //Hilo controlado
            Thread hiloEtiquetas = new Thread() {
                @Override
                public void run() {
                    while (!START.isEnabled()) {
                        try {
                            
                            int num, hor, min, seg;
                            num = (int) miMuestra.getTiempoJAVA();
                            hor = num / 3600;
                            min = (num - (3600 * hor)) / 60;
                            seg = num - ((hor * 3600) + (min * 60));

                            if (INICIAR.isEnabled()) {
                                actEstadosContactSensors();
                            }
                            if (tiempo_segundo != seg) {
                                TIEMPO_ETIQUETA.setText(hor + ":" + min + ":" + seg + "");
                                bat.setText(miMuestra.getBateria() + "%");
                                LatidosCorazon.setText(":" + miMuestra.getLPS());
                                gsr.setText(":" + miMuestra.getGSR());
                                tiempo_segundo = seg;
                                if (miMuestra.getLPS() == -9999) {
                                    state_src.setVisible(true);
                                } else {
                                    state_src.setVisible(false);
                                }
                                if (miMuestra.getGSR() == -9999) {
                                    state_gsr.setVisible(true);
                                } else {
                                    state_gsr.setVisible(false);
                                }
                            }
                            sleep(100);

                        } catch (Exception sss) {
                            System.out.println("Detalle en Hilo 3");
                        }
                    }
                }
            };
            hiloEtiquetas.start();
        }
    }//GEN-LAST:event_STARTActionPerformed
    int valor_de_minisec_f = 0;

    public void ModificarMillisegundosF(int val) {
        valor_de_minisec_f += val;
        //System.out.println(" "+hora+" "+minuto+" "+segundo+" "+dia+" "+mes+" "+anio);
        //f = new Millisecond(valor_de_minisec_f, hora, minuto, segundo, dia, mes, anio);
        f = new Millisecond(valor_de_minisec_f, 0, 0, 0, 28, 07, 1996);
    }

    private void STOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STOPActionPerformed
        if (FINALIZAR.isEnabled()) {
            try {
                GuardarExperimentoTemporalBD();
                btn_Finalizar();

            } catch (SQLException ex) {
                Logger.getLogger(Experimento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        btn_stop();

    }//GEN-LAST:event_STOPActionPerformed
    String Directorio = "";

    //Millisecond se;
    private void INICIARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INICIARActionPerformed
        jTextArea1.setText("");
        jTextField1.setEnabled(true);
        ActivarTimeSerieCollection("");
        try {
            //Este hilo está listo
            Thread hiloIniciar = new Thread() {
                @Override
                public void run() {
                    ActivarTimeSerieCollection("");
                    while (!INICIAR.isEnabled()) {
                        try {
                            actEstadosContactSensors();
                            sleep(100);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Experimento.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            if (S_F3.isSelected()) {
                                ts.addOrUpdate(new Millisecond(), miMuestra.getF3() * valor + 6000);
                            }
                            if (S_FC6.isSelected()) {
                                ts2.addOrUpdate(new Millisecond(), miMuestra.getFC6() * valor + 5000);
                            }
                            if (S_P7.isSelected()) {
                                ts3.addOrUpdate(new Millisecond(), miMuestra.getP7() * valor + 4000);
                            }
                            if (S_T8.isSelected()) {
                                ts4.addOrUpdate(new Millisecond(), miMuestra.getT8() * valor + 3000);
                            }
                            if (S_F7.isSelected()) {
                                ts5.addOrUpdate(new Millisecond(), miMuestra.getF7() * valor + 2000);
                            }
                            if (S_F8.isSelected()) {
                                ts6.addOrUpdate(new Millisecond(), miMuestra.getF8() * valor + 1000);
                            }
                            if (S_T7.isSelected()) {
                                ts7.addOrUpdate(new Millisecond(), miMuestra.getT7() * valor);
                            }
                            if (S_P8.isSelected()) {
                                ts8.addOrUpdate(new Millisecond(), miMuestra.getP8() * valor - 1000);
                            }
                            if (S_AF4.isSelected()) {
                                ts9.addOrUpdate(new Millisecond(), miMuestra.getAF4() * valor - 2000);
                            }
                            if (S_F4.isSelected()) {
                                ts10.addOrUpdate(new Millisecond(), miMuestra.getF4() * valor - 3000);
                            }
                            if (S_AF3.isSelected()) {
                                ts11.addOrUpdate(new Millisecond(), miMuestra.getAF3() * valor - 4000);
                            }
                            if (S_O2.isSelected()) {
                                ts12.addOrUpdate(new Millisecond(), miMuestra.getO2() * valor - 5000);
                            }
                            if (S_O1.isSelected()) {
                                ts13.addOrUpdate(new Millisecond(), miMuestra.getO1() * valor - 6000);
                            }
                            if (S_FC5.isSelected()) {
                                ts14.addOrUpdate(new Millisecond(), miMuestra.getFC5() * valor - 7000);
                            }
                        } catch (Exception ssd) {
                            System.out.println("Detalle en Hilo 2");
                        }
                    }
                }
            };
            hiloIniciar.start();
        } catch (Exception c) {
            System.out.println("El hilo ya ha finalizado");
        }
        Calendar calendario = Calendar.getInstance();

        int hora, minutos, segundos;

        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);

        this.START.setEnabled(false);
        this.STOP.setEnabled(true);
        this.INICIAR.setEnabled(false);
        this.FINALIZAR.setEnabled(true);
        this.MARCADOR.setEnabled(true);

        this.RECORDING.setBackground(Color.red);

        this.miMuestra.reiniciaTiempo();

        Directorio = "./" + carpeta + " " + hora + "_" + minutos + "_" + segundos;
        File folder = new File(Directorio);
        folder.mkdir();
        if (folder.isDirectory()) {
            System.out.println("Directorio creado");
        }

        try {
            this.archivo = new FileWriter(Directorio + "/data_signals.csv");
            this.archivoMarcador = new FileWriter(Directorio + "/marcadores.txt");
            //Hilo controlado
            new Thread(new Runnable() {
                @Override
                public void run() {
                    miMuestra.iniciaEscrituraArchivo(archivo);
                    while (!INICIAR.isEnabled()) {
                        try {
                            sleep(100);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Experimento.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    miMuestra.finalizaEscrituraArchivo();
                }
            }).start();
        } catch (IOException ex) {
            Logger.getLogger(Experimento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_INICIARActionPerformed

    public void CerrarProcesos() {
        try {
            this.INICIAR.setEnabled(true);
            miMuestra.finalizaEscrituraArchivo();
        } catch (Exception x) {
        }
    }

    private void FINALIZARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FINALIZARActionPerformed
        try {
            GuardarExperimentoTemporalBD();
            btn_Finalizar();
            JOptionPane.showMessageDialog(null, "Experimento almacenado exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(Experimento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_FINALIZARActionPerformed
    public void btn_Finalizar() throws SQLException {
        // TODO add your handling code here:
        this.START.setEnabled(false);
        this.STOP.setEnabled(true);
        this.INICIAR.setEnabled(true);
        this.FINALIZAR.setEnabled(false);
        this.MARCADOR.setEnabled(false);

        this.TIEMPO_ETIQUETA.setText("00:00:00");

        this.RECORDING.setBackground(Color.black);
        try {
            this.archivo.close();
            this.archivoMarcador.close();
            //CRUD_ListaExperimentosTemporales let = new CRUD_ListaExperimentosTemporales();
            //let.InsertarExperimentoNuevo(usuario.getIdUsuario(), Sujeto, nombreExp);
        } catch (IOException ex) {
            System.out.println("H");
        }
    }
    private void CARGAR_VIDEOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CARGAR_VIDEOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CARGAR_VIDEOActionPerformed

    private void CARGAR_MUSICAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CARGAR_MUSICAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CARGAR_MUSICAActionPerformed

    private void MARCADORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MARCADORActionPerformed
        miMuestra.activarMarcador();

    }//GEN-LAST:event_MARCADORActionPerformed

    private void S_F7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_F7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_F7ActionPerformed

    private void S_F8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_S_F8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_F8ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            if (hiloRep.isAlive()) {
                hiloRep.stop();
            }
        } catch (Exception w) {
            System.out.println("" + w.toString());
        }
    }//GEN-LAST:event_formWindowClosing

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (jButton4.getText().equals("Pause")) {
            jButton4.setText("Continuar");
            hiloRep.suspend();
        } else {
            jButton4.setText("Pause");
            hiloRep.resume();
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        //System.out.println(""+jTextField1.getText());
        if (nuevo == 1) {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                //System.out.println(""se.get);
                jTextArea1.setText(jTextArea1.getText() + "" + TIEMPO_ETIQUETA.getText() + ": " + jTextField1.getText() + "\n");
                try {
                    archivoMarcador.write(TIEMPO_ETIQUETA.getText() + ": " + jTextField1.getText() + "\n");
                } catch (IOException ex) {
                    Logger.getLogger(Experimento.class.getName()).log(Level.SEVERE, null, ex);
                }
                /*
        try {
            // TODO add your handling code here:
            String str = "Marcador a los " + Double.toString(miMuestra.getTiempoJAVA()) + " segundos";
            
        } catch (IOException ex) {
            Logger.getLogger(Experimento.class.getName()).log(Level.SEVERE, null, ex);
        }
                 */
                jTextField1.setText("");
            }
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        jTextField1.setSelectionStart(0);
        jTextField1.setSelectionEnd(jTextField1.getText().length());
    }//GEN-LAST:event_jTextField1MouseClicked

    public void actEstadosContactSensors() {
        System.out.println(miMuestra);
        switch (miMuestra.getContacto_F3()) {
            case 0:
                this.F3.setBackground(Color.red);
                break;
            case 1:
                this.F3.setBackground(Color.yellow);
                break;
            case 2:
                this.F3.setBackground(Color.green);
                break;
        }
        switch (miMuestra.getContacto_FC6()) {
            case 0:
                this.FC6.setBackground(Color.red);
                break;
            case 1:
                this.FC6.setBackground(Color.yellow);
                break;
            case 2:
                this.FC6.setBackground(Color.green);
                break;
        }
        switch (miMuestra.getContacto_P7()) {
            case 0:
                this.P7.setBackground(Color.red);
                break;
            case 1:
                this.P7.setBackground(Color.yellow);
                break;
            case 2:
                this.P7.setBackground(Color.green);
                break;
        }
        switch (miMuestra.getContacto_T8()) {
            case 0:
                this.T8.setBackground(Color.red);
                break;
            case 1:
                this.T8.setBackground(Color.yellow);
                break;
            case 2:
                this.T8.setBackground(Color.green);
                break;
        }
        switch (miMuestra.getContacto_F7()) {
            case 0:
                this.F7.setBackground(Color.red);
                break;
            case 1:
                this.F7.setBackground(Color.yellow);
                break;
            case 2:
                this.F7.setBackground(Color.green);
                break;
        }
        switch (miMuestra.getContacto_F8()) {
            case 0:
                this.F8.setBackground(Color.red);
                break;
            case 1:
                this.F8.setBackground(Color.yellow);
                break;
            case 2:
                this.F8.setBackground(Color.green);
                break;
        }
        switch (miMuestra.getContacto_T7()) {
            case 0:
                this.T7.setBackground(Color.red);
                break;
            case 1:
                this.T7.setBackground(Color.yellow);
                break;
            case 2:
                this.T7.setBackground(Color.green);
                break;
        }
        switch (miMuestra.getContacto_P8()) {
            case 0:
                this.P8.setBackground(Color.red);
                break;
            case 1:
                this.P8.setBackground(Color.yellow);
                break;
            case 2:
                this.P8.setBackground(Color.green);
                break;
        }
        switch (miMuestra.getContacto_AF4()) {
            case 0:
                this.AF4.setBackground(Color.red);
                break;
            case 1:
                this.AF4.setBackground(Color.yellow);
                break;
            case 2:
                this.AF4.setBackground(Color.green);
                break;
        }
        switch (miMuestra.getContacto_F4()) {
            case 0:
                this.F4.setBackground(Color.red);
                break;
            case 1:
                this.F4.setBackground(Color.yellow);
                break;
            case 2:
                this.F4.setBackground(Color.green);
                break;
        }
        switch (miMuestra.getContacto_AF3()) {
            case 0:
                this.AF3.setBackground(Color.red);
                break;
            case 1:
                this.AF3.setBackground(Color.yellow);
                break;
            case 2:
                this.AF3.setBackground(Color.green);
                break;
        }
        switch (miMuestra.getContacto_O2()) {
            case 0:
                this.O2.setBackground(Color.red);
                break;
            case 1:
                this.O2.setBackground(Color.yellow);
                break;
            case 2:
                this.O2.setBackground(Color.green);
                break;
        }
        switch (miMuestra.getContacto_O1()) {
            case 0:
                this.O1.setBackground(Color.red);
                break;
            case 1:
                this.O1.setBackground(Color.yellow);
                break;
            case 2:
                this.O1.setBackground(Color.green);
                break;
        }
        switch (miMuestra.getContacto_FC5()) {
            case 0:
                this.FC5.setBackground(Color.red);
                break;
            case 1:
                this.FC5.setBackground(Color.yellow);
                break;
            case 2:
                this.FC5.setBackground(Color.green);
                break;
        }
    }

    public void cerrar() throws SQLException {
        Object[] opciones = {"Aceptar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(rootPane, "En realidad desea realizar cerrar la aplicacion", "Mensaje de Confirmacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
        if (eleccion == JOptionPane.YES_OPTION) {
            if (INICIAR.isEnabled()) {
                btn_Finalizar();
            }
            System.exit(0);
        } else {
        }
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas AF3;
    private java.awt.Canvas AF4;
    private javax.swing.JButton CARGAR_MUSICA;
    private javax.swing.JButton CARGAR_VIDEO;
    private java.awt.Canvas F3;
    private java.awt.Canvas F4;
    private java.awt.Canvas F7;
    private java.awt.Canvas F8;
    private java.awt.Canvas FC5;
    private java.awt.Canvas FC6;
    private javax.swing.JButton FINALIZAR;
    public javax.swing.JButton INICIAR;
    private javax.swing.JLabel LatidosCorazon;
    private javax.swing.JButton MARCADOR;
    private java.awt.Canvas O1;
    private java.awt.Canvas O2;
    private java.awt.Canvas P7;
    private java.awt.Canvas P8;
    private java.awt.Canvas RECORDING;
    private javax.swing.JSpinner RETARDO_INICIO;
    private javax.swing.JPanel RythmHeart;
    public javax.swing.JButton START;
    private javax.swing.JButton STOP;
    private javax.swing.JCheckBox S_AF3;
    private javax.swing.JCheckBox S_AF4;
    private javax.swing.JCheckBox S_F3;
    private javax.swing.JCheckBox S_F4;
    private javax.swing.JCheckBox S_F7;
    private javax.swing.JCheckBox S_F8;
    private javax.swing.JCheckBox S_FC5;
    private javax.swing.JCheckBox S_FC6;
    private javax.swing.JCheckBox S_O1;
    private javax.swing.JCheckBox S_O2;
    private javax.swing.JCheckBox S_P7;
    private javax.swing.JCheckBox S_P8;
    private javax.swing.JCheckBox S_T7;
    private javax.swing.JCheckBox S_T8;
    private javax.swing.JPanel StateSensors;
    private java.awt.Canvas T7;
    private java.awt.Canvas T8;
    private javax.swing.JLabel TIEMPO_ETIQUETA;
    private javax.swing.JLabel TIEMPO_ETIQUETA1;
    private javax.swing.JLabel bat;
    private javax.swing.JPanel graficaDatos;
    private javax.swing.JPanel graficaTR;
    private javax.swing.JLabel gsr;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel state_gsr;
    private javax.swing.JLabel state_src;
    // End of variables declaration//GEN-END:variables

    private void ActivarTodosSensoresGrafica() {

        S_F3.setSelected(true);
        S_FC6.setSelected(true);
        S_P7.setSelected(true);
        S_T8.setSelected(true);
        S_F7.setSelected(true);
        S_F8.setSelected(true);
        S_T7.setSelected(true);
        S_P8.setSelected(true);
        S_AF4.setSelected(true);
        S_F4.setSelected(true);
        S_AF3.setSelected(true);
        S_O2.setSelected(true);
        S_O1.setSelected(true);
        S_FC5.setSelected(true);
    }

    private void ActivarTimeSerieCollection(String nombre) {
        try{
        if (nombre.equals("")) {
            nombre = "Tiempo";
        }
        TimeSeriesCollection dataset = new TimeSeriesCollection(ts);
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "Lista de Sensores",
                nombre,
                "Valores",
                dataset,
                true,
                true,
                false
        );

        dataset.addSeries(ts2);
        dataset.addSeries(ts3);
        dataset.addSeries(ts4);
        dataset.addSeries(ts5);
        dataset.addSeries(ts6);
        dataset.addSeries(ts7);
        dataset.addSeries(ts8);
        dataset.addSeries(ts9);
        dataset.addSeries(ts10);
        dataset.addSeries(ts11);
        dataset.addSeries(ts12);
        dataset.addSeries(ts13);
        dataset.addSeries(ts14);
        ts.clear();
        ts2.clear();
        ts3.clear();
        ts4.clear();
        ts5.clear();
        ts6.clear();
        ts7.clear();
        ts8.clear();
        ts9.clear();
        ts10.clear();
        ts11.clear();
        ts12.clear();
        ts13.clear();
        ts14.clear();

        final XYPlot plot = chart.getXYPlot();
        ValueAxis axis = plot.getDomainAxis();
        axis.setAutoRange(true);
        axis.setFixedAutoRange(30000.0);

        graficaDatos.removeAll();
        graficaDatos.updateUI();
        ChartPanel p1 = new ChartPanel(chart);
        p1.setSize(1110, 820);
        graficaDatos.add(p1);
        graficaDatos.revalidate();
        graficaDatos.repaint();
        }catch(Exception s){
            System.out.println("Continuar con error");
        }
    }

    private void GuardarExperimentoTemporalBD() throws SQLException {
        CRUD_ListaExperimentos l = new CRUD_ListaExperimentos();
        ModExperimento exs = new ModExperimento(usuario.getIdUsuario(), Sujeto, nombreExp, Directorio);
        l.InsertarExperimentoNuevo(exs);
        System.out.println("Experimento Temporal Almacenado en la Base de datos");
    }

    private void btn_stop() {
        // TODO add your handling code here:
        this.START.setEnabled(true);
        this.STOP.setEnabled(false);
        this.INICIAR.setEnabled(false);
        this.FINALIZAR.setEnabled(false);
        this.MARCADOR.setEnabled(false);

        this.F3.setBackground(Color.BLACK);
        this.FC6.setBackground(Color.BLACK);
        this.P7.setBackground(Color.BLACK);
        this.T8.setBackground(Color.BLACK);
        this.F7.setBackground(Color.BLACK);
        this.F8.setBackground(Color.BLACK);
        this.T7.setBackground(Color.BLACK);
        this.P8.setBackground(Color.BLACK);
        this.AF4.setBackground(Color.BLACK);
        this.F4.setBackground(Color.BLACK);
        this.AF3.setBackground(Color.BLACK);
        this.O2.setBackground(Color.BLACK);
        this.O1.setBackground(Color.BLACK);
        this.FC5.setBackground(Color.BLACK);

        this.TIEMPO_ETIQUETA.setText("00:00:00");
        try {
            hiloPrincipal.stop();
        } catch (Exception d) {
            System.out.println("");
        }
        if (nuevo != 1) {

            ActivarTimeSerieCollection("");
        }
    }

    private void ColorFrame() {
        Color oscuro = new Color(79,84,93);
        this.getContentPane().setBackground(oscuro);
    }

}
