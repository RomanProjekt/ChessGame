/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.regeln;

import src.model.Spielrunde;



/**
 *
 * @author roman
 */
public interface Regeln {
    
   
    public void bewegeSchachfigur(Spielrunde runde);
    public void schlageSchachfigur(Spielrunde runde);
    //public boolean isRechtsBewegung(Spielrunde runde);
    public boolean isLinksBewegung(Spielrunde runde);
    public boolean isNachHintenBewegung(Spielrunde runde);
    public boolean isDiogonalBewegung(Spielrunde runde);
    
    
    public boolean isSchlag_gueltig(Spielrunde runde);
    public boolean isBewegung_fuer_Spieler1_gueltig(Spielrunde runde);
    public boolean isBewegung_fuer_Spieler2_gueltig(Spielrunde runde);
}
