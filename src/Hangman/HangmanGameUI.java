package Hangman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangmanGameUI extends JFrame {
      private HangmanGame hangmanGame;
      private JLabel wordLabel;
      private JLabel livesLabel;
      private JTextField guessField;
      private JTextArea letterBoxArea;
      private JButton guessButton;
      private JButton newGameButton;
      private HangmanDrawing hangmanDrawing;

      public HangmanGameUI() {
            setTitle("Hangman Game");
            setSize(400, 450); // Mengurangi lebar jendela
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            hangmanGame = new HangmanGame();

            wordLabel = new JLabel("Word: " + hangmanGame.getHiddenWord());
            livesLabel = new JLabel("Lives: " + hangmanGame.getLives());
            guessField = new JTextField(5);
            letterBoxArea = new JTextArea(5, 20);
            letterBoxArea.setEditable(false);
            guessButton = new JButton("Guess");
            newGameButton = new JButton("New Game");

            guessButton.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        String input = guessField.getText().toUpperCase();
                        if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                              char guess = input.charAt(0);
                              hangmanGame.makeGuess(guess);
                              updateUI();
                              guessField.setText("");
                              if (hangmanGame.isGameOver()) {
                                    String message = hangmanGame.isWin() ? "You Win!"
                                                : "You Lose!\nThe Word was: " + hangmanGame.getFullWord();
                                    JOptionPane.showMessageDialog(null, message);
                              }
                        } else {
                              JOptionPane.showMessageDialog(null, "Please enter a single letter.");
                              guessField.setText("");
                        }
                  }
            });

            newGameButton.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        hangmanGame = new HangmanGame();
                        updateUI();
                  }
            });

            setLayout(new BorderLayout());

            // Top panel with word and lives labels
            JPanel topPanel = new JPanel(new GridLayout(2, 1));
            topPanel.add(wordLabel);
            topPanel.add(livesLabel);
            add(topPanel, BorderLayout.NORTH);

            // Center panel with guess input, button, and drawing
            JPanel centerPanel = new JPanel(new BorderLayout());

            // Input panel with "Enter your guess", guessField, and guessButton centered
            JPanel inputPanel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);

            gbc.gridx = 0;
            gbc.gridy = 0;
            inputPanel.add(new JLabel("Enter your guess:"), gbc);

            gbc.gridx = 1;
            gbc.gridy = 0;
            inputPanel.add(guessField, gbc);

            gbc.gridx = 2;
            gbc.gridy = 0;
            inputPanel.add(guessButton, gbc);

            centerPanel.add(inputPanel, BorderLayout.NORTH);

            hangmanDrawing = new HangmanDrawing(hangmanGame.getLives());
            centerPanel.add(hangmanDrawing, BorderLayout.CENTER);
            add(centerPanel, BorderLayout.CENTER);

            // Bottom panel with used letters and new game button
            JPanel bottomPanel = new JPanel(new BorderLayout());
            bottomPanel.add(new JScrollPane(letterBoxArea), BorderLayout.CENTER);
            bottomPanel.add(newGameButton, BorderLayout.SOUTH);
            add(bottomPanel, BorderLayout.SOUTH);

            updateUI();
      }

      private void updateUI() {
            wordLabel.setText("Word: " + hangmanGame.getHiddenWord());
            livesLabel.setText("Lives: " + hangmanGame.getLives());
            letterBoxArea.setText("Used Letters: " + hangmanGame.getUsedLetters());
            hangmanDrawing.setLives(hangmanGame.getLives());
            hangmanDrawing.repaint();
      }

      public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                  @Override
                  public void run() {
                        new HangmanGameUI().setVisible(true);
                  }
            });
      }
}
