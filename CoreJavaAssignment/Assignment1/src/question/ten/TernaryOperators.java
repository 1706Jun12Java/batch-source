package question.ten;

public class TernaryOperators {

	public static void main(String[] args) {
		System.out.println(findMin(10, 7));	

	}
	
	public static int findMin(int a, int b){
		int minValue = (a < b) ? a : b;
		return minValue;
		
	}

}
