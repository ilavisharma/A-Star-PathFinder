import java.awt.*;

class GridCell {
  int xCod, yCod;
  Button cell;
  GridCell neighbors[];

  GridCell(int x, int y) {
    xCod = x;
    yCod = y;
    cell = new Button();
    cell.setBounds(x, y, 20, 20);
  }

  public void addToFrame(Frame frame) {
    frame.add(cell);
  }

  public void addNeighbor(GridCell cells[][]) {

  }

  public void showColor(Color c) {
    cell.setBackground(c);
  }
}