import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class GameScene extends Scene {
    KeyHandler kH;

    static Rect playerDimensions = new Rect(30,(Constants.SCREEN_HEIGHT/2) - 100,11, 120);
    static Rect aiDimensions = new Rect(Constants.SCREEN_WIDTH - 41,(Constants.SCREEN_HEIGHT/2) - 100,11, 120);
    static Rect ballDimensions = new Rect((Constants.SCREEN_WIDTH/2) - Constants.TILE_SIZE,
        (Constants.SCREEN_HEIGHT/2) - Constants.TILE_SIZE, 
        Constants.TILE_SIZE, Constants.TILE_SIZE);

    public Player player = new Player(playerDimensions);
    public AI ai = new AI(aiDimensions);
    Ball ball = Ball.getInstance(ballDimensions, player, ai);
    int playerScore = 0;
    int aiScore = 0;

    GameScene(KeyHandler kH) {
        this.kH = kH;
    }

    @Override
    public void update() {
        if (kH.upPressed == true) {
            player.changeDirection("up");
        } 
        else if (kH.upPressed = false) {
            player.changeDirection("fill");
        }
        else if (kH.downPressed == true) {
            player.changeDirection("down");
        } 
        else if (kH.downPressed == false) {
            player.changeDirection("fill");
        }

        player.update();

        if (ball.xPos < 34) {
            aiScore++;
            Ball.instance = null;
            ball = Ball.getInstance(ballDimensions, player, ai);
            if ((playerScore + aiScore % 2) == 1) {
                ball.ballSwitch = true;
            }
        }
        
        if (ball.xPos > Constants.SCREEN_WIDTH - 30) {
            playerScore++;
            Ball.instance = null;
            ball = Ball.getInstance(ballDimensions, player, ai);
            if ((playerScore + aiScore) % 2 == 1) {
                ball.ballSwitch = true;
            }
        } 
        
        ball.update();
        ai.update(ball);

        if (playerScore + aiScore == 5) { 
            MouseHandler.clicked = false;
            GamePanel.panel.changeScene(0);
        }
    }

    @Override
    public void draw(Graphics2D g) {
        player.draw(g);
        ai.draw(g);
        ball.draw(g);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 70));
        g.drawString(playerScore + " : " + aiScore, 275, 75);
    }
    
}
