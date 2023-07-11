/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import model.Feld;
import model.Position;
import model.Schachfeld;
import model.Schachfigur;
import model.Spieler;
import model.Spielfigur;
import static model.Spielfigur.getListBlack;
import static model.Spielfigur.getListBlackBauern;
import static model.Spielfigur.getListWhite;
import static model.Spielfigur.getListWhiteBauern;
import model.Spielrunde;



/**
 *
 * @author roman
 */
public class SchachField extends JFrame {

    ArrayList<Schachfigur> listeSchachfigur_des_Schachbrett = new ArrayList<>();
    List<Schachfeld> liste64_Felder_des_Schachbrett = new ArrayList<>();
    Schachfeld schachfelder = null;
    private Spielrunde runde;
    public final int MAX_REIHE = 8;
    public final int MAX_SPALTE =  8;

    private void init(Spieler spieler1, Spieler spieler2) {
        JPanel panel = new JPanel();
        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        grid.setConstraints(panel, gbc);
        panel.setLayout(grid);
        
        this.build_Schachfiguren_Liste();
        this.build_Schachbrett(gbc, panel);
        this.build_Schachbrett_with_Schachfigur();
        this.build_SchachLogik_with_Schachbrett();
        
        this.add(panel);
        this.setSize(1200, 1200);
        this.setResizable( false );
        this.setPreferredSize(getSize());
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private final void initCandas() {
        CanvasModel canvasModel = new CanvasModel();
        Canvas canvas = new Canvas(canvasModel);
        this.add(canvas, BorderLayout.CENTER);
        
    }
    
    private JLabel createLabel(JLabel label, Color c, String txt) {
        label = new JLabel(txt, SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(95, 95));
        label.setOpaque(true);
        label.setBackground(c);
        return label;
    }

    private void build_Schachbrett(GridBagConstraints gbc, JPanel panel)
    {    
        JLabel jlabel = null;
        Color color;
        
        runde = new Spielrunde(null, null, null, null, 0, false);
        for (int zeile = 0; zeile < 8; zeile++) 
        {
            int k = 65;
            boolean farbwechsel = false;
            if (zeile == 0 || zeile % 2 == 0) {
                farbwechsel = true;
            } 
            for (int spalte = 0; spalte < 8; spalte++) 
            {
                gbc.gridx = spalte;
                gbc.gridy = zeile;
                if (spalte == 0 || spalte % 2 == 0) 
                {
                    if (farbwechsel) 
                    {
                        color = Color.WHITE;
                    } else 
                    {
                        color = Color.BLACK;
                    }
                } else {
                    if (farbwechsel) 
                    {
                        color = Color.BLACK;
                    } else 
                    {
                        color = Color.WHITE;
                    }
                }
                
                if (zeile > 0) {
                    jlabel = createLabel(jlabel, color, "");
                    Feld feldobjekt = new Feld(panel, jlabel, gbc.gridx, gbc.gridy, new Position(((char) k++), (8-zeile)));
                    panel.add(jlabel, gbc);
                    schachfelder = new Schachfeld(null, feldobjekt);
                    liste64_Felder_des_Schachbrett.add(schachfelder);
                } else {
                    jlabel = createLabel(jlabel, color, "");
                    Feld feldobjekt = new Feld(panel, jlabel, gbc.gridx, gbc.gridy, new Position(((char) k++) , (8 - zeile)));
                    panel.add(jlabel, gbc);
                    schachfelder = new Schachfeld(null, feldobjekt);
                    liste64_Felder_des_Schachbrett.add(schachfelder);
                }
            }
        }
    }
    
    
    private void build_Schachbrett_with_Schachfigur() {
        for (int i = 0; i < 16; i++) {
            Schachfeld si = liste64_Felder_des_Schachbrett.get(i);
            si.setSchachfigur(listeSchachfigur_des_Schachbrett.get(i));
            JLabel spielfeld = si.getFeld().getJlabel();
            spielfeld.setText(listeSchachfigur_des_Schachbrett.get(i).getSpielfigur().getName());
        }
        for (int i = 48, j = 16; i < 64 & j < 32; i++, j++) {
            Schachfeld si = liste64_Felder_des_Schachbrett.get(i);
            si.setSchachfigur(listeSchachfigur_des_Schachbrett.get(j));
            JLabel spielfeld = si.getFeld().getJlabel();
            spielfeld.setText(listeSchachfigur_des_Schachbrett.get(j).getSpielfigur().getName());
        }
    }
    
    private void build_SchachLogik_with_Schachbrett() {
        for (Schachfeld schachfeld : liste64_Felder_des_Schachbrett) {
            JLabel spielfeld = schachfeld.getFeld().getJlabel();
            if (schachfeld.getSchachfigur() != null) {
                spielfeld.addMouseListener(new SchachLogic(schachfeld,this.runde));
            } else {
                spielfeld.addMouseListener(new SchachLogic(schachfeld,this.runde));
            }
        }
    }

    private void build_Schachfiguren_Liste() {

        ArrayList<Spielfigur> whiteA8 = getListWhite();
        ArrayList<Spielfigur> whiteBauern = getListWhiteBauern();
        ArrayList<Spielfigur> blackA2 = getListBlack();
        ArrayList<Spielfigur> blackBauern = getListBlackBauern();

        //Speieler 1
        //Erste Reihe 
        int k = 65;
        for (Spielfigur spielfigur : whiteA8) {
            Schachfigur schachfigur = new Schachfigur(spielfigur, new Position(((char) k++), 8));
            listeSchachfigur_des_Schachbrett.add(schachfigur);
        }
        k = 65;
        //Zweite Reihe Bauern
        for (Spielfigur spielfigur : whiteBauern) {
            Schachfigur schachfigur = new Schachfigur(spielfigur, new Position(((char) k++), 7));
            listeSchachfigur_des_Schachbrett.add(schachfigur);
        }
        k = 65;
        //Zweite Reihe Bauern
        for (Spielfigur spielfigur : blackBauern) {
            Schachfigur schachfigur = new Schachfigur(spielfigur, new Position(((char) k++), 2));
            listeSchachfigur_des_Schachbrett.add(schachfigur);
        }
        //Spieler 2  
        k = 65;
        for (Spielfigur spielfigur : blackA2) {
            Schachfigur schachfigur = new Schachfigur(spielfigur, new Position(((char) k++), 1));
            listeSchachfigur_des_Schachbrett.add(schachfigur);

        }
    }
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SchachField().init(null, null);
        });
    }
    
    

}
