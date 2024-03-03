//Created a new class for inherating the properties of Jpanel class in Java.
//import all the neccessary packages;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.*;


public class SnakeGame extends JPanel{
  public SnakeGame(int boardwidth, int boardheight){
  this.boardwidth= boardwidth;
  this.boardheight= boardheight;        
    // private ImageIcon titleImage;
    // public int SnakeGamae(){
    //   return 0;
    // }
    public void paint(Graphics g){

    g.setColor(Color.RED);
    g.drawRect(24,10,851,55);

     //setting border of title image of game
     titleImage = new ImageIcon("title.jpg");
     titleImage.paintIcon(this, g, 25, 11);

    // now setting us the boarder of actual game play 
    g.setColor(Color.RED);
    g.drawRect(24,74,851,577);  
    g.setColor(Color.BLACK);
    g.fillRect(25, 75,850, 575);
    
  }
  }
