package Question15;

public class Calculator implements Mathable {
	// All functions return a double since its the most general data type
	/**
	 * adds two Numbers and returns a double
	 */
	@Override
	public double add(Number x, Number y) {
		double ans = x.doubleValue() + y.doubleValue();
		return ans;
	}

	/**
	 * subtracts two Numbers and returns a double
	 */
	@Override
	public double subtract(Number x, Number y) {
		double ans = x.doubleValue() - y.doubleValue();
		return ans;
	}

	/**
	 * multiplies two Numbers and returns a double
	 */
	@Override
	public double multiply(Number x, Number y) {
		double ans = x.doubleValue() * y.doubleValue();
		return ans;
	}

	/**
	 * divides two Numbers and returns a double
	 */
	@Override
	public double divide(Number x, Number y) {
		double ans = x.doubleValue() / y.doubleValue();
		return ans;
	}

}
