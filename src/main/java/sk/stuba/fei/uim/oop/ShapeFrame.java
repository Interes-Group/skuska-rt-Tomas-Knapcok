package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class ShapeFrame extends JFrame {

    public ShapeFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Draw Shapes");
        this.setLocation(50, 50);
        this.setSize(500, 500);
        this.setLayout(new BorderLayout());

        CanvasPaper canvas = new CanvasPaper();
        SouthPanel buttons = new SouthPanel(canvas);


        this.add("Center", canvas);
        this.add("South", buttons);
        this.setFocusable(false);
        this.setVisible(true);
    }
}
