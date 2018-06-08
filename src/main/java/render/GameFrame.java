package render;

import javax.swing.*;

public class GameFrame extends JFrame {


    public GameFrame() {
        super();
        add(new GamePanel());
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
