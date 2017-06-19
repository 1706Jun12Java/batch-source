package question12;

public class EvenArray {
	public static void main(String[] args) {
		int[] nums = new int[100];
		for(int i=0;i<100;i++){
			nums[i]= i+1;
		}
		
		for(int i:nums){
			if(i%2==0){
				System.out.println(i);
			}
		}
	}
}