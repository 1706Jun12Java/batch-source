package Question16;

public class Count {

		public static void main(String[] args) {
			
			//use enhanced for loop to print length of string from command line
			/*can use command line by going to run>run configs>arguments tab>then type anything into program arguments
			 * then click run
			 */
			
			for (String i : args){
				System.out.println(i.length());
			}
		}
}
