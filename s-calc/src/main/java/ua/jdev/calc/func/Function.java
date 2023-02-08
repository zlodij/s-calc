package ua.jdev.calc.func;

import ua.jdev.calc.CalculatorException;

public interface Function {
	int execute() throws CalculatorException;
	
	void addArgument(int arg);
	
	FunctionType getType();
}
