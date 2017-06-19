package q13;

//Display the triangle on the console 0
//as follows using any type of loop.  1 0
//Do NOT use a simple group of print  1 0 1
//statements to accomplish this.      0 1 0 1
public class Triangle {

	public static void main(String[] args) {

		boolean T = true;

		for(int i = 1; i < 5; i++){

			for(int j=0; j<i; j++){

				if(T){
					System.out.print(0 + " ");
					T = false;
				} else{
					System.out.print(1 + " ");
					T = true;
				}
			}
			System.out.println("");
		}
	}
}