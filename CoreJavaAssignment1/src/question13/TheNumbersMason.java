package question13;

public class TheNumbersMason {
	
	public static void main(String[] args){
		for(int i = 0; i < 4; i++){
			if(i == 0){
				System.out.println("0");
			} else if( i == 1){
				System.out.println("1 0");
			} else if(i == 2){
				System.out.println("1 0 1");
			} else if(i == 3){
				System.out.println("0 1 0 1");
			}
		}
	}
}
