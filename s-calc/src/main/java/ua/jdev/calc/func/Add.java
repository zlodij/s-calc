package ua.jdev.calc.func;

class Add extends FunctionImpl {
	@Override
	protected int doExecute() {
		return args.stream().mapToInt(Integer::intValue).sum();
	}
	
	@Override
	public FunctionType getType() {
		return FunctionType.MULTIPLE;
	}
}
