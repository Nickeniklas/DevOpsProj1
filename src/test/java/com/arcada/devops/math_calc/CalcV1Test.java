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
	
	@Test
	public void testSubtraction() {
        int userN1 = 10;
        int userN2 = 3;
        int expected = 7;
        int mathSolved = userN1 - userN2;
        
        assertEquals(expected, mathSolved);
    }
	
	 @Test
	    public void testMultiplication() {
	        int userN1 = 5;
	        int userN2 = 4;
	        int expected = 20;
	        int mathSolved = userN1 * userN2;
	        
	        assertEquals(expected, mathSolved);
	    }

	    @Test
	    public void testDivision() {
	        int userN1 = 20;
	        int userN2 = 4;
	        int expected = 5;
	        int mathSolved = userN1 / userN2;
	        
	        assertEquals(expected, mathSolved);
	    }

	    @Test
	    public void testDivisionByZero() {
	        int userN1 = 10;
	        int userN2 = 0;
	        
	        try {
	            int mathSolved = userN1 / userN2;
	        } catch (ArithmeticException e) {
	            assertEquals("divison(/) by zero", e.getMessage(), "Division by zero should throw ArithmeticException");
	        }
	    }

}
