package codeChallenge1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Scanner file = null;
		System.out.println("Would you like to provide a file? Type Y for yes, N for no, or anything else for example");
		String uInput = sc.nextLine();
		uInput = uInput.toLowerCase();
		switch(uInput){
		case "y":
			System.out.println("Enter file name including the extention: ");
			try{
				uInput = sc.nextLine();
				File f = new File(uInput);
				file = new Scanner(f);
				while(file.hasNextLine()){
					String start = file.nextLine();
					String end = file.nextLine();
					String bankString = file.nextLine();
					String[] bank = bankString.split(",");
					GeneTherapy gt = new GeneTherapy(start, end, bank);
					int mutations = gt.getGenesComparison();
					switch(mutations){
					case -1: System.out.println("Not valid. Mutations: " + mutations); 
							break;
					case 0: System.out.println("Genes are the same. Mutations: " + mutations);
							break;
					default: System.out.println("Mutations: " + mutations);
							break;
					}
				}
			} catch(FileNotFoundException e){
				e.printStackTrace();
			}
			break;
		case "n": System.out.println("Enter starting gene: ");
					String start = sc.nextLine();
					System.out.println("Enter ending gene: ");
					String end = sc.nextLine();
					System.out.println("Enter gene bank, separated by commas: ");
					String bankString = sc.nextLine();
					String[] bank = bankString.split(",");
					GeneTherapy gt = new GeneTherapy(start, end, bank);
					int mutations = gt.getGenesComparison();
					switch(mutations){
					case -1: System.out.println("Not valid. Mutations: " + mutations); 
							break;
					case 0: System.out.println("Genes are the same. Mutations: " + mutations);
							break;
					default: System.out.println("Mutations: " + mutations);
							break;
					}
					break;
		default: System.out.println("hard coded example running: ");
				 String[] test = new String[]{"AACCGGT","AACGTTT","AGGGAATT"};
				 GeneTherapy gt2 = new GeneTherapy("AACCCGT", "AACCGGT", test);
				 int mutations2 = gt2.getGenesComparison();
					switch(mutations2){
					case -1: System.out.println("Not valid. Mutations: " + mutations2); 
							break;
					case 0: System.out.println("Genes are the same. Mutations: " + mutations2);
							break;
					default: System.out.println("Mutations: " + mutations2);
							break;
					}
					break;
		
		}
	}

}
