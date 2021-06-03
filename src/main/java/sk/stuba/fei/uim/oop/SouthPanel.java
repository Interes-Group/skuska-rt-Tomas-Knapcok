package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SouthPanel extends JPanel implements ActionListener {

    private JButton tree;
    private JButton move;
    private JButton nextColor;
    private JLabel text;
    private CanvasPaper paper;
    private Color[] colors = {Color.RED, Color.BLUE, Color.green};
    private int i = 0;

    public SouthPanel(CanvasPaper paper) {

        this.setLayout(new GridLayout(1,0));
        this.tree = new JButton("Strom");
        this.move = new JButton("Presun");
        this.nextColor = new JButton("Dalsia Farba");
        this.text = new JLabel("NEROBIM NIC");
        this.text.setOpaque(true);
        this.text.setBackground(Color.RED);
        this.paper = paper;

        this.add(tree);
        this.add(move);
        this.add(nextColor);
        this.add(text);

        tree.addActionListener(this);
        move.addActionListener(this);
        nextColor.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tree){
            paper.setDrawShape(true);
            text.setText("KRESLENIE");
        }
        if (e.getSource() == move){
            paper.setMoveStatus(true);
            text.setText("PRESUVANIE");
        }
        if (e.getSource() == nextColor){
            paper.setColor(colors[i]);
            text.setBackground(colors[i]);
            i++;
            if(i > 2)
                i = 0;
        }


    }
}
