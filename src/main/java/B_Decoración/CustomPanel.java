package B_Decoración;

import javax.swing.*;
import java.awt.*;

public class CustomPanel extends JPanel {
    private Color backgroundColor;

    public CustomPanel(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(backgroundColor);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}