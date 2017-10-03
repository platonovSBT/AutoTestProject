import java.awt.*;

public class Rectangle extends Form {
    //####### Fields #############
    protected int width; // ширина
    protected int heigth; // высота

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

    //####### Implements Methods of Form ###########
    @Override
    public void draw(Graphics g) {
        Color oldColor=g.getColor();
        g.setColor(color);
        g.drawRect(x,y,width,heigth);
        g.setColor(oldColor);
    }
    @Override
    public double square() {
        return width*heigth;
    }
    @Override
    public double perimetr() {
        return  (heigth+width)*2;
    }
    @Override
    public String toString()
    {
        return super.toString()+" ,Height:"+heigth+" ,Width: "+width;
    }

}