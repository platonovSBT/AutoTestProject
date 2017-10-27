package first_lab;

import java.awt.*;

public class Oval extends Form {
    //####### Fields #############
    private int width; //ширина
    private int height; //высота

    //######### Constructors ############
    public Oval() {
    }

    public Oval(int x, int y, Color color, int width, int height) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }
    //####### Getters & Setters ###########
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    //####### Implements Methods of first_lab.Form ###########
    @Override
    public void draw(Graphics g) {
        Color oldColor=g.getColor();
        g.setColor(getColor());
        g.drawOval(getX() - width / 2,getY() - height / 2,width,height);
        g.setColor(oldColor);
    }
    @Override
    public void fill(Graphics g)
    {
        Color oldColor=g.getColor();
        g.setColor(getColor());
        g.fillOval(getX() - width / 2,getY() - height / 2,width,height);
        g.setColor(oldColor);
    }
    @Override
    public double square() {
        return Math.PI * width * height / 4;
    }
    @Override
    public double perimetr() {
        return  Math.PI * (width + height) / 2;
    }
    @Override
    public String toString()
    {
        return super.toString() + " ,Height:" + height + " ,Width: " + width;
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Oval other = (Oval) obj;
        if (width != other.width)
            return false;
        if (height != other.height)
            return false;
        return true;
    }
}