package test_first_lab;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import first_lab.Oval;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.awt.*;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author sbt-platonov-aa
 */
@RunWith(Parameterized.class)
public class OvalTestWithParameters {
    //######### Fields ##########

    private  Oval inputOval;
    private static final Oval expectedOval = new Oval(1,1,Color.BLUE,2,3);
    //######### Consctructors ##########
    public OvalTestWithParameters(Oval inputOval, Oval expectedOval ) {

        this.inputOval=inputOval;
    }

    //######### TestBlock ##########


    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][] {
               { new Oval(1,1,Color.BLUE,2,3), expectedOval},
                { new Oval(0,0,Color.BLACK,5,7), expectedOval},
                { new Oval(2,2,Color.GREEN,6,9),expectedOval},
                { new Oval(1,1,Color.BLACK,2,3), expectedOval},
                { new Oval(1,1,Color.BLUE,2,3), expectedOval},
                { new Oval(0,0,Color.BLUE,2,3),expectedOval},
        });
    }
    /**
     * Test of getWidth method, of class first_lab.Oval.
     */
    @Test
    public void testDraw() {
        assertTrue("Объекты не эквивалентны!",expectedOval.equals(inputOval));
    }

    /**
     * Test of getWidth method, of class first_lab.Oval.
     */
    @Test
    public void testGetWidth() {
        assertEquals("Неверное значение в first_lab.Oval.getWidth()",expectedOval.getWidth(), inputOval.getWidth());
    }
    /**
     * Test of getHeight method, of class first_lab.Oval.
     */
    @Test
    public void testGetHeight() {
        assertEquals("Неверное значение в first_lab.Oval.getHeight()",expectedOval.getHeight(), inputOval.getHeight());
    }

    /**
     * Test of square method, of class first_lab.Oval.
     */
    @Test
    public void testSquare() {
        assertEquals("Неверное значение в first_lab.Oval.square()",expectedOval.square(), inputOval.square(),0.0);
    }

    /**
     * Test of perimetr method, of class first_lab.Oval.
     */
    @Test
    public void testPerimetr() {
        assertEquals("Неверное значение в first_lab.Oval.perimetr()",expectedOval.perimetr(), inputOval.perimetr(),0.0);
    }

    /**
     * Test of toString method, of class first_lab.Oval.
     */
    @Test
    public void testToString() {
        assertEquals("Неверное значение в first_lab.Oval.toString()",expectedOval.toString(), inputOval.toString());
    }
    
}
