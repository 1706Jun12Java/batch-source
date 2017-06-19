package hw1Q8Package;

import java.util.ArrayList;
import java.util.List;

public class Question8 {
	public static void main(String[] args){
		String[] strArray = {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"};
		List<String> strArray1 = new ArrayList<String>();
		for(int i = 0 ; i < strArray.length; i++){
			strArray1.add(strArray[i]);
		}
		List<String> normalArray = new ArrayList<String>();
		List<String> paliArray = new ArrayList<String>();
		char lastIndex;
		for(int i = 0; i<strArray1.size();i++){
			lastIndex = (char) (strArray1.get(i).length()-1);
			if(strArray1.get(i).charAt(0) == strArray1.get(i).charAt(lastIndex)){
				paliArray.add(strArray1.get(i));
			}else{
				normalArray.add(strArray1.get(i));
			}
		}
		System.out.print("Original array: " + strArray1);
		System.out.println("\nPalidromes array: " + paliArray);
		System.out.println("Normal array: " + normalArray);
	}
}
