package B_Decoración;

import javax.swing.*;
import java.awt.*;

public class decoPanel extends JSeparator {

    public decoPanel() {
        super(JSeparator.VERTICAL);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        g.drawLine(1, 0, 1, getHeight());
    }
}