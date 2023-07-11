/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schachfigur;

import java.awt.Color;
import javax.swing.ImageIcon;
import model.Spieler;
import model.Spielfigur;
import regeln.Bewegungslogik;


/**
 *
 * @author roman
 */
public class King extends Spielfigur  {

    public King(String name, Color farbe, Spieler spieler, ImageIcon icon, Bewegungslogik bewegungslogik) {
        super(name, farbe, spieler, icon, bewegungslogik);
    }

    @Override
    public ImageIcon getImage(String pfad) {
        return super.getImage(pfad); 
    }

    @Override
    public Bewegungslogik getBewegungslogik() {
        return super.getBewegungslogik(); 
    }

    @Override
    public String toString() {
        return super.toString(); 
    }
    
    
    
}
