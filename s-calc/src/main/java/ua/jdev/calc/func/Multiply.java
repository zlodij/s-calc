package ua.jdev.calc.func;

class Multiply extends FunctionImpl {
	@Override
	public int doExecute() {
		return args.stream().mapToInt(Integer::intValue).reduce(1, (a, b) -> a * b);
	}
	
	@Override
	public FunctionType getType() {
		return FunctionType.MULTIPLE;
	}
}
