package question2;

public class FibbonaciNumbers {
	
	public static void main(String[] args){
		int firstNum = 0;
		int secondNum = 1;
		int sum;
		String listOfNums="0,";
		for(int i = 0; i < 24; i++){
			sum = firstNum + secondNum;
			firstNum = secondNum;
			secondNum = sum;
			if(i == 0 || i == 23){
				listOfNums += sum;
			}else{
				listOfNums += "," + sum;
			}
			
		}
		System.out.println(listOfNums);
	}
}
