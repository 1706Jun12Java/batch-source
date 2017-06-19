
public class Driver {

	public static void main(String[] args) {
		Solution test = new Solution();
		String start="AACCGGTT";
		String end="AAACGGTA";
		String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
		System.out.println(test.solution(start, end, bank));
		//System.out.println(test.characterDifference(start, end));
	}

}
