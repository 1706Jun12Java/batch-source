package question1;

/*
 * Perform a bubble sort on 
 * the following integer array:  1,0,5,6,3,2,3,7,9,8,4
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] myArr = {1,0,5,6,3,2,3,7,9,8,4 };

		int temp;
		boolean sort = false;
		
		while(sort == false) {
			sort = true;
			
			for(int i = 0;i <myArr.length; i++){
				if(myArr[i] > myArr[i +1]) {
					temp =myArr[i+1];
					myArr[i+1] = myArr[i];
					myArr[i] = temp;
					sort = false;
				}
			}
		}
	
		for(int i =0; i< myArr.length; i++) {
			System.out.println(myArr[i]);
		}
	}	
}
