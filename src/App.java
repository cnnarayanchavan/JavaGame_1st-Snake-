// First Stage is to build the interface (GUI)
// creating a board for snake game.
import java.awt.Color;

import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
      JFrame frame = new JFrame();
      frame.setTitle("Snake");
      //frame.setSize(boardwidth,boardheight);
      frame.setBounds(10,10,905,700);
      frame.setVisible(true);
      frame.setResizable(false);
      // frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setBackground(Color.DARK_GRAY);
      SnakeGame game = new SnakeGame();
      frame.add(game);
      
    }
}
//now we have to create the Jpanel to further game progress of GUI of snake game