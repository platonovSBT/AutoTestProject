/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.awt.*;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
/**
 *
 * @author sbt-platonov-aa
 */
@RunWith(Parameterized.class)
public class OvalTestWithParameters {
    //######### Fields ##########

    private Oval inputOval;
    private Oval expectedOval;
    //######### Consctructors ##########
    public OvalTestWithParameters(Oval input,Oval expected) {
        inputOval=input;
        expectedOval=expected;
    }

    //######### TestBlock ##########


    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][] {
                { new Oval(1,1,Color.BLUE,2,3), new Oval(1,1,Color.BLUE,2,3)},
                { new Oval(0,0,Color.BLACK,5,7), new Oval(1,1,Color.BLUE,2,3)},
                { new Oval(2,2,Color.GREEN,6,9),new Oval(2,2,Color.GREEN,6,9)}
        });
    }

    /**
     * Test of getWidth method, of class Oval.
     */
    @Test
    public void testGetWidth() {
        assertEquals("Неверное значение в Oval.getWidth()",expectedOval.getWidth(), inputOval.getWidth());
    }
    /**
     * Test of getHeight method, of class Oval.
     */
    @Test
    public void testGetHeight() {
        assertEquals("Неверное значение в Oval.getHeight()",expectedOval.getHeight(), inputOval.getHeight());
    }

    /**
     * Test of square method, of class Oval.
     */
    @Test
    public void testSquare() {
        assertEquals("Неверное значение в Oval.square()",expectedOval.square(), inputOval.square(),0.0);
    }

    /**
     * Test of perimetr method, of class Oval.
     */
    @Test
    public void testPerimetr() {
        assertEquals("Неверное значение в Oval.perimter()",expectedOval.perimetr(), inputOval.perimetr(),0.0);
    }

    /**
     * Test of toString method, of class Oval.
     */
    @Test
    public void testToString() {
        assertEquals("Неверное значение в Oval.perimter()",expectedOval.toString(), inputOval.toString());
    }
    
}
