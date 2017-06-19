package Question12;

public class EvenNumbers {

	public static void main(String[] args) {
		
		//create an IntArray and fill it with numbers 1-100
		int[] list = new int[101];
		for (int i = 1; i < list.length; i++) {
			list[i] = i;
		}
		//create another array that will hold the even numbers of previous list
		int[] even = new int[101];
		//use enhanced for loop to add the even numbers into new list
		for (int count : list) {
			if (count % 2 == 0) {
				even[count] = count;
				System.out.print(even[count] + " ");
			}
		}
	}
}
