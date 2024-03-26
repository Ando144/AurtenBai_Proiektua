package src.Bista;

import src.Eredua.*;

import java.awt.*;
import java.util.*;
import javax.swing.Timer;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HasieraMenua extends JFrame implements Observer{
	
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
	private JLabel Leh;
	private JLabel Big;
	private JLabel Hir;
	private JLabel Lau;
	private JLabel Bos;
	private JLabel LehName;
	private JLabel LehScore;
	private JLabel BigName;
	private JLabel BigScore;
	private JLabel HirName;
	private JLabel HirScore;
	private JLabel LauName;
	private JLabel LauScore;
	private JLabel BosName;
	private JLabel BosScore;

	private Kontroladorea kontroladorea = null;

	private Kontroladorea getKontroladorea() {
		if (kontroladorea == null) {
			kontroladorea = new Kontroladorea();
		}
		return kontroladorea;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PartidaErregistro pe = new PartidaErregistro();
					HasieraMenua frame = new HasieraMenua(pe);
					pe.getLehenengoBostak();
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
	public HasieraMenua(Observable pErreg) {
		setFont(new Font("Dialog", Font.PLAIN, 31));
		getContentPane().setBackground(new Color(0, 0, 0));
		getContentPane().setForeground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		getContentPane().setLayout(new GridLayout(2, 1, 0, 0));
		getContentPane().add(getPanel());
		getContentPane().add(getPanel_1());
		
		pErreg.addObserver(this);
		
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
                Leh.setForeground(koloreak[intOrain1]);
                LehName.setForeground(koloreak[intOrain1]);
                LehScore.setForeground(koloreak[intOrain1]);
                Big.setForeground(koloreak[intOrain2]);
                BigName.setForeground(koloreak[intOrain2]);
                BigScore.setForeground(koloreak[intOrain2]);
                Hir.setForeground(koloreak[intOrain3]);
                HirName.setForeground(koloreak[intOrain3]);
                HirScore.setForeground(koloreak[intOrain3]);
                Lau.setForeground(koloreak[intOrain4]);
                LauName.setForeground(koloreak[intOrain4]);
                LauScore.setForeground(koloreak[intOrain4]);
                Bos.setForeground(koloreak[intOrain5]);
                BosName.setForeground(koloreak[intOrain5]);
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
			Erregistroa.add(getLeh());
			Erregistroa.add(getBig());
			Erregistroa.add(getHir());
			Erregistroa.add(getLau());
			Erregistroa.add(getBos());
			Erregistroa.add(getLehName());
			Erregistroa.add(getLehScore());
			Erregistroa.add(getBigName());
			Erregistroa.add(getBigScore());
			Erregistroa.add(getHirName());
			Erregistroa.add(getHirScore());
			Erregistroa.add(getLauName());
			Erregistroa.add(getLauScore());
			Erregistroa.add(getBosName());
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
			PlayBotoi.addActionListener(getKontroladorea());
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
			ExitBotoi.addActionListener(getKontroladorea());
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
	private JLabel getLeh() {
		if (Leh == null) {
			Leh = new JLabel("1st");
			Leh.setHorizontalAlignment(SwingConstants.CENTER);
			Leh.setFont(new Font("Arial", Font.PLAIN, 15));
			Leh.setForeground(new Color(0, 255, 255));
			Leh.setBounds(10, 40, 43, 14);
		}
		return Leh;
	}
	private JLabel getBig() {
		if (Big == null) {
			Big = new JLabel("2nd");
			Big.setHorizontalAlignment(SwingConstants.CENTER);
			Big.setFont(new Font("Arial", Font.PLAIN, 15));
			Big.setForeground(Color.GREEN);
			Big.setBounds(10, 65, 43, 14);
		}
		return Big;
	}
	private JLabel getHir() {
		if (Hir == null) {
			Hir = new JLabel("3rd");
			Hir.setHorizontalAlignment(SwingConstants.CENTER);
			Hir.setFont(new Font("Arial", Font.PLAIN, 15));
			Hir.setForeground(Color.MAGENTA);
			Hir.setBounds(10, 90, 43, 14);
		}
		return Hir;
	}
	private JLabel getLau() {
		if (Lau == null) {
			Lau = new JLabel("4th");
			Lau.setHorizontalAlignment(SwingConstants.CENTER);
			Lau.setFont(new Font("Arial", Font.PLAIN, 15));
			Lau.setForeground(new Color(255, 140, 0));
			Lau.setBounds(10, 115, 43, 14);
		}
		return Lau;
	}
	
	//   ((PartidaErregistroa)arg0).metodo1()
	
	
	private JLabel getBos() {
		if (Bos == null) {
			Bos = new JLabel("5th");
			Bos.setHorizontalAlignment(SwingConstants.CENTER);
			Bos.setFont(new Font("Arial", Font.PLAIN, 15));
			Bos.setForeground(Color.YELLOW);
			Bos.setBounds(10, 140, 43, 14);
		}
		return Bos;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		LehName.setText(((PartidaErregistro)o).getLeh());
		LehScore.setText(((PartidaErregistro)o).getLehSc());
		
		BigName.setText(((PartidaErregistro)o).getBig());
		BigScore.setText(((PartidaErregistro)o).getBigSc());
		
		HirName.setText(((PartidaErregistro)o).getHir());
		HirScore.setText(((PartidaErregistro)o).getHirSc());
		
		LauName.setText(((PartidaErregistro)o).getLau());
		LauScore.setText(((PartidaErregistro)o).getLauSc());
		
		BosName.setText(((PartidaErregistro)o).getBos());
		BosScore.setText(((PartidaErregistro)o).getBosSc());
		
	}
	private JLabel getLehName() {
		if (LehName == null) {
			LehName = new JLabel("1Name1");
			LehName.setHorizontalAlignment(SwingConstants.CENTER);
			LehName.setFont(new Font("Arial", Font.PLAIN, 12));
			LehName.setForeground(Color.CYAN);
			LehName.setBounds(84, 41, 74, 14);
		}
		return LehName;
	}
	private JLabel getLehScore() {
		if (LehScore == null) {
			LehScore = new JLabel("1Score1");
			LehScore.setHorizontalAlignment(SwingConstants.CENTER);
			LehScore.setFont(new Font("Arial", Font.PLAIN, 15));
			LehScore.setForeground(Color.CYAN);
			LehScore.setBounds(182, 40, 51, 14);
		}
		return LehScore;
	}
	private JLabel getBigName() {
		if (BigName == null) {
			BigName = new JLabel("2Name2");
			BigName.setHorizontalAlignment(SwingConstants.CENTER);
			BigName.setFont(new Font("Arial", Font.PLAIN, 12));
			BigName.setForeground(Color.GREEN);
			BigName.setBounds(84, 65, 74, 14);
		}
		return BigName;
	}
	private JLabel getBigScore() {
		if (BigScore == null) {
			BigScore = new JLabel("2Score2");
			BigScore.setHorizontalAlignment(SwingConstants.CENTER);
			BigScore.setFont(new Font("Arial", Font.PLAIN, 15));
			BigScore.setForeground(Color.GREEN);
			BigScore.setBounds(182, 65, 51, 14);
		}
		return BigScore;
	}
	private JLabel getHirName() {
		if (HirName == null) {
			HirName = new JLabel("3Name3");
			HirName.setHorizontalAlignment(SwingConstants.CENTER);
			HirName.setFont(new Font("Arial", Font.PLAIN, 12));
			HirName.setForeground(Color.MAGENTA);
			HirName.setBounds(84, 90, 74, 14);
		}
		return HirName;
	}
	private JLabel getHirScore() {
		if (HirScore == null) {
			HirScore = new JLabel("3Score3");
			HirScore.setHorizontalAlignment(SwingConstants.CENTER);
			HirScore.setFont(new Font("Arial", Font.PLAIN, 15));
			HirScore.setForeground(Color.MAGENTA);
			HirScore.setBounds(182, 90, 51, 14);
		}
		return HirScore;
	}
	private JLabel getLauName() {
		if (LauName == null) {
			LauName = new JLabel("4Name4");
			LauName.setHorizontalAlignment(SwingConstants.CENTER);
			LauName.setFont(new Font("Arial", Font.PLAIN, 12));
			LauName.setForeground(new Color(255, 140, 0));
			LauName.setBounds(84, 115, 74, 14);
		}
		return LauName;
	}
	private JLabel getLauScore() {
		if (LauScore == null) {
			LauScore = new JLabel("4Score4");
			LauScore.setHorizontalAlignment(SwingConstants.CENTER);
			LauScore.setFont(new Font("Arial", Font.PLAIN, 15));
			LauScore.setForeground(new Color(255, 140, 0));
			LauScore.setBounds(182, 115, 51, 14);
		}
		return LauScore;
	}
	private JLabel getBosName() {
		if (BosName == null) {
			BosName = new JLabel("5Name5");
			BosName.setHorizontalAlignment(SwingConstants.CENTER);
			BosName.setFont(new Font("Arial", Font.PLAIN, 12));
			BosName.setForeground(Color.YELLOW);
			BosName.setBounds(84, 140, 74, 14);
		}
		return BosName;
	}
	private JLabel getBosScore() {
		if (BosScore == null) {
			BosScore = new JLabel("5Score5");
			BosScore.setHorizontalAlignment(SwingConstants.CENTER);
			BosScore.setFont(new Font("Arial", Font.PLAIN, 15));
			BosScore.setForeground(Color.YELLOW);
			BosScore.setBounds(182, 140, 51, 14);
		}
		return BosScore;
	}

	private class Kontroladorea implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(PlayBotoi)){
				Jokoa.getJokoa().partidaBatJokatu();
				panelNagusia.main(null);
				dispose();
				//itxi hasierako panela
			}else if(e.getSource().equals(ExitBotoi)){
				System.exit(0);
			}
		}
	}
}
