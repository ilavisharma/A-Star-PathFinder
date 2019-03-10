import java.awt.*;

class GridCell {
  int xCod, yCod;
  Button cell;
  GridCell neighbors[];
  int f, g;
  double h;

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