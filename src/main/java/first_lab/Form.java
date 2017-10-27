package first_lab;

import java.awt.*;

public abstract class Form {
    //###### Fields ##########
    private int x; //координата по оси У
    private int y; //координата по оси У
    private Color color; //цвет
    //####### Constructors ########
    public Form() {
    }

    public Form(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    //####### Getters&Setters ######

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    //####### Methods ############
    public abstract void draw(Graphics g);
    public abstract void fill(Graphics g);
    public double square() {return 0;}
    public double perimetr() {return  0;}


    //######### OverrideBlock ##########
    @Override
    public String toString()
    {
        return getClass().getSimpleName() + "color: " + color + ", X: " + x + ", Y: " + y;
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
        Form other = (Form) obj;
        if (x != other.getX())
            return false;
        if (y != other.getY())
            return false;
        if (color != other.getColor())
            return false;
        return true;
    }


}