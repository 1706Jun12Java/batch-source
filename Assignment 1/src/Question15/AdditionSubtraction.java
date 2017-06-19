package Question15;




public class AdditionSubtraction implements InterfaceCal {

	@Override
	public int addition(int a, int b) {

		
		
		
		
		return a+b;
	}

	@Override
	public int subtraction(int a, int b) {
		// TODO Auto-generated method stub
		return a-b;
	}

	@Override
	public double division(int a, int b) {
		return b!=0 ? a/b : 0;
	}

	@Override
	public double multiplication(int a, int b) {
		// TODO Auto-generated method stub
		return a*b;
	}

	
	
	
}

class SubClass{
	
	public static void main(String args[])
	{
		AdditionSubtraction a = null;
		
		a.addition(10, 14);
		
		a.subtraction(14, 10);
		
		System.out.println(a.division(10, 2));
		
	

		
		
	}
	
	
	
}

