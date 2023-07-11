/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.regeln;

import src.model.Position;
import src.model.Schachfeld;
import src.model.Schachfigur;
import src.model.Spielrunde;
import src.schachfigur.Pawn;




public class PawnLogik extends Bewegungslogik implements Regeln {
    
    protected void mache_Schachzug_fuer_Bauer(Spielrunde runde) {
        Pawn bauer = (Pawn) runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur();
        System.out.println(bauer.toString());
        if (bauer.getSpieler().getSpielerKennzeichen().equals("Spieler1")) {
            if (this.isFigurVorhanden_Auf_Dem_Feld(runde)
                    && this.isGegnerFigur_von_Spieler_1(runde) && this.isSchlag_gueltig(runde)) {
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
        if (runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur().getSpieler().getSpielerKennzeichen().equals("Spieler1")) {
            walk_Pawn(runde);
        } else if (runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur().getSpieler().getSpielerKennzeichen().equals("Spieler2")) {
            walk_Pawn(runde);
        }
    }
    
    private void walk_Pawn(Spielrunde runde) {
        Schachfigur schachfigur_vorher = runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur();
        
        int neuesY = schachfigur_vorher.getPosition().getPy() + runde.getAnzahl_Spruenge();
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
    public void schlageSchachfigur(Spielrunde runde) {
        //Prüfe, ob der Zug richtig ist?
        runde.getNeues_ausgewähltes_Schachfeld().setSchachfigur(null);
        Schachfeld nachher = runde.getNeues_ausgewähltes_Schachfeld();
        nachher.setSchachfigur(runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur());
        System.out.println(runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur());
        System.out.println(runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur().getFarbe());
        runde.setSpielzugEnde(true);
    }
    
    @Override
    public boolean isSchlag_gueltig(Spielrunde runde) {
        
        Position posNach = runde.getNeues_ausgewähltes_Schachfeld().getSchachfigur().getPosition();
        Position posVor = runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getPosition();
        
        char posX_SchlageRechts = ((char) (Integer.valueOf(posVor.getPx())-1));
        int posY_SchlageRechts = posVor.getPy()-1;
        Position position_SchlageRechts = new Position(posX_SchlageRechts, posY_SchlageRechts);
        
        char posX_SchlageLinks = ((char) (Integer.valueOf(posVor.getPx())+1));
        int posY_SchlageLinks = posVor.getPy()-1;
        Position position_SchlageLinks = new Position(posX_SchlageLinks, posY_SchlageLinks);
        runde.setSpielzugEnde(true);
        
        return position_SchlageRechts.equals(posNach) || position_SchlageLinks.equals(posNach);
    }
    
    @Override
    public boolean isBewegung_fuer_Spieler1_gueltig(Spielrunde runde) {
        Position posNach = runde.getNeues_ausgewähltes_Schachfeld().getFeld().getPosition();
        Position posVor = runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getPosition();
        
        char posX_regelkonformer_Zug = posVor.getPx();
        int posY_regelkonformer_Zug = posVor.getPy()-1;
        Position position_regelkonformer_Zug = new Position(posX_regelkonformer_Zug, posY_regelkonformer_Zug);
        return  (posNach.getPx() == position_regelkonformer_Zug.getPx()) &&  (posNach.getPy() == position_regelkonformer_Zug.getPy());
    }
    
    @Override
    public boolean isBewegung_fuer_Spieler2_gueltig(Spielrunde runde) {
        Position posNach = runde.getNeues_ausgewähltes_Schachfeld().getFeld().getPosition();
        Position posVor = runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getPosition();
        
        char posX_regelkonformer_Zug = posVor.getPx();
        int posY_regelkonformer_Zug = posVor.getPy()+1;
        Position position_regelkonformer_Zug = new Position(posX_regelkonformer_Zug, posY_regelkonformer_Zug);
        return  (posNach.getPx() == position_regelkonformer_Zug.getPx()) &&  (posNach.getPy() == position_regelkonformer_Zug.getPy());
    }
    
    @Override
    public boolean isRechtsBewegung(Spielrunde runde) {
        char posX_neu = 0;
        Position posVorher = runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getPosition();
        Position posNachher = runde.getNeues_ausgewähltes_Schachfeld().getFeld().getPosition();
        if (runde.getNeues_ausgewähltes_Schachfeld().getSchachfigur() == null 
                || runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur().getBewegungslogik().isGegnerFigur_von_Spieler_1(runde)) {
            //Links
            posX_neu = (((char) (Integer.valueOf(posVorher.getPx()) - 1)));
        } else if (runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur().getBewegungslogik().isGegnerFigur_von_Spieler_2(runde)) {
            //Rechts
            posX_neu = (((char) (Integer.valueOf(posVorher.getPx()) + 1)));
        }
        return (posX_neu == posNachher.getPx()) && (posVorher.getPy() == posNachher.getPy());
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
    public boolean isLinksBewegung(Spielrunde runde) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isDiogonalBewegung(Spielrunde runde) {
        return false;
    }
    
    
    
}
