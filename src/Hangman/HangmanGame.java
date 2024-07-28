package Hangman;

public class HangmanGame {
      private Player player;
      private Words secretWord;
      private LetterBox letterBox;
      private int wrongGuessCount = 7;

      public HangmanGame() {
            player = new Player();
            player.askName();
            secretWord = new Words();
            letterBox = new LetterBox();
      }

      public void makeGuess(char guess) {
            if (letterBox.contains(guess)) {
                  System.out.println("Try again, You've already used the letter " + guess);
            } else {
                  letterBox.add(guess); // Tambahkan ini
                  if (secretWord.guess(guess)) {
                        System.out.println("Great, You have found the letter " + guess);
                  } else {
                        wrongGuessCount--;
                        System.out.println("Ohh sorry, You guessed wrong. Lives left: " + wrongGuessCount);
                  }
            }
      }

      public boolean isGameOver() {
            return wrongGuessCount <= 0 || secretWord.found();
      }

      public boolean isWin() {
            return secretWord.found();
      }

      public String getHiddenWord() {
            return secretWord.getHiddenWord();
      }

      public int getLives() {
            return wrongGuessCount;
      }

      public String getUsedLetters() {
            return letterBox.toString();
      }

      public String getFullWord() {
            return secretWord.getWord();
      }
}
