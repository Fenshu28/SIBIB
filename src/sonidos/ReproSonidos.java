/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sonidos;

import java.io.File;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

/**
 *
 * @author LabTW21
 */
public class ReproSonidos {

    public void SonidoConfirmacion() {
        try {
            BasicPlayer player = new BasicPlayer(); // Llamo la clase de la libreria Basic Player, que reproduce
            player.open(new File("src/sounds/Confirmacion.mp3"));// Dentro las "" va la ruta de tu archivo mp3.
            player.play();// Llama al método Reproducir también existen los métodos  stop,resume.           
        } catch (BasicPlayerException ex) {
            System.out.print("-------Error-----" + ex.getMessage());
        }// Fin try
    }
    public void SonidoSinLatido() {
        try {
            BasicPlayer player = new BasicPlayer(); // Llamo la clase de la libreria Basic Player, que reproduce
            player.open(new File("src/sounds/SinLatido.wav"));// Dentro las "" va la ruta de tu archivo mp3.
            player.play();// Llama al método Reproducir también existen los métodos  stop,resume.           
        } catch (BasicPlayerException ex) {
            System.out.print("-------Error-----" + ex.getMessage());
        }// Fin try
    }
    public void SonidoNegacion() {
        try {
            BasicPlayer player = new BasicPlayer(); // Llamo la clase de la libreria Basic Player, que reproduce
            player.open(new File("src/sounds/Negacion.wav"));// Dentro las "" va la ruta de tu archivo mp3.
            player.play();// Llama al método Reproducir también existen los métodos  stop,resume.           
        } catch (BasicPlayerException ex) {
            System.out.print("-------Error-----" + ex.getMessage());
        }// Fin try
    }
    public void SonidoLatidoNormal() {
        try {
            BasicPlayer player = new BasicPlayer(); // Llamo la clase de la libreria Basic Player, que reproduce
            player.open(new File("src/sounds/LatidoNormal.wav"));// Dentro las "" va la ruta de tu archivo mp3.
            player.play();// Llama al método Reproducir también existen los métodos  stop,resume.           
        } catch (BasicPlayerException ex) {
            System.out.print("-------Error-----" + ex.getMessage());
        }// Fin try
    }
    public void SonidoIniciarSesion() {
        try {
            BasicPlayer player = new BasicPlayer(); // Llamo la clase de la libreria Basic Player, que reproduce
            player.open(new File("src/sounds/IniciarSesion.wav"));// Dentro las "" va la ruta de tu archivo mp3.
            player.play();// Llama al método Reproducir también existen los métodos  stop,resume.           
        } catch (BasicPlayerException ex) {
            System.out.print("-------Error-----" + ex.getMessage());
        }// Fin try
    }
    public void SonidoError() {
        try {
            BasicPlayer player = new BasicPlayer(); // Llamo la clase de la libreria Basic Player, que reproduce
            player.open(new File("src/sounds/Error.mp3"));// Dentro las "" va la ruta de tu archivo mp3.
            player.play();// Llama al método Reproducir también existen los métodos  stop,resume.           
        } catch (BasicPlayerException ex) {
            System.out.print("-------Error-----" + ex.getMessage());
        }// Fin try
    }
    public void SonidoCerrarSesion() {
        try {
            BasicPlayer player = new BasicPlayer(); // Llamo la clase de la libreria Basic Player, que reproduce
            player.open(new File("src/sounds/CerrarSesion.wav"));// Dentro las "" va la ruta de tu archivo mp3.
            player.play();// Llama al método Reproducir también existen los métodos  stop,resume.           
        } catch (BasicPlayerException ex) {
            System.out.print("-------Error-----" + ex.getMessage());
        }// Fin try
    }
}
