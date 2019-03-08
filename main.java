import java.awt.*;
import javax.swing.*;

class Grid extends Frame {
    int rows, cols;
    Button but[][];
    int x = 0, y = 0;

    Grid() {
        JFrame fr = new JFrame();
        // Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // int width = (int) screenSize.getWidth();
        // int height = (int) screenSize.getHeight();
        cols = 70;
        rows = 33;

        fr.setTitle("Grid");
        fr.setSize(1366, 768);
        fr.setLayout(null);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        but = new Button[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                but[i][j] = new Button();
                but[i][j].setBounds(x, y, 20, 20);
                fr.add(but[i][j]);
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