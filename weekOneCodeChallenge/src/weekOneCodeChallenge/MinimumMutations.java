package weekOneCodeChallenge;

import java.io.*;
import java.util.*;

public class MinimumMutations {

	public static void main(String[] args) {

		System.out.println(FindMinimumMutations());

	}

	public static int FindMinimumMutations() {

		String startGene = null;
		String endGene = null;
		String[] bank = null;

		String filename = "src/input.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			startGene = br.readLine();
			endGene = br.readLine();
			String[] bank_temp = br.readLine().split(",");
			bank = bank_temp;

		} catch (IOException e) {

			e.printStackTrace();
		}

		// endGene not in bank
		if (!Arrays.asList(bank).contains(endGene)) {
			return -1;
		}

		// end=start
		if (startGene.equals(endGene)) {
			return 0;
		}

		// Use bfs
		// for efficiency one should first create adjacency list.
		// Here for save time, I skip it.

		boolean[] visited = new boolean[bank.length];
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}

		int min_step = 1;
		String root = startGene;
		Queue<String> q = new LinkedList<String>();

		ArrayList<String> Nodes = findNextNodes(root, bank, visited);
		// System.out.println(Nodes);
		for (int i = 0; i < Nodes.size(); i++) {
			// System.out.println(Nodes.indexOf(endGene));
			if (Nodes.indexOf(endGene) != -1) { // fond
				min_step++;
				return min_step;
			}
		}
		q.addAll(Nodes);
		// System.out.println(q);
		while (!q.isEmpty()) {
			root = (String) q.poll();

			ArrayList<String> nextNodes = findNextNodes(root, bank, visited);

			for (int i = 0; i < Nodes.size(); i++) {

				if (nextNodes.indexOf(endGene) != -1) { // fond
					min_step++;
					return min_step;
				}
			}
			q.addAll(nextNodes);
		}

		return -1;

	}

	static boolean haveNotVisitedAll(boolean[] visited) {

		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == false) {
				return true;
			}
		}
		return false;
	}

	static ArrayList<String> findNextNodes(String root, String[] bank, boolean[] visited) {

		ArrayList<String> res = new ArrayList<String>();

		for (int i = 0; i < bank.length; i++) {
			if (visited[i] == false) {
				// check one char difference in the string
				int count = 0;
				for (int j = 0; j < 8; j++) {
					if (root.charAt(j) != bank[i].charAt(j)) {
						count++;
					}
				}
				if (count == 1) {
					visited[i] = true;
					res.add(bank[i]);
				}
			}
		}

		return res;

	}

}
