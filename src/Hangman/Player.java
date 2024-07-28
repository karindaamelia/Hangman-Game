package Hangman;

import javax.swing.JOptionPane;

class Player {
      private String name;

      public void askName() {
            name = JOptionPane.showInputDialog(null, "Hi, Before starting this game, Please enter your name:",
                        "Welcome To The Hangman", JOptionPane.QUESTION_MESSAGE);
            if (name == null || name.trim().isEmpty()) {
                  name = "Player";
            }
      }

      public String getName() {
            return name;
      }
}
