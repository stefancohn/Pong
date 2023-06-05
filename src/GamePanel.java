import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {
    Thread GameThread = new Thread(this);
    public static GamePanel panel = null;

    public int sceneNum;
    public Scene currentScene;

    MouseHandler mh = new MouseHandler();
    KeyHandler kh = new KeyHandler();

    GamePanel(int width, int height) {
        //set up game panel
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.setDoubleBuffered(true);
        this.addMouseListener(mh);
        this.addMouseMotionListener(mh);
        this.addKeyListener(kh);
        changeScene(0);
    }

    //singleton game panel
    public static GamePanel getPanel() {
        if (GamePanel.panel == null) {
            GamePanel.panel = new GamePanel(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        }
        return panel;
    }

    //scene manager
    public void changeScene(int newState) {
        sceneNum = newState;
        switch(sceneNum) {
            case 0:
                currentScene = new MenuScene(mh);
                break;
            case 1:
                currentScene = new GameScene(kh);
                break;
            default:
                System.out.println("Unknown scene.");
                currentScene = null;
                break;
        }
    }

    //game thread
    public void startGameThread() { 
        GameThread.start();
    } 

    @Override
    //game loop
    public void run() {
        double drawInterval = 1000000000/Constants.FPS;
        double delta = 0; 
        long lastTime = System.nanoTime();
        long currentTime; 

        while (GameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update() {
        //update whatever scene encompases the "current scene"
        currentScene.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        currentScene.draw(g2);
        g2.dispose();
    }
}
   
