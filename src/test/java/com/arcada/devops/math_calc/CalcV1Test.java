package com.arcada.devops.math_calc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



/**
 * Unit test for simple App.
 */
public class CalcV1Test {
	
	//	SELENIUM TEST
	@Test
	public void shouldAnswearTrue() {
		// CHROME DRIVER EXE LINKED
	  	System.setProperty("webdriver.chrome.driver", "C:\\Applications\\Chrome-ext\\chromedriver-win64\\chromedriver.exe");
	  	ChromeOptions options = new ChromeOptions();
	  	WebDriver driver = new ChromeDriver(options);
	  	driver.get("http://localhost:8080");
	  	
	  	try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  	
	 // Step # | name | target | value
	    // 1 | open | / | 
	    driver.get("http://localhost:8080/");
	    // 2 | setWindowSize | 945x1020 | 
	    driver.manage().window().setSize(new Dimension(945, 1020));
	    // 3 | click | css=body | 
	    driver.findElement(By.cssSelector("body")).click();
	    
	    //OLD 4 | click | name=userN1 | 
	    //OLD driver.findElement(By.name("userN1")).click();
	    //	NEW PATH and INPUT STORED AS VARIABLE
	    WebElement userInput1 = driver.findElement(By.xpath("//input[@name=\'userN1\']"));
	    userInput1.click();
	    
	    // 5 | type | name=userN1 | 2
	    driver.findElement(By.name("userN1")).sendKeys("2");
	    
	    //	NEW PATH, SAVE AS VARIABLE, CHECK IF CORRECT
	    //OLD 6 | click | name=userN2 | 
	    //OLD driver.findElement(By.name("userN2")).click();
	    // 6 | click | xpath=//input[2] | 
	    WebElement userInput2 = driver.findElement(By.xpath("//input[2]"));
	    userInput2.click();
	    // 7 | type | name=userN2 | 3
	    userInput2.sendKeys("3");
	    //	CHECK IF CORRECT
	    assertTrue(userInput2.getAttribute("value").equalsIgnoreCase("3"));
	    
	    // 8 | click | name=operation | 
	    driver.findElement(By.name("operation")).click();
	    // 9 | select | name=operation | label=Subtraction
	    {
	      WebElement dropdown = driver.findElement(By.name("operation"));
	      dropdown.findElement(By.xpath("//option[. = 'Subtraction']")).click();
	    }
	    // 10 | click | xpath=//input[3] | 
	    driver.findElement(By.xpath("//input[3]")).click();
	    
	    //	Check if outputted result was -1
	    String resultText = driver.findElement(By.tagName("h1")).getText();
	    assertTrue(resultText.equalsIgnoreCase("Result: -1"));
	    
	    // 11 | click | linkText=Go back | 
	    driver.findElement(By.linkText("Go back")).click();
	    // 12 | click | name=userN1 | 
	    driver.findElement(By.name("userN1")).click();
	    // 13 | type | name=userN1 | 1
	    driver.findElement(By.name("userN1")).sendKeys("1");
	    // 14 | click | name=userN2 | 
	    driver.findElement(By.name("userN2")).click();
	    // 15 | type | name=userN2 | 2
	    driver.findElement(By.name("userN2")).sendKeys("2");
	    // 16 | click | name=operation | 
	    driver.findElement(By.name("operation")).click();
	    // 17 | select | name=operation | label=Multiplication
	    {
	      WebElement dropdown = driver.findElement(By.name("operation"));
	      dropdown.findElement(By.xpath("//option[. = 'Multiplication']")).click();
	    }
	    // 18 | click | css=input:nth-child(13) | 
	    driver.findElement(By.cssSelector("input:nth-child(13)")).click();
	  
	  	System.out.println("Selenium Executed Succesfully!");
	  	
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
	            assertEquals("/ by zero", e.getMessage(), "Division by zero should throw ArithmeticException");
	        }
	    }

}
