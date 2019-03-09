import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class Grid extends Frame implements ActionListener {
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
        start.addActionListener(this);
        fr.add(start);

        fr.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // System.out.print("start pressed");
    }

    public void A_Star() {
        GridCell start = cells[0][0];
        GridCell end = cells[cols - 1][rows - 1];

        // GridCell openSet[]= new GridCell[100];
        // ArrayList<GridCell>

        while (true) {

        }

    }

}

class DisplayFrame {
    public static void main(String[] args) {
        Grid g1 = new Grid();
    }
}