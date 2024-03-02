// First Stage is to build the interface (GUI)
import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
      int boardwidth = 600;
      int boardheight = boardwidth;
      JFrame frame = new JFrame();
      frame.setTitle("Snake");
      frame.setSize(boardwidth,boardheight);
      frame.setVisible(true);
      frame.setResizable(false);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
//now we have to create the Jpanel to further game progress 