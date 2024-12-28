/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import javax.swing.SwingWorker;

/**
 *
 * @author Fercho
 */
public class Progress extends SwingWorker<Integer, String> {

    private String dispositivo = "";
    String IP ="127.0.0.1";
    String PUERTO="2401";
    
    
    Progress(JLabel lblprocesar, JProgressBar progressBar, String dispositivo, JToggleButton btn_continuar) {
        this.label = lblprocesar;
        this.jpbar = progressBar;
        this.dispositivo = dispositivo;
        this.btn_continuar = btn_continuar;
    }

    /**
     * @return the label
     */
    public JLabel getLabel() {
        return label;
    }

    public Progress(JLabel label, JProgressBar jpbar, String dispositivo) {
        this.label = label;
        this.jpbar = jpbar;
        this.dispositivo = dispositivo;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(JLabel label) {
        this.label = label;
    }

    /**
     * @return the jpbar
     */
    public JProgressBar getJpbar() {
        return jpbar;
    }

    /**
     * @param jpbar the jpbar to set
     */
    public void setJpbar(JProgressBar jpbar) {
        this.jpbar = jpbar;
    }

    private JLabel label;
    private JProgressBar jpbar;
    private JToggleButton btn_continuar;

    public Boolean State_comunicacion=false;
    @Override
    protected Integer doInBackground() throws Exception {
        getLabel().setVisible(true);
        getLabel().setText(getLabel().getText() + getDispositivo());
        getJpbar().setIndeterminate(true);

        //Proceso
        try {
            for (int i = 0; i <2; i++) {
        //        System.out.println("Vamos en el " + i);
                Thread.sleep(1000);
            }
            
            //Verificando conexión con Rasp Berri
            if("Rasp Berry".equals(getDispositivo())){
                if(VerificandoConexionCon(getDispositivo())){
                    getLabel().setText("Comunicación exitosa con " + getDispositivo()+" :v");
                    State_comunicacion = true;
                }else{
                    getLabel().setText("Error de comunicación con " + getDispositivo()+" :v");
                    State_comunicacion = false;
                }
            }else{
                getLabel().setText("Comunicación exitosa con " + getDispositivo());
            }
            
            
            getBtn_continuar().setVisible(true);
        } catch (Exception w) {
           // System.out.println("" + w.toString());
        }

        getJpbar().setIndeterminate(false);
        return 0;
    }

    /**
     * @return the dispositivo
     */
    public String getDispositivo() {
        return dispositivo;
    }

    /**
     * @param dispositivo the dispositivo to set
     */
    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    /**
     * @return the btn_continuar
     */
    public JToggleButton getBtn_continuar() {
        return btn_continuar;
    }

    /**
     * @param btn_continuar the btn_continuar to set
     */
    public void setBtn_continuar(JToggleButton btn_continuar) {
        this.btn_continuar = btn_continuar;
    }

    private Boolean VerificandoConexionCon(String dispositivo) throws IOException {
       int band = 1;
       BufferedReader in = null;
       OutputStream out = null;
       Socket sock = null;
              
       try {
           //sock = new Socket(args[0], Integer.parseInt(args[1]));
           sock = new Socket(IP, Integer.parseInt(PUERTO));
           out = sock.getOutputStream();
           in = new BufferedReader(new InputStreamReader(sock.getInputStream()));

           String line = "hey";
           char[] strArray;
           strArray = line.toCharArray();

           //for( int index = 1; index < strArray.length; index++){
           out.write(strArray[0]);
           //}
           out.flush();
           
           if(true){
               band = 1;
           }
       }
       catch (IOException ioe) {
   //        System.out.println("Por algún motivo hay error");
           band=0;
     //      System.err.println(ioe);
       }
       finally {
           if (in != null)
               in.close();
           if (out != null)
               out.close();
           if (sock != null)
               sock.close();
       }
        return band == 1;
    }

}
