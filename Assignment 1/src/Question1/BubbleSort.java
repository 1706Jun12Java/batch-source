package Question1;

public class BubbleSort {

	public static void main(String[] args) {

		int array [] = {1,0,5,3,2,3,7,9,8,4 } ;
		
		for(int x=0 ; x<10; x++)
		{
			for(int i=1; i<10; i++)
			{
				if(array[i-1]>array[i]) 
				{ int temp=array[i-1]; array[i-1]=array[i]; array[i]=temp;}
			}
			
			
			
			
		}
		
		for(int i: array) { System.out.println(i);}
		
	}

}
