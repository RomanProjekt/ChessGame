/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.schachfigur;

import java.awt.Color;
import javax.swing.ImageIcon;
import src.model.Spieler;
import src.model.Spielfigur;
import src.regeln.Bewegungslogik;


/**
 *
 * @author roman
 */
//farbe == Color.WHITE ? return new ImageIcon("\\king_black.png") : return new ImageIcon("\\king_white.png");
public class Bishop extends Spielfigur  {

    
    public Bishop(String name, Color farbe, Spieler spieler, ImageIcon icon, Bewegungslogik bewegungslogik) {
        super(name, farbe, spieler, icon, bewegungslogik);
    }
  
   

   
    
    
    
    
}
