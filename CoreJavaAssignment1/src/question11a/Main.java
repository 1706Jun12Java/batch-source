package question11a;
import question11b.TheMeaningOfLife;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		System.out.println("The meaning of life: " +TheMeaningOfLife.meaningOfLife);
		System.out.println("Why was 6 afraid of 7? Cause 7 ate " + TheMeaningOfLife.whyWas6AfraidOf7);
		TheMeaningOfLife ml = new TheMeaningOfLife();
		System.out.println("Well just to use both a static variables and a instance variable: " + ml.justCause);
	}

}
