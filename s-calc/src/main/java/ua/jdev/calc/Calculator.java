package ua.jdev.calc;

import java.util.Objects;
import java.util.StringTokenizer;

import ua.jdev.calc.func.Function;
import ua.jdev.calc.func.FunctionFactory;

public class Calculator {
	private int countBracketPairs(String expression) throws CalculatorException {
		Objects.requireNonNullElse(expression, "");

		int left = 0;
		int right = 0;
		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if (ch == '(') {
				left++;
			} else if (ch == ')') {
				right++;
			}
		}

		if (left < right) {
			throw new CalculatorException("One or more opening brackets are missing");
		} else if (right < left) {
			throw new CalculatorException("One or more closing brackets are missing");
		}

		return left;
	}

	public int evaluate(String expression) throws CalculatorException {
		int result = 0;

		int pairs = countBracketPairs(expression);
		if (pairs > 0) {
			int end = -1;
			do {
				end = expression.indexOf(")");
				if (end > 0) {
					String temp = expression.substring(0, end);
					int start = temp.lastIndexOf("(");

					if (start >= 0) {
						String operation = temp.substring(start + 1).trim();

						if (operation.length() == 0) {
							throw new CalculatorException("Expression inside brackets couldn't  be empty!");
						}

						StringTokenizer tokenizer = new StringTokenizer(operation);
						String functionName = tokenizer.nextToken();

						Function function = FunctionFactory.getFactory().createFunction(functionName);

						while (tokenizer.hasMoreElements()) {
							String element = tokenizer.nextToken();

							try {
								function.addArgument(Integer.parseInt(element));
							} catch (NumberFormatException nfe) {
								throw new CalculatorException("Invalid number format '" + element + "'!", nfe);
							}
						}

						expression = expression.substring(0, start) + function.execute() + expression.substring(end + 1);
					} else {
						throw new CalculatorException("Function's opening bracket missed!");
					}
				}

			} while (end > 0);
		}

		try {
			result = Integer.parseInt(expression);
		} catch (NumberFormatException nfe) {
			throw new CalculatorException("Invalid number format '" + expression + "'!", nfe);
		}

		return result;
	}

	public static void main(String[] args) {
		if (args != null && args.length > 0) {
			try {
				Calculator calculator = new Calculator();
				System.out.println(calculator.evaluate(args[0]));
			} catch (CalculatorException fe) {
				System.err.println("ERROR: " + fe.getMessage());
			}
		} else {
			System.out.println("WARNING: empty expression");
		}
	}
}
