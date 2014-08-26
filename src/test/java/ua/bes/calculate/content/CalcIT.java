/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.bes.calculate.content;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

/**
 *
 * @author Andr
 */
public class CalcIT {

    private Data testDataMock = null;
    Calc instance;

    @Before
    public void setUp() {
	instance = new Calc();
	testDataMock = mock(Data.class);
    }
    
    /**
     * Test of setPar method, of class Calc.
     */
    @Test
    public void testSetParNull() {
	System.out.println("is null");

	testDataMock = null;
	String result = instance.setPar(testDataMock);
	assertEquals("Fail", result);
    }

    @Test
    public void testSetPar() {
	System.out.println(" the operation test ");
	double a = 4, b = 2;

	when(testDataMock.getOneNumber()).thenReturn(a);
	when(testDataMock.getTwoNumber()).thenReturn(b);

	System.out.println("operation + ");
	when(testDataMock.getOperation()).thenReturn("+");
	assertEquals(Double.toString(a + b), instance.setPar(testDataMock));

	System.out.println("operation - ");
	when(testDataMock.getOperation()).thenReturn("-");
	assertEquals(Double.toString(a - b), instance.setPar(testDataMock));

	System.out.println("operation % ");
	when(testDataMock.getOperation()).thenReturn("%");
	assertEquals(Double.toString(a * (b / 100)), instance.setPar(testDataMock));

	System.out.println("operation / ");
	when(testDataMock.getOperation()).thenReturn("/");
	assertEquals(Double.toString(a / b), instance.setPar(testDataMock));

	System.out.println("operation sqrt ");
	when(testDataMock.getOperation()).thenReturn("sqrt");
	assertEquals(Double.toString(Math.sqrt(a)), instance.setPar(testDataMock));
	
	System.out.println("operation sqrt+ ");
	when(testDataMock.getOperation()).thenReturn("sqrt");
	assertEquals(Double.toString(Math.pow(a, 1/b)), instance.setPar(testDataMock));
	
        System.out.println("operation * ");
	when(testDataMock.getOperation()).thenReturn("*");
	assertEquals(Double.toString(a*b), instance.setPar(testDataMock));
		

    }

}
