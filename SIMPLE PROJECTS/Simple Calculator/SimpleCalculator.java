// A simple calculator in Java

import java.util.Scanner;

public class SimpleCalculator {
	
	public static void main(String[] args) {
		
		// initalize our variables
		double firstNumber = 0;
		double secondNumber = 0;
		double result = 0;
		char operator;
		
		// create a Scanner object
	    Scanner input = new Scanner(System.in);
	    
	    // ask the user to enter the numbers
	    System.out.println("Enter the first number: ");
	    firstNumber = input.nextDouble();

	    System.out.println("Enter the second number: ");
	    secondNumber = input.nextDouble();
	    
	    // ask the user to enter the operator
	    System.out.println("Choose an operator: +, -, *, or /");
	    operator = input.next().charAt(0);
	    
	    switch (operator) {
	      // performs addition between numbers
	      case '+':
	        result = firstNumber + secondNumber;
	        break;

	      // performs subtraction between numbers
	      case '-':
	    	result = firstNumber - secondNumber;	        
	        break;

	      // performs multiplication between numbers
	      case '*':
	    	result = firstNumber * secondNumber;	        
	        break;

	      // performs division between numbers
	      case '/':
	    	result = firstNumber / secondNumber;	        
	        break;

	      // invalid operator
	      default:	    	
	    	System.out.println("Invalid operator!");
	    	
	    	// close the Scanner
		    input.close();
		    
		    // end our program
	    	System.exit(0);	        
	    }
	    
	    System.out.println("The result: " + result);
	    
	    // close the Scanner
	    input.close();
	}	
}