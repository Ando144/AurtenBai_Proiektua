package src.Bista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import src.Eredua.Minijokoa;
import java.util.Observer;
import java.util.Observable;

public class miniJokoaBista implements Observer{
    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JLabel label;

    public miniJokoaBista (Observable pMinijokoa){
        pMinijokoa.addObserver(this);
    }
    public void update(Observable arg0, Object arg1)
    {
            System.out.println("Aldaketa bat egon da.");
            if()
    }

    private class MinijokoController extends MouseAdapter
    {
        //hay que llamar al EMA de Minijoko para que el controller acceda a el
        Minijokoa minijoko = new Minijokoa();
        Minijokoa = minijoko.getNireMinijokoa();
        public void punteroaBarruan(MouseEvent e)
        {
            
            int x = e.getX();
            int y = e.getY();
            int zutabea = x / 50;
            int lerroa = y / 50;
            Minijokoa.laukiaAktualizatu(lerroa, zutabea);
            
        }
        //input de las flechas del teclado
        public void keyPressed(KeyEvent e)
        {
            if(!Minijokoa.irabaziDu()){
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_UP)
                {
                    Minijokoa.TamagochiMugitu(1);
                }
                else if (key == KeyEvent.VK_DOWN)
                {
                    Minijokoa.TamagochiMugitu(2);
                }
                else if (key == KeyEvent.VK_LEFT)
                {
                    Minijokoa.TamagochiMugitu(3);
                }
                else if (key == KeyEvent.VK_RIGHT)
                {
                    Minijokoa.TamagochiMugitu(4);
                }
            }
        }

    }
}
