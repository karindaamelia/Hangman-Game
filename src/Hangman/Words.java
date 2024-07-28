package Hangman;

import java.util.Random;

class Words {
      private String a;
      private StringBuffer b;
      private int found = 0;

      {
            String[] Words = new String[] {
                        "EQUIPMENT", "STUDENT", "ENVIRONMENT", "TEMPERATURE", "INFORMATION", "TELEPHONE", "GOVERNMENT",
                        "HEALTH",
                        "COMPUTER", "LITERATURE", "KNOWLEDGE", "ABILITY", "NATURE", "ACTIVITY", "QUALITY", "LANGUAGE",
                        "SECURITY",
                        "THOUGHT", "DIRECTION", "TECHNOLOGY", "FREEDOM", "UNIVERSITY", "DEPARTMENT", "GROWTH", "ADMIRE",
                        "APOLOGIZE",
                        "APPROACH", "CELEBRATE", "CONTINUE", "DETERMINE", "ENCOURAGE", "ADDITIONAL", "AVAILABLE",
                        "COMPETITIVE",
                        "CONFIDENT", "DIFFICULT", "EXPENSIVE", "FRIENDLY", "IMPORTANT", "IMPOSSIBLE", "COMPARE",
                        "EXPLAIN", "PREVENT",
                        "REMEMBER", "UNDERSTAND", "NERVOUS", "TELEVISION", "CHILD", "WATERMELON", "MUSHROOM", "SAUSAGE"
            };

            Random random = new Random();
            int randomWord = random.nextInt(Words.length);
            a = Words[randomWord];
            b = new StringBuffer(a.length());

            for (int i = 0; i < a.length(); i++) {
                  b.append('_');
            }
      }

      public boolean found() {
            return found == a.length();
      }

      public boolean guess(char character) {
            int index = a.indexOf(character);

            if (index == -1) {
                  return false;
            } else {
                  found += findOccurrences(character);
                  return true;
            }
      }

      private int findOccurrences(char character) {
            int idx = a.indexOf(character);
            b.setCharAt(idx, a.charAt(idx));

            int counter = 1;
            while (idx != -1) {
                  int index = a.indexOf(character, idx + 1);
                  idx = index;

                  if (idx != -1) {
                        counter++;
                        b.setCharAt(idx, a.charAt(idx));
                  }
            }
            return counter;
      }

      public String getHiddenWord() {
            StringBuilder hiddenWord = new StringBuilder();
            for (int i = 0; i < b.length(); i++) {
                  hiddenWord.append(b.charAt(i)).append(' ');
            }
            return hiddenWord.toString();
      }

      public String getWord() {
            return a;
      }
}
