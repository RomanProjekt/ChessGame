/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package regeln;

import java.util.List;
import model.Position;
import model.Schachfeld;
import model.Spielrunde;
import schachfigur.Queen;


/**
 *
 * @author roman
 */
public class QueenLogik extends Bewegungslogik implements Regeln {
    
    protected void mache_Schachzug_fuer_Dame(Spielrunde runde) {
        Queen queen = (Queen) runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur();
        System.out.println(queen.toString());
        if (queen.getSpieler().getSpielerKennzeichen().equals("Spieler1")) {
            if (this.isFigurVorhanden_Auf_Dem_Feld(runde) && this.isGegnerFigur_von_Spieler_1(runde) && this.isSchlag_gueltig(runde)) {
                this.schlageSchachfigur(runde);
            } else if(this.isBewegung_fuer_Spieler1_gueltig(runde)) {
                this.bewegeSchachfigur(runde);
            } else {
                System.out.println("Ungültiger Zug.");
                runde.setSpielzugEnde(false);
            }
        } else {
            if (this.isFigurVorhanden_Auf_Dem_Feld(runde) && this.isGegnerFigur_von_Spieler_2(runde) && this.isSchlag_gueltig(runde)) {
                this.schlageSchachfigur(runde);
            } else if(this.isBewegung_fuer_Spieler2_gueltig(runde)) {
                this.bewegeSchachfigur(runde);
            } else {
                System.out.println("Ungültiger Zug.");
                runde.setSpielzugEnde(false);
            }
        }
    }
    
    @Override
    public void bewegeSchachfigur(Spielrunde runde) {
       Position position = runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getPosition();
       int x = position.getPx();
       int y = position.getPy();
       System.out.println(position.toString());
       
       
        
    }

    public void schlageSchachfigur(Spielrunde runde,List<Schachfeld> Liste_aller_64_Schachfelder) {
      
    }

    @Override
    public void schlageSchachfigur(Spielrunde runde) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isRechtsBewegung(Spielrunde runde) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isLinksBewegung(Spielrunde runde) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isSchlag_gueltig(Spielrunde runde) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isBewegung_fuer_Spieler1_gueltig(Spielrunde runde) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isBewegung_fuer_Spieler2_gueltig(Spielrunde runde) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isNachHintenBewegung(Spielrunde runde) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isDiogonalBewegung(Spielrunde runde) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   
    
}
