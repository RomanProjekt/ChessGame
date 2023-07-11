/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.view;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import src.model.Schachfeld;
import src.model.Spielfigur;
import src.model.Spielrunde;


/**
 *
 * @author roman
 */
public class SchachLogic implements MouseListener {

    public Schachfeld aktuelle_SchachFeld;
    public Spielrunde runde;

    public SchachLogic() {}
    
    public SchachLogic(Schachfeld aktuelle_SchachFeld, Spielrunde runde) {
        this.aktuelle_SchachFeld = aktuelle_SchachFeld;
        this.runde = runde;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (runde.getAltes_ausgewähltes_Schachfeld() == null && runde.getNeues_ausgewähltes_Schachfeld() == null) {
            runde.setFarbe_altes_Feld(aktuelle_SchachFeld.getFeld().getJlabel().getBackground());
            runde.setAltes_ausgewähltes_Schachfeld(aktuelle_SchachFeld);
            runde.getAltes_ausgewähltes_Schachfeld().getFeld().getJlabel().setBackground(Color.red);
        } 
        else if (runde.getAltes_ausgewähltes_Schachfeld() != null && runde.getNeues_ausgewähltes_Schachfeld() == null) {
            if (aktuelle_SchachFeld.equals(runde.getAltes_ausgewähltes_Schachfeld())) {
                runde.setAltes_ausgewähltes_Schachfeld(null);
                aktuelle_SchachFeld.getFeld().getJlabel().setBackground(runde.getFarbe_altes_Feld());
            } else {
                runde.setNeues_ausgewähltes_Schachfeld(aktuelle_SchachFeld);
                runde.setFarbe_makiertes_Feld(aktuelle_SchachFeld.getFeld().getJlabel().getBackground());
                runde.getNeues_ausgewähltes_Schachfeld().getFeld().getJlabel().setBackground(Color.BLUE);
                Spielfigur spielfigur = runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur();
                spielfigur.getBewegungslogik().mache_Schachzug(runde);
            }
        } else if (runde.getAltes_ausgewähltes_Schachfeld() != null && runde.getNeues_ausgewähltes_Schachfeld() != null) {
            if (aktuelle_SchachFeld.equals(runde.getNeues_ausgewähltes_Schachfeld())) {
                runde.getNeues_ausgewähltes_Schachfeld().getFeld().getJlabel().setBackground(aktuelle_SchachFeld.getFeld().getJlabel().getBackground());
                runde.setNeues_ausgewähltes_Schachfeld(null);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
