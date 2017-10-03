import java.awt.*;

public class Oval extends Form {
    //####### Fields #############
    protected int width; //ширина
    protected int height; //высота

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

    //####### Implements Methods of Form ###########
    @Override
    public void draw(Graphics g) {
        Color oldColor=g.getColor();
        g.setColor(color);
        g.drawOval(x-width/2,y-height/2,width,height);
        g.setColor(oldColor);
    }
    @Override
    public double square() {
        return Math.PI*width*height/4;
    }
    @Override
    public double perimetr() {
        return  Math.PI*(width+height)/2;
    }
    @Override
    public String toString()
    {
        return super.toString()+" ,Height:"+height+" ,Width: "+width;
    }

}