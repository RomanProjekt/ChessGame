package model;


/**
 *
 * @author roman
 */
public class Schachfeld {
    
    private Schachfigur schachfigur;
    private Feld feld;

    public Schachfeld(Schachfigur schachfigur, Feld feld) {
        this.schachfigur = schachfigur;
        this.feld = feld;
    }

    public Schachfigur getSchachfigur() {
        return schachfigur;
    }

    public void setSchachfigur(Schachfigur schachfigur) {
        this.schachfigur = schachfigur;
    }

    @Override
    public String toString() {
        return "Schachbrett{" + "object=" + schachfigur + ", Feldeigenschaft=" + feld + '}';
    }

    public Feld getFeld() {
        return feld;
    }
    
    
    
    

    

   
    
    
}
