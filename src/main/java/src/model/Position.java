package src.model;

public class Position {

    private char px;
    private int py;

    public Position(char px, int py) {
        this.px = px;
        this.py = py;
    }

    public char getPx() {
        return px;
    }

    public void setPx(char px) {
        this.px = px;
    }

    public int getPy() {
        return py;
    }

    public void setPy(int py) {
        this.py = py;
    }

    @Override
    public String toString() {
        return "Position{" + "px=" + px + ", py=" + py + '}';
    }

}
