import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class MenuScene extends Scene {
    MouseHandler mH;
    Rect playBounds = new Rect(275, 325, 160, 100);
    Boolean darken = false;
    int i = 0;

    MenuScene(MouseHandler mH) {
        this.mH = mH;
    }

    @Override
    public void update() {
        if (mH.getX() > playBounds.x && mH.getY() > playBounds.y && 
        mH.getX() < playBounds.x + playBounds.width && mH.getY() < playBounds.y + playBounds.height) {
            darken = true;
            if (MouseHandler.clicked == true) {
                GamePanel.panel.changeScene(1);
            }
        } else {
            darken = false; }
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.setFont(new Font("Comic Sans MS", Font.BOLD, 100));
        g.drawString("Pong", 245, 220);
        if (darken == true) {
            g.setColor(Color.GRAY);
            g.setFont(new Font("Comic Sans MS", Font.PLAIN, 80));
            g.drawString("Play", 275, 400);
        } else {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Comic Sans MS", Font.PLAIN, 80));
            g.drawString("Play", 275, 400);
        }
    }
    
}
