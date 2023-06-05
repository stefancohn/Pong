import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    Boolean upPressed = false;
    Boolean downPressed = false;

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int i = e.getKeyCode();
        if (i == KeyEvent.VK_DOWN) {
            downPressed = true;
        }
        if (i == KeyEvent.VK_UP) {
            upPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int i = e.getKeyCode();
        if (i == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if (i == KeyEvent.VK_UP) {
            upPressed = false;
        }
    }
    
}
