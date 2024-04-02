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

import src.Eredua.Marutchi;
import src.Eredua.Mimitchi;
import src.Eredua.Minijokoa;
import src.Eredua.Tamagotchi;

import java.util.Observer;
import java.util.Observable;
import java.awt.Color;



public class miniJokoaBista implements Observer{
    private JFrame frame;
    private static JLabel laukiak[][];
    private static JLabel Tamagochi;
    private int x;
    private int y;


    public miniJokoaBista (Observable pMinijokoa){
        pMinijokoa.addObserver(this);
    }
    
    @Override
    public void update(Observable arg0, Object arg1)
    {
        
        System.out.println("ha pasado a el update");
        switch((String)arg1)//((MiniJokoa)arg0).get...
        {
            case "hasieratu":
                Hasieratu();
                break;
            case "laukiaAktualizatu"://NO SALTA ESTE CASE
                System.out.println("ha llegado al obvserver de aktualizatu");
                LaukiakAktualizatu();
                break;
            case "tamagochiMugitu":
                tamagochiMugitu();
                break;
            case "tamagochietaTartaHasieratu":
                System.out.println("ha llegado al obvserver de tarta y tamagochi");
                tamagochietatartaKokatu();
                break;
            case "irabaziDu":
                irabaziDu();
                break;
            case "galdu":
                galduDu();
                break;
        }
        
    }

    public void Hasieratu() 
    {
        
     //metodo que inicializa una matriz de 12 x 12 de laukias
        System.out.println("3");
        laukiak = new JLabel[12][12];
        frame = new JFrame("MiniJokua");
        frame.setLayout(new GridLayout(12, 12));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i = 0; i < 12; i++)
        {
            for (int j = 0; j < 12; j++)
            {
                laukiak[i][j] = new JLabel();
                laukiak[i][j].setOpaque(true);
                laukiak[i][j].setBackground(koloreaAtera(i, j));
                laukiak[i][j].addMouseListener(new CustomMouseListener(i,j));
                frame.add(laukiak[i][j]);
            }
        }
        frame.addKeyListener(new CustomKeyListener());
        
        frame.setSize(500, 500);
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
    public void galduDu()//falta por conectar con monge
    {
        frame.dispose(); // Close the main frame
        
        JFrame perdedorFrame = new JFrame("GALDU DUZU!");
        perdedorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        perdedorFrame.add(panel);
        
        JLabel mensajeLabel = new JLabel("GALDU DUZU!");
        panel.add(mensajeLabel);
        
        JButton aceptarButton = new JButton("Aceptar");
        /*aceptarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // KONEXIOA CON MONGE
            }
        });
        panel.add(aceptarButton);
        */
        perdedorFrame.setSize(300, 200);
        perdedorFrame.setVisible(true);
    }
    public void irabaziDu()//falta por conectar con monge
    {
        frame.dispose(); // Close the main frame
        
        JFrame ganadorFrame = new JFrame("IRABAZI DUZU!");
        ganadorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        ganadorFrame.add(panel);
        
        JLabel mensajeLabel = new JLabel("IRABAZI DUZU!");
        panel.add(mensajeLabel);
        
        JButton aceptarButton = new JButton("Aceptar");
        /*aceptarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // KONEXIOA CON MONGE
            }
        });
        panel.add(aceptarButton);
        */
        ganadorFrame.setSize(300, 200);
        ganadorFrame.setVisible(true);
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
        x = Minijokoa.getMinijokoa().getZutabea();
        y = Minijokoa.getMinijokoa().getLerroa();
        if (Minijokoa.getMinijokoa().tamagochiVisible()==true){
            //hay que llamar bien al metodo zeinEboluzioDa()
            Mimitchi tamagochi= new Mimitchi(y, x, false, false);
            String aux=tamagochi.zeinEboluzioDa();
            if (aux=="Egg"){
                laukiak[x][y].setIcon(new ImageIcon(this.getClass().getResource("/sprites/Egg1.png")));
            } 
            else if (aux=="Kuchipatchi"){
                laukiak[x][y].setIcon(new ImageIcon(this.getClass().getResource("/sprites/Kuchipatchi1.png")));
            }
            else if (aux=="Mimitchi"){
                laukiak[x][y].setIcon(new ImageIcon(this.getClass().getResource("/sprites/Mimitchi1.png")));
            }
            else if (aux=="Maskutchi"){
                laukiak[x][y].setIcon(new ImageIcon(this.getClass().getResource("/sprites/Maskutchi1.png")));
            }
            else {
                laukiak[x][y].setIcon(new ImageIcon(this.getClass().getResource("/sprites/Marutchi1.png")));
            }     
        }
    }
    private void tamagochietatartaKokatu()
    { 
        int xTama = Minijokoa.getMinijokoa().getLerroa();
        int yTama = Minijokoa.getMinijokoa().getZutabea();

        if(Minijokoa.getMinijokoa().tamagochiVisible())
        {
            laukiak[yTama][xTama].setIcon(new ImageIcon(this.getClass().getResource("/sprites/Mimitchi1.png")));
            //esto puede dar un problema de que cuando se actualize por un movimiento el tamagochi deje estela de tamagochis
        }

        int yTarta = Minijokoa.getTartaZutabea();
        int xTarta = Minijokoa.getTartaLerroa();

        if(Minijokoa.getMinijokoa().tartaVisible())
        {
            laukiak[yTarta][xTarta].setIcon(new ImageIcon(this.getClass().getResource("/sprites/Tarta.png")));
        }
        

    }
    private static class CustomMouseListener extends MouseAdapter 
    {
        private int lerroa;
        private int zutabea;
        
        public CustomMouseListener(int lerroa, int zutabea)
        {
            this.lerroa = lerroa;
            this.zutabea = zutabea;
        }

        @Override
        public void mouseEntered(MouseEvent e)
        {
            System.out.println("Mouse entered: " + lerroa + " " + zutabea);
            Minijokoa.getMinijokoa().laukiaAktualizatu(lerroa, zutabea);
        }
    }
    public class CustomKeyListener extends KeyAdapter{
     
        //input de las flechas del teclado
        @Override
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
