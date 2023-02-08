package ua.jdev.calc.func;

import java.io.IOException;
import java.util.Properties;

import ua.jdev.calc.CalculatorException;

public class FunctionFactory {
	private static FunctionFactory instance;
	
	private Properties prop = new Properties();
	
	private FunctionFactory() {
		try {
			prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public Function createFunction(String functionName) throws CalculatorException {
		Function result = null;
		
		if (prop.containsKey(functionName)) {
			String value = prop.getProperty(functionName);
			
			try {
				result = (Function) Class.forName(value).getDeclaredConstructor().newInstance();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		} else {
			throw new CalculatorException("Unknown function '" + functionName + "'!");
		}
		
		return result;		
	}
	
	public static FunctionFactory getFactory( ) {
		if (instance == null) {
			instance = new FunctionFactory();
		}
		
		return instance;	
	}
}
