import javax.swing.*;

public class Main {
    static ImageIcon logo = new ImageIcon(("duckIcon.png"));
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle(Constants.SCREEN_TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        GamePanel panel = GamePanel.getPanel();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setIconImage(logo.getImage());

        panel.startGameThread();
    }
}
