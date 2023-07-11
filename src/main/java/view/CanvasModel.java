/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author roman
 */
public class CanvasModel extends Observable {
    
    private List<CanvasWidget> widgetList = new ArrayList<CanvasWidget>();

    public void add(CanvasWidget widget) {
        widgetList.add(widget);
        notifyModelChanged();
    }

    public void remove(CanvasWidget widget) {
        widgetList.remove(widget);
        notifyModelChanged();
    }

    public List<CanvasWidget> getWidgetList() {
        return widgetList;
    }

    public CanvasWidget getWidgetAt(Point p) {
        for (CanvasWidget widget : widgetList) {
            if (widget.getBounds().contains(p)) {
                return widget;
            }
        }
        return null;
    }

    public void notifyModelChanged() {
        setChanged();
        notifyObservers();
    }

}
