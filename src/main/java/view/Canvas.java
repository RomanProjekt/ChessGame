/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Graphics;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;




/**
 *
 * @author roman
 */
public class Canvas extends JPanel implements Observer {

    CanvasModel canvasModel;
    List<CanvasWidget> widgetList = null;

    public Canvas(CanvasModel canvasModel) {
        this.canvasModel = canvasModel;
        canvasModel.addObserver(this);
    }

    @Override
    protected void paintChildren(Graphics g) {
        for (CanvasWidget widget : canvasModel.getWidgetList()) {
            widget.paint(g);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        repaint();
    }

    public CanvasModel getCanvasModel() {
        return canvasModel;
    }

}
