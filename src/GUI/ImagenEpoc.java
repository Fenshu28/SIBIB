/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author LFSM
 */
public class ImagenEpoc extends JPanel {
    ImageIcon imagen;
    String url;
    
    public ImagenEpoc(String url){
        this.url = url;       
    }

    @Override
    public void paint(Graphics g) {
        //Dimension tamanio= getSize();   
        imagen = new ImageIcon(getClass().getResource(url));
        g.drawImage(imagen.getImage(),0,0,this.getWidth(),this.getHeight(),null);
        setOpaque(false);
        super.paint(g);          
    }
}
