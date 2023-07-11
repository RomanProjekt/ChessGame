/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.model;
/**
 *
 * @author roman
 */
public class Spieler {
    
    private int id;
    private String name;
    private final String spielerKennzeichen;

    public Spieler(int id, String name, String spielerKennzeichen) {
        this.id = id;
        this.name = name;
        this.spielerKennzeichen = spielerKennzeichen;
    }
    
    
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpielerKennzeichen() {
        return spielerKennzeichen;
    }
    
    
    
}
