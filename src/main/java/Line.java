import java.awt.*;

public class Line extends Form {
    //###### Fields ##########
    private int x2; //координата по оси X2
    private int y2; //координата по оси У2

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
        g.setColor(getColor());
        g.drawLine(getX(),x2,getY(),y2);
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
        return super.toString() + " ,X2:" + x2 + ", Y2:" + y2;
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
        Line other = (Line) obj;
        if (x2 != other.x2)
            return false;
        if (y2 != other.y2)
            return false;
        return true;
    }
    //######## Methods #########
    public double lineLenght()
    {
        return Math.hypot((x2 - getX()),(y2 - getY()));
    }
}