package q1;

public class Main {
	
	static void bubbleSort(int[] arr)
	{
		int n;
		boolean flag = true; //set flag to true to begin first pass
		int temp = 0;
		
		while(flag)
		{
			flag=false; //sets flag to false, awaiting a possible swap
			for(n=0;n<arr.length-1;n++)
			{
				if(arr[n]>arr[n+1]) // would change to < for descending bubble sort. 
				{
					temp = arr[n]; // to swap the elements
					arr[n]= arr[n+1];
					arr[n+1]= temp;
					flag = true; //swap occurred
				}
			}
			
		}
	}

	public static void main(String[] args) {
		// Question 1: Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4
		int array[] = {1,0,5,6,3,2,3,7,9,8,4};
		
		//Displays array before bubble sort
		for(int i=0; i<array.length;i++)
		{
			System.out.print(array[i] + " ");
		}
		
		System.out.println();
		
		// Perform bubble sort: 
		bubbleSort(array); 
		
		//Displays array after bubble sort
		for(int i=0; i<array.length;i++)
		{
			System.out.print(array[i] + " ");
		}
		

	}
	

}
