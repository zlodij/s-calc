package ua.jdev.calc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCalculator {
	@Test
	public void testInt() throws Exception {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(0, calculator.evaluate("0"));
		Assertions.assertEquals(123, calculator.evaluate("123"));
	}
	
	@Test
	public void testAdd() throws Exception {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(0, calculator.evaluate("(add 0 0)"));
		Assertions.assertEquals(2, calculator.evaluate("(add 1 1)"));
		Assertions.assertEquals(579, calculator.evaluate("(add 123 456)"));
		Assertions.assertEquals(7, calculator.evaluate("(add 0 (add 3 4))"));
		Assertions.assertEquals(12, calculator.evaluate("(add 3 (add (add 3 3) 3))"));
	}

	@Test
	public void testMultiply() throws Exception {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(0, calculator.evaluate("(multiply 0 0)"));
		Assertions.assertEquals(1, calculator.evaluate("(multiply 1 1)"));
		Assertions.assertEquals(0, calculator.evaluate("(multiply 0 (multiply 3 4))"));
		Assertions.assertEquals(24, calculator.evaluate("(multiply 2 (multiply 3 4))"));
		Assertions.assertEquals(81, calculator.evaluate("(multiply 3 (multiply (multiply 3 3) 3))"));
	}

	@Test
	public void testMix() throws Exception {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(7, calculator.evaluate("(add 1 (multiply 2 3))"));
		Assertions.assertEquals(28, calculator.evaluate("(multiply 2 (add (multiply 2 3) 8))"));
		Assertions.assertEquals(96, calculator.evaluate("(multiply 2 (add (multiply 2 3 5) 8 (add 5 5)))"));
	}
	
	@Test
	public void testExponent() throws Exception {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(1, calculator.evaluate("(exponent 2 0)"));
		Assertions.assertEquals(0, calculator.evaluate("(exponent 0 2)"));
		Assertions.assertEquals(32, calculator.evaluate("(exponent 2 5)"));
	}

	@Test
	public void testSqrt() throws Exception {
		Calculator calculator = new Calculator();
		Assertions.assertEquals(0, calculator.evaluate("(sqrt 0)"));
		Assertions.assertEquals(3, calculator.evaluate("(sqrt 15)"));
		Assertions.assertEquals(4, calculator.evaluate("(sqrt 16)"));
		Assertions.assertEquals(4, calculator.evaluate("(sqrt 17)"));
	}
	
	@Test
	public void testExtraArgs() throws Exception {
		Calculator calculator = new Calculator();
		
		Assertions.assertEquals(3, calculator.evaluate("(sqrt 9 16)"));
		Assertions.assertEquals(64, calculator.evaluate("(exponent 2 6 8)"));
		Assertions.assertEquals(10, calculator.evaluate("(add 2 2 2 2 2)"));
		Assertions.assertEquals(32, calculator.evaluate("(multiply 2 2 2 2 2)"));
	}

	@Test
	public void testMissingArgs() throws Exception {
		Calculator calculator = new Calculator();
		
		Assertions.assertThrowsExactly(CalculatorException.class, () -> calculator.evaluate("(sqrt)"));
		Assertions.assertThrowsExactly(CalculatorException.class, () -> calculator.evaluate("(exponent)"));
		Assertions.assertThrowsExactly(CalculatorException.class, () -> calculator.evaluate("(exponent 15)"));
		Assertions.assertThrowsExactly(CalculatorException.class, () -> calculator.evaluate("(add)"));
		Assertions.assertThrowsExactly(CalculatorException.class, () -> calculator.evaluate("(add 1)"));
		Assertions.assertThrowsExactly(CalculatorException.class, () -> calculator.evaluate("(multiply)"));
		Assertions.assertThrowsExactly(CalculatorException.class, () -> calculator.evaluate("(multiply 1)"));
	}
	
	@Test
	public void testInvalidInt() throws Exception {
		Calculator calculator = new Calculator();
		Assertions.assertThrowsExactly(CalculatorException.class, () -> calculator.evaluate("1a"));
		Assertions.assertThrowsExactly(CalculatorException.class, () -> calculator.evaluate("(add 3a 3))"));
	}
	
	@Test
	public void testInvalidExpression() throws Exception {
		Calculator calculator = new Calculator();
		Assertions.assertThrowsExactly(CalculatorException.class, () -> calculator.evaluate("(add 3 3"));
		Assertions.assertThrowsExactly(CalculatorException.class, () -> calculator.evaluate("add 3 3)"));
	}
	
	@Test
	public void testUnknownFunction() throws Exception {
		Calculator calculator = new Calculator();
		Assertions.assertThrowsExactly(CalculatorException.class, () -> calculator.evaluate("(min 3 3)"));
	}
}