/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.bes.calculate.content;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Andr
 */
public class CalcIT {
    
    public CalcIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setPar method, of class Calc.
     */
    @Test
    public void testSetPar() {
	System.out.println("setPar");
	Data data = null;
	Calc instance = new Calc();
	String expResult = "Fail";
	String result = instance.setPar(data);
	System.out.println("------------test-------------- "+result);
	assertEquals(expResult, result);
	
    }
    
}
