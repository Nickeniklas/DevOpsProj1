package com.arcada.devops.math_calc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class CalcV1Test {

	@Test
	public void testCalcAdditionIsInt() {
		//	Does the function 2 + 2 = 4
		//	confirms return is Int
		int expected = 4; 
		int actual = CalcV1.calcAddition(2, 2); 
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCalcAdditionWithNegatives() {
		//	is -2 + -3 = -5
		assertEquals(-5, CalcV1.calcAddition(-2, -3));
	}
	
	@Test
	public void testAdditionWithZero() {
	    assertEquals(0, CalcV1.calcAddition(0, 0));
	    assertEquals(3, CalcV1.calcAddition(3, 0));
	    assertEquals(3, CalcV1.calcAddition(0, 3));
	}
	
	

}
