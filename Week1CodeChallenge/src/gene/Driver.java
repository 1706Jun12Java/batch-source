package gene;

public class Driver {

	public static void main(String[] args) {
		final String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		String start = "AAACGGTC";
		String end = "AACCGGTA";
				
		System.out.println(Utility.returnNumOfMutations(start, end, bank));
		
		

	}

}
