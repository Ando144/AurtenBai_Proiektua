package src.Bista;

import src.Eredua.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.util.Observer;
import java.util.Observable;
import javax.swing.Timer;
public class panelNagusia extends JFrame implements Observer{
	private JFrame frame;
	private JPanel panel;
	private static final long serialVersionUID = 1L;
	private JPanel panel_tamagochi;
	private JPanel panel_bihotzak;
	private JPanel panel_platos;
	private JLabel Tamagochi_Izena;
	private JLabel score_label;
	private JLabel Puntuazioa;
	private JButton boton_exit;
	private JPanel panel_candy;
	private JPanel panel__soup;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel bihotza4;
	private JLabel bihotza3;
	private JLabel bihotza2;
	private JLabel bihotza1;
	private JLabel katilu4;
	private JLabel katilu3;
	private JLabel katilu2;
	private JLabel katilu1;
	private ImageIcon[] TamaIrudiak;
	private int intOrain;
	private Timer timer;
	private ImageIcon irudiak;
	private JLabel eggIrudi;
	private JLabel kakaIrudi;
	private JLabel gaixoIrudi;
	private int pBizitza;
	private int pAsetasuna;
	private boolean pGaixorik;
	private boolean pKaka;
	private Kontroladorea kontroladorea = null;
	private JLabel candy1;
	private JLabel candy2;
	private JLabel candy3;
	private JLabel koilara1;
	private JLabel koilara2;
	private JLabel koilara3;
	private JLabel tamagotchiIrudi;
	private int offsetx,offsety;
	/**
	 * Launch the application.
	 */
	private Kontroladorea getKontroladorea(){
		if(kontroladorea == null){
			kontroladorea = new Kontroladorea();
		}
		return kontroladorea;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Partida part = new Partida();
					panelNagusia frame = new panelNagusia(part);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public panelNagusia(Observable pObservable){
		pObservable.addObserver(this);
	}
	private void hasieratu() {
		frame = new JFrame();
		frame.setBackground(new Color(0, 0, 0));
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		//panel.setLayout(new GridLayout(12,12));
		frame.add(panel);
		frame.setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 500, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.add(getPanel_tamagochi());
		frame.add(getPanel_bihotzak());
		frame.add(getPanel_platos());
		frame.add(getTamagochi_Izena());
		frame.add(getScore_label());
		frame.add(getPuntuazioa());
		frame.add(getBoton_exit());
		frame.add(getPanel_candy());
		frame.add(getPanel__soup());
		frame.add(getLblNewLabel_3());
		frame.add(getLblNewLabel_4());
		TamaIrudiak= new ImageIcon[] {
				new ImageIcon((this.getClass().getResource("/sprites/egg1.png"))),
				new ImageIcon((this.getClass().getResource("/sprites/egg2.png")))
		};
		intOrain=0;
		//segundoro irudia aldatzeko
		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				intOrain = (intOrain + 1) % TamaIrudiak.length;
				eggIrudi.setIcon(TamaIrudiak[intOrain]);
			}
		});
		timer.start(); 
		frame.setVisible(true);
		System.out.println("eyouuuu");        
	}
	private JPanel getPanel_tamagochi() {
		if (panel_tamagochi == null) {
			panel_tamagochi = new JPanel();
			panel_tamagochi.setBackground(new Color(0, 0, 0));
			panel_tamagochi.setLayout(null);
			panel_tamagochi.add(getEggIrudi());
			panel_tamagochi.setBounds(100, 108, 294, 165);
			panel_tamagochi.setLayout(null);
		}
		return panel_tamagochi;
	}
	private JPanel getPanel_bihotzak() {
		if (panel_bihotzak == null) {
			panel_bihotzak = new JPanel();
			panel_bihotzak.setBackground(new Color(0, 0, 0));
			panel_bihotzak.setBounds(10, 108, 51, 165);
			panel_bihotzak.setLayout(null);
			panel_bihotzak.add(getBihotza4());
			panel_bihotzak.add(getBihotza3());
			panel_bihotzak.add(getBihotza2());
			panel_bihotzak.add(getBihotza1());
		}
		return panel_bihotzak;
	}
	private JPanel getPanel_platos() {
		if (panel_platos == null) {
			panel_platos = new JPanel();
			panel_platos.setBackground(new Color(0, 0, 0));
			panel_platos.setBounds(425, 108, 51, 165);
			panel_platos.setLayout(null);
			panel_platos.add(getkatilu4());
			panel_platos.add(getkatilu3());
			panel_platos.add(getKatilu2());
			panel_platos.add(getkatilu1());
		}
		return panel_platos;
	}
	private JLabel getTamagochi_Izena() {
		if (Tamagochi_Izena == null) {
			Tamagochi_Izena = new JLabel("Egg");
			Tamagochi_Izena.setFont(new Font("Tahoma", Font.PLAIN, 14));
			Tamagochi_Izena.setForeground(new Color(192, 192, 192));
			Tamagochi_Izena.setBounds(71, -5, 64, 28);
		}
		return Tamagochi_Izena;
	}
	private JLabel getScore_label() {
		if (score_label == null) {
			score_label = new JLabel("Score:");
			score_label.setForeground(new Color(192, 192, 192));
			score_label.setBounds(232, 4, 40, 13);
		}
		return score_label;
	}
	private JLabel getPuntuazioa() {
		if (Puntuazioa == null) {
			int aldagai= Partida.getPartida().getScore();
			Puntuazioa = new JLabel(""+aldagai);
			Puntuazioa.setForeground(new Color(255, 255, 255));
			Puntuazioa.setBounds(282, 4, 45, 13);
		}
		return Puntuazioa;
	}
	private JButton getBoton_exit() {
		if (boton_exit == null) {
			boton_exit = new JButton("exit");
			boton_exit.setBackground(new Color(0, 0, 0));
			boton_exit.setForeground(new Color(192, 192, 192));
			boton_exit.setFont(new Font("Tahoma", Font.PLAIN, 10));
			boton_exit.setBounds(351, 0, 85, 21);
			boton_exit.addActionListener(getKontroladorea());
		}
		return boton_exit;
	}
	private JPanel getPanel_candy() {
		if (panel_candy == null) {
			panel_candy = new JPanel();
			panel_candy.setForeground(new Color(255, 255, 255));
			panel_candy.setBackground(new Color(0, 0, 0));
			panel_candy.setBorder(new LineBorder(new Color(128, 128, 128)));
			panel_candy.setBounds(50, 354, 103, 34);
			panel_candy.add(getCandy1());
			panel_candy.add(getCandy2());
			panel_candy.add(getCandy3());
		}
		return panel_candy;
	}
	private JPanel getPanel__soup() {
		if (panel__soup == null) {
			panel__soup = new JPanel();
			panel__soup.setBackground(new Color(0, 0, 0));
			panel__soup.setForeground(new Color(255, 255, 255));
			panel__soup.setBorder(new LineBorder(new Color(128, 128, 128)));
			panel__soup.setBounds(351, 354, 85, 34);
			panel__soup.add(getKoilara1());
			panel__soup.add(getKoilara2());
			panel__soup.add(getKoilara3());
		}
		return panel__soup;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Soup");
			lblNewLabel_3.setForeground(new Color(255, 255, 255));
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_3.setBounds(404, 333, 45, 21);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("Candy");
			lblNewLabel_4.setForeground(new Color(255, 255, 255));
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_4.setBounds(50, 333, 45, 21);
		}
		return lblNewLabel_4;
	}
	private JLabel getBihotza4() {
		if (bihotza4 == null) {
			bihotza4 = new JLabel("");
			bihotza4.setIcon(new ImageIcon(this.getClass().getResource("/sprites/heart.png")));
			bihotza4.setBounds(10, 10, 45, 39);
		}
		return bihotza4;
	}
	private JLabel getBihotza3() {
		if (bihotza3 == null) {
			bihotza3 = new JLabel("");
			bihotza3.setIcon(new ImageIcon(this.getClass().getResource("/sprites/heart.png")));
			bihotza3.setBounds(10, 48, 45, 39);
		}
		return bihotza3;
	}
	private JLabel getBihotza2() {
		if (bihotza2 == null) {
			bihotza2 = new JLabel("");
			bihotza2.setIcon(new ImageIcon(this.getClass().getResource("/sprites/heart.png")));
			bihotza2.setBounds(10, 92, 45, 39);
		}
		return bihotza2;
	}
	private JLabel getBihotza1() {
		if (bihotza1 == null) {
			bihotza1 = new JLabel("");
			bihotza1.setIcon(new ImageIcon(this.getClass().getResource("/sprites/heart.png")));
			bihotza1.setBounds(10, 130, 45, 35);
		}
		return bihotza1;
	}
	private JLabel getkatilu4() {
		if (katilu4 == null) {
			katilu4 = new JLabel("");
			katilu4.setEnabled(true);
			katilu4.setIcon(new ImageIcon(this.getClass().getResource("/sprites/hungry.png")));
			katilu4.setBounds(10, 10, 45, 31);
		}
		return katilu4;
	}
	private JLabel getkatilu3() {
		if (katilu3 == null) {
			katilu3 = new JLabel("");
			katilu3.setIcon(new ImageIcon(this.getClass().getResource("/sprites/hungry.png")));
			katilu3.setBounds(10, 51, 45, 31);
		}
		return katilu3;
	}
	private JLabel getKatilu2() {
		if (katilu2 == null) {
			katilu2 = new JLabel("");
			katilu2.setIcon(new ImageIcon(this.getClass().getResource("/sprites/hungry.png")));
			katilu2.setBounds(10, 92, 45, 31);
		}
		return katilu2;
	}
	private JLabel getkatilu1() {
		if (katilu1 == null) {
			katilu1 = new JLabel("");
			katilu1.setIcon(new ImageIcon(this.getClass().getResource("/sprites/hungry.png")));
			katilu1.setBounds(10, 133, 45, 32);
		}
		return katilu1;
	}
	private JLabel getEggIrudi( ) {
		if (eggIrudi == null) {
			eggIrudi = new JLabel("");
			eggIrudi.setBounds(80, 0, 200, 200);
			eggIrudi.setIcon(new ImageIcon(this.getClass().getResource("/sprites/egg1.png")));
		}
		else {
			eggIrudi.setIcon(TamaIrudiak[intOrain]);
		}
		return eggIrudi;
	}
	private JLabel getKakaIrudi( ) {
		if (kakaIrudi == null) {
			kakaIrudi = new JLabel("");
			kakaIrudi.setBounds(100, 100, 100, 100);
			kakaIrudi.setIcon(new ImageIcon(this.getClass().getResource("/sprites/kk.png")));
		}
		return kakaIrudi;
	}
	private JLabel getgaixoIrudi( ) {
		if (gaixoIrudi == null) {
			gaixoIrudi = new JLabel("");
			gaixoIrudi.setBounds(80, 0, 100, 100);
			gaixoIrudi.setIcon(new ImageIcon(this.getClass().getResource("/sprites/Virus.png")));
		}
		return gaixoIrudi;
	}
	private JLabel getCandy1() {
		if (candy1 == null) {
			candy1 = new JLabel("");
			candy1.setIcon(new ImageIcon(this.getClass().getResource("/sprites/candy.png")));
			candy1.setBounds(0, 0, 29, 34);
			candy1.addMouseListener(new MouseAdapter(){
				public void mousePressed(MouseEvent e){
					offsetx=e.getX();
					offsety=e.getY();
				}
			});
			candy1.addMouseMotionListener(new MouseAdapter() {
				public void mouseDragged(MouseEvent e){
					int newX=e.getXOnScreen()-frame.getLocationOnScreen().x -offsetx;
					int newY=e.getYOnScreen()-frame.getLocationOnScreen().y- offsety;
					candy1.setLocation(newX, newY);
					repaint();
				}	
			}
			);
		}
		return candy1;
	}
	private JLabel getCandy2() {
		if (candy2 == null) {
			candy2 = new JLabel("");
			candy2.setIcon(new ImageIcon(this.getClass().getResource("/sprites/candy.png")));
			candy2.setBounds(35, 0, 29, 34);
		}
		return candy2;
	}
	private JLabel getCandy3() {
		if (candy3 == null) {
			candy3 = new JLabel("");
			candy3.setIcon(new ImageIcon(this.getClass().getResource("/sprites/candy.png")));
			candy3.setBounds(74, 0, 29, 34);
		}
		return candy3;
	}
	private JLabel getKoilara1() {
		if (koilara1 == null) {
			koilara1 = new JLabel("");
			koilara1.setIcon(new ImageIcon(this.getClass().getResource("/sprites/spoon.png")));
			koilara1.setBounds(10, 0, 26, 34);
		}
		return koilara1;
	}
	private JLabel getKoilara2() {
		if (koilara2 == null) {
			koilara2 = new JLabel("");
			koilara2.setIcon(new ImageIcon(this.getClass().getResource("/sprites/spoon.png")));
			koilara2.setBounds(41, 0, 26, 34);
		}
		return koilara2;
	}
	private JLabel getKoilara3() {
		if (koilara3 == null) {
			koilara3 = new JLabel("");
			koilara3.setIcon(new ImageIcon(this.getClass().getResource("/sprites/spoon.png")));
			koilara3.setBounds(77, 0, 26, 34);
		}
		return koilara3;
	}
	public void update(Observable o, Object arg){
		switch ((String)arg) {
			case "hasieratu":
				hasieratu();
				break;
			case "4bihotzjarri":
				lauBihotzJarri();
				break;
		
			case "3bihotzjarri":
				hiruBihotzJarri();
				break;
			case "2bihotzjarri":
				biBihotzJarri();
				break;
			case "bihotz1jarri":
				bihotzBatJarri();
				break;
			case "hildaDago":
				hildaDago();
				break;
		
			case "4sopajarri":
				lauKatiluJarri();
				break;
		
			case "3sopajarri":
				hiruKatiluJarri();
				break;
			case "2sopajarri":
				biKatiluJarri();
				break; 
			case "sopa1jarri":
				katiluBatJarri();
				break;
			case "kaka":
				kaka();
				break;
			case "gaixo":
				gaixo();
				break;
			case "MiniJokua":
				minijokuaBistaratu();
				break;
			case "marutchi":
				marutchiBistaratu();
				break;
			case "mimitchi":
				System.out.println("pasatu dut");
				mimitchiBistaratu();
				break;
			case "kuchipatchi":
				System.out.println("kuchichcihoda");
				kuchipatchiBistaratu();
				break;
			case "maskutchi":
				maskutchiBistaratu();
				break;
			case "Puntuazioa":
				PuntuazioaEguneratuEtaBistaratu();
				break;
		}
	}
	private void lauBihotzJarri(){
		bihotza1.setEnabled(true);
		bihotza2.setEnabled(true);
		bihotza3.setEnabled(true);
		bihotza4.setEnabled(true);
	}
	private void hiruBihotzJarri(){
		bihotza1.setEnabled(true);
		bihotza2.setEnabled(true);
		bihotza3.setEnabled(true);
		bihotza4.setEnabled(false);
	}
	private void biBihotzJarri(){
		bihotza1.setEnabled(true);
		bihotza2.setEnabled(true);
		bihotza3.setEnabled(false);
		bihotza4.setEnabled(false);
	}
	private void bihotzBatJarri(){
		bihotza1.setEnabled(true);
		bihotza2.setEnabled(false);
		bihotza3.setEnabled(false);
		bihotza4.setEnabled(false);
	}
	private void hildaDago(){}	
	private void lauKatiluJarri(){
		katilu1.setEnabled(true);
		katilu2.setEnabled(true);
		katilu3.setEnabled(true);
		katilu4.setEnabled(true);
	}
	private void hiruKatiluJarri(){
		katilu1.setEnabled(true);
		katilu2.setEnabled(true);
		katilu3.setEnabled(true);
		katilu4.setEnabled(false);
	}
	private void biKatiluJarri(){
		katilu1.setEnabled(true);
		katilu2.setEnabled(true);
		katilu3.setEnabled(false);
		katilu4.setEnabled(false);
	}
	private void katiluBatJarri(){
		katilu1.setEnabled(true);
		katilu2.setEnabled(false);
		katilu3.setEnabled(false);
		katilu4.setEnabled(false);
	}
	private void kaka(){
		panel_tamagochi.add(getKakaIrudi());
	}
	private void gaixo(){
		panel_tamagochi.add(getgaixoIrudi());
	}
	private void minijokuaBistaratu(){
		
	}
	private void marutchiBistaratu(){
		TamaIrudiak= new ImageIcon[] {
			new ImageIcon((this.getClass().getResource("/sprites/Marutchi1.png"))),
			new ImageIcon((this.getClass().getResource("/sprites/Marutchi2.png"))),
			new ImageIcon((this.getClass().getResource("/sprites/Marutchi3.png"))),
			new ImageIcon((this.getClass().getResource("/sprites/Marutchi2.png")))
		};
		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				intOrain = (intOrain + 1) % TamaIrudiak.length;
				tamagotchiIrudi.setIcon(TamaIrudiak[intOrain]);
			}
		});
		Tamagochi_Izena.setText("Marutchi");

	}
	private void kuchipatchiBistaratu(){
		TamaIrudiak= new ImageIcon[] {
			new ImageIcon((this.getClass().getResource("/sprites/Kuchipatchi1.png"))),
			new ImageIcon((this.getClass().getResource("/sprites/Kuchipatchi2.png"))),
			new ImageIcon((this.getClass().getResource("/sprites/Kuchipatchi3.png"))),
			new ImageIcon((this.getClass().getResource("/sprites/Kuchipatchi4.png")))
		};
		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				intOrain = (intOrain + 1) % TamaIrudiak.length;
				tamagotchiIrudi.setIcon(TamaIrudiak[intOrain]);
			}
		});
		Tamagochi_Izena.setText("Kuchipatchi");
	}
	private void mimitchiBistaratu(){
		TamaIrudiak= new ImageIcon[] {
			new ImageIcon((this.getClass().getResource("/sprites/Mimitchi1.png"))),
			new ImageIcon((this.getClass().getResource("/sprites/Mimitchi2.png"))),
			new ImageIcon((this.getClass().getResource("/sprites/Mimitchi3.png"))),
			new ImageIcon((this.getClass().getResource("/sprites/Mimitchi4.png")))
		};
		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				intOrain = (intOrain + 1) % TamaIrudiak.length;
				tamagotchiIrudi.setIcon(TamaIrudiak[intOrain]);
			}
		});
		Tamagochi_Izena.setText("Mimitchi");
	}
	
	 private void maskutchiBistaratu(){
		TamaIrudiak= new ImageIcon[] {
			new ImageIcon((this.getClass().getResource("/sprites/Maskutchi1.png"))),
			new ImageIcon((this.getClass().getResource("/sprites/Maskutchi2.png"))),
			new ImageIcon((this.getClass().getResource("/sprites/Maskutchi3.png"))),
			new ImageIcon((this.getClass().getResource("/sprites/Maskutchi4.png")))
		};
		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				intOrain = (intOrain + 1) % TamaIrudiak.length;
				tamagotchiIrudi.setIcon(TamaIrudiak[intOrain]);
			}
		});
		Tamagochi_Izena.setText("Maskutchi");
	 }
	private void PuntuazioaEguneratuEtaBistaratu(){

	}
	private class Kontroladorea implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			if(e.getSource().equals(boton_exit)){
				HasieraMenua frame2 = new HasieraMenua(PartidaErregistro.getPartidaErregistro());
				frame2.setVisible(true);
				PartidaErregistro.getPartidaErregistro().getLehenengoBostak();
				frame.dispose();
			}
			//dispose();
		}
	}
}


