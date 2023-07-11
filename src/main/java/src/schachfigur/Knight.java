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
public class Knight extends Spielfigur {
    
    
    /*Der König zieht in alle Richtungen, also horizontal, 
    vertikal und diagonal, jeweils ein Feld. Er darf jedoch 
    nie direkt in ein Schach bzw. in ein vom Gegner 
    angegriffenes Feld ziehen. Der König ist stets zu schützen und darf nicht durch Angreifer gefangen werden.
    */

    public Knight(String name, Color farbe, Spieler spieler, ImageIcon icon, Bewegungslogik bewegungslogik) {
        super(name, farbe, spieler, icon, bewegungslogik);
    }
}
