package ua.jdev.calc.func;

import java.util.ArrayList;
import java.util.List;

import ua.jdev.calc.CalculatorException;

public abstract class FunctionImpl implements Function {
	protected List<Integer> args = new ArrayList<>();

	protected abstract int doExecute();

	@Override
	public final int execute() throws CalculatorException {
		if (getType() == FunctionType.UNARY && args.size() < 1) {
			throw new CalculatorException("Function requires 1 argument to execute");
		} else if (getType() == FunctionType.BINARY && args.size() < 2) {
			throw new CalculatorException("Function requires 2 arguments to execute");
		} else if (getType() == FunctionType.MULTIPLE && args.size() < 2) {
			throw new CalculatorException("Function requires at least 2 arguments to execute");
		}

		return doExecute();
	}

	@Override
	public void addArgument(int arg) {
		args.add(arg);
	}
}
