package hw1Q13Package;

public class Question13 {

	public static void main(String[] args) {
		boolean toggle = true;
		for(int i = 1; i < 5; i++){
			for(int j = 0; j<i; j++){
				if(toggle == true){
					System.out.print("0" + " ");
					toggle = !toggle;
				}else{
					System.out.print("1" + " ");
					toggle = !toggle;
				}			}
			System.out.println();
		}
	}

}
