package question15;

interface basicmath {
	
	double sum(double a, double b);

	double sub(double a, double b);

	double mul(double a, double b);

	double div(double a, double b);


}


public class Question15 implements basicmath{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Question15 obj = new Question15();
		
		System.out.println(obj.sum(4, 5));
		System.out.println(obj.mul(4, 5));
	}

	public double sum(double a,double b){
		double c = a+b;
		return c;
	}
	public double sub(double a,double b){
		double c = a-b;
		return c;
	}
	public double mul(double a,double b){
		double c = a*b;
		return c;
	}
	public double div(double a,double b){
		double c = a/b;
		return c;
	}
	

}
