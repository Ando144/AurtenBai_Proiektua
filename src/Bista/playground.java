package src.Bista;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class playground extends JFrame {

    private JPanel panel;

    public playground() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 800, 600);
        this.add(panel);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new playground();
    }
}
