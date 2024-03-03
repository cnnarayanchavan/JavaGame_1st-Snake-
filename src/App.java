// First Stage is to build the interface (GUI)
// creating a board for snake game.
import java.awt.Color;

import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        int boardwidth = 700;
        int boardheight = boardwidth;
      JFrame frame = new JFrame();
      frame.setTitle("Snake_Game");
      //frame.setSize(boardwidth,boardheight);
      frame.setSize(boardwidth, boardheight);
      frame.setVisible(true);
      frame.setResizable(false);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setBackground(Color.DARK_GRAY);
      SnakeGame game = new SnakeGame();
      frame.add(game);
      
    }
}
//now we have to create the Jpanel to further game progress of GUI of snake game
