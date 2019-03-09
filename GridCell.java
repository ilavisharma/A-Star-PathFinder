import java.awt.*;

class GridCell {
    int xCod, yCod;
    Button cell;

    GridCell(int x, int y) {
        xCod = x;
        yCod = y;
        cell = new Button();
        cell.setBounds(x, y, 20, 20);
    }

    public void addToFrame(Frame frame) {
        frame.add(cell);
    }
}