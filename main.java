import java.awt.*;
import javax.swing.*;

class Grid extends Frame {
    Button but[] = new Button[300];
    int x = 0, y = 0, z = 1;

    Grid() {
        JFrame fr = new JFrame();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        fr.setTitle("Grid");
        fr.setSize(500, 500);
        fr.setLayout(null);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        for (int i = 0; i < but.length; i++) {
            but[i] = new Button();
            but[i].setBounds(x, y, 20, 20);
            fr.add(but[i]);

            if (x >= width) {
                x = 0;

            }
        }

        fr.setVisible(true);
    }
}

class DisplayFrame {
    public static void main(String[] args) {
        Grid g1 = new Grid();
    }
}