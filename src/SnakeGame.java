//Created a new class for inherating the properties of Jpanel class in Java.
//import all the neccessary packages;
import javax.swing.JPanel;
import java.awt.*;


public class SnakeGame extends JPanel{
  // public SnakeGame(int boardwidth, int boardheight){
  //   this.boardwidth= boardwidth;
  //   this.boardheight= boardheight;        
    public int SnakeGamae(){
      return 0;
    }
    public void paint(Graphics g){
    //setting border of title image of game
    g.setColor(Color.RED);
    g.drawRect(24,10,851,55);

    // now setting us the boarder of actual game play 
    g.setColor(Color.RED);
    g.drawRect(24,70,851,55);  
    
  }
  }
