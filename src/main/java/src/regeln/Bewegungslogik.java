package src.regeln;

import java.awt.Color;
import src.model.Position;
import src.model.Spielfigur;
import src.model.Spielrunde;
import src.schachfigur.Bishop;
import src.schachfigur.King;
import src.schachfigur.Knight;
import src.schachfigur.Pawn;
import src.schachfigur.Queen;
import src.schachfigur.Rook;


/**
 *
 * @author roman
 */
public class Bewegungslogik  {
    
    public boolean isFigurVorhanden_Auf_Dem_Feld(Spielrunde runde) {
        return runde.getNeues_ausgewähltes_Schachfeld().getSchachfigur() != null;
    }
    
    public Spielfigur getSchachfigur_Nachher(Spielrunde runde) {
        return runde.getNeues_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur();
    }

    public boolean isGegnerFigur_von_Spieler_1(Spielrunde runde) {
        return getSchachfigur_Nachher(runde).getFarbe().equals(Color.BLACK);
    }
    
    public boolean isGegnerFigur_von_Spieler_2(Spielrunde runde) {
        return getSchachfigur_Nachher(runde).getFarbe().equals(Color.WHITE);
    }
    
    
    
    //todo: entscheidung, ob links/rechtsbewegung für spieler getrennt wird???
    
    public boolean isLinksBewegung_fuer_Spieler1_gueltig(Spielrunde runde) {
        Position posVorher = runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getPosition();
        Position posNachher =  runde.getNeues_ausgewähltes_Schachfeld().getFeld().getPosition();
        
        if(runde.getNeues_ausgewähltes_Schachfeld().getSchachfigur() == null || runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur().getBewegungslogik().isGegnerFigur_von_Spieler_1(runde)) {
            //Rechts
            char posX_neu = (((char) (Integer.valueOf(posVorher.getPx()) + runde.getAnzahl_Spruenge())));
            return posX_neu == posNachher.getPx() && posVorher.getPy() == posNachher.getPy();
        }
        else if(runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur().getBewegungslogik().isGegnerFigur_von_Spieler_2(runde)) {
            //Links
            char posX_neu = (((char) (Integer.valueOf(posVorher.getPx()) - runde.getAnzahl_Spruenge())));
            return (posX_neu == posNachher.getPx()) && (posVorher.getPy() == posNachher.getPy());
        }
        return false;
    }
    
    
    
    
    
    
    protected boolean isRechtsBewegung(Spielrunde runde) {
        
        char posX_neu = 0;
        Position posVorher = runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getPosition();
        Position posNachher = runde.getNeues_ausgewähltes_Schachfeld().getFeld().getPosition();
        if(runde.getNeues_ausgewähltes_Schachfeld().getSchachfigur() == null || runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur().getBewegungslogik().isGegnerFigur_von_Spieler_1(runde)) {
            //Links
            posX_neu = (((char) (Integer.valueOf(posVorher.getPx()) - runde.getAnzahl_Spruenge())));
        }
        else if(runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur().getBewegungslogik().isGegnerFigur_von_Spieler_2(runde)) {
            //Rechts
            posX_neu = (((char) (Integer.valueOf(posVorher.getPx()) + runde.getAnzahl_Spruenge())));
        }
        return (posX_neu == posNachher.getPx()) && (posVorher.getPy() == posNachher.getPy());
    }
    
          
    protected boolean isNachVorneBewegung(Spielrunde runde) {
        Position posVorher = runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getPosition();
        Position posNachher = runde.getNeues_ausgewähltes_Schachfeld().getFeld().getPosition();
        if(runde.getNeues_ausgewähltes_Schachfeld().getSchachfigur() == null 
                || runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur().getBewegungslogik().isGegnerFigur_von_Spieler_1(runde)) {
            //X bleibt gleich // Y = -1
            int posY_neu = posVorher.getPy() - runde.getAnzahl_Spruenge();
            return posVorher.getPx() == posNachher.getPx() && posY_neu == posNachher.getPy();
           
        }
        else if(runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur().getBewegungslogik().isGegnerFigur_von_Spieler_2(runde)) {
            int posX_neu = posVorher.getPy() + runde.getAnzahl_Spruenge();
            return posVorher.getPx() == posNachher.getPx() && posX_neu == posNachher.getPy();
        }
        return false;
    }    



    public void mache_Schachzug(Spielrunde runde) {
        Spielfigur spielfigur = runde.getAltes_ausgewähltes_Schachfeld().getSchachfigur().getSpielfigur();
        if (spielfigur.getName().compareTo("Bauer") == 0) {
            Pawn bauer = (Pawn) spielfigur;
            PawnLogik bauerLogik = (PawnLogik) bauer.getBewegungslogik();
            bauerLogik.mache_Schachzug_fuer_Bauer(runde);
        }
        if (runde.getAltes_ausgewähltes_Schachfeld() != null && spielfigur.getName().compareTo("König") == 0) {
            System.out.println(spielfigur.getName());
            King king = (King) spielfigur;
            KingLogik kinglogik = (KingLogik) king.getBewegungslogik();
            
            
            //Todo: Berechnung der möglichen Bewegung am Feld
            
            
           
            
            
            kinglogik.mache_Schachzug_für_König(runde);
        }
        if (runde.getAltes_ausgewähltes_Schachfeld() != null && spielfigur.getName().compareTo("Dame") == 0) {
            System.out.println(spielfigur.getName());
            Queen queen = (Queen) spielfigur;
            QueenLogik queenLogik = (QueenLogik) queen.getBewegungslogik();
            System.out.println(queen.toString());
            queenLogik.mache_Schachzug_fuer_Dame(runde);
        }
        if (runde.getAltes_ausgewähltes_Schachfeld() != null && spielfigur.getName().compareTo("Springer") == 0) {
            System.out.println(spielfigur.getName());
            Knight knight = (Knight) spielfigur;
            System.out.println(knight.toString());
            KnightLogik knightLogik = (KnightLogik) knight.getBewegungslogik();
            knightLogik.mache_Schachzug_fuer_Springer(runde);
        }
        if (runde.getAltes_ausgewähltes_Schachfeld() != null && spielfigur.getName().compareTo("Läufer") == 0) {
            System.out.println(spielfigur.getName());
            Bishop bishop = (Bishop) spielfigur;
            System.out.println(bishop.toString());
            BishopLogik bishopLogik = (BishopLogik) bishop.getBewegungslogik();
            bishopLogik.mache_Schachzug_fuer_Bishop(runde);

        }
        if (runde.getAltes_ausgewähltes_Schachfeld() != null && spielfigur.getName().compareTo("Turm") == 0) {
            System.out.println(spielfigur.getName());
            Rook rook = (Rook) spielfigur;
            System.out.println(rook.toString());
            RookLogik rookLogic = (RookLogik) rook.getBewegungslogik();
            rookLogic.mache_Schachzug_fuer_Rook(runde);

        }
    }    
    
    
    
    

    
}
