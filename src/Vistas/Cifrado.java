package Vistas;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Base64;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LabTW21
 */
public class Cifrado {
    public static final String DEFAULT_ENCODING = "UTF-8"; 
//    static BASE64Encoder enc = new BASE64Encoder();
//    static BASE64Decoder dec = new BASE64Decoder();

    private static String base64encode(String text) {
        try {
            return Base64.getEncoder().encodeToString(text.getBytes(DEFAULT_ENCODING));
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }//base64encode

    private static String base64decode(String text) {
        try {
            return new String(Base64.getDecoder().decode(text), DEFAULT_ENCODING);
        } catch (IOException e) {
            return null;
        }
    }//base64decode
    private String Informacion="";
    private String key = "UNSIS";
    String encoded="";
    private String TextoXor="";
    private String TextoXorDedodificado="";
    private String original="";
    public Cifrado() {
    }
    public String TextoCifrado(String Informacion){
        this.Informacion = Informacion;
        return base64encode(Informacion);
    }
    public String TextoDescifrado(String encoded){
        return base64decode(encoded);
    }

    private static String xorMessage(String message, String key) {
        try {
            if (message == null || key == null) return null;

            char[] keys = key.toCharArray();
            char[] mesg = message.toCharArray();

            int ml = mesg.length;
            int kl = keys.length;
            char[] newmsg = new char[ml];

            for (int i = 0; i < ml; i++) {
                newmsg[i] = (char)(mesg[i] ^ keys[i % kl]);
            }//for i

            return new String(newmsg);
        } catch (Exception e) {
            return null;
        }
    }//xorMessage
}
