import java.awt.Color;
import java.awt.Graphics2D;

public class Player {
    public int xPos;
    public int yPos;
    int width;
    int height; 
    String direction = "";

    public Player (Rect playerRect) {
        this.xPos = playerRect.x;
        this.yPos = playerRect.y;
        this.width = playerRect.width;
        this.height = playerRect.height;
    }

    public void changeDirection(String direction){
        if (direction == "up"){
            this.direction = direction;
        }
        else if (direction == "down"){
            this.direction = direction;
        }
        else {
            this.direction = direction;
        }
    }
    
    public void update() {
        if (direction == "up" && (yPos > 0)){
            yPos = yPos - Constants.SPEED;
        }
        else if (direction == "down" && (yPos < Constants.SCREEN_HEIGHT - height)) {
            yPos = yPos + Constants.SPEED;
        }
        else if (direction == "fill") {
        }
    }
    
    public void draw(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillRect(xPos, yPos, width, height);
    }
    
}
