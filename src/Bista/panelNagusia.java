package src.Bista;

import java.awt.EventQueue;
import src.Eredua.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.util.Observer;
import java.util.Observable;
import javax.swing.Timer;
public class panelNagusia extends JFrame implements Observer{

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
	private Kontroladorea kontroladorea = null;
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

	public panelNagusia(Observable pObservable) {
		getContentPane().setBackground(new Color(0, 0, 0));
		getContentPane().setForeground(new Color(0, 0, 0));
		setBounds(100, 100, 500, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().add(getPanel_tamagochi());
		getContentPane().add(getPanel_bihotzak());
		getContentPane().add(getPanel_platos());
		getContentPane().add(getTamagochi_Izena());
		getContentPane().add(getScore_label());
		getContentPane().add(getPuntuazioa());
		getContentPane().add(getBoton_exit());
		getContentPane().add(getPanel_candy());
		getContentPane().add(getPanel__soup());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getLblNewLabel_4());
		pObservable.addObserver(this);
		TamaIrudiak= new ImageIcon[] {
				new ImageIcon((this.getClass().getResource("/sprites/Egg1.png"))),
				new ImageIcon((this.getClass().getResource("/sprites/Egg2.png")))
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
			Puntuazioa = new JLabel("0");
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
			panel_candy.setBounds(50, 354, 85, 34);
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
	private JLabel getEggIrudi() {
		if (eggIrudi == null) {
			eggIrudi = new JLabel("");
			eggIrudi.setBounds(80, 0, 200, 200);
			eggIrudi.setIcon(new ImageIcon(this.getClass().getResource("/sprites/Egg1.png")));
		}
		else {
			eggIrudi.setIcon(TamaIrudiak[intOrain]);
		}
		return eggIrudi;
	}
	public void update(Observable o, Object arg){
		switch ((String)arg) {
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
		}
	}
	public void lauBihotzJarri(){
		bihotza1.setEnabled(true);
		bihotza2.setEnabled(true);
		bihotza3.setEnabled(true);
		bihotza4.setEnabled(true);
	}
	public void hiruBihotzJarri(){
		bihotza1.setEnabled(true);
		bihotza2.setEnabled(true);
		bihotza3.setEnabled(true);
		bihotza4.setEnabled(false);
	}
	public void biBihotzJarri(){
		bihotza1.setEnabled(true);
		bihotza2.setEnabled(true);
		bihotza3.setEnabled(false);
		bihotza4.setEnabled(false);
	}
	public void bihotzBatJarri(){
		bihotza1.setEnabled(true);
		bihotza2.setEnabled(false);
		bihotza3.setEnabled(false);
		bihotza4.setEnabled(false);
	}
	public void hildaDago(){}	
	public void lauKatiluJarri(){
		katilu1.setEnabled(true);
		katilu2.setEnabled(true);
		katilu3.setEnabled(true);
		katilu4.setEnabled(true);
	}
	public void hiruKatiluJarri(){
		katilu1.setEnabled(true);
		katilu2.setEnabled(true);
		katilu3.setEnabled(true);
		katilu4.setEnabled(false);
	}
	public void biKatiluJarri(){
		katilu1.setEnabled(true);
		katilu2.setEnabled(true);
		katilu3.setEnabled(false);
		katilu4.setEnabled(false);
	}
	public void katiluBatJarri(){
		katilu1.setEnabled(true);
		katilu2.setEnabled(false);
		katilu3.setEnabled(false);
		katilu4.setEnabled(false);
	}
	private class Kontroladorea implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
				PartidaErregistro pe = new PartidaErregistro();
				HasieraMenua frame = new HasieraMenua(pe);
				pe.getLehenengoBostak();
				frame.setVisible(true);
				dispose();	
		}
	}
}


