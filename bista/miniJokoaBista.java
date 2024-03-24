import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;



public class miniJokoaBista {
    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JLabel label;

    public void main(String[] args) {
        
    }    
    public void hasieratu()
    {
        frame = new JFrame("Mini Jokoa");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panelakSortu();
    }
    public void panelakSortu()
    {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                panels[i][j] = new JPanel(); // Crear un nuevo panel
                panels[i][j].setBackground(getColor(laukiak[i][j])); // Establecer el color del panel según la fuerza
                panels[i][j].addMouseListener(new CustomMouseListener(i, j)); // Agregar un listener de eventos de ratón al panel
                frame.add(panels[i][j]); // Agregar el panel a la ventana
            }
    }
}
