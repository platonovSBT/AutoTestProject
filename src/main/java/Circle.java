import java.awt.*;

public class Circle extends Oval {
    //####### Constructors #########
    public Circle() {
    }

    public Circle(int x, int y, Color color, int r) {
        super(x, y, color, 2 * r, 2 * r);
    }
    //####### Implements Methods of Oval ###########
    public double getRadius()
    {
        return width / 2;
    }
    public void setRadius(double r)
    {
        width= (int) (2 * r);
        height= (int) (2 * r);
    }

    @Override
    public void setWidth(int width) {
        this.width=width;
        height=width;

    }

    @Override
    public void setHeight(int height) {
        width=height;
        this.height=height;
    }
    //####### Implements Methods of Form ###########
    @Override
    public void draw(Graphics g) {
        Color oldColor=g.getColor();
        g.setColor(color);
        g.drawOval(x - width / 2,y - height / 2,width,height);
        g.setColor(oldColor);
    }
    @Override
    public void fill(Graphics g){
        Color oldColor=g.getColor();
        g.setColor(color);
        g.fillOval(x - width / 2,y - height / 2,width,height);
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
        return super.toString() + " ,radius:" + height / 2;
    }
}