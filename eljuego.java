import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class proba {
    private static final int SIZE = 10;
    private static final int MAX_STRENGTH = 3;

    private static int[][] strengths = new int[SIZE][SIZE];
    private static JPanel[][] panels = new JPanel[SIZE][SIZE];

    public static void main(String[] args) {
        JFrame frame = new JFrame("Matrix");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(SIZE, SIZE));

        initializeStrengths();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                panels[i][j] = new JPanel();
                panels[i][j].setBackground(getColor(strengths[i][j]));
                panels[i][j].addMouseListener(new CustomMouseListener(i, j));
                frame.add(panels[i][j]);
            }
        }

        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    private static void initializeStrengths() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                strengths[i][j] = (int) (Math.random() * MAX_STRENGTH) + 1;
            }
        }
    }

    private static Color getColor(int strength) {
        switch (strength) {
            case 1:
                return Color.RED;
            case 2:
                return Color.GREEN;
            case 3:
                return Color.BLUE;
            default:
                return Color.WHITE;
        }
    }

    private static class CustomMouseListener extends MouseAdapter {
        private int row;
        private int col;

        public CustomMouseListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (strengths[row][col] > 0) {
                strengths[row][col]--;
                panels[row][col].setBackground(getColor(strengths[row][col]));
            }
        }
    }
}
