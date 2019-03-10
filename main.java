import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Grid extends Frame implements ActionListener {
    int rows, cols;
    GridCell cells[][];
    int x = 0, y = 0;
    GridCell start;
    GridCell end;

    Grid() {
        JFrame fr = new JFrame();
        cols = 70;
        rows = 33;

        fr.setTitle("Grid");
        fr.setSize(1366, 768);
        fr.setLayout(null);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creating the grid
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
        A_Star();
    }

    public void A_Star() {
        start = cells[0][0];
        end = cells[cols - 1][rows - 1];

    }

    public int getH(GridCell start, GridCell end) {

        int x = (end.xCod - start.xCod) * (end.xCod - start.xCod);
        int y = (end.yCod - start.yCod) * (end.yCod - start.yCod);
        return (int) Math.sqrt(x + y);
    }
}
