package Hangman;

import java.util.HashSet;
import java.util.Set;

public class LetterBox {
      private Set<Character> letters;

      public LetterBox() {
            letters = new HashSet<>();
      }

      public void add(char letter) {
            letters.add(letter);
      }

      public boolean contains(char letter) {
            return letters.contains(letter);
      }

      @Override
      public String toString() {
            return letters.toString();
      }
}
