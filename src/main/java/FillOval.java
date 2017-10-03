import java.awt.*;

public class FillOval extends Oval {
    //########## Constructors ################
    public FillOval() {
    }

    public FillOval(int x, int y, Color color, int width, int height) {
        super(x, y, color, width, height);
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