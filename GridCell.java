import java.awt.*;
import java.util.*;

class GridCell {
  int xCod, yCod;
  Button cell;
  // GridCell neighbors[];
  ArrayList<GridCell> neighbors = new ArrayList<GridCell>();
  double g = 0, f = 0;
  double h = 0;
  GridCell pathVia = null;

  GridCell(int x, int y) {
    xCod = x;
    yCod = y;
    cell = new Button();
    cell.setBounds(x, y, 20, 20);
  }

  public void addToFrame(Frame frame) {
    frame.add(cell);
  }

  public void addNeighbor(GridCell cell) {
    neighbors.add(cell);
  }

  public void showColor(Color c) {
    cell.setBackground(c);
  }
}

class CellComparator implements Comparator<GridCell> {
  // Overriding compare()method of Comparator
  // for descending order
  public int compare(GridCell first, GridCell second) {
    if (first.f < second.f) {
      return 1;
    } else if (first.f > second.f) {
      return -1;
    }
    return 0;
  }
}