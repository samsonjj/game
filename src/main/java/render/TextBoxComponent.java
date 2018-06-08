package render;

import state.CurrentText;

import javax.swing.*;
import java.awt.*;


public class TextBoxComponent extends JComponent {

    public static final int WIDTH = 500;
    public static final int HEIGHT = 200;

    public static final int TEXT_START_X = 30;
    public static final int TEXT_START_Y = 30;

    private String text;

    public TextBoxComponent() {
        super();
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        text = "initial text";
    }

    @Override
    public void paintComponent(Graphics g) {
        setText(CurrentText.text);

        Graphics2D g2 = (Graphics2D) g;
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, .5f));

        g2.setColor(new Color(1, 0, 0));
        g2.fillRect(0, 0, WIDTH, HEIGHT);
        g2.setColor(Color.WHITE);
        g2.fillRect(5, 5, WIDTH - 10, HEIGHT - 10);
        g2.setColor(Color.BLACK);
        drawText(text, g);

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
    }

    public void setText(String text) {
        this.text = text;
    }

    private void drawText(String text, Graphics g)
    {
        g.setFont(new Font("Helvetica", Font.BOLD, 20));
        FontMetrics textMetrics = g.getFontMetrics();

        int lineHeight = textMetrics.getHeight();
        String textToDraw = text;
        String[] arr = textToDraw.split(" ");
        int nIndex = 0;
        int startX = TEXT_START_X;
        int startY = TEXT_START_Y;
        while ( nIndex < arr.length )
        {
            String line = arr[nIndex++];
            while ( ( nIndex < arr.length ) && (textMetrics.stringWidth(line + " " + arr[nIndex]) < 447) )
            {
                line = line + " " + arr[nIndex];
                nIndex++;
            }
            g.drawString(line, startX, startY);
            startY = startY + lineHeight;
        }
    }
}
