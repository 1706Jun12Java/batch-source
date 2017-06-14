package question12;

public class WhoCanEven {

		public static void main(String[] args){
			int[] array = new int[100];
			for(int i = 0; i < 100;i++){
				array[i] = i+1;
			}
			
			for(int a:array){
				if(a%2==0){
					System.out.println(a+ " can even!");
				}
			}
		}
}
