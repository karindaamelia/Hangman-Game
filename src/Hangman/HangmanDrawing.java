package Hangman;

import javax.swing.*;
import java.awt.*;

public class HangmanDrawing extends JPanel {
      private int lives;

      public HangmanDrawing(int lives) {
            this.lives = lives;
            setPreferredSize(new Dimension(800, 300));
      }

      public void setLives(int lives) {
            this.lives = lives;
            repaint();
      }

      @Override
      protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawHangman(g, lives);
      }

      private void drawHangman(Graphics g, int lives) {
            // Gambar dasar tiang gantungan
            g.drawLine(50, 200, 150, 200); // base
            g.drawLine(100, 200, 100, 50); // pole
            g.drawLine(100, 50, 150, 50); // top bar
            g.drawLine(150, 50, 150, 70); // rope

            // Gambar berdasarkan jumlah nyawa yang tersisa
            switch (lives) {
                  case 5:
                        g.drawOval(140, 70, 20, 20); // head
                        break;
                  case 4:
                        g.drawOval(140, 70, 20, 20); // head
                        g.drawLine(150, 90, 150, 140); // body
                        break;
                  case 3:
                        g.drawOval(140, 70, 20, 20); // head
                        g.drawLine(150, 90, 150, 140); // body
                        g.drawLine(150, 110, 130, 100); // left arm
                        break;
                  case 2:
                        g.drawOval(140, 70, 20, 20); // head
                        g.drawLine(150, 90, 150, 140); // body
                        g.drawLine(150, 110, 130, 100); // left arm
                        g.drawLine(150, 110, 170, 100); // right arm
                        break;
                  case 1:
                        g.drawOval(140, 70, 20, 20); // head
                        g.drawLine(150, 90, 150, 140); // body
                        g.drawLine(150, 110, 130, 100); // left arm
                        g.drawLine(150, 110, 170, 100); // right arm
                        g.drawLine(150, 140, 130, 160); // left leg
                        break;
                  case 0:
                        g.drawOval(140, 70, 20, 20); // head
                        g.drawLine(150, 90, 150, 140); // body
                        g.drawLine(150, 110, 130, 100); // left arm
                        g.drawLine(150, 110, 170, 100); // right arm
                        g.drawLine(150, 140, 130, 160); // left leg
                        g.drawLine(150, 140, 170, 160); // right leg
                        break;
            }
      }
}
