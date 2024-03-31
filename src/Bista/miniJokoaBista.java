package src.Bista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import src.Eredua.Minijokoa;
import java.util.Observer;
import java.util.Observable;
import java.awt.Color;



public class miniJokoaBista implements Observer{
    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JLabel label;
    private JLabel laukiak[][];
    private JLabel Tamagochi;
    private int x;
    private int y;


    public miniJokoaBista (Observable pMinijokoa){
        pMinijokoa.addObserver(this);
    }
    

    public void update(Observable arg0, Object arg1)
    {
        switch((String)arg1)//((MiniJokoa)arg0).get...
        {
            case "hasieratu":
                Hasieratu();
                System.out.println("ha pasado el observer de hasieratu");
                break;
            case "LaukiakAktualizatu":
                LaukiakAktualizatu();
                break;
            case "tamagochiMugitu":
                tamagochiMugitu();
                break;
            case "tamagochietaTartaHasieratu":
                //tartaKokatu();
                break;
            case "irabazi":
                //irabazi();
                break;
            case "galdu":
                //galdu();
                break;
        }
        
    }
    public void Hasieratu() 
    {
        
        System.out.println("Hasieratu da 2");
     //metodo que inicializa una matriz de 12 x 12 de laukias
        laukiak = new JLabel[12][12];
        frame = new JFrame();
        panel = new JPanel();
        panel.setLayout(new GridLayout(12, 12));
        frame.add(panel);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        for (int i = 0; i < 12; i++)
        {
            for (int j = 0; j < 12; j++)
            {
                laukiak[i][j] = new JLabel();
                laukiak[i][j].setOpaque(true);
                laukiak[i][j].setBackground(koloreaAtera(i, j));
                panel.add(laukiak[i][j]);

                System.out.println("Creando JLabel en la posición " + i + ", " + j);
            }
        }
        frame.addKeyListener(new MinijokoController());
        frame.setVisible(true);
    }
    public void LaukiakAktualizatu()
    {
         
        for (int i = 0; i < 12; i++)
        {
            for (int j = 0; j < 12; j++)
            {
                laukiak[i][j].setBackground(koloreaAtera(i, j));
            }
        }
    }
    private Color koloreaAtera(int lerroa, int zutabea)
    {
        if (Minijokoa.getMinijokoa().getLaukiak()[lerroa][zutabea] == 1)
        {
            return Color.LIGHT_GRAY;
        }
        else if (Minijokoa.getMinijokoa().getLaukiak()[lerroa][zutabea] == 2)
        {
            return Color.GRAY;
        }
        else if (Minijokoa.getMinijokoa().getLaukiak()[lerroa][zutabea] == 3)
        {
            return Color.DARK_GRAY;
        }
        else
        {
            return Color.LIGHT_GRAY;
        }
    }
    public void tamagochiMugitu()
    {
        x = Minijokoa.getMinijokoa().getTamagochiZutabea();
        y = Minijokoa.getMinijokoa().getTamagochiLerroa();
        if (Minijokoa.getMinijokoa().tamagochiVisible()==true){
        //Faltan los ifs para saber que evolucion de tamagochi es

            laukiak[x][y].setIcon(new ImageIcon(this.getClass().getResource("/sprites/Marutchi1.png")));
        }
    }

    private class MinijokoController extends MouseAdapter implements KeyListener
    {

        //hay que llamar al EMA de Minijoko para que el controller acceda a el
        
        public void punteroaBarruan(MouseEvent e)
        {
            int x = e.getX();
            int y = e.getY();
            int zutabea = x / 50;
            int lerroa = y / 50;
            Minijokoa minijokoa = new Minijokoa();
            minijokoa.laukiaAktualizatu(lerroa, zutabea);
        }
        //input de las flechas del teclado
        public void keyPressed(KeyEvent e)
        {
            if(!Minijokoa.irabaziDu() && Minijokoa.tamagochiVisible())
            {
                
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_UP)
                {
                    Minijokoa.getMinijokoa().TamagochiMugitu(1);
                }
                else if (key == KeyEvent.VK_DOWN)
                {
                    Minijokoa.getMinijokoa().TamagochiMugitu(2);
                }
                else if (key == KeyEvent.VK_LEFT)
                {
                    Minijokoa.getMinijokoa().TamagochiMugitu(3);
                }
                else if (key == KeyEvent.VK_RIGHT)
                {
                    Minijokoa.getMinijokoa().TamagochiMugitu(4);
                }
            }
        }
        public void keyReleased(KeyEvent e)
        {
        }
        public void keyTyped(KeyEvent e)
        {
        }


    }
}
