import javax.swing.*;
import java.awt.*;

public class Main extends JComponent {
    private Form[] forms=new Form[4];

    public Main( ) {
        System.out.println(" Инициализация фигур ");
        forms[0]=new Line(600,10,Color.BLACK,50,30);
        forms[1]=new Circle(150,150, Color.GREEN,50);
        forms[2]=new Oval(220,220,Color.GRAY,150,50);
        forms[3]=new Rectangle(5,330,Color.RED,250,300);
    }

    @Override
    public void paint(Graphics graphics) {
        for (Form form: forms)
        {
            System.out.println("Draw: "+form);
            form.draw(graphics);
        }
    }

    public static void main(String[] args) {
	// write your code here
        JFrame frame=new JFrame("Интерфейс");
        frame.setSize(1024,768);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Main());
        frame.setVisible(true);


    }
}
