package com.exam;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.exam.Calculator.Calculator;

public class CalculatorTest {

	Calculator cal;
	
	@Test
	public void testMultiply() {
		cal=new Calculator();
		assertEquals(20,cal.multiply(4, 5));
	}
	
	@Test
	public void testDivide() {
		cal=new Calculator();
		assertEquals(5, cal.divide(10, 2));
	}
}
