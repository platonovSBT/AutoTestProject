package first_lab;

import java.awt.*;

public class Rectangle extends Form {
    //####### Fields #############
    private int width; // ширина
    private int heigth; // высота

    //####### Constructors ########

    public Rectangle() {}

    public Rectangle(int x, int y, Color color, int width, int heigth) {
        super(x, y, color);
        this.width = width;
        this.heigth = heigth;
    }
    //####### Getters & Setters ########
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    //####### Implements Methods of first_lab.Form ###########
    @Override
    public void draw(Graphics g) {
        Color oldColor=g.getColor();
        g.setColor(getColor());
        g.drawRect(getX(),getY(),width,heigth);
        g.setColor(oldColor);
    }
    @Override
    public void fill(Graphics g) {
        Color oldColor=g.getColor();
        g.setColor(getColor());
        g.fillRect(getX(),getY(),width,heigth);
        g.setColor(oldColor);
    }
    @Override
    public double square() {
        return width * heigth;
    }
    @Override
    public double perimetr() {
        return  (heigth + width) * 2;
    }
    @Override
    public String toString()
    {
        return super.toString() + " ,Height:" + heigth + " ,Width: " + width;
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
        Rectangle other = (Rectangle) obj;
        if (width != other.width)
            return false;
        if (heigth != other.heigth)
            return false;
        return true;
    }

}