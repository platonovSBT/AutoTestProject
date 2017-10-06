import java.awt.*;

public class Line extends Form {
    //###### Fields ##########
    protected int x2; //координата по оси X2
    protected int y2; //координата по оси У2

    //####### Constructors #######

    public Line() {
    }

    public Line(int x, int y, Color color, int x2, int y2) {
        super(x, y, color);
        this.x2 = x2;
        this.y2 = y2;
    }
    //###### Getters& Setters ########

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    //######## Implements Methods of Form #########

    @Override
    public void draw(Graphics g) {
        Color oldColor=g.getColor();
        g.setColor(color);
        g.drawLine(x,x2,y,y2);
        g.setColor(oldColor);
    }
    @Override
    public void fill(Graphics g)
    {
        System.out.println("Это же линия,Карл! Какая еще закраска?");
    }

    @Override
    public String toString()
    {
        return super.toString()+" ,X2:"+x2+", Y2:"+y2;
    }
    //######## Methods #########
    public double lineLenght()
    {
        return Math.hypot((x2-x),(y2-y));
    }
}