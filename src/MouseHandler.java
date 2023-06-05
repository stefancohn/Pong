import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener {
    static Boolean clicked = false;
    int x;
    int y;

    public int getX() { 
        return this.x; 
    }
    public int getY() { 
        return this.y;
    }
    public boolean clicked() {
        return MouseHandler.clicked; 
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        MouseHandler.clicked = true;
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        MouseHandler.clicked = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.x = e.getX();
        this.y = e.getY();
    }
}
