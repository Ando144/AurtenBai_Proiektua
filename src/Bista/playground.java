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
        /*Esto sirve para crear todo, en hasieratu de vista hay que llamar aqui para crear todo lo referido a la vista
         * y luego despues de hasieratuarlo llamar a en vista a la funcion que actualiza la vista y punto (EXPLICADO POR GAIZKA: Todas las dudas a el).
         */
    }

    public static void main(String[] args) {
        new playground();
    }
}
