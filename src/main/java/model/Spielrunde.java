/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Color;


public class Spielrunde {
    
    private Schachfeld altes_ausgewähltes_Schachfeld;
    private Schachfeld neues_ausgewähltes_Schachfeld;
    private Color farbe_altes_Feld; 
    private Color farbe_markiertes_Feld;
    private int anzahl_Spruenge;
    private boolean spielzugEnde;

    public Spielrunde(Schachfeld altes_ausgewähltes_Schachfeld, Schachfeld neues_ausgewähltes_Schachfeld, Color farbe_altes_Feld, Color farbe_markiertes_Feld, int anzahl_Spruenge, boolean spielzugEnde) {
        this.altes_ausgewähltes_Schachfeld = altes_ausgewähltes_Schachfeld;
        this.neues_ausgewähltes_Schachfeld = neues_ausgewähltes_Schachfeld;
        this.farbe_altes_Feld = farbe_altes_Feld;
        this.farbe_markiertes_Feld = farbe_markiertes_Feld;
        this.anzahl_Spruenge = anzahl_Spruenge;
        this.spielzugEnde = spielzugEnde;
    }

    public Schachfeld getAltes_ausgewähltes_Schachfeld() {
        return altes_ausgewähltes_Schachfeld;
    }

    public void setAltes_ausgewähltes_Schachfeld(Schachfeld altes_ausgewähltes_Schachfeld) {
        this.altes_ausgewähltes_Schachfeld = altes_ausgewähltes_Schachfeld;
    }

    public Schachfeld getNeues_ausgewähltes_Schachfeld() {
        return neues_ausgewähltes_Schachfeld;
    }

    public void setNeues_ausgewähltes_Schachfeld(Schachfeld neues_ausgewähltes_Schachfeld) {
        this.neues_ausgewähltes_Schachfeld = neues_ausgewähltes_Schachfeld;
    }

    public Color getFarbe_altes_Feld() {
        return farbe_altes_Feld;
    }

    public void setFarbe_altes_Feld(Color vorher) {
        this.farbe_altes_Feld = vorher;
    }

    public Color getFarbe_markiertes_Feld() {
        return farbe_markiertes_Feld;
    }

    public void setFarbe_makiertes_Feld(Color nachher) {
        this.farbe_markiertes_Feld = nachher;
    }

    public boolean isSpielzugEnde() {
        return spielzugEnde;
    }

    public void setSpielzugEnde(boolean spielzugEnde) {
        this.spielzugEnde = spielzugEnde;
    }
    
    @Override
    public String toString() {
        return "Runde{" + "positionVorher=" + altes_ausgewähltes_Schachfeld + ", positionNachher=" + neues_ausgewähltes_Schachfeld + ", vorher=" + farbe_altes_Feld + ", nachher=" + farbe_markiertes_Feld + '}';
    }

    public int getAnzahl_Spruenge() {
        return anzahl_Spruenge;
    }

    public void setAnzahl_Spruenge(int anzahl_Spruenge) {
        this.anzahl_Spruenge = anzahl_Spruenge;
    }

    
    
    

    

    
    
    
}
