/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.regeln;

import src.model.Schachfigur;
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
public class VorschauLogik {
    
    
    
    public void showZugVorschau(Schachfigur schachobjekt) {

        if (schachobjekt.getSpielfigur() instanceof Bishop) {
            int x = schachobjekt.getPosition().getPx();
            int y = schachobjekt.getPosition().getPy();

        }

        if (schachobjekt.getSpielfigur() instanceof King) {
            int x = schachobjekt.getPosition().getPx();
            int y = schachobjekt.getPosition().getPy();

        }

        if (schachobjekt.getSpielfigur() instanceof Queen) {
            int x = schachobjekt.getPosition().getPx();
            int y = schachobjekt.getPosition().getPy();

        }

        if (schachobjekt.getSpielfigur() instanceof Pawn) {
            int x = schachobjekt.getPosition().getPx();
            int y = schachobjekt.getPosition().getPy();

        }

        if (schachobjekt.getSpielfigur() instanceof Rook) {
            int x = schachobjekt.getPosition().getPx();
            int y = schachobjekt.getPosition().getPy();

        }

        if (schachobjekt.getSpielfigur() instanceof Knight) {
            int x = schachobjekt.getPosition().getPx();
            int y = schachobjekt.getPosition().getPy();

        }
        
    }
    
}
