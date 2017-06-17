package corejava1.q04;

public class NFactorial {
	public static int nFac(int num) {
		if(num == 1) {
			return 1;
		}
		int answer = nFac(num - 1) * num;
		return answer;
	}
	
	public static void main(String [] args) {
		System.out.println(nFac(3));
	}
}
