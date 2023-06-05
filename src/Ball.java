import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Ball {
    public static Ball instance;
    public Player player;
    public AI ai;
    Random random = new Random();
    public int xPos;
    public int yPos;
    public int width;
    public int height;

    int ballYstart = random.nextInt(12) - 6;

    Boolean ballSwitch = false;
    Boolean topBotSwitch = false;

    public Ball(Rect ballD, Player player, AI ai) {
        this.xPos = ballD.x;
        this.yPos = ballD.y;
        this.width = ballD.width;
        this.height = ballD.height;
        this.player = player;
        this.ai = ai;
        if (ballYstart == 0) {
            ballYstart++;
        }
    }

    public static Ball getInstance(Rect ballD, Player player, AI ai) {
        if (instance == null) {
            instance = new Ball(ballD, player, ai);
        }
        return instance;
    }

    public void playerBallCollision() {
        if (xPos >= 37 && xPos <= 41 && yPos >= player.yPos - Constants.TILE_SIZE && yPos <= 
        player.yPos + player.height + Constants.TILE_SIZE) {
            ballSwitch = !ballSwitch;
        }
        
        if (xPos >= 640 && yPos >= ai.yPos - Constants.TILE_SIZE 
        && yPos <= ai.yPos + ai.height + Constants.TILE_SIZE) {
            ballSwitch = !ballSwitch;
        }
        if(yPos <= 0) {
            ballYstart *= -1;
        }
        if (yPos >= Constants.SCREEN_HEIGHT - Constants.TILE_SIZE) {
            ballYstart *= -1;
        }
    }

    public void update() {
        
        if (ballSwitch) {
            xPos += Constants.BALL_SPEED ;
            yPos += ballYstart * -1;
        }
        else if (!ballSwitch) {
            xPos -= Constants.BALL_SPEED;
            yPos += ballYstart * -1;
        }
        playerBallCollision();
        //System.out.println(ballSwitch);
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillRect(xPos, yPos, width, height);
        g.setStroke(new BasicStroke(3));
        g.setColor(Color.blue);
        g.drawRect(xPos, yPos, width, height);
    }
}
