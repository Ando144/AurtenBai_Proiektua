package src.Bista;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
    private JLabel Tamagochi;

    public miniJokoaBista (Observable pMinijokoa){
        pMinijokoa.addObserver(this);
    }
    private static JPanel[][] laukiak = new JPanel[12][12];

    public void update(Observable arg0, Object arg1)
    {
        switch((String)arg1)//((MiniJokoa)arg0).get...
        {
            case "hasieratu":
                hasieratu();
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
    public void hasieratu()
    {
        frame = new JFrame("Minijokoa");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(12, 12));

        for (int i = 0; i < 12; i++)
        {
            for (int j = 0; j < 12; j++)
            {
                laukiak[i][j] = new JPanel();
                laukiak[i][j].setBackground(koloreaAtera(i, j));
                laukiak[i][j].addMouseListener(new MinijokoController());
                frame.add(laukiak[i][j]);
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
