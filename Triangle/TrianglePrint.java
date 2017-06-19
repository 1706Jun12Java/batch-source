/*
 * Display the triangle on the console as follows using any type of loop. Do NOT use
 * a simple group of print statements to accomplish this.
 *  
 *  0

    1 0

    1 0 1

    0 1 0 1
 */
package Triangle;

public class TrianglePrint {

	public static void main(String[] args) {
		//loop through number of rows
        for (int i = 0; i <= 3; ++i) {
        	//for each row add 1 or 0
            for (int j = 0; j <= i; ++j) {
                if ((i + j) % 2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}
