//Created a new class for inherating the properties of Jpanel class in Java.
//import all the neccessary packages;
import java.awt.event.*;
import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;


public class SnakeGame extends JPanel implements ActionListener,KeyListener{

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

    //snake head
    Tile SnakeHead;
    ArrayList<Tile> snakeBody;
    
    
    //snake food

    //snake food
    Tile food;

    Random random;

    //game logic for move snake
    Timer gameLoop;
    Boolean gameOver = false;

    //movement for snake
    int velocityX;
    int velocityY;
    


    SnakeGame(int boardwidth, int boardheight){
        this.boardwidth = boardwidth;
        this.boardheight = boardheight;
        
        setPreferredSize(new Dimension(this.boardwidth, this.boardheight));
        
        setBackground(Color.black);

        addKeyListener(this);
        setFocusable(true);


        snakeBody = new ArrayList<Tile>();
        
        
        snakeBody = new ArrayList<Tile>();
        
        SnakeHead = new Tile(5,5);

        food = new Tile(10,10);

        random = new Random();

        placeFood();

        gameLoop = new Timer(100, this);
        gameLoop.start();

        velocityX = 0;
        velocityY = 0;
        

    }

    public void paint(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
    // for definign grids on board of snake game
        // for(int i = 0; i<boardwidth/tileSize; i++){
        //     g.drawLine(i*tileSize, 0, i*tileSize, boardheight);
        //     g.drawLine( 0, i*tileSize, boardwidth, i*tileSize);        
        // }


        //defining the food and it's color
        g.setColor(Color.red);
        //g.fillRect(food.x * tileSize, food.y*tileSize,tileSize,tileSize);
        g.fill3DRect(food.x * tileSize, food.y*tileSize,tileSize,tileSize,true);   //here we use the 3d shape for rectangle with every tile

        
        //defining color for snake
        g.setColor(Color.green);
        //g.fillRect(SnakeHead.x * tileSize, SnakeHead.y*tileSize, tileSize, tileSize);
        g.fill3DRect(SnakeHead.x * tileSize, SnakeHead.y*tileSize, tileSize, tileSize,true);

        //body of snake 
        for(int i = 0; i < snakeBody.size(); i++){
            Tile snakePart = snakeBody.get(i);
            //g.fillRect(snakePart.x*tileSize, snakePart.y*tileSize, tileSize, tileSize);       
            g.fill3DRect(snakePart.x*tileSize, snakePart.y*tileSize, tileSize, tileSize,true);       
        }
        //for tracking score of the game 
        g.setFont(new Font("Arial",Font.PLAIN, 10));
        if(gameOver){
            g.setColor(Color.blue);
            g.drawString(" GAME_OVER: " +String.valueOf(snakeBody.size()),tileSize - 16, tileSize);
        }
        else{
            g.drawString(" SCORE: " +String.valueOf(snakeBody.size()),tileSize - 16, tileSize);
        }
    }
 

    //now for placing the food at random position 
    public void placeFood(){
        food.x = random.nextInt(boardwidth/tileSize); //600/24 = 24
        food.y = random.nextInt(boardheight/tileSize);
    }

    //function for detect collision between snake head and food.
     public boolean collision(Tile tile1, Tile tile2){
         return tile1.x == tile2.x && tile1.y == tile2.y;
     }
    

    public void move(){

        //eating food
        if(collision(SnakeHead, food)){
            snakeBody.add(new Tile(food.x,food.y));
            placeFood();
        }

        for(int i= snakeBody.size()-1; i>=0; i--){
            Tile snakePart = snakeBody.get(i);
    
        if(i==0){
            snakePart.x = SnakeHead.x;
            snakePart.y = SnakeHead.y;
                
        }
        else{
            Tile previousSnakePart = snakeBody.get(i-1);
            snakePart.x = previousSnakePart.x;
            snakePart.y = previousSnakePart.y;
        }
        } 

        //snake head
        SnakeHead.x+=velocityX;
        SnakeHead.y+=velocityY;

        //added game over condition if..
        // 1st the snake collidies with it's won body 
        //2nd if snake touches the broder
        for(int i=0; i<snakeBody.size(); i++){
            Tile snakPart = snakeBody.get(i);
                //if it collied with snake head 
                if(collision(SnakeHead,snakPart)){
                    gameOver = true;
                }
        }

        //another condtion for if snake touches any of four walls it will stop 
        if(SnakeHead.x*tileSize <0 || SnakeHead.x*tileSize>boardwidth || SnakeHead.y*tileSize <0 || SnakeHead.y*tileSize>boardheight){
            gameOver = true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
        if(gameOver){
            gameLoop.stop();
        }
        // if(gameOver){
        //     gameLoop.stop();  //no need to be overwritten the collied condition 
        // }
        
    }

    @Override
    public void keyPressed(KeyEvent e ) {
        if(e.getKeyCode() == KeyEvent.VK_UP && velocityY != 1){
            velocityX = 0;
            velocityY = -1;
        }
        else if ( e.getKeyCode() == KeyEvent.VK_DOWN && velocityY != -1) {
                velocityX =0;
                velocityY=1;
        }
        else if(e.getKeyCode()==KeyEvent.VK_LEFT && velocityX != 1){
            velocityX = -1;
            velocityY = 0;
        }
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT && velocityX != -1){
            velocityX = 1;
            velocityY = 0;
        }
    }
    //now we have to make the game pannel (snake board) is to listen to the key presses
    //for that we have add the prigram into the constructor

    @Override
    public void keyTyped(KeyEvent e) {}


    @Override
    public void keyReleased(KeyEvent e) {} 

}



//rendom
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
