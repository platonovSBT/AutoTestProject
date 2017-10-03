/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sbt-platonov-aa
 */
public class LineTest {
    //######### Fields ##########
    private Line exLine;

    //######### Consctructors ##########
    public LineTest() {
    }

    //######### TestBlock ##########
    @Before
    public void initialize()
    {
        exLine=new Line(0,0, Color.BLUE,2,2);
    }


    /**
     * Test of getX2 method, of class Line.
     */
    @Test
    public void testGetX2() {
        System.out.println("getX2");
        int expResult = 2;
        int result = exLine.getX2();
        assertEquals(expResult, result);
    }

    /**
     * Test of getY2 method, of class Line.
     */
    @Test
    public void testGetY2() {
        System.out.println("getY2");
        int expResult = 2;
        int result = exLine.getY2();
        assertEquals(expResult, result);
    }

    /**
     * Test of draw method, of class Line.
     */
    @Test
    public void testDraw() {
        System.out.println("draw");
        Graphics g = null;
        Line instance = new Line();
        instance.draw(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Line.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "java.awt.Color[r=0,g=0,b=255], X: 0, Y: 0 ,X2:2, Y2:2";
        String result = exLine.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of lineLenght method, of class Line.
     */
    @Test
    public void testLineLenght() {
        System.out.println("lineLenght");
        double expResult = 0.0;
        double result = exLine.lineLenght();
        assertEquals(expResult, result, 0.0);

    }
    
}
