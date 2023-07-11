/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.model;

import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author roman
 */
public class Feld {
    
    private JPanel jpanel;
    private JLabel jlabel;
    private int gridx;
    private int gridy;
    private Position position;
    
    
    public Feld() {  }

    public Feld(JPanel jpanel, JLabel jlabel, int gridx, int gridy, Position position) {
        this.jpanel = jpanel;
        this.jlabel = jlabel;
        this.gridx = gridx;
        this.gridy = gridy;
        this.position = position;
        
    }

    public JPanel getJpanel() {
        return jpanel;
    }

    public void setJpanel(JPanel jpanel) {
        this.jpanel = jpanel;
    }

    public JLabel getJlabel() {
        return jlabel;
    }

    public void setJlabel(JLabel jlabel) {
        this.jlabel = jlabel;
    }

    public int getGridx() {
        return gridx;
    }

    public int getGridy() {
        return gridy;
    }

    public Position getPosition() {
        return position;
    }
    
    

    
}
