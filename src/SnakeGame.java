//Created a new class for inherating the properties of Jpanel class in Java.
//import all the neccessary packages;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.*;


public class SnakeGame extends JPanel{
  // public SnakeGame(int boardwidth, int boardheight){
  //   this.boardwidth= boardwidth;
  //   this.boardheight= boardheight;        
    private ImageIcon ImageTitle;
    public int SnakeGamae(){
      return 0;
    }
    public void paint(Graphics g){
    //setting border of title image of game
    ImageTitle = new ImageIcon("Title.jpg");
    ImageTitle.paintIcon(this, g, 25, 11);
    g.setColor(Color.RED);
    g.drawRect(24,10,851,55);

    // now setting us the boarder of actual game play 
    g.setColor(Color.RED);
    g.drawRect(24,74,851,577);  
    g.setColor(Color.BLACK);
    g.fillRect(25, 75,850, 575);
    
  }
  }
