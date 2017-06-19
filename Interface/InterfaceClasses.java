package Interface;

public class InterfaceClasses implements RootInterface{

	public InterfaceClasses() {
		// TODO Auto-generated constructor stub
	}

	private double a,b,c,d,e,f,g,h;
	
	public double add(double a, double b) {
		return a+b;
	}

	public double substract(double c, double d) {
		return c-d;
	}

	public double multiple(double e, double f) {
		return e*f;
	}

	public double division(double g, double h) {
		return g/h;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}
	
	public double getD() {
		return d;
	}

	public void setD(double d) {
		this.d = d;
	}

	public double getE() {
		return e;
	}

	public void setE(double e) {
		this.e = e;
	}

	public double getF() {
		return f;
	}

	public void setF(double f) {
		this.f = f;
	}

	public double getG() {
		return g;
	}

	public void setG(double g) {
		this.g = g;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

	@Override
	public String toString() {
		return "InterfaceClasses [a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + ", e=" + e + ", f=" + f + ", g=" + g
				+ ", h=" + h + "]";
	}

}
