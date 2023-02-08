package ua.jdev.calc.func;

class Sqrt extends FunctionImpl {
	@Override
	public int doExecute() {
		return (int) Math.sqrt(args.get(0));
	}

	@Override
	public FunctionType getType() {
		return FunctionType.UNARY;
	}
}
