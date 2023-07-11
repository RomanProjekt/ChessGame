/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.regeln;

import src.model.Position;
import src.model.Schachfigur;
import src.model.Spielrunde;
import src.schachfigur.King;



/**
 *
 * @author roman
 */
public class KingLogik extends Bewegungslogik implements Regeln {

   
    
    public void mache_Schachzug_für_König(Spielrunde runde) {
        King king = (King) runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur();
        System.out.println(king.toString());
        
        runde.setAnzahl_Spruenge(0);
        
        if (king.getSpieler().getSpielerKennzeichen().equals("Spieler1")) {
            if (this.isFigurVorhanden_Auf_Dem_Feld(runde))  {
                if (this.isGegnerFigur_von_Spieler_1(runde) && this.isSchlag_gueltig(runde)) {
                    this.schlageSchachfigur(runde);
                }
            } else if (this.isBewegung_fuer_Spieler1_gueltig(runde)) {
                bewegeSchachfigur(runde);
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
       
       if(isRechtsBewegung(runde)) {
           System.out.println("Rechts");
       }
       else if(isLinksBewegung(runde)) {
           System.out.println("Links");
           
       }
       else if (isNachVorneBewegung(runde)) {
           System.out.println("Vorne");
           if (runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur().getSpieler().getSpielerKennzeichen().equals("Spieler1")) {
               bewegeSchachFigur(runde, -1);
           } else if (runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur().getSpieler().getSpielerKennzeichen().equals("Spieler2")) {
               bewegeSchachFigur(runde, 1);
           }
       }
       else if(isNachHintenBewegung(runde)) {
           System.out.println("Hinten");
           
       }
       else {
           System.out.println("Ungülter Zug!");
       }
    }
    
    
    //Todo: List kann man entfernen nur zu überpfrüfen ob die Liste richtig war 
    private void bewegeSchachFigur(Spielrunde runde, int r) {
        //Neue Position der Schachfigur
        Schachfigur schachfigur_vorher = runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur();
        int neuesY = schachfigur_vorher.getPosition().getPy() + r;
        schachfigur_vorher.getPosition().setPy(neuesY);
        
        runde.getNeues_ausgewähltes_Schachfeld().getFeld().getJlabel().setBackground(runde.getFarbe_markiertes_Feld());
        runde.getNeues_ausgewähltes_Schachfeld().setSchachfigur(schachfigur_vorher);
        runde.getNeues_ausgewähltes_Schachfeld().getFeld().getJlabel().setText(schachfigur_vorher.getSpielfigur().getName());
        
        //Zum Schluss löschen von SchachbrettObjekt => null
        runde.getAltes_ausgewähltes_Schachfeld().setSchachfigur(null);
        runde.getAltes_ausgewähltes_Schachfeld().getFeld().getJlabel().setBackground(runde.getFarbe_altes_Feld());
        runde.getAltes_ausgewähltes_Schachfeld().getFeld().getJlabel().setText(" ");
        
        runde.setAltes_ausgewähltes_Schachfeld(null);
        runde.setNeues_ausgewähltes_Schachfeld(null);
        runde.setFarbe_altes_Feld(null);
        runde.setFarbe_makiertes_Feld(null);
        runde.setSpielzugEnde(true);
        
        System.out.println();
        System.out.println("-----------------------");
    }

    
    @Override
    public void schlageSchachfigur(Spielrunde Runde) {
       
    }
    
    @Override
    public boolean isBewegung_fuer_Spieler1_gueltig(Spielrunde runde) {
        return isRechtsBewegung(runde) || isLinksBewegung(runde) || isNachVorneBewegung(runde) || isNachHintenBewegung(runde);
    }
    
    @Override
    public boolean isLinksBewegung(Spielrunde runde) {
        return super.isLinksBewegung_fuer_Spieler1_gueltig(runde);
    }
    
    @Override
    public boolean isRechtsBewegung(Spielrunde runde) {
        return super.isRechtsBewegung(runde);
    }

    
    @Override
    protected boolean isNachVorneBewegung(Spielrunde runde) {
        Position posVorher = runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getPosition();
        Position posNachher = runde.getNeues_ausgewähltes_Schachfeld().getFeld().getPosition();
        if(runde.getNeues_ausgewähltes_Schachfeld().getSchachfigur() == null 
                || runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur().getBewegungslogik().isGegnerFigur_von_Spieler_1(runde)) {
            //X bleibt gleich // Y = -1
            int posY_neu = posVorher.getPy() - 1;
            return posVorher.getPx() == posNachher.getPx() && posY_neu == posNachher.getPy();
           
        }
        else if(runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur().getBewegungslogik().isGegnerFigur_von_Spieler_2(runde)) {
            int posX_neu = posVorher.getPy() + 1;
            return posVorher.getPx() == posNachher.getPx() && posX_neu == posNachher.getPy();
        }
        return false;
    }
    
    @Override
    public boolean isNachHintenBewegung(Spielrunde runde) {
        Position posVorher = runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getPosition();
        Position posNachher = runde.getNeues_ausgewähltes_Schachfeld().getFeld().getPosition();
        
        if(runde.getNeues_ausgewähltes_Schachfeld().getSchachfigur() == null 
                || runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur().getBewegungslogik().isGegnerFigur_von_Spieler_1(runde)) {
            //X bleibt gleich // Y = -1
            int posY_neu = posVorher.getPy() + 1;
            return posVorher.getPx() == posNachher.getPx() && posY_neu == posNachher.getPy();
        }
        else if(runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur().getBewegungslogik().isGegnerFigur_von_Spieler_2(runde)) {
            int posY_neu = posVorher.getPy() - 1;
            return posVorher.getPx() == posNachher.getPx() && posY_neu == posNachher.getPy();
        }
        return false;
    }

    @Override
    public boolean isBewegung_fuer_Spieler2_gueltig(Spielrunde runde) {
       return false;
    }

    @Override
    public boolean isSchlag_gueltig(Spielrunde runde) {
        return false;
    }

    @Override
    public boolean isDiogonalBewegung(Spielrunde runde) {
        return false;
    }
    
   
    
    
}
