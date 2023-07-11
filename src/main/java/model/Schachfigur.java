/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;




public class Schachfigur {
    
    private Spielfigur spielefigur;
    private Position position;
   
   

//    public Schachfigur(Spielfigur spielefigur, Position position) {
//        super(spielefigur.getName(), spielefigur.getFarbe(), spielefigur.getSpieler(), spielefigur.getIcon());
//        this.spielefigur = spielefigur;
//        this.position = position;
//    }

    public Schachfigur(Spielfigur spielefigur, Position position) {
        this.spielefigur = spielefigur;
        this.position = position;
       
    }

    public Spielfigur getSpielfigur() {
        return spielefigur;
    }

    public void setSpielfigur(Spielfigur spielfigur) {
        this.spielefigur = spielfigur;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Schachbrett{" + "schachfigur=" + spielefigur + ", position=" + position.getPx() + " " + position.getPy() + " " +  "}";  
    }
    
}
