/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        exLine=new Line(0,0, Color.BLUE,3,4);
    }


    /**
     * Test of getX2 method, of class Line.
     */
    @Test
    public void testGetX2() {
        assertEquals("Неверное значение в Line.getX2()",3, exLine.getX2());
    }

    /**
     * Test of getY2 method, of class Line.
     */
    @Test
    public void testGetY2() {
        assertEquals("Неверное значение в Line.getY2()",4, exLine.getY2());
    }

    /**
     * Test of draw method, of class Line.
     */
    @Test
    public void testDraw() {
        Line instance = new Line(0,0, Color.BLUE,3,4);
        assertTrue("Объекты не эквивалентны!", exLine.equals(instance));

        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of toString method, of class Line.
     */
    @Test
    public void testToString() {
        assertEquals("Неверное значение в Line.toString()!","Linecolor: java.awt.Color[r=0,g=0,b=255], X: 0, Y: 0 ,X2:3, Y2:4",  exLine.toString());
    }

    /**
     * Test of lineLenght method, of class Line.
     */
    @Test
    public void testLineLenght() {
        assertEquals("Неверное значение в Line.lineLenght()!",5.1, exLine.lineLenght(),0.1);
    }
    
}
