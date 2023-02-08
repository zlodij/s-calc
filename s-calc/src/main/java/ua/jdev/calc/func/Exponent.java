package ua.jdev.calc.func;

class Exponent extends FunctionImpl {
	@Override
	public int doExecute() {
		return (int) Math.pow(args.get(0), args.get(1));
	}
	
	@Override
	public FunctionType getType() {
		return FunctionType.BINARY;
	}
}
