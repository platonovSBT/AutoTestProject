import java.awt.*;

public class FillCircle extends Circle {
    //########## Constructors ################
    public FillCircle() {
    }

    public FillCircle(int x, int y, Color color, int r ) {
        super(x, y, color, r);
    }
    //##########Implements Methods of Form ###########
    @Override
    public void draw(Graphics g) {
        Color oldColor=g.getColor();
        g.setColor(color);
        g.fillOval(x-width/2,y-height/2,width,height);
        g.setColor(oldColor);
    }
}