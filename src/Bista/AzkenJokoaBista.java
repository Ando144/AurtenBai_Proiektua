package src.Bista;
import javax.swing.*;

import java.awt.*;
import java.util.*;
import javax.swing.Timer;
import javax.swing.*;
import javax.swing.border.LineBorder;

import src.Eredua.AzkenJokoa;
import src.Eredua.Harria;
import src.Eredua.Orria;
import src.Eredua.Partida;
import src.Eredua.Artazia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AzkenJokoaBista extends JFrame implements Observer{
    private static final long serialVersionUID = 1L;
    private JFrame frame;
	private JPanel panel;
	private JPanel contentPane;
	private JRadioButton harri_botoia;
	private JRadioButton orri_botoia;
	private JRadioButton artazi_botoia;
	private JLabel harriIrudia;
	private JLabel orriIrudia;
	private JLabel artaziIrudia;
	private JPanel emaitzen_panela;
	private JLabel labelPuntuak;
	private JLabel labelZurePuntuak;
	private JLabel labelPuntuakMakina;
	private JLabel jokalari_emaitza;
	private JLabel makina_emaitza;
	private JButton jokatuBotoia;
	private JLabel makina_irudi;
	private JLabel labelIrudiMakina;
	private Kontroladorea kontroladorea = null;

	private Kontroladorea getKontroladorea(){
		if(kontroladorea == null){
			kontroladorea = new Kontroladorea();
		}
		return kontroladorea;
	}

	public AzkenJokoaBista(Observable o) {
       o.addObserver(this);
       hasieratu();
	}

    public void hasieratu(){
        frame= new JFrame();
        frame.getContentPane().setBackground(new Color(229, 229, 229));
        frame.setBackground(new Color(229, 229, 229));
        panel = new JPanel();
        panel.setBackground(new Color(229, 229, 229));
        frame.getContentPane().add(panel);
        frame.setForeground(new Color(0, 0, 0));
        frame.setBounds(100, 100, 623, 440);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        ButtonGroup group = new ButtonGroup(); //esto es para que no se puedan elegir mas de una opcion
		group.add(getArtazi_botoia());
		group.add(getHarri_botoia());
		group.add(getOrri_botoia());
        frame.getContentPane().add(getHarri_botoia());
        frame.getContentPane().add(getOrri_botoia());
        frame.getContentPane().add(getArtazi_botoia());
        frame.getContentPane().add(getHarriIrudia());
        frame.getContentPane().add(getOrriIrudia());
        frame.getContentPane().add(getArtaziIrudia());
        frame.getContentPane().add(getEmaitzen_panela());
        frame.getContentPane().add(getJokatuBotoia());
        frame.getContentPane().add(getMakina_irudi());
        frame.getContentPane().add(getLabelIrudiMakina());
        frame.setVisible(true);

    }
	private JRadioButton getHarri_botoia() {
		if (harri_botoia == null) {
			harri_botoia = new JRadioButton("Harria");
			harri_botoia.setBackground(new Color(229, 229, 229));
			harri_botoia.setBounds(6, 53, 84, 21);
			harri_botoia.addActionListener(getKontroladorea());
		}
		return harri_botoia;
	}
	private JRadioButton getOrri_botoia() {
		if (orri_botoia == null) {
			orri_botoia = new JRadioButton("Orria");
			orri_botoia.setBackground(new Color(229, 229, 229));
			orri_botoia.setBounds(6, 178, 84, 21);
			orri_botoia.addActionListener(getKontroladorea());
		}
		return orri_botoia;
	}
	private JRadioButton getArtazi_botoia() {
		if (artazi_botoia == null) {
			artazi_botoia = new JRadioButton("Artazia");
			artazi_botoia.setBackground(new Color(229, 229, 229));
			artazi_botoia.setBounds(6, 320, 84, 21);
			artazi_botoia.addActionListener(getKontroladorea());
		}
		return artazi_botoia;
	}
	private JLabel getHarriIrudia() {
		if (harriIrudia == null) {
			harriIrudia = new JLabel("");
			harriIrudia.setIcon(new ImageIcon(this.getClass().getResource("sprites/harria.png")));
			harriIrudia.setBounds(96, 10, 113, 105);
		}
		return harriIrudia;
	}
	private JLabel getOrriIrudia() {
		if (orriIrudia == null) {
			orriIrudia = new JLabel("");
			orriIrudia.setIcon(new ImageIcon(this.getClass().getResource("sprites/orria.png")));
			orriIrudia.setBounds(96, 125, 113, 129);
		}
		return orriIrudia;
	}
	private JLabel getArtaziIrudia() {
		if (artaziIrudia == null) {
			artaziIrudia = new JLabel("");
			artaziIrudia.setIcon(new ImageIcon(this.getClass().getResource("sprites/artazia.png")));
			artaziIrudia.setBounds(96, 264, 132, 129);
		}
		return artaziIrudia;
	}
	private JPanel getEmaitzen_panela() {
		if (emaitzen_panela == null) {
			emaitzen_panela = new JPanel();
			emaitzen_panela.setBackground(new Color(229, 229, 229));
			emaitzen_panela.setBorder(new LineBorder(new Color(0, 0, 0)));
			emaitzen_panela.setBounds(244, 10, 210, 105);
			emaitzen_panela.setLayout(null);
			emaitzen_panela.add(getLabelPuntuak());
			emaitzen_panela.add(getLabelZurePuntuak());
			emaitzen_panela.add(getLabelPuntuakMakina());
			emaitzen_panela.add(getJokalari_emaitza());
			emaitzen_panela.add(getMakina_emaitza());
		}
		return emaitzen_panela;
	}
	private JLabel getLabelPuntuak() {
		if (labelPuntuak == null) {
			labelPuntuak = new JLabel("EMAITZA");
			labelPuntuak.setBounds(71, 10, 71, 13);
		}
		return labelPuntuak;
	}
	private JLabel getLabelZurePuntuak() {
		if (labelZurePuntuak == null) {
			labelZurePuntuak = new JLabel("ZU");
			labelZurePuntuak.setBounds(22, 32, 52, 13);
		}
		return labelZurePuntuak;
	}
	private JLabel getLabelPuntuakMakina() {
		if (labelPuntuakMakina == null) {
			labelPuntuakMakina = new JLabel("MAKINA");
			labelPuntuakMakina.setBounds(117, 32, 83, 13);
		}
		return labelPuntuakMakina;
	}
	private JLabel getJokalari_emaitza() {
		if (jokalari_emaitza == null) {
			jokalari_emaitza = new JLabel("0");
			jokalari_emaitza.setBounds(27, 55, 13, 25);
		}
		return jokalari_emaitza;
	}
	private JLabel getMakina_emaitza() {
		if (makina_emaitza == null) {
			makina_emaitza = new JLabel("0");
			makina_emaitza.setBounds(129, 55, 13, 25);
		}
		return makina_emaitza;
	}
	private JButton getJokatuBotoia() {
		if (jokatuBotoia == null) {
			jokatuBotoia = new JButton("JOKATU");
			jokatuBotoia.setBackground(new Color(229, 229, 229));
			jokatuBotoia.setBounds(292, 188, 104, 53);
			jokatuBotoia.addActionListener(getKontroladorea());
		}
		return jokatuBotoia;
	}
	private JLabel getMakina_irudi() {
		if (makina_irudi == null) {
			makina_irudi = new JLabel("");
			//makina_irudi.setIcon(new ImageIcon(this.getClass().getResource("sprites/harria.png")));
			makina_irudi.setBounds(469, 155, 114, 99);
		}
		return makina_irudi;
	}
	private JLabel getLabelIrudiMakina() {
		if (labelIrudiMakina == null) {
			labelIrudiMakina = new JLabel("MAKINA");
			labelIrudiMakina.setBounds(488, 125, 65, 13);
		}
		return labelIrudiMakina;
	}

	/*private void irudiakAlternatu(){
		for (int i = 0; i < 3; i++){
			makina_irudi.setIcon(new ImageIcon(this.getClass().getResource("sprites/harria.png")));
			try {Thread.sleep(200);} catch (InterruptedException e) {e.printStackTrace();}
			makina_irudi.setIcon(new ImageIcon(this.getClass().getResource("sprites/orria.png")));
			try {Thread.sleep(200);} catch (InterruptedException e) {e.printStackTrace();}
			makina_irudi.setIcon(new ImageIcon(this.getClass().getResource("sprites/artazia.png")));
			try {Thread.sleep(200);} catch (InterruptedException e) {e.printStackTrace();}
		}
	}*/

	public void puntuazioakEguneratu(){
		jokalari_emaitza.setText(Integer.toString(AzkenJokoa.getAzkenJokoa().getPuntJokalaria()));
		makina_emaitza.setText(Integer.toString(AzkenJokoa.getAzkenJokoa().getPuntOrdenagailua()));
	}

	public void update(Observable o, Object arg){
		switch ((String)arg) {
			case "Harria":
				makina_irudi.setIcon(new ImageIcon(this.getClass().getResource("sprites/harria.png")));
				break;
			case "Orria":
				makina_irudi.setIcon(new ImageIcon(this.getClass().getResource("sprites/orria.png")));
				break;
			case "Artazia":
				makina_irudi.setIcon(new ImageIcon(this.getClass().getResource("sprites/artazia.png")));
				break;
			case "rIrabazi":
				puntuazioakEguneratu();
            	JOptionPane.showMessageDialog(this, "Ronda hau irabazi duzu.");
				break;
			case "rGaldu":
				puntuazioakEguneratu();
				JOptionPane.showMessageDialog(this, "Ronda hau galdu duzu.");
				break;
			case "rBerdinketa":
				JOptionPane.showMessageDialog(this, "Berdinketa egon da. Ronda errepikatu.");
				break;
			case "jIrabazi":
				puntuazioakEguneratu();
				JOptionPane.showMessageDialog(this, "Jokoa irabazi duzu. Tamagotchiak errebibitu du.");
				frame.dispose();
				AzkenJokoa.getAzkenJokoa().reset();
				Partida.getPartida().tamagotchiErrebibitu();
				break;
			case "jGaldu":
				puntuazioakEguneratu();
				JOptionPane.showMessageDialog(this, "Jokoa galdu duzu. Tamagotchia hil da.");
				frame.dispose();
				AzkenJokoa.getAzkenJokoa().reset();
				Partida.getPartida().partidaBukatu();
				break;
		}
	}

	private class Kontroladorea implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(getHarri_botoia())) {
				AzkenJokoa.getAzkenJokoa().jokalariaAukeraEgin(new Harria());
			} else if(e.getSource().equals(getOrri_botoia())){
				AzkenJokoa.getAzkenJokoa().jokalariaAukeraEgin(new Orria());
			} else if(e.getSource().equals(getArtazi_botoia())){
				AzkenJokoa.getAzkenJokoa().jokalariaAukeraEgin(new Artazia());
			} else if(e.getSource().equals(getJokatuBotoia())){
				//irudiakAlternatu();
				AzkenJokoa.getAzkenJokoa().rondaBatJokatu();
			}
		}
	}
}

