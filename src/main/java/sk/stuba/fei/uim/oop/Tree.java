package sk.stuba.fei.uim.oop;

import java.awt.*;

public class Tree extends Rectangle {

    private Color color;

    public Tree(int x, int y, int width, int height, Color color) {
        super(x,y,width,height);
        this.color = color;

    }

    public void drawTree(Graphics g){
        g.setColor(color);
        g.fillOval(this.x,this.y,this.width,2*this.height/5);
        g.fillRect(this.x+this.width/3,this.y+this.height/3,width/3,2*height/6);
    }
}
