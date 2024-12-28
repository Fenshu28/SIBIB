/*
 * Esta clase permite copiar la información generada por los experimentos a una ruta que proporcione el usuario
 */
package Datos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Luis Fernando Santiago Martínez
 * Universidad de la Sierra Sur
 * 
 */
public class CopiarDatos {
    String carpeta;
    public CopiarDatos() {
    }
    /*
    Esta función permite el almacenamiento de los experimentos en la carpeta Experimentos del disco local C
    */
    public void copiarDirectorio(String origen ) throws IOException {
        String destino="C:/Experimentos/"+origen;
        comprobarCrearDirectorio(destino);
        File directorio = new File(origen);
        File f;
        if (directorio.isDirectory()) {
            comprobarCrearDirectorio(destino);
            String[] files = directorio.list();
            if (files.length > 0) {
                for (String archivo : files) {
                    f = new File(origen + File.separator + archivo);
                    if (f.isDirectory()) {
                        //comprobarCrearDirectorio(destino + File.separator + archivo + File.separator);
                        //copiarDirectorio(origen + File.separator + archivo + File.separator, destino + File.separator + archivo + File.separator);
                    } else { //Es un archivo
                        copiarArchivo(origen + File.separator + archivo, destino + File.separator + archivo);
                    }
                }
            }
        }
    }
    /*
        Esta función permite la copia de archivos de una carpeta a otra
    */
    public void copiaraUbicacion(String origen ,String destino) throws IOException {
        String actual="C:/Experimentos/"+origen;
        
        comprobarCrearDirectorio(destino);
        
        File directorio = new File(actual);
        File f;
        if (directorio.isDirectory()) {
            comprobarCrearDirectorio(destino);
            String[] files = directorio.list();
            if (files.length > 0) {
                for (String archivo : files) {
                    f = new File(actual + File.separator + archivo);
                    if (f.isDirectory()) {
                        //comprobarCrearDirectorio(destino + File.separator + archivo + File.separator);
                        //copiarDirectorio(origen + File.separator + archivo + File.separator, destino + File.separator + archivo + File.separator);
                    } else { //Es un archivo
                        copiarArchivo(actual + File.separator + archivo, destino + File.separator + archivo);
                    }
                }
            }
        }
    }
    /*
    Esta función permite retornar el directorio donde se encuentra la aplicación
    */
    public String imprimeDirectorioActual() throws IOException{
        File miDir = new File (".");
     try {
       System.out.println ("Directorio actual: " + miDir.getCanonicalPath());
       }
     catch(IOException e) {
       }
     return miDir.getCanonicalPath();
    }

    /**
     * Copia el archivo origen en el destino
     *
     * @param sOrigen
     * @param sDestino
     */
    public void copiarArchivo(String sOrigen, String sDestino) throws FileNotFoundException, IOException {
        File origen = new File(sOrigen);
        File destino = new File(sDestino);
        InputStream in = new FileInputStream(origen);
        OutputStream out = new FileOutputStream(destino);
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        in.close();
        out.close();
    }

    /**
     * Comprueba si un directorio existe, y en caso contrario crea toda la ruta
     * necesaria para que exista
     *
     * @param ruta
     */
    public void comprobarCrearDirectorio(String ruta) {
        File directorio = new File(ruta);
        if (!directorio.exists()) {
            directorio.mkdirs();
        }
    }
}
