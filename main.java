import java.awt.*;
import javax.swing.*;

class Grid extends Frame {
    int rows, cols;
    GridCell cells[][];
    int x = 0, y = 0;

    Grid() {
        JFrame fr = new JFrame();
        cols = 70;
        rows = 33;

        fr.setTitle("Grid");
        fr.setSize(1366, 768);
        fr.setLayout(null);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cells = new GridCell[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                cells[i][j] = new GridCell(x, y);
                cells[i][j].addToFrame(fr);
                if (x >= 1300) {
                    x = 0;
                    y = y + 20;
                } else
                    x = x + 20;
            }
        }

        JButton start = new JButton("Start");
        start.setBounds(10, y + 10, 100, 30);
        fr.add(start);

        fr.setVisible(true);
    }
}

class DisplayFrame {
    public static void main(String[] args) {
        Grid g1 = new Grid();
    }
}