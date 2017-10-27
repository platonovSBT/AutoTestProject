package first_lab;

import java.awt.*;

public class Circle extends Oval {
    //####### Constructors #########
    public Circle() {
    }

    public Circle(int x, int y, Color color, int r) {
        super(x, y, color, 2 * r, 2 * r);
    }
    //####### Implements Methods of first_lab.Oval ###########
    public double getRadius()
    {
        return getWidth() / 2;
    }
    public void setRadius(double r)
    {
        setWidth((int) (2 * r));
        setHeight ((int) (2 * r));
    }

    @Override
    public void setWidth(int width) {
        setHeight(width);
        setWidth(width);
    }

    @Override
    public void setHeight(int height) {
        setHeight(height);
        setWidth(height);
    }
    //####### Implements Methods of first_lab.Form ###########
    @Override
    public void draw(Graphics g) {
        Color oldColor=g.getColor();
        g.setColor(getColor());
        g.drawOval(getX() - getHeight() / 2,getY() - getHeight() / 2,getWidth(),getHeight());
        g.setColor(oldColor);
    }
    @Override
    public void fill(Graphics g){
        Color oldColor=g.getColor();
        g.setColor(getColor());
        g.fillOval(getX() - getWidth() / 2,getY() - getHeight() / 2,getWidth(),getHeight());
        g.setColor(oldColor);
    }
    @Override
    public double square() {
        return Math.PI * getWidth() * getHeight() / 4;
    }
    @Override
    public double perimetr() {
        return  Math.PI * (getWidth() + getHeight()) / 2;
    }
    @Override
    public String toString()
    {
        return super.toString() + " ,radius:" + getHeight() / 2;
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
        Circle other = (Circle) obj;
        if (getWidth() != other.getRadius())
            return false;
        if (getHeight() != other.getRadius())
            return false;
        return true;
    }
}