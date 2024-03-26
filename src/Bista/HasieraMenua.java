package src.Bista;

import src.Eredua.*;

import java.awt.*;
import java.awt.EventQueue;
import java.util.*;
import javax.swing.Timer;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class HasieraMenua extends JFrame {
	
	private Timer timer;
	private ImageIcon[] tamagotchiIrudiak;
	private Color[] koloreak;
	private int intOrain;
	private int intOrain1;
	private int intOrain2;
	private int intOrain3;
	private int intOrain4;
	private int intOrain5;
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel Erregistroa;
	private JPanel Irudia;
	private JPanel Titulua;
	private JPanel PartSortu;
	private JLabel TituluIrudi;
	private JLabel MarutchiIrudi;
	private JLabel lblNewLabel;
	private JButton PlayBotoi;
	private JButton ExitBotoi;
	private JTextField PartIztxt;
	private JLabel YourNametxt;
	private JLabel LeaderBoardtxt;
	private JLabel LBTitulua;
	private JLabel LehScore;
	private JLabel BigScore;
	private JLabel HirScore;
	private JLabel LauScore;
	private JLabel BosScore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HasieraMenua frame = new HasieraMenua();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HasieraMenua() {
		setFont(new Font("Dialog", Font.PLAIN, 31));
		getContentPane().setBackground(new Color(0, 0, 0));
		getContentPane().setForeground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		getContentPane().setLayout(new GridLayout(2, 1, 0, 0));
		getContentPane().add(getPanel());
		getContentPane().add(getPanel_1());
		
		koloreak = new Color[]{
				Color.CYAN,
				Color.GREEN,
				Color.MAGENTA,
				new Color(255, 140, 0),
				Color.YELLOW
		};
		tamagotchiIrudiak = new ImageIcon[]{
                new ImageIcon("C:\\Users\\jonan\\Downloads\\sprites\\Marutchi1.png"),
                new ImageIcon("C:\\Users\\jonan\\Downloads\\sprites\\Marutchi2.png"),
                new ImageIcon("C:\\Users\\jonan\\Downloads\\sprites\\Marutchi4.png")
                // Irudiak
        };
		intOrain = 0;
        intOrain1= 0;
        intOrain2= 1;
        intOrain3= 2;
        intOrain4= 3;
        intOrain5= 4;

        // Segundoro irudia aldatzeko
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                intOrain = (intOrain + 1) % tamagotchiIrudiak.length;
                intOrain1 = (intOrain1 +1) % koloreak.length;
                intOrain2 = (intOrain2 +1) % koloreak.length;
                intOrain3 = (intOrain3 +1) % koloreak.length;
                intOrain4 = (intOrain4 +1) % koloreak.length;
                intOrain5 = (intOrain5 +1) % koloreak.length;
                MarutchiIrudi.setIcon(tamagotchiIrudiak[intOrain]);
                LehScore.setForeground(koloreak[intOrain1]);
                BigScore.setForeground(koloreak[intOrain2]);
                HirScore.setForeground(koloreak[intOrain3]);
                LauScore.setForeground(koloreak[intOrain4]);
                BosScore.setForeground(koloreak[intOrain5]);
            }
        });
        timer.start();
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(2, 1, 0, 0));
			panel.add(getTitulua());
			panel.add(getPartSortu());
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridLayout(0, 2, 0, 0));
			panel_1.add(getErregistroa());
			panel_1.add(getIrudia());
		}
		return panel_1;
	}
	private JPanel getErregistroa() {
		if (Erregistroa == null) {
			Erregistroa = new JPanel();
			Erregistroa.setBackground(SystemColor.desktop);
			Erregistroa.setLayout(null);
			Erregistroa.add(getLBTitulua());
			Erregistroa.add(getLehScore());
			Erregistroa.add(getBigScore());
			Erregistroa.add(getHirScore());
			Erregistroa.add(getLauScore());
			Erregistroa.add(getBosScore());
		}
		return Erregistroa;
	}
	private JPanel getIrudia() {
		if (Irudia == null) {
			Irudia = new JPanel();
			Irudia.setBackground(SystemColor.desktop);
			Irudia.setLayout(null);
			Irudia.add(getMarutchiIrudi());
			Irudia.add(getLblNewLabel());
		}
		return Irudia;
	}
	private JPanel getTitulua() {
		if (Titulua == null) {
			Titulua = new JPanel();
			Titulua.setBackground(SystemColor.desktop);
			FlowLayout fl_Titulua = (FlowLayout) Titulua.getLayout();
			Titulua.add(getTituluIrudi());
		}
		return Titulua;
	}
	private JPanel getPartSortu() {
		if (PartSortu == null) {
			PartSortu = new JPanel();
			PartSortu.setBackground(SystemColor.desktop);
			PartSortu.setLayout(null);
			PartSortu.add(getPlayBotoi());
			PartSortu.add(getExitBotoi());
			PartSortu.add(getPartIztxt());
			PartSortu.add(getYourNametxt());
			PartSortu.add(getLeaderBoardtxt());
		}
		return PartSortu;
	}
	private JLabel getTituluIrudi() {
		if (TituluIrudi == null) {
			TituluIrudi = new JLabel("");
			TituluIrudi.setIcon(new ImageIcon("C:\\Users\\jonan\\Downloads\\sprites\\MainTitle.png"));
		}
		return TituluIrudi;
	}
	private JLabel getMarutchiIrudi() {
		if (MarutchiIrudi == null) {
			MarutchiIrudi = new JLabel("");
			MarutchiIrudi.setBounds(80, 0, 200, 200);
			MarutchiIrudi.setIcon(new ImageIcon("C:\\Users\\jonan\\Downloads\\sprites\\Marutchi1.png"));
		}
		else {
			MarutchiIrudi.setIcon(tamagotchiIrudiak[intOrain]);
		}
		return MarutchiIrudi;
	}
	
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(28, 124, 54, 48);
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jonan\\Downloads\\sprites\\gudetama1.gif"));
		}
		return lblNewLabel;
	}
	private JButton getPlayBotoi() {
		if (PlayBotoi == null) {
			PlayBotoi = new JButton("play");
			PlayBotoi.setFont(new Font("Arial Black", Font.PLAIN, 15));
			PlayBotoi.setForeground(SystemColor.desktop);
			PlayBotoi.setBackground(Color.red);
			PlayBotoi.setBounds(283, 13, 89, 23);
			PlayBotoi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Jokoa.getJokoa().partidaBatJokatu();
					panelNagusia.main(null);
					//itxi frame hau
				}
			});
		}
		return PlayBotoi;
	}
	private JButton getExitBotoi() {
		if (ExitBotoi == null) {
			ExitBotoi = new JButton("exit");
			ExitBotoi.setFont(new Font("Arial Black", Font.PLAIN, 15));
			ExitBotoi.setForeground(SystemColor.desktop);
			ExitBotoi.setBackground(Color.red);
			ExitBotoi.setBounds(382, 13, 89, 23);
			ExitBotoi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return ExitBotoi;
	}
	private JTextField getPartIztxt() {
		if (PartIztxt == null) {
			PartIztxt = new JTextField();
			PartIztxt.setForeground(SystemColor.activeCaptionBorder);
			PartIztxt.setBackground(Color.DARK_GRAY);
			PartIztxt.setBounds(132, 13, 123, 22);
			PartIztxt.setColumns(10);
		}
		return PartIztxt;
	}
	private JLabel getYourNametxt() {
		if (YourNametxt == null) {
			YourNametxt = new JLabel("Your Name:");
			YourNametxt.setForeground(Color.RED);
			YourNametxt.setBounds(33, 11, 89, 23);
			Font fu = new Font (YourNametxt.getFont().getName(), Font.PLAIN, 15);
			YourNametxt.setFont(new Font("Arial Black", Font.PLAIN, 12));
		}
		return YourNametxt;
	}
	private JLabel getLeaderBoardtxt() {
		if (LeaderBoardtxt == null) {
			LeaderBoardtxt = new JLabel("LeaderBoard");
			LeaderBoardtxt.setForeground(Color.WHITE);
			Font fu1 = new Font (LeaderBoardtxt.getFont().getName(), Font.PLAIN, 20);
			LeaderBoardtxt.setFont(new Font("Arial", Font.PLAIN, 20));
			LeaderBoardtxt.setBounds(67, 69, 136, 23);
		}
		return LeaderBoardtxt;
	}
	private JLabel getLBTitulua() {
		if (LBTitulua == null) {
			LBTitulua = new JLabel("Rank           Name           Score");
			LBTitulua.setForeground(Color.RED);
			LBTitulua.setFont(new Font("Arial Black", Font.PLAIN, 13));
			LBTitulua.setBounds(10, 11, 223, 14);
		}
		return LBTitulua;
	}
	private JLabel getLehScore() {
		if (LehScore == null) {
			LehScore = new JLabel("1st                 ABC                 99");
			LehScore.setFont(new Font("Arial", Font.PLAIN, 15));
			LehScore.setForeground(new Color(0, 255, 255));
			LehScore.setBounds(10, 40, 223, 14);
		}
		return LehScore;
	}
	private JLabel getBigScore() {
		if (BigScore == null) {
			BigScore = new JLabel("New label");
			BigScore.setForeground(Color.GREEN);
			BigScore.setBounds(10, 90, 223, 14);
		}
		return BigScore;
	}
	private JLabel getHirScore() {
		if (HirScore == null) {
			HirScore = new JLabel("New label");
			HirScore.setForeground(Color.MAGENTA);
			HirScore.setBounds(10, 65, 223, 14);
		}
		return HirScore;
	}
	private JLabel getLauScore() {
		if (LauScore == null) {
			LauScore = new JLabel("New label");
			LauScore.setForeground(new Color(255, 140, 0));
			LauScore.setBounds(10, 140, 223, 14);
		}
		return LauScore;
	}
	private JLabel getBosScore() {
		if (BosScore == null) {
			BosScore = new JLabel("New label");
			BosScore.setForeground(Color.YELLOW);
			BosScore.setBounds(10, 115, 223, 14);
		}
		return BosScore;
	}
}
