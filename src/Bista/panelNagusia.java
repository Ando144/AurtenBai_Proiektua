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
import java.awt.event.MouseListener;
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
	private JLabel hilIrudi;
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
	private int kontadorea1 = 0;
	private int kontadorea2 = 0;
	private int puntuazioa;
	private int offsetx,offsety;
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
					//Partida part = new Partida();
					//panelNagusia frame = new panelNagusia(part);
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public panelNagusia(Observable pObservable){
		pObservable.addObserver(this);
		hasieratu();
	}

	private void hasieratu() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.desktop);
		frame.setBackground(new Color(0, 0, 0));
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		//panel.setLayout(new GridLayout(12,12));
		frame.getContentPane().add(panel);
		frame.setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 500, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(getPanel_tamagochi());
		frame.getContentPane().add(getPanel_bihotzak());
		frame.getContentPane().add(getPanel_platos());
		frame.getContentPane().add(getTamagochi_Izena());
		frame.getContentPane().add(getScore_label());
		frame.getContentPane().add(getPuntuazioa());
		frame.getContentPane().add(getBoton_exit());
		frame.getContentPane().add(getPanel_candy());
		frame.getContentPane().add(getPanel__soup());
		frame.getContentPane().add(getLblNewLabel_3());
		frame.getContentPane().add(getLblNewLabel_4());
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
			panel_tamagochi.add(getKakaIrudi());
			panel_tamagochi.add(getgaixoIrudi());
			getKakaIrudi().setVisible(false);
			getgaixoIrudi().setVisible(false);
			panel_tamagochi.setBounds(100, 108, 294, 197);
			panel_tamagochi.setLayout(null);
			panel_tamagochi.addMouseListener((MouseListener) getKontroladorea());
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
			Tamagochi_Izena.setBounds(50, -5, 85, 28);
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
			Puntuazioa = new JLabel(Integer.toString(aldagai));
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
			getCandy1().setVisible(false);
			getCandy2().setVisible(false);
			getCandy3().setVisible(false);
			panel_candy.addMouseListener((MouseListener) getKontroladorea());
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
			getKoilara1().setVisible(false);
			getKoilara2().setVisible(false);
			getKoilara3().setVisible(false);
			panel__soup.addMouseListener((MouseListener) getKontroladorea());
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
			kakaIrudi.addMouseListener((MouseListener) getKontroladorea());
		}
		return kakaIrudi;
	}

	private JLabel getHilIrudi( ) {
		if (hilIrudi == null) {
			hilIrudi = new JLabel("");
			hilIrudi.setBounds(100, 100, 100, 100);
			hilIrudi.setIcon(new ImageIcon(this.getClass().getResource("/sprites/death.gif")));
		}
		return hilIrudi;
	}

	private JLabel getgaixoIrudi( ) {
		if (gaixoIrudi == null) {
			gaixoIrudi = new JLabel("");
			gaixoIrudi.setBounds(80, 0, 100, 100);
			gaixoIrudi.setIcon(new ImageIcon(this.getClass().getResource("/sprites/Virus.png")));
			gaixoIrudi.addMouseListener((MouseListener) getKontroladorea());
		}
		return gaixoIrudi;
	}
	private JLabel getCandy1() {
		if (candy1 == null) {
			candy1 = new JLabel("");
			candy1.setIcon(new ImageIcon(this.getClass().getResource("/sprites/candy.png")));
			candy1.setBounds(0, 0, 29, 34);
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
		//System.out.println("observer nagooo----------------------");
		switch ((int)arg) {
			case 1:
				hasieratu();
				break;
			case 2:
				//System.out.println("--------------4bihotzjarri----------------");
				lauBihotzJarri();
				break;
			case 3:
			//System.out.println("--------------Obvserber 3----------------");
				hiruBihotzJarri();
				break;
			case 4:
			//System.out.println("--------------Obvserver 4----------------");
				biBihotzJarri();
				break;
			case 5:
			//System.out.println("--------------Obvserver 5----------------");
				bihotzBatJarri();
				break;
			case 6:
			//System.out.println("--------------Obvserver 6----------------");
				hildaDagoKatilu();
				break;
			case 7:
			//System.out.println("--------------Obvserver 7----------------");
				hildaDagoBihotz();
				break;
			case 8:
			//System.out.println("--------------Obvserver 8----------------");
				lauKatiluJarri();
				break;
			case 9:
			//System.out.println("--------------Obvserver 9----------------");
				hiruKatiluJarri();
				break;
			case 10:
			//System.out.println("--------------Obvserver 10----------------");
				biKatiluJarri();
				break; 
			case 11:
			//System.out.println("--------------Obvserver 11----------------");
				katiluBatJarri();
				break;
			case 12:
			//System.out.println("--------------Obvserver 12----------------");
				kaka();
				break;
			case 13:
			//System.out.println("--------------Obvserver 13----------------");
				gaixo();
				break;
			case 14:
			//System.out.println("--------------Obvserver 14----------------");
				minijokuaBistaratu();
				break;
			case 15:
			//System.out.println("--------------Obvserver 15----------------");
				marutchiBistaratu();
				break;
			case 16:
			//System.out.println("--------------Obvserver 16----------------");
				mimitchiBistaratu();
				break;
			case 17:
			//System.out.println("--------------Obvserver 17----------------");
				kuchipatchiBistaratu();
				break;
			case 18:
			//System.out.println("--------------Obvserver 18----------------");
				maskutchiBistaratu();
				break;
			case 19:
			//System.out.println("--------------Obvserver 19----------------");
				PuntuazioaEguneratuEtaBistaratu();
				break;
			case 20:
				marutchiKaka();
				break;
			case 21:
				marutchiGaixo();
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
	private void hildaDagoKatilu(){
		katilu1.setEnabled(false);
		katilu2.setEnabled(false);
		katilu3.setEnabled(false);
		katilu4.setEnabled(false);
		panel_tamagochi.add(getHilIrudi());
		try {
			Thread.sleep(5000); // Espera 5 segundo
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Partida.getPartida().gordePartida();
		Partida.getPartida().reset();
		HasieraMenua frame2 = new HasieraMenua(PartidaErregistro.getPartidaErregistro());
		frame2.setVisible(true);
		PartidaErregistro.getPartidaErregistro().getLehenengoBostak();
		frame.dispose();
		
	}	
	private void hildaDagoBihotz(){
		bihotza1.setEnabled(false);
		bihotza2.setEnabled(false);
		bihotza3.setEnabled(false);
		bihotza4.setEnabled(false);
		panel_tamagochi.add(getHilIrudi());
		try {
			Thread.sleep(5000); // Espera 5 segundo
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Partida.getPartida().gordePartida();
		Partida.getPartida().reset();
		HasieraMenua frame2 = new HasieraMenua(PartidaErregistro.getPartidaErregistro());
		frame2.setVisible(true);
		PartidaErregistro.getPartidaErregistro().getLehenengoBostak();
		frame.dispose();
	}	
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
		getKakaIrudi().setVisible(true);
	}
	private void gaixo(){
		getgaixoIrudi().setVisible(true);
	}
	private void minijokuaBistaratu(){
		Minijokoa Minijokoa = new Minijokoa();
		Minijokoa.hasieratuMinijokoa();
	}
	private void marutchiBistaratu(){
		TamaIrudiak= new ImageIcon[] {
			new ImageIcon((this.getClass().getResource("/sprites/Marutchi1.png"))),
			new ImageIcon((this.getClass().getResource("/sprites/Marutchi2.png"))),
			//new ImageIcon((this.getClass().getResource("/sprites/Marutchi3.png"))),
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
		int aldagaia= Partida.getPartida().getScore();
		Puntuazioa.setForeground(new Color(255, 255, 255));
		Puntuazioa.setBounds(282, 4, 45, 13);
		Puntuazioa.setText(Integer.toString(aldagaia));
	}
	private void marutchiKaka(){
		TamaIrudiak= new ImageIcon[]{
			new ImageIcon((this.getClass().getResource("/sprites/Marutchi3.png")))
		};
	}
	private void marutchiGaixo(){
		TamaIrudiak= new ImageIcon[]{
			new ImageIcon((this.getClass().getResource("/sprites/Marutchi3.png")))
		};
	}
	/*private boolean panelContains(JPanel panel, JLabel label) {
		for (Component component : panel.getComponents()) {
			if (component.equals(label)) {
				return true;
			}
		}
		return false;
	}*/
	private class Kontroladorea implements ActionListener, MouseListener{
		@Override
		public void actionPerformed(ActionEvent e){
			if(e.getSource().equals(boton_exit)){
				Partida.getPartida().gordePartida();
				Partida.getPartida().reset();
				HasieraMenua frame2 = new HasieraMenua(PartidaErregistro.getPartidaErregistro());
				frame2.setVisible(true);
				PartidaErregistro.getPartidaErregistro().getLehenengoBostak();
				frame.dispose();
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource().equals(kakaIrudi)){
				getKakaIrudi().setVisible(false);
				Partida.getPartida().tamaKakaGarbitu();
			}else if(e.getSource().equals(gaixoIrudi)){
				getgaixoIrudi().setVisible(false);
				Partida.getPartida().tamaBirusKendu();
			}else if(e.getSource().equals(panel_candy)){
				kontadorea1++;
				System.out.println("clikatu da piruleta "+kontadorea1+" aldiz");
				
				if(getCandy3().isVisible()){
				}else if(getCandy2().isVisible()){
					getCandy3().setVisible(true);
				}else if(getCandy1().isVisible()){
					getCandy2().setVisible(true);
				}else{	
					getCandy1().setVisible(true);
				}
			}else if(e.getSource().equals(panel__soup)){
				kontadorea2++;
				System.out.println("clikatu da sopa "+kontadorea2+" aldiz");
				
				if(getKoilara3().isVisible()){
				}else if(getKoilara2().isVisible()){
					getKoilara3().setVisible(true);
				}else if(getKoilara1().isVisible()){
					getKoilara2().setVisible(true);
				}else{	
					getKoilara1().setVisible(true);
				}
			}else if(e.getSource().equals(panel_tamagochi)){
				if(getCandy3().isVisible()){
					getCandy3().setVisible(false);
					getCandy2().setVisible(false);
					getCandy1().setVisible(false);
				}else if(getCandy2().isVisible()){
					getCandy2().setVisible(false);
					getCandy1().setVisible(false);
				}else if(getCandy1().isVisible()){
					getCandy1().setVisible(false);
				}
				if(getKoilara3().isVisible()){
					getKoilara3().setVisible(false);
					getKoilara2().setVisible(false);
					getKoilara1().setVisible(false);
				}else if(getKoilara2().isVisible()){
					getKoilara2().setVisible(false);
					getKoilara1().setVisible(false);
				}else if(getKoilara1().isVisible()){
					getKoilara1().setVisible(false);
				}
				System.out.println("ikutu da tamagotchi");
				Partida.getPartida().tamaJan(kontadorea1,kontadorea2);
				kontadorea1=0;
				kontadorea2=0;
				
			}
		}
		/*public void bihotzakEtaSopakGehitu(int kont1, int kont2){
				int multiplikatzaileBiz=kont1;
				int multiplikatzaileAse=kont2;
				System.out.println("gehitu bizitzaaaaaa");
				Partida.getPartida().tamaJan(multiplikatzaileBiz,multiplikatzaileAse);
		}*/
		
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
	}
}


