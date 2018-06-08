package render;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {


    public GamePanel() {
        super();
        setLayout(null);
        initComponents();
        setSize(1000, 1000);
    }


    public void initComponents() {
        TextBoxComponent textBoxComponent = new TextBoxComponent();
        add(textBoxComponent);
        textBoxComponent.setBounds(250, 700, 1000, 1000);

        BackgroundComponent backgroundComponent = new BackgroundComponent();
        add(backgroundComponent);
        backgroundComponent.setBounds(0, 0, 1000, 1000);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
