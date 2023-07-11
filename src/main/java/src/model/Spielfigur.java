/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.ImageIcon;
import src.regeln.Bewegungslogik;
import src.regeln.BishopLogik;
import src.regeln.KingLogik;
import src.regeln.KnightLogik;
import src.regeln.PawnLogik;
import src.regeln.QueenLogik;
import src.regeln.RookLogik;
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
public class Spielfigur  {

    private String name;
    private final Spieler spieler;
    private final Color farbe;
    private ImageIcon icon;
    private Bewegungslogik bewegungslogik;

    public Spielfigur(String name, Color farbe, Spieler spieler, ImageIcon icon, Bewegungslogik bewegungslogik) {
        this.name = name;
        this.farbe = farbe;
        this.spieler = spieler;
        this.icon = icon;
        this.bewegungslogik = bewegungslogik;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Spieler getSpieler() {
        return spieler;
    }

    public Color getFarbe() {
        return farbe;
    }

    public ImageIcon getIcon() {
        return icon;
    }
    
    

    @Override
    public String toString() {
        return "Schachfigur{" + "name=" + name + ", spieler=" + spieler + ", farbe=" + farbe + '}';
    }

    public ImageIcon getImage(String pfad) {
        return new ImageIcon(pfad);
    }

    public Bewegungslogik getBewegungslogik() {
        return bewegungslogik;
    }

    public void setBewegungslogik(Bewegungslogik bewegungslogik) {
        this.bewegungslogik = bewegungslogik;
    }
    
    
    
   
    
    public static ArrayList<Spielfigur> getListWhite() {
        ArrayList<Spielfigur> liste = new ArrayList<>();
        Spieler spieler1 = new Spieler(0, "" , "Spieler1");
        Rook turmA8 = new Rook("Turm", Color.WHITE, spieler1, new ImageIcon("\\king_white.png"), new RookLogik());
        liste.add(turmA8);
        Bishop läuferB8 = new Bishop("Läufer", Color.WHITE, spieler1, new ImageIcon("\\king_white.png"), new BishopLogik());
        liste.add(läuferB8);
        Knight springerC8 = new Knight("Springer", Color.WHITE, spieler1, new ImageIcon("\\king_white.png"), new KnightLogik());
        liste.add(springerC8);
        Queen dame = new Queen("Dame", Color.WHITE, spieler1, new ImageIcon("\\king_white.png"),new QueenLogik());
        liste.add(dame);
        King könig = new King("König", Color.WHITE, spieler1, new ImageIcon("\\king_white.png"), new KingLogik());
        liste.add(könig);
        Bishop läuferF8 = new Bishop("Läufer", Color.WHITE, spieler1, new ImageIcon("\\king_white.png"),new BishopLogik());
        liste.add(läuferF8);
        Knight springerG8 = new Knight("Spring", Color.WHITE, spieler1, new ImageIcon("\\king_white.png"), new KnightLogik());
        liste.add(springerG8);
        Rook turmH8 = new Rook("Turm", Color.WHITE, spieler1, new ImageIcon("\\king_white.png"), new RookLogik());
        liste.add(turmH8);

        return liste;
    }

    public static ArrayList<Spielfigur> getListWhiteBauern() {
        Spieler spieler1 = new Spieler(0, "", "Spieler1");
        ArrayList<Spielfigur> liste = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            Pawn bauer = new Pawn("Bauer", Color.WHITE, spieler1, new ImageIcon("\\king_white.png"), new PawnLogik());
            liste.add(bauer);
        }
        return liste;
    }
    
    public static List<Spielfigur> getListe_Gesamten_Weiße_Schachfiguren() {
        return Stream.of(
                getListWhite(), 
                getListWhiteBauern())
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
    }
    
    public static List<Spielfigur> getListe_Gesamten_Schwarze_Schachfiguren() {
        return Stream.of(
                getListBlackBauern(),
                getListBlack())
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
    }
    
    public static List<Spielfigur> getListe_Gesamten__Schachfiguren() {
        return Stream.of(
                getListe_Gesamten_Weiße_Schachfiguren(), 
                getListe_Gesamten_Schwarze_Schachfiguren())
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
    }  

    public static ArrayList<Spielfigur> getListBlack() {
        ArrayList<Spielfigur> liste = new ArrayList<>();
        Spieler spieler2 = new Spieler(0, "", "Spieler2");
        Rook turmA8 = new Rook("Turm", Color.BLACK, spieler2, new ImageIcon("\\king_white.png"), new RookLogik());
        liste.add(turmA8);
        Bishop läuferB8 = new Bishop("Läufer", Color.BLACK, spieler2, new ImageIcon("\\king_white.png"), new BishopLogik());
        liste.add(läuferB8);
        Knight springerC8 = new Knight("Springer", Color.BLACK, spieler2, new ImageIcon("\\king_white.png"), new KnightLogik());
        liste.add(springerC8);
        Queen dame = new Queen("Dame", Color.BLACK, spieler2, new ImageIcon("\\king_white.png"), new QueenLogik());
        liste.add(dame);
        King könig = new King("König", Color.BLACK, spieler2, new ImageIcon("\\king_black.png"), new KingLogik());
        liste.add(könig);
        Knight läuferF8 = new Knight("Läufer", Color.BLACK, spieler2, new ImageIcon("\\king_white.png"), new KnightLogik());
        liste.add(läuferF8);
        Bishop springerG8 = new Bishop("Springer", Color.BLACK, spieler2, new ImageIcon("\\king_white.png"), new BishopLogik());
        liste.add(springerG8);
        Rook turmH8 = new Rook("Turm", Color.BLACK, spieler2, new ImageIcon("\\king_white.png"), new RookLogik());
        liste.add(turmH8);
        return liste;
    }

    public static ArrayList<Spielfigur> getListBlackBauern() {
        Spieler spieler2 = new Spieler(0, "", "Spieler2");
        ArrayList<Spielfigur> liste = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            Pawn bauer = new Pawn("Bauer", Color.BLACK, spieler2, new ImageIcon("\\king_white.png"), new PawnLogik());
            liste.add(bauer);
        }
        return liste;
    }


}
