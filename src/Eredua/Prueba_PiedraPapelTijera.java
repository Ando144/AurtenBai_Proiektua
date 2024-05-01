package src.Eredua;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;



public class Prueba_PiedraPapelTijera extends JFrame implements ActionListener {
    private JLabel tamagotchiLabel;
    private JButton piedraButton;
    private JButton papelButton;
    private JButton tijeraButton;
    private int playerScore;
    private int tamagotchiScore;

    public Prueba_PiedraPapelTijera() {
        setTitle("Piedra, Papel, Tijera");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tamagotchiLabel = new JLabel();
        add(tamagotchiLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        piedraButton = new JButton("Piedra");
        piedraButton.addActionListener(this);
        buttonPanel.add(piedraButton);

        papelButton = new JButton("Papel");
        papelButton.addActionListener(this);
        buttonPanel.add(papelButton);

        tijeraButton = new JButton("Tijera");
        tijeraButton.addActionListener(this);
        buttonPanel.add(tijeraButton);

        add(buttonPanel, BorderLayout.SOUTH);

        playerScore = 0;
        tamagotchiScore = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == piedraButton) {
            playGame("piedra");
        } else if (e.getSource() == papelButton) {
            playGame("papel");
        } else if (e.getSource() == tijeraButton) {
            playGame("tijera");
        }
    }

    private void playGame(String playerChoice) {
        String[] choices = {"piedra", "papel", "tijera"};
        Random random = new Random();
        int tamagotchiChoiceIndex = random.nextInt(choices.length);
        String tamagotchiChoice = choices[tamagotchiChoiceIndex];

        // Mostrar la elección de la máquina durante 2 segundos
        tamagotchiLabel.setText(tamagotchiChoice);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tamagotchiLabel.setText("");

        if (playerChoice.equals(tamagotchiChoice)) {
            JOptionPane.showMessageDialog(this, "Empate");
        } else if ((playerChoice.equals("piedra") && tamagotchiChoice.equals("tijera")) ||
                (playerChoice.equals("papel") && tamagotchiChoice.equals("piedra")) ||
                (playerChoice.equals("tijera") && tamagotchiChoice.equals("papel"))) {
            playerScore++;
            JOptionPane.showMessageDialog(this, "Ganaste esta ronda");
        } else {
            tamagotchiScore++;
            JOptionPane.showMessageDialog(this, "Perdiste esta ronda");
        }

        if (playerScore == 2) {
            JOptionPane.showMessageDialog(this, "¡Ganaste el juego!");
            resetGame();
        } else if (tamagotchiScore == 2) {
            JOptionPane.showMessageDialog(this, "¡Perdiste el juego!");
            resetGame();
        }
    }

    private void resetGame() {
        playerScore = 0;
        tamagotchiScore = 0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Prueba_PiedraPapelTijera game = new Prueba_PiedraPapelTijera();
            game.setVisible(true);
        });
    }
}
