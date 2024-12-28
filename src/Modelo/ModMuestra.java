package Modelo;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Luis Fernando Santiago Martínez Lic. Informática Descripción: Esta
 * clase almacena los datos que se reciben mediante el proto- colo TCP y permite
 * almacenar los mismos datos en un archivo con extención .csv
 */
public class ModMuestra {

    private final double constanteTiempo;
    private float tiempoC;
    private double tiempoJAVA;
    private int F3;
    private int FC6;
    private int P7;
    private int T8;
    private int F7;
    private int F8;
    private int T7;
    private int P8;
    private int AF4;
    private int F4;
    private int AF3;
    private int O2;
    private int O1;
    private int FC5;
    private int contador;
    private int giroscopioX;
    private int giroscopioY;
    private int bateria;
    private int contacto_F3;
    private int contacto_FC6;
    private int contacto_P7;
    private int contacto_T8;
    private int contacto_F7;
    private int contacto_F8;
    private int contacto_T7;
    private int contacto_P8;
    private int contacto_AF4;
    private int contacto_F4;
    private int contacto_AF3;
    private int contacto_O2;
    private int contacto_O1;
    private int contacto_FC5;
    private boolean bandera;
    FileWriter data;
    private float LPS, GSR;
    public ModMuestra() {
        constanteTiempo = 0.0078125;
        bandera = false;
    }
    int marcadorUsuario=0;
    public void recibeDatos(String a) {
        String[] partes = a.split(",");
        this.tiempoC = Float.parseFloat(partes[0]);
        this.F3 = Integer.parseInt(partes[1]);
        this.FC6 = Integer.parseInt(partes[2]);
        this.P7 = Integer.parseInt(partes[3]);
        this.T8 = Integer.parseInt(partes[4]);
        this.F7 = Integer.parseInt(partes[5]);
        this.F8 = Integer.parseInt(partes[6]);
        this.T7 = Integer.parseInt(partes[7]);
        this.P8 = Integer.parseInt(partes[8]);
        this.AF4 = Integer.parseInt(partes[9]);
        this.F4 = Integer.parseInt(partes[10]);
        this.AF3 = Integer.parseInt(partes[11]);
        this.O2 = Integer.parseInt(partes[12]);
        this.O1 = Integer.parseInt(partes[13]);
        this.FC5 = Integer.parseInt(partes[14]);
        this.contador = Integer.parseInt(partes[15]);
        this.giroscopioX = Integer.parseInt(partes[16]);
        this.giroscopioY = Integer.parseInt(partes[17]);
        this.bateria = Integer.parseInt(partes[18]);
        this.contacto_F3 = Integer.parseInt(partes[19]);
        this.contacto_FC6 = Integer.parseInt(partes[20]);
        this.contacto_P7 = Integer.parseInt(partes[21]);
        this.contacto_T8 = Integer.parseInt(partes[22]);
        this.contacto_F7 = Integer.parseInt(partes[23]);
        this.contacto_F8 = Integer.parseInt(partes[24]);
        this.contacto_T7 = Integer.parseInt(partes[25]);
        this.contacto_P8 = Integer.parseInt(partes[26]);
        this.contacto_AF4 = Integer.parseInt(partes[27]);
        this.contacto_F4 = Integer.parseInt(partes[28]);
        this.contacto_AF3 = Integer.parseInt(partes[29]);
        this.contacto_O2 = Integer.parseInt(partes[30]);
        this.contacto_O1 = Integer.parseInt(partes[31]);
        this.contacto_FC5 = Integer.parseInt(partes[32]);
        //System.out.println(""+">"+partes.length);
        try {
            LPS = Float.parseFloat(partes[33]);
            GSR = Float.parseFloat(partes[34]);
            //this.band=0;
        } catch (NumberFormatException w) {
            //this.band=1;
            System.out.println("Se omite la lectura de los otros dos sensores");
            System.out.println("Paquete Erroneo 33 "+partes[33]);
            System.out.println("Paquete Erroneo 34 "+partes[34]);
        }
        this.aumentaTiempo();
        if (this.bandera) {
            try {
                String tramaCSV = Double.toString(tiempoJAVA) + ",";
                tramaCSV += Integer.toString(F3) + ",";
                tramaCSV += Integer.toString(FC6) + ",";
                tramaCSV += Integer.toString(P7) + ",";
                tramaCSV += Integer.toString(T8) + ",";
                tramaCSV += Integer.toString(F7) + ",";
                tramaCSV += Integer.toString(F8) + ",";
                tramaCSV += Integer.toString(T7) + ",";
                tramaCSV += Integer.toString(P8) + ",";
                tramaCSV += Integer.toString(AF4) + ",";
                tramaCSV += Integer.toString(F4) + ",";
                tramaCSV += Integer.toString(AF3) + ",";
                tramaCSV += Integer.toString(O2) + ",";
                tramaCSV += Integer.toString(O1) + ",";
                tramaCSV += Integer.toString(FC5) + ",";
                tramaCSV += Integer.toString(contador) + ",";
                tramaCSV += Integer.toString(contacto_F3) + ",";
                tramaCSV += Integer.toString(contacto_FC6) + ",";
                tramaCSV += Integer.toString(contacto_P7) + ",";
                tramaCSV += Integer.toString(contacto_T8) + ",";
                tramaCSV += Integer.toString(contacto_F7) + ",";
                tramaCSV += Integer.toString(contacto_F8) + ",";
                tramaCSV += Integer.toString(contacto_T7) + ",";
                tramaCSV += Integer.toString(contacto_P8) + ",";
                tramaCSV += Integer.toString(contacto_AF4) + ",";
                tramaCSV += Integer.toString(contacto_F4) + ",";
                tramaCSV += Integer.toString(contacto_AF3) + ",";
                tramaCSV += Integer.toString(contacto_O2) + ",";
                tramaCSV += Integer.toString(contacto_O1) + ",";
                tramaCSV += Integer.toString(contacto_FC5) + "";
                    tramaCSV += "," + Float.toString(LPS) + ",";
                    tramaCSV += Float.toString(GSR)+",";
                    tramaCSV += Integer.toString(marcadorUsuario);
                marcadorUsuario=0;
                data.write(tramaCSV + "\n");
            } catch (IOException ex) {
            }
        }
    }

    public void iniciaEscrituraArchivo(FileWriter a) {
        this.data = a;
        this.bandera = true;
        System.out.println("Empezamos a escribir en el archivo");
    }

    public void finalizaEscrituraArchivo() {
        this.bandera = false;
        System.out.println("Terminanos de escribir en el archivo");
    }

    public void aumentaTiempo() {
        this.tiempoJAVA += constanteTiempo;
    }

    public void reiniciaTiempo() {
        this.tiempoJAVA = 0;
    }

    public float getTiempoC() {
        return tiempoC;
    }

    public double getTiempoJAVA() {
        return tiempoJAVA;
    }

    public int getF3() {
        return F3;
    }

    public int getFC6() {
        return FC6;
    }

    public int getP7() {
        return P7;
    }

    public int getT8() {
        return T8;
    }

    public int getF7() {
        return F7;
    }

    public int getF8() {
        return F8;
    }

    public int getT7() {
        return T7;
    }

    public int getP8() {
        return P8;
    }

    public int getAF4() {
        return AF4;
    }

    public int getF4() {
        return F4;
    }

    public int getAF3() {
        return AF3;
    }

    public int getO2() {
        return O2;
    }

    public int getO1() {
        return O1;
    }

    public int getFC5() {
        return FC5;
    }

    public int getContador() {
        return contador;
    }

    public int getGiroscopioX() {
        return giroscopioX;
    }

    public int getGiroscopioY() {
        return giroscopioY;
    }

    public int getBateria() {
        return bateria;
    }

    public int getContacto_F3() {
        return contacto_F3;
    }

    public int getContacto_FC6() {
        return contacto_FC6;
    }

    public int getContacto_P7() {
        return contacto_P7;
    }

    public int getContacto_T8() {
        return contacto_T8;
    }

    public int getContacto_F7() {
        return contacto_F7;
    }

    public int getContacto_F8() {
        return contacto_F8;
    }

    public int getContacto_T7() {
        return contacto_T7;
    }

    public int getContacto_P8() {
        return contacto_P8;
    }

    public int getContacto_AF4() {
        return contacto_AF4;
    }

    public int getContacto_F4() {
        return contacto_F4;
    }

    public int getContacto_AF3() {
        return contacto_AF3;
    }

    public int getContacto_O2() {
        return contacto_O2;
    }

    public int getContacto_O1() {
        return contacto_O1;
    }

    public int getContacto_FC5() {
        return contacto_FC5;
    }

    public double getLPS() {
        return LPS;
    }
    public double getGSR() {
        return GSR;
    }
    public void activarMarcador(){
        marcadorUsuario=1;
    }
}
