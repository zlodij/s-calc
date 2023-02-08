package ua.jdev.calc;

public class CalculatorException extends Exception {
	private static final long serialVersionUID = 3553524407150530233L;

	public CalculatorException(String message) {
		super(message);
	}
	
	public CalculatorException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CalculatorException(Throwable cause) {
        super(cause);
    }
}
