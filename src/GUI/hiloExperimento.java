/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Modelo.ModUsuario;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Fercho
 */
public class hiloExperimento extends Thread {

    private String Ip = "";
    private String Puerto = "";
    private ModUsuario usuario = null;
    private String Sujeto = "";
    private String nombreExp = "";
    private int nuevo;
    String idExperimento = "";
    String fecha = "";

    public hiloExperimento(String Ip, String Puerto, ModUsuario usuario, String sujeto, String nombreExp, int nuevo) {
        this.Ip = Ip;
        this.Puerto = Puerto;
        this.usuario = usuario;
        this.Sujeto = sujeto;
        this.nombreExp = nombreExp;
        this.nuevo = nuevo;
        System.out.println("Constructo de hilo nuevo");
    }

    public hiloExperimento(String id, String fecha, String sujeto, String nombreExp, int nuevo) {
        idExperimento = id;
        this.fecha = fecha;
        this.Sujeto = sujeto;
        this.nombreExp = nombreExp;
        this.nuevo = nuevo;
        System.out.println("Nuevo " + nuevo);
    }

    @Override
    public void run() {
        if (this.nuevo == 1) {
            System.out.println("Iniciando experimento nuevo");
            iniciarExperimento();
            System.out.println("Finalizando Hilo");
        } else {
            System.out.println("Vamos a iniciar una repetición");
            iniciarRepeticion();
            System.out.println("Finalizando Repetición");
        }
    }

    public void iniciarRepeticion() {
        Experimento miInterfaz = new Experimento(idExperimento, Sujeto, nombreExp, this.nuevo, fecha);
        miInterfaz.setVisible(true);
    }

    public void iniciarExperimento() {
        boolean ExperimentoFinalizado = true;
        Experimento miInterfaz = new Experimento(usuario, Sujeto, nombreExp, this.nuevo);

        System.out.println("Iniciando Programa");
        String hostName = Ip;
        int portNumber = Integer.parseInt(Puerto);

        try {
            Socket echoSocket = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));

            String userInput = "";
            System.out.println("Todo bien");
            miInterfaz.setVisible(true);

            // Simular clicks automáticamente
            try {
                Thread.sleep(1000); // Esperar a que la interfaz esté lista
                miInterfaz.simularClickStart();
                Thread.sleep(1000); // Esperar entre clicks
                miInterfaz.simularClickIniciar();
            } catch (InterruptedException e) {
                System.out.println("Error en simulación de clicks: " + e.getMessage());
            }

            while (ExperimentoFinalizado) {
                out.println(userInput + " 1");
                System.out.println(in.readLine());
                miInterfaz.miMuestra.recibeDatos(in.readLine());
                if (!miInterfaz.isShowing()) {
                    System.out.println("Cerrando todo");
                    ExperimentoFinalizado = false;
                }
            }
        } catch (Exception x) {
            System.out.println("Error de Conexión");
            JOptionPane.showMessageDialog(null, "No ha iniciado la aplicación en el dispositivo Linux"
                    + " o "
                    + "existe algún error de conexión."
                    + " Para más información verifique el manual");
            System.out.println(x.getMessage());
        }
        System.out.println("Finalizando lectura desde C");
    }

//    public void iniciarExperimento() throws IOException {
//
//        boolean ExperimentoFinalizado = true;
//
//        Experimento miInterfaz = new Experimento(usuario, Sujeto, nombreExp);
//
//        BufferedReader in = null;
//        OutputStream out = null;
//        Socket sock = null;
//
//        try {
//            System.out.println("IP:" + Ip + " Puerto:" + Integer.parseInt(Puerto));
//            sock = new Socket(Ip, Integer.parseInt(Puerto));
//            out = sock.getOutputStream();
//            in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
//
//            out.flush();
//            miInterfaz.setVisible(true);
//
//            System.out.println("Bien hasta antes del while");
//            while (ExperimentoFinalizado) {
//                System.out.println("Dentro del while");
//                miInterfaz.miMuestra.recibeDatos(in.readLine());
//                if (!miInterfaz.isShowing()) {
//                    System.out.println("Cerrando todo");
//                    ExperimentoFinalizado = false;
//                }
//            }
//            System.out.println("Hola después de while");
//        } catch (IOException ioe) {
//            System.err.println(ioe);
//            JOptionPane.showMessageDialog(null, "No ha iniciado el Programa para recolectar los Datos", "Error", JOptionPane.ERROR_MESSAGE);
//        } finally {
//            if (in != null) {
//                in.close();
//            }
//            if (out != null) {
//                out.close();
//            }
//            if (sock != null) {
//                sock.close();
//            }
//        }/*
//        try{
//            miInterfaz.dispose();
//        }catch(Exception x){
//            System.out.println("Error al cerrar el Frame hiloExperimento");
//        }*/
//    }
}
