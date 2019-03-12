import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class Grid extends Frame implements ActionListener {
    int rows, cols;
    JFrame fr;
    GridCell grid[][];
    int x = 0, y = 0;
    GridCell start;
    GridCell end;
    JButton startButton;
    JButton exitButton;

    Grid() {
        fr = new JFrame();
        cols = 70;
        rows = 33;

        fr.setTitle("Grid");
        fr.setSize(1366, 768);
        fr.setLayout(null);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creating the grid
        grid = new GridCell[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                grid[i][j] = new GridCell(x, y);
                grid[i][j].addToFrame(fr);
                if (x >= 1300) {
                    x = 0;
                    y = y + 20;
                } else
                    x = x + 20;
            }
        }

        // add neighbors to the cells
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (i < cols - 1) {
                    grid[i][j].addNeighbor(grid[i + 1][j]);
                }
                if (i > 0) {
                    grid[i][j].addNeighbor(grid[i - 1][j]);
                }
                if (j < rows - 1) {
                    grid[i][j].addNeighbor(grid[i][j + 1]);
                }
                if (j > 0) {
                    grid[i][j].addNeighbor(grid[i][j - 1]);
                }
            }
        }

        startButton = new JButton("Start");
        startButton.setBounds(10, y + 10, 100, 30);
        startButton.addActionListener(this);
        fr.add(startButton);
        exitButton = new JButton("Exit");
        exitButton.setBounds(200, y + 10, 100, 30);
        exitButton.addActionListener(this);
        fr.add(exitButton);

        fr.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // A_Star();
        if (e.getSource() == startButton) {
            A_Star();
        } else if (e.getSource() == exitButton) {
            fr.dispose();
        }

    }

    public void A_Star() {
        start = grid[0][0];
        end = grid[cols - 1][rows - 1];

        Stack<GridCell> closedSet = new Stack<GridCell>();
        PriorityQueue<GridCell> openSet = new PriorityQueue<GridCell>(new CellComparator());
        // add start to the queue

        start.f = getDistance(start, end);
        openSet.add(start);

        while (!(openSet.size() == 0)) {

            GridCell current = openSet.peek();

            if (current == end) {
                System.out.println("Completed");
                System.out.println(current.xCod + "," + current.yCod);
                System.out.println("f= " + current.f);
                System.out.println("g= " + current.g);
                System.out.println("h= " + current.h);
                System.out.println("Completed");
                current.showColor(Color.black);

                return;
                // fr.dispose();

            }
            openSet.remove(current);
            closedSet.push(current);

            for (GridCell neighbor : current.neighbors) {
                if (closedSet.contains(neighbor)) {
                    // ignore
                    // this neighbor is already evaluated
                    continue;
                }

                // distance from start to neighbor
                double tentGScore = current.g + getDistance(current, neighbor);

                if (!(openSet.contains(neighbor))) {
                    openSet.add(neighbor);
                }

                if (tentGScore >= neighbor.g) {
                    continue;
                }

                // this path is the best save it!
                neighbor.pathVia = current;

                neighbor.g = tentGScore;
                neighbor.f = neighbor.g + getDistance(neighbor, end);

            }
            for (GridCell cell : closedSet) {
                cell.showColor(Color.red);
            }
            for (GridCell cell : openSet) {
                cell.showColor(Color.green);
            }

            // Stack<GridCell> path = new Stack<GridCell>();
            // GridCell temp = current;
            // path.push(temp);

            // for (GridCell cell : path) {
            // cell.showColor(Color.blue);
            // }
            // GridCell temp2 = current.pathVia;
            // while (temp != null) {
            // temp2.showColor(Color.blue);
            // temp = temp2.pathVia;
            // }

        }

    }

    public double getDistance(GridCell start, GridCell end) {

        double x = (end.xCod - start.xCod) * (end.xCod - start.xCod);
        double y = (end.yCod - start.yCod) * (end.yCod - start.yCod);
        return (double) Math.sqrt(x + y);
    }

    public void constructPath(GridCell cameFrom, GridCell currnet) {

    }
}
