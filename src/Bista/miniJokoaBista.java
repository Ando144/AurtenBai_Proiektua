package src.Bista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.*;
import java.util.stream.IntStream;

import javax.swing.Timer;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


import src.Eredua.Marutchi;
import src.Eredua.Mimitchi;
import src.Eredua.Minijokoa;
import src.Eredua.Partida;
import src.Eredua.Tamagotchi;



public class miniJokoaBista extends JFrame implements Observer{
    private JFrame frame;
    JFrame perdedorFrame = new JFrame("GALDU DUZU!");
    JFrame ganadorFrame = new JFrame("IRABAZI DUZU!");

    private static GelaxkaBista laukiak[][];
    private static JLabel Tamagochi;
    private int x;
    private int y;
    private JPanel puntosPanel;
    private JLabel puntosLabel;
    private JButton aceptarButton;
    private Kontroladorea kontroladorea = null;
    private Minijokoa aux;

	private Kontroladorea getKontroladorea() {
		if (kontroladorea == null) {
			kontroladorea = new Kontroladorea();
		}
		return kontroladorea;
	}
    

    public miniJokoaBista (Observable pMinijokoa){
        pMinijokoa.addObserver(this);
    } 
    @Override
    public void update(Observable arg0, Object arg1)
    {
        switch((String)arg1) {
            case "hasieratu":
                Hasieratu();
                break;
            /*case "laukiAktualizatu":
                LaukiakAktualizatu();
                break;*/
            case "tamagochiMugitu":
                tamagochiMugitu();
                break;
            case "tamagochietaTartaHasieratu":
                tamagochietatartaKokatu();
                break;
            case "irabaziDu":
                irabaziDu();
                break;
            case "galduDu":
                galduDu();
                break;
            case "itzali":
                itzali();
            break;
        }
        
    }

    public void Hasieratu() {
        laukiak = new GelaxkaBista[12][12];
        frame = new JFrame("MiniJokua");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        puntosPanel = new JPanel();
        puntosPanel.setLayout(new BoxLayout(puntosPanel, BoxLayout.X_AXIS));
        puntosLabel = new JLabel("Puntuazioa: " + Partida.getPartida().getScore());
        puntosPanel.add(puntosLabel);
        frame.add(puntosPanel, BorderLayout.NORTH);

        JPanel matrizea = new JPanel(new GridLayout(12, 12, 0, 0));

        /*for (int i = 0; i < 12; i++)
        {
            for (int j = 0; j < 12; j++)
            {
                laukiak[i][j] = new GelaxkaBista(i,j);
                matrizea.add(laukiak[i][j]);
                Minijokoa.getMinijokoa().getGelaxka(i, j).addObserver(laukiak[i][j]);
            }
        }*/
        IntStream.range(0, 12).forEach(i ->
            IntStream.range(0, 12).forEach(j -> {
                laukiak[i][j] = new GelaxkaBista(i,j);
                matrizea.add(laukiak[i][j]);
                Minijokoa.getMinijokoa().getGelaxka(i, j).addObserver(laukiak[i][j]);
            })
        );
        
        frame.add(matrizea, BorderLayout.CENTER);
        frame.addKeyListener(new CustomKeyListener());
        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public void galduDu(){
        if(Minijokoa.irabaziDu()==false)
        {
            frame.dispose();

            perdedorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JPanel panel = new JPanel();
            perdedorFrame.add(panel);
            
            JLabel mensajeLabel = new JLabel("GALDU DUZU!");
            panel.add(mensajeLabel);
            Minijokoa.setFlag(true);
            Partida.getPartida().sumarPuntuacion(-20);

            panel.add(getAceptarButton());
            
            perdedorFrame.setSize(300, 200);
            perdedorFrame.setVisible(true);
        }
       
    }
    private JButton getAceptarButton() {
		if (aceptarButton == null) {
			aceptarButton = new JButton("Aceptar");
			aceptarButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
			aceptarButton.setForeground(SystemColor.desktop);
			aceptarButton.setBackground(Color.red);
			aceptarButton.setBounds(283, 13, 89, 23);
			aceptarButton.addActionListener(getKontroladorea());
		}
		return aceptarButton;
    }
    private void itzali()
    {
        
        perdedorFrame.dispose();
        ganadorFrame.dispose();
        Minijokoa.getMinijokoa().apagarTimer();
    }
    public void irabaziDu()
    {
        frame.dispose();
        
        ganadorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        ganadorFrame.add(panel);
        
        JLabel mensajeLabel = new JLabel("IRABAZI DUZU!");
        panel.add(mensajeLabel);
        Partida.getPartida().sumarPuntuacion(20);
        
        panel.add(getAceptarButton());
        
        ganadorFrame.setSize(300, 200);
        ganadorFrame.setVisible(true);
    }
    /*private Color koloreaAtera(int lerroa, int zutabea)
    {
        if (Minijokoa.getMinijokoa().getLaukiak()[lerroa][zutabea].getIndarra()==1)
        {
            return Color.LIGHT_GRAY;
        }
        else if (Minijokoa.getMinijokoa().getLaukiak()[lerroa][zutabea].getIndarra() == 2)
        {
            return Color.GRAY;
        }
        else if (Minijokoa.getMinijokoa().getLaukiak()[lerroa][zutabea].getIndarra() == 3)
        {
            return Color.DARK_GRAY;
        }
        else
        {
            return Color.BLACK;
        }
    }*/
    public void tamagochiMugitu()
    {
        int x = Minijokoa.getMinijokoa().getZutabea();
        int y = Minijokoa.getMinijokoa().getLerroa();
        int yTarta = Minijokoa.getTartaZutabea();
        int xTarta = Minijokoa.getTartaLerroa();

        if (Minijokoa.getMinijokoa().tamagochiVisible()==true){
            String aux="Mimitchi";
            ImageIcon pertsonaia;
            if (aux=="Egg"){
                pertsonaia = new ImageIcon("src/Bista/sprites/Egg1.png");
            } 
            else if (aux=="Kuchipatchi"){
                pertsonaia = new ImageIcon("src/Bista/sprites/Kuchipatchi1.png");
            }
            else if (aux=="Mimitchi"){
                pertsonaia = new ImageIcon("src/Bista/sprites/Mimitchi1.png");
            }
            else if (aux=="Maskutchi"){
                pertsonaia = new ImageIcon("src/Bista/sprites/Maskutchi1.png");
            }
            else {
                pertsonaia = new ImageIcon("src/Bista/sprites/Marutchi1.png");
            }     
            garbituAurrekoa();

            Image image = pertsonaia.getImage().getScaledInstance(20, 20, 20);
            ImageIcon pertsonaiak = new ImageIcon(image);
            laukiak[y][x].setIcon(pertsonaiak);
            laukiak[y][x].revalidate();
            laukiak[y][x].repaint();

         
        }

        if(Minijokoa.getMinijokoa().tartaVisible())
        {
            ImageIcon tarta = new ImageIcon("src/Bista/sprites/dorayaki.png");

            laukiak[yTarta][xTarta].setIcon(tarta);
            laukiak[yTarta][xTarta].revalidate();
            laukiak[yTarta][xTarta].repaint();
            
        }
    }

    private void tamagochietatartaKokatu()
    { 
        int xTama = Minijokoa.getMinijokoa().getLerroa();
        int yTama = Minijokoa.getMinijokoa().getZutabea();

        if(Minijokoa.getMinijokoa().tamagochiVisible())
        {
            laukiak[yTama][xTama].setIcon(new ImageIcon("src/Bista/sprites/Mimitchi1.png"));
        }

        int yTarta = Minijokoa.getTartaZutabea();
        int xTarta = Minijokoa.getTartaLerroa();

        if(Minijokoa.getMinijokoa().tartaVisible())
        {
            
            laukiak[yTarta][xTarta].setIcon(new ImageIcon("src/Bista/sprites/Tarta.png"));
        }
        

    }
    private void garbituAurrekoa() {
        int xTama = Minijokoa.getMinijokoa().getLerroa();
        int yTama = Minijokoa.getMinijokoa().getZutabea();

        Arrays.stream(laukiak).forEach(lerro -> 
            Arrays.stream(lerro).forEach(lauki -> {
                if (lauki.getIcon()!=null && (lauki.getLerroa() != yTama || lauki.getZutabea() != xTama) && !esTarta(lauki.getLerroa(), lauki.getZutabea())) {
                    lauki.setIcon(null);
                    lauki.revalidate();
                    lauki.repaint();
                }
            
            })
        );

        /*for (int i = 0; i < laukiak.length; i++) {
            for (int j = 0; j < laukiak[i].length; j++) {
                if (laukiak[i][j].getIcon() != null && (i != yTama || j != xTama) && !esTarta(i, j)) {
                    laukiak[i][j].setIcon(null);
                    laukiak[i][j].revalidate();
                    laukiak[i][j].repaint();
                }
            }
        }*/
    }

    private boolean esTarta(int lerroa, int zutabea) {
        int xTarta = Minijokoa.getTartaLerroa();
        int yTarta = Minijokoa.getTartaZutabea();
        return lerroa == yTarta && zutabea == xTarta;
    }

    public class CustomKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            if(!Minijokoa.irabaziDu() && Minijokoa.tamagochiVisible()){
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
        private class Kontroladorea implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(aceptarButton)){
                    dispose();
                    Minijokoa.getMinijokoa().apagarMinijokoa();
                    Partida.getPartida().minijokoaAmaituDa();
                    Partida.getPartida().setMinijokoaMartxan(false);
                
                    
                    ganadorFrame.dispose();
                    perdedorFrame.dispose();

                    
                }
            }
        }
    
}
