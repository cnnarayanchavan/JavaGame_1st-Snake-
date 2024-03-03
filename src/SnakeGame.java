//Created a new class for inherating the properties of Jpanel class in Java.
//import all the neccessary packages;
import java.awt.event.*;
import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class SnakeGame extends JPanel{

    private class Tile{
        int x;
        int y;
        Tile(int x, int y){
            this.x = x;
            this.y =y;
        }
}
    int boardwidth;
    int boardheight;
    int tileSize = 25;
    Tile SnakeHead;

    SnakeGame(int boardwidth, int boardheight){
        this.boardwidth = boardwidth;
        this.boardheight = boardheight;
        setPreferredSize(new Dimension(this.boardwidth, this.boardheight));
        setBackground(Color.black);
        SnakeHead = new Tile(5,5);

    }

    public void paint(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){

        
        //defining color for snake
        g.setColor(Color.yellow);
        g.fillRect(SnakeHead.x * tileSize, SnakeHead.y*tileSize, tileSize, tileSize);
    }

}




// public class SnakeGame extends JPanel{
//   public SnakeGame(int boardwidth, int boardheight){
//   this.boardwidth= boardwidth;
//   this.boardheight= boardheight;        
//     // private ImageIcon titleImage;
//     // public int SnakeGamae(){
//     //   return 0;
//     // }
//     public void paint(Graphics g){

//     g.setColor(Color.white);
//     g.drawRect(24,10,851,55);

//      //setting border of title image of game
//      titleImage = new ImageIcon("title.jpg");
//      titleImage.paintIcon(this, g, 25, 11);

//     // now setting us the boarder of actual game play 
//     g.setColor(Color.white);
//     g.drawRect(24,74,851,577);  
//     g.setColor(Color.BLACK);
//     g.fillRect(25, 75,850, 575);
    
//   }
//   }
