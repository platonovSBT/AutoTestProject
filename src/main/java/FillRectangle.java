import java.awt.*;

public class FillRectangle extends Rectangle {
    //#### Contstructors ########
    public FillRectangle() {
    }

    public FillRectangle(int x, int y, Color color, int width, int heigth) {
        super(x, y, color, width, heigth);
    }
    //####### Implements Methods of Form ###########
    @Override
    public void draw(Graphics g) {
        Color oldColor=g.getColor();
        g.setColor(color);
        g.fillRect(x,y,width,heigth);
        g.setColor(oldColor);
    }

}