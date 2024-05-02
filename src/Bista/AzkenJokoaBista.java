package src.Bista;
import javax.swing.*;

import java.awt.*;
import java.util.*;
import javax.swing.Timer;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AzkenJokoaBista implements Observer{
    private static final long serialVersionUID = 1L;
    private JFrame frame;
	private JPanel panel;
	private JPanel contentPane;
	private JRadioButton harri_botoia;
	private JRadioButton orri_botoia;
	private JRadioButton artazi_botoia;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPanel emaitzen_panela;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel jokalari_emaitza;
	private JLabel makina_emaitza;
	private JButton btnNewButton;
	private JLabel makina_irudi;
	private JLabel lblNewLabel_8;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
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
        frame.getContentPane().add(getLblNewLabel());
        frame.getContentPane().add(getLblNewLabel_1());
        frame.getContentPane().add(getLblNewLabel_2());
        frame.getContentPane().add(getEmaitzen_panela());
        frame.getContentPane().add(getBtnNewButton());
        frame.getContentPane().add(getMakina_irudi());
        frame.getContentPane().add(getLblNewLabel_8());
        frame.setVisible(true);

    }
	private JRadioButton getHarri_botoia() {
		if (harri_botoia == null) {
			harri_botoia = new JRadioButton("Harria");
			harri_botoia.setBackground(new Color(229, 229, 229));
			harri_botoia.setBounds(6, 53, 84, 21);
		}
		return harri_botoia;
	}
	private JRadioButton getOrri_botoia() {
		if (orri_botoia == null) {
			orri_botoia = new JRadioButton("Orria");
			orri_botoia.setBackground(new Color(229, 229, 229));
			orri_botoia.setBounds(6, 178, 84, 21);
		}
		return orri_botoia;
	}
	private JRadioButton getArtazi_botoia() {
		if (artazi_botoia == null) {
			artazi_botoia = new JRadioButton("Artazia");
			artazi_botoia.setBackground(new Color(229, 229, 229));
			artazi_botoia.setBounds(6, 320, 84, 21);
		}
		return artazi_botoia;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("sprites/harria.png")));
			lblNewLabel.setBounds(96, 10, 113, 105);
		}
		return lblNewLabel;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(this.getClass().getResource("sprites/orria.png")));
			lblNewLabel_1.setBounds(96, 125, 113, 129);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setIcon(new ImageIcon(this.getClass().getResource("sprites/artazia.png")));
			lblNewLabel_2.setBounds(96, 264, 132, 129);
		}
		return lblNewLabel_2;
	}
	private JPanel getEmaitzen_panela() {
		if (emaitzen_panela == null) {
			emaitzen_panela = new JPanel();
			emaitzen_panela.setBackground(new Color(229, 229, 229));
			emaitzen_panela.setBorder(new LineBorder(new Color(0, 0, 0)));
			emaitzen_panela.setBounds(244, 10, 210, 105);
			emaitzen_panela.setLayout(null);
			emaitzen_panela.add(getLblNewLabel_3());
			emaitzen_panela.add(getLblNewLabel_4());
			emaitzen_panela.add(getLblNewLabel_5());
			emaitzen_panela.add(getJokalari_emaitza());
			emaitzen_panela.add(getMakina_emaitza());
		}
		return emaitzen_panela;
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("EMAITZA");
			lblNewLabel_3.setBounds(71, 10, 71, 13);
		}
		return lblNewLabel_3;
	}
	private JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("ZU");
			lblNewLabel_4.setBounds(22, 32, 52, 13);
		}
		return lblNewLabel_4;
	}
	private JLabel getLblNewLabel_5() {
		if (lblNewLabel_5 == null) {
			lblNewLabel_5 = new JLabel("MAKINA");
			lblNewLabel_5.setBounds(117, 32, 83, 13);
		}
		return lblNewLabel_5;
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
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("JOKATU");
			btnNewButton.setBackground(new Color(229, 229, 229));
			btnNewButton.setBounds(292, 188, 104, 53);
		}
		return btnNewButton;
	}
	private JLabel getMakina_irudi() {
		if (makina_irudi == null) {
			makina_irudi = new JLabel("");
			makina_irudi.setIcon(new ImageIcon("C:\\Users\\mikel\\Desktop\\proba\\harria.png"));
			makina_irudi.setBounds(469, 155, 114, 99);
		}
		return makina_irudi;
	}
	private JLabel getLblNewLabel_8() {
		if (lblNewLabel_8 == null) {
			lblNewLabel_8 = new JLabel("MAKINA");
			lblNewLabel_8.setBounds(488, 125, 65, 13);
		}
		return lblNewLabel_8;
	}
    public void update(Observable o, Object arg){}
}

