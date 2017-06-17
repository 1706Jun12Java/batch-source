package Q1; 

public class QuestionOne {

	public static void main(String[] args) {
//		Perform a bubble sort on the following 
//		integer array: 1,0,5,6,3,2,3,7,9,8,4

		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		
		for (int i = 0; i<arr.length-1; i++){
			for (int j= i; j<arr.length; j++){
				if (arr[i]>arr[j]){
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		
		for (int a: arr){
			System.out.println(a);
		} 
	}

}
