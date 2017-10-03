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
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
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
        System.out.println("Результаты проверки метода getWidth:");
        assertEquals(expectedOval.getWidth(), inputOval.getWidth());
    }
    /**
     * Test of getHeight method, of class Oval.
     */
    @Test
    public void testGetHeight() {
        System.out.println("Результаты проверки метода getHeight:");
        assertEquals(expectedOval.getHeight(), inputOval.getHeight());
    }

    /**
     * Test of square method, of class Oval.
     */
    @Test
    public void testSquare() {
        System.out.println("Результаты проверки метода square:");
        assertEquals(expectedOval.square(), inputOval.square(),0.0);
    }

    /**
     * Test of perimetr method, of class Oval.
     */
    @Test
    public void testPerimetr() {
        System.out.println("Результаты проверки метода perimetr:");
        assertEquals(expectedOval.square(), inputOval.square(),0.0);
    }

    /**
     * Test of toString method, of class Oval.
     */
    @Test
    public void testToString() {
        System.out.println("Результаты проверки метода toString:");
        assertEquals(expectedOval.toString(), inputOval.toString());
    }
    
}
