package sk.stuba.fei.uim.oop;

import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

@Data
public class CanvasPaper extends JPanel implements MouseListener, MouseMotionListener {

    public ArrayList<Tree> trees = new ArrayList<>();
    Tree currentTree;
    int posX = 0;
    int posY = 0;
    boolean moveStatus;
    boolean drawShape;
    Color color;

    public CanvasPaper() {
        super();
        addMouseListener(this);
        addMouseMotionListener(this);
        this.color = Color.RED;
        this.moveStatus = false;
        this.drawShape = false;
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(color);

        for (Tree temp : trees){
            temp.drawTree(g);
        }

        if (currentTree != null){
            currentTree.drawTree(g);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.posX = e.getX();
        this.posY = e.getY();

        if (drawShape)
            currentTree = new Tree(posX, posY, 1,1,color);

        if (moveStatus){
            if (trees != null){
                for (Tree temp : trees){
                    if (temp.contains(posX, posY)){
                        currentTree = temp;
                        trees.remove(temp);
                        System.out.println("si na strome");
                    }
                    else
                        System.out.println("nesi na strome");
                }
            }

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (drawShape){
            trees.add(currentTree);
        }
        if (moveStatus){
            trees.add(currentTree);
        }
        repaint();
        currentTree = null;
        drawShape = false;
        moveStatus = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int dragX = e.getX();
        int dragY = e.getY();

        if (currentTree != null && moveStatus){
            currentTree.x = dragX;
            currentTree.y = dragY;
            repaint();
        }


        if (currentTree != null && !moveStatus){
            if (dragX > posX && dragY > posY) {
                currentTree.width = dragX - posX;
                currentTree.height = dragY - posY;

            }
            if (dragX < posX && dragY > posY) {
                currentTree.x = dragX;
                currentTree.width = posX - dragX;
                currentTree.height = dragY - posY;

            }

            if (dragX > posX && dragY < posY) {
                currentTree.y = dragY;
                currentTree.width = dragX - posX;
                currentTree.height = posY - dragY;

            }

            if (dragX < posX && dragY < posY) {
                currentTree.x = dragX;
                currentTree.y = dragY;
                currentTree.width = posX - dragX;
                currentTree.height = posY - dragY;
            }

            repaint();
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
