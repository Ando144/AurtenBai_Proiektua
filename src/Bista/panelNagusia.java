package src.Bista;

import java.awt.EventQueue;
import src.Eredua.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
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
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_5;
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
			panel_tamagochi.setBounds(71, 33, 294, 165);
			panel_tamagochi.setLayout(null);
		}
		return panel_tamagochi;
	}
	private JPanel getPanel_bihotzak() {
		if (panel_bihotzak == null) {
			panel_bihotzak = new JPanel();
			panel_bihotzak.setBackground(new Color(0, 0, 0));
			panel_bihotzak.setBounds(10, 33, 51, 165);
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
			panel_platos.setBounds(375, 33, 51, 165);
			panel_platos.setLayout(null);
			panel_platos.add(getLblNewLabel());
			panel_platos.add(getLblNewLabel_1());
			panel_platos.add(getLblNewLabel_2());
			panel_platos.add(getLblNewLabel_5());
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
		}
		return boton_exit;
	}
	private JPanel getPanel_candy() {
		if (panel_candy == null) {
			panel_candy = new JPanel();
			panel_candy.setForeground(new Color(255, 255, 255));
			panel_candy.setBackground(new Color(0, 0, 0));
			panel_candy.setBorder(new LineBorder(new Color(128, 128, 128)));
			panel_candy.setBounds(50, 219, 85, 34);
		}
		return panel_candy;
	}
	private JPanel getPanel__soup() {
		if (panel__soup == null) {
			panel__soup = new JPanel();
			panel__soup.setBackground(new Color(0, 0, 0));
			panel__soup.setForeground(new Color(255, 255, 255));
			panel__soup.setBorder(new LineBorder(new Color(128, 128, 128)));
			panel__soup.setBounds(302, 219, 85, 34);
		}
		return panel__soup;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("Soup");
			lblNewLabel_3.setForeground(new Color(255, 255, 255));
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_3.setBounds(351, 201, 45, 21);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("Candy");
			lblNewLabel_4.setForeground(new Color(255, 255, 255));
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel_4.setBounds(53, 201, 45, 21);
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
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setEnabled(true);
			lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/sprites/hungry.png")));
			lblNewLabel.setBounds(10, 10, 45, 31);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(this.getClass().getResource("/sprites/hungry.png")));
			lblNewLabel_1.setBounds(10, 51, 45, 31);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(this.getClass().getResource("/sprites/hungry.png")));
			lblNewLabel_2.setBounds(10, 92, 45, 31);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("");
			lblNewLabel_5.setIcon(new ImageIcon(this.getClass().getResource("/sprites/hungry.png")));
			lblNewLabel_5.setBounds(10, 133, 45, 32);
		}
		return lblNewLabel_5;
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

	}
	private class Kontroladorea implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			if(e.getSource().equals(boton_exit)){
				PartidaErregistro pe = new PartidaErregistro();
					HasieraMenua frame = new HasieraMenua(pe);
					pe.getLehenengoBostak();
					frame.setVisible(true);
					dispose();}
			}
		}
}


