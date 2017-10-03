import java.awt.*;

public abstract class Form {
    //###### Fields ##########
    protected int x; //координата по оси У
    protected int y; //координата по оси У
    protected Color color; //цвет
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
    public double square() {return 0;}
    public double perimetr() {return  0;}

    //######### OverrideBlock ##########
    @Override
    public String toString()
    {
        return getClass().getSimpleName()+"color: "+color+", X: "+x+", Y: "+y;
    }
}