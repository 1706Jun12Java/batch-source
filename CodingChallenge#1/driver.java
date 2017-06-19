package Package;

import java.util.*;

public class driver {

	public static void main(String[] args) {
		String start;
		String end;
		ArrayList bank = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter start");
		start = scan.nextLine();
		System.out.println("Enter end");
		end = scan.nextLine();
		String str = "";
		int count = 1;
		do {
			System.out.println("Enter bank entry #" + count + " or type 'done' when finished");
			str = scan.nextLine();
			bank.add(str);
			count++;
		} while (!str.toLowerCase().equals("done"));
		System.out.println(Gene.checkMutations(start, end, bank));
	}

}
