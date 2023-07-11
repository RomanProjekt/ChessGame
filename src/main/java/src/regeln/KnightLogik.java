/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.regeln;


import src.model.Position;
import src.model.Spielrunde;
import src.schachfigur.Knight;



/**
 *
 * @author roman
 */
public class KnightLogik extends Bewegungslogik implements Regeln {
    
    protected void mache_Schachzug_fuer_Springer(Spielrunde runde) {
        Knight knight = (Knight) runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur();
        System.out.println(knight.toString());
        if (knight.getSpieler().getSpielerKennzeichen().equals("Spieler1")) {
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
        Position posNachher = runde.getNeues_ausgewähltes_Schachfeld().getFeld().getPosition();
    }
    
    @Override
    public void schlageSchachfigur(Spielrunde runde) {
        
    }
    
    @Override
    public boolean isSchlag_gueltig(Spielrunde runde) {
        return isLinksBewegung(runde) || isRechtsBewegung(runde) || isNachHintenBewegung(runde) || isNachHintenBewegung(runde);
    }

    @Override
    public boolean isLinksBewegung(Spielrunde runde) {
        Position posVorher = runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getPosition();
        Position posNachher = runde.getNeues_ausgewähltes_Schachfeld().getFeld().getPosition();
        
        return false;
    }

    @Override
    public boolean isRechtsBewegung(Spielrunde runde) {
        Position posVorher = runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getPosition();
        Position posNachher = runde.getNeues_ausgewähltes_Schachfeld().getFeld().getPosition();
        
        if(runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur().getBewegungslogik().isGegnerFigur_von_Spieler_1(runde)) {
            //Links
        }
        else if(runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur().getBewegungslogik().isGegnerFigur_von_Spieler_2(runde)) {
            //Rechts
            posVorher.setPx(((char) (Integer.valueOf(posVorher.getPx())+1)));
        }
        return false;
    }

    @Override
    public boolean isNachHintenBewegung(Spielrunde runde) {
        Position posVorher = runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getPosition();
        Position posNachher = runde.getNeues_ausgewähltes_Schachfeld().getFeld().getPosition();
        return true;
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
    public boolean isDiogonalBewegung(Spielrunde runde) {
        return false;
    }
    
}
