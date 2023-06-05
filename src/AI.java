import java.awt.Color;
import java.awt.Graphics2D;

public class AI {
    int xPos;
    int yPos;
    int width; 
    int height;

    public AI(Rect aiRect) {
        this.xPos = aiRect.x;
        this.yPos = aiRect.y;
        this.width = aiRect.width;
        this.height = aiRect.height;
    }

    public void update(Ball ball) {
        if (yPos + height / 2 < ball.yPos) {
            if (yPos < Constants.SCREEN_HEIGHT - height) {
                yPos += Constants.AI_SPEED;
            }
        } else if (yPos + height / 2 > ball.yPos) {
            if (yPos > 0) {
                yPos -= Constants.AI_SPEED;
            }
        }
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillRect(xPos, yPos, width, height);
    }
}
